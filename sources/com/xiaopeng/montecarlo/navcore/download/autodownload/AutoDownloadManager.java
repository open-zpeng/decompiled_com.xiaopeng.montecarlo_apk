package com.xiaopeng.montecarlo.navcore.download.autodownload;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.autonavi.gbl.pos.model.LocDataType;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.autodownload.AutoDownloadManager;
import com.xiaopeng.montecarlo.navcore.download.autodownload.profile.DownloadUserProfile;
import com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.DownloadStrategyFactory;
import com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.DownloadStrategyWifi;
import com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.IDownloadStartStrategy;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationErrCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import com.xiaopeng.montecarlo.root.network.IXPNetworkListener;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.util.XpCacheConsts;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.function.Consumer;
/* loaded from: classes2.dex */
public class AutoDownloadManager {
    private static final String BROADCAST_ACTION_DAY_CHANGE = "com.xiaopeng.montecarlo.broadcast.DAY_CHANGE";
    private static final String KEY_ADCODE = "adCode";
    private static final String KEY_ADCODE_LIST = "adCode_list";
    private static final String KEY_ERROR_CODE = "errorCode";
    private static final String KEY_OPERATION_TYPE = "operation_type";
    private static final String KEY_TASK_CODE = "taskCode";
    private static final int MSG_CANCEL_DOWNLOAD = 102;
    private static final int MSG_DOWNLOAD_OPERATED = 105;
    private static final int MSG_DOWNLOAD_STATUS_CHANGE = 104;
    private static final int MSG_NETWORK_STATE_CHANGE = 103;
    private static final int MSG_START_DOWNLOAD = 101;
    private static final int ONE_MINUTE = 60000;
    private static final L.Tag TAG = new L.Tag("AutoDownloadManager");
    private Handler mAutoDownLoadHandler;
    private IDownloadStartStrategy mCurrentDownloadStrategy;
    private DownloadUserProfile mUserProfile;

    public void initAutoDownload() {
        this.mCurrentDownloadStrategy = DownloadStrategyFactory.createDownloadStrategy();
        this.mUserProfile = new DownloadUserProfile();
        this.mAutoDownLoadHandler = new AnonymousClass1(WorkThreadUtil.getInstance().getDataProcessThreadLooper());
        XPNetworkManager.INSTANCE.addNetworkListener(new XPNetworkListener(this, null));
        MapDataManager.getInstance().registerDownloadDataChangeObserver(new DownloadDataChangeCallback(this, null));
        registerDayChangeBroadcast();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.navcore.download.autodownload.AutoDownloadManager$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 101:
                    L.i(AutoDownloadManager.TAG, "MSG_START_DOWNLOAD");
                    if (AutoDownloadManager.this.mCurrentDownloadStrategy != null) {
                        AutoDownloadManager.this.mCurrentDownloadStrategy.execute();
                        return;
                    }
                    return;
                case 102:
                    L.i(AutoDownloadManager.TAG, "MSG_CANCEL_DOWNLOAD");
                    if (AutoDownloadManager.this.mCurrentDownloadStrategy != null) {
                        AutoDownloadManager.this.mCurrentDownloadStrategy.interrupt();
                        return;
                    }
                    return;
                case 103:
                    L.i(AutoDownloadManager.TAG, "MSG_NETWORK_STATE_CHANGE");
                    if (AutoDownloadManager.this.mCurrentDownloadStrategy != null) {
                        AutoDownloadManager.this.mCurrentDownloadStrategy.interrupt();
                        AutoDownloadManager.this.mCurrentDownloadStrategy = DownloadStrategyFactory.createDownloadStrategy();
                        AutoDownloadManager.this.mCurrentDownloadStrategy.execute();
                        return;
                    }
                    return;
                case 104:
                    L.i(AutoDownloadManager.TAG, "MSG_DOWNLOAD_STATUS_CHANGE");
                    if (AutoDownloadManager.this.mCurrentDownloadStrategy != null) {
                        AutoDownloadManager.this.mCurrentDownloadStrategy.onCityDataStatusChange(message.getData().getInt(AutoDownloadManager.KEY_ADCODE), (TaskStatusCodeEnum) message.getData().getSerializable(AutoDownloadManager.KEY_TASK_CODE), (OperationErrCodeEnum) message.getData().getSerializable(AutoDownloadManager.KEY_ERROR_CODE));
                        return;
                    }
                    return;
                case 105:
                    L.i(AutoDownloadManager.TAG, "MSG_DOWNLOAD_OPERATED");
                    if (AutoDownloadManager.this.mCurrentDownloadStrategy != null) {
                        final OperationTypeEnum operationTypeEnum = (OperationTypeEnum) message.getData().getSerializable(AutoDownloadManager.KEY_OPERATION_TYPE);
                        Serializable serializable = message.getData().getSerializable(AutoDownloadManager.KEY_ADCODE_LIST);
                        if (serializable instanceof ArrayList) {
                            ((ArrayList) serializable).forEach(new Consumer() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.-$$Lambda$AutoDownloadManager$1$ihCzH-FI3P3ewP-Zwu5fYgyhOXM
                                @Override // java.util.function.Consumer
                                public final void accept(Object obj) {
                                    AutoDownloadManager.AnonymousClass1.this.lambda$handleMessage$0$AutoDownloadManager$1(operationTypeEnum, obj);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public /* synthetic */ void lambda$handleMessage$0$AutoDownloadManager$1(OperationTypeEnum operationTypeEnum, Object obj) {
            if (obj instanceof Integer) {
                AutoDownloadManager.this.mCurrentDownloadStrategy.onOperated(operationTypeEnum, (Integer) obj);
            }
        }
    }

    public void onAdCodeChanged(int i) {
        DownloadUserProfile downloadUserProfile = this.mUserProfile;
        if (downloadUserProfile != null) {
            downloadUserProfile.onAdCodeChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadCountryBaseData() {
        CityDataBean cityDataBean = MapDataManager.getInstance().getCityDataBean(0);
        if (cityDataBean == null || cityDataBean.isFinish()) {
            return;
        }
        L.i(TAG, "Auto download country base data");
        MapDataManager.getInstance().startDownload(Integer.valueOf(cityDataBean.getAdcode()));
    }

    public void onAutoDownloadSwitchChanged(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "onAutoDownloadSwitchChanged:" + z);
        if (!isReadyToDownload()) {
            L.e(TAG, "onAutoDownloadSwitchChanged data is not initialized!!");
            return;
        }
        Handler handler = this.mAutoDownLoadHandler;
        if (handler == null || !(this.mCurrentDownloadStrategy instanceof DownloadStrategyWifi)) {
            return;
        }
        if (z) {
            handler.sendMessage(handler.obtainMessage(101));
        } else {
            handler.sendMessage(handler.obtainMessage(102));
        }
    }

    public void retriggerAutoDownload() {
        L.i(TAG, "retriggerAutoDownload:");
        if (!isReadyToDownload()) {
            L.e(TAG, "retriggerAutoDownload data is not initialized!!");
            return;
        }
        Handler handler = this.mAutoDownLoadHandler;
        if (handler == null || !(this.mCurrentDownloadStrategy instanceof DownloadStrategyWifi)) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(101));
    }

    public DownloadUserProfile getUserProfile() {
        return this.mUserProfile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isReadyToDownload() {
        return MapDataManager.getInstance().isCompletedInitialized();
    }

    private void registerDayChangeBroadcast() {
        Intent intent = new Intent();
        intent.setAction(BROADCAST_ACTION_DAY_CHANGE);
        PendingIntent broadcast = PendingIntent.getBroadcast(ContextUtils.getContext(), 0, intent, LocDataType.LocDataVDRInfo);
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        AlarmManager alarmManager = (AlarmManager) ContextUtils.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            alarmManager.cancel(broadcast);
            alarmManager.setInexactRepeating(1, calendar.getTimeInMillis(), XpCacheConsts.ONE_DAY, broadcast);
        }
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.AutoDownloadManager.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent2) {
                L.Tag tag = AutoDownloadManager.TAG;
                L.i(tag, "onReceive: " + intent2.getAction());
                if (!AutoDownloadManager.BROADCAST_ACTION_DAY_CHANGE.equals(intent2.getAction()) || AutoDownloadManager.this.mUserProfile == null) {
                    return;
                }
                AutoDownloadManager.this.mUserProfile.saveMapInDatabase();
                if (AutoDownloadManager.this.mAutoDownLoadHandler == null || !AutoDownloadManager.this.isReadyToDownload()) {
                    return;
                }
                AutoDownloadManager.this.mAutoDownLoadHandler.sendMessage(AutoDownloadManager.this.mAutoDownLoadHandler.obtainMessage(101));
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION_DAY_CHANGE);
        ContextUtils.getContext().registerReceiver(broadcastReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class DownloadDataChangeCallback implements IDownloadDataChangeCallback {
        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onCityListCreated() {
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onPercent(Integer num, Integer num2, Float f) {
        }

        private DownloadDataChangeCallback() {
        }

        /* synthetic */ DownloadDataChangeCallback(AutoDownloadManager autoDownloadManager, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onCityDataFetched() {
            L.i(AutoDownloadManager.TAG, "onCityDataFetched");
            AutoDownloadManager.this.downloadCountryBaseData();
            AutoDownloadManager.this.mAutoDownLoadHandler.sendMessage(AutoDownloadManager.this.mAutoDownLoadHandler.obtainMessage(101));
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onOperated(OperationTypeEnum operationTypeEnum, ArrayList<Integer> arrayList) {
            L.Tag tag = AutoDownloadManager.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onOperated: ");
            sb.append(operationTypeEnum);
            sb.append(", adcodeList.size: ");
            sb.append(arrayList == null ? 0 : arrayList.size());
            L.i(tag, sb.toString());
            if (AutoDownloadManager.this.mAutoDownLoadHandler == null || arrayList == null) {
                return;
            }
            Message obtainMessage = AutoDownloadManager.this.mAutoDownLoadHandler.obtainMessage(105);
            Bundle data = obtainMessage.getData();
            data.putSerializable(AutoDownloadManager.KEY_OPERATION_TYPE, operationTypeEnum);
            data.putSerializable(AutoDownloadManager.KEY_ADCODE_LIST, arrayList);
            obtainMessage.setData(data);
            AutoDownloadManager.this.mAutoDownLoadHandler.sendMessage(obtainMessage);
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onDownLoadStatus(int i, TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum) {
            L.Tag tag = AutoDownloadManager.TAG;
            L.i(tag, "onDownLoadStatus " + i + " " + taskStatusCodeEnum);
            if (AutoDownloadManager.this.mAutoDownLoadHandler != null) {
                Message obtainMessage = AutoDownloadManager.this.mAutoDownLoadHandler.obtainMessage(104);
                Bundle data = obtainMessage.getData();
                data.putInt(AutoDownloadManager.KEY_ADCODE, i);
                data.putSerializable(AutoDownloadManager.KEY_TASK_CODE, taskStatusCodeEnum);
                data.putSerializable(AutoDownloadManager.KEY_ERROR_CODE, operationErrCodeEnum);
                obtainMessage.setData(data);
                AutoDownloadManager.this.mAutoDownLoadHandler.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class XPNetworkListener implements IXPNetworkListener {
        private XPNetworkListener() {
        }

        /* synthetic */ XPNetworkListener(AutoDownloadManager autoDownloadManager, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.xiaopeng.montecarlo.root.network.IXPNetworkListener
        public void onNetworkChanged(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
            if (AutoDownloadManager.this.mAutoDownLoadHandler != null) {
                AutoDownloadManager.this.mAutoDownLoadHandler.removeMessages(103);
                AutoDownloadManager.this.mAutoDownLoadHandler.sendMessageDelayed(AutoDownloadManager.this.mAutoDownLoadHandler.obtainMessage(103), 1000L);
            }
        }
    }
}
