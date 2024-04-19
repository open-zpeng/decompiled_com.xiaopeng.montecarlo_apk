package com.xiaopeng.montecarlo.navcore.download.dataoperator;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.download.IMapDataOperator;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.autodownload.profile.DownloadUserProfile;
import com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback;
import com.xiaopeng.montecarlo.navcore.download.constant.MapDataOperateEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationErrCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.download.MapDataDownloader;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.record.CityRecordBean;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.record.MapDataRecorder;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.network.IXPNetworkListener;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class MapDataOperator implements IMapDataOperator {
    private static final L.Tag TAG = new L.Tag("tMapDataOperator");
    private MapDataDownloader mDataDownloader;
    private MapDataRecorder mDataRecorder;
    private MapDataSizeKeeper mDataSizeKeeper;
    private MapDataInfoUploader mMapDataInfoUploader;
    private Handler mMapOperateHandler;
    boolean mIsPowerOn = true;
    IXPNetworkListener mNetworkListener = new AnonymousClass1();
    private final CarServiceManager.IXPCarStateListener mCarStateListener = new CarServiceManager.IXPCarStateListener() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator.2
        @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
        public void onIgStatusChange(int i) {
            if (i == 0) {
                MapDataOperator.this.onPowerOff();
            } else if (1 == i) {
                MapDataOperator.this.onPowerOn();
            }
        }
    };
    IDownloadDataChangeCallback mMapDataListener = new AnonymousClass3();

    @Override // com.xiaopeng.montecarlo.navcore.download.IMapDataOperator
    public DownloadUserProfile getUserProfile() {
        return null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.IMapDataOperator
    public void onAutoDownloadSwitchChanged(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.IMapDataOperator
    public void retriggerAutoDownload() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements IXPNetworkListener {
        AnonymousClass1() {
        }

        @Override // com.xiaopeng.montecarlo.root.network.IXPNetworkListener
        public void onNetworkChanged(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
            if (z) {
                L.i(MapDataOperator.TAG, "onNetworkChanged connected");
                MapDataOperator.this.runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.-$$Lambda$MapDataOperator$1$Mi9A0Fg6r8vUc3fuV_fHmW0u00E
                    @Override // java.lang.Runnable
                    public final void run() {
                        MapDataOperator.AnonymousClass1.this.lambda$onNetworkChanged$0$MapDataOperator$1();
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onNetworkChanged$0$MapDataOperator$1() {
            MapDataOperator.this.mDataDownloader.executeDownloadQueue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 implements IDownloadDataChangeCallback {
        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onCityListCreated() {
        }

        AnonymousClass3() {
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onCityDataFetched() {
            MapDataOperator.this.runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator.3.1
                @Override // java.lang.Runnable
                public void run() {
                    L.i(MapDataOperator.TAG, "onCityDataFetched");
                    MapDataOperator.this.mDataRecorder.fixLocalRecord();
                    MapDataOperator.this.mDataSizeKeeper.onCityDataFetched();
                    MapDataOperator.this.mDataDownloader.onInitDownload();
                }
            });
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onOperated(final OperationTypeEnum operationTypeEnum, final ArrayList<Integer> arrayList) {
            MapDataOperator.this.runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator.3.2
                @Override // java.lang.Runnable
                public void run() {
                    L.Tag tag = MapDataOperator.TAG;
                    L.i(tag, "onOperated operationType:" + operationTypeEnum);
                    MapDataOperator.this.mDataSizeKeeper.onOperated(operationTypeEnum);
                    MapDataOperator.this.mDataRecorder.onOperated(operationTypeEnum, arrayList);
                }
            });
        }

        public /* synthetic */ void lambda$onPercent$0$MapDataOperator$3(Integer num, Integer num2, Float f) {
            MapDataOperator.this.mDataSizeKeeper.onPercent(num, num2, f);
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onPercent(final Integer num, final Integer num2, final Float f) {
            MapDataOperator.this.runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.-$$Lambda$MapDataOperator$3$wYiXLEW-Qa0s8ieNu4EoLKieNxs
                @Override // java.lang.Runnable
                public final void run() {
                    MapDataOperator.AnonymousClass3.this.lambda$onPercent$0$MapDataOperator$3(num, num2, f);
                }
            });
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onDownLoadStatus(final int i, final TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum) {
            MapDataOperator.this.runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.-$$Lambda$MapDataOperator$3$8NBDC8jKvH48UjskJqClPSxSeBs
                @Override // java.lang.Runnable
                public final void run() {
                    MapDataOperator.AnonymousClass3.this.lambda$onDownLoadStatus$1$MapDataOperator$3(i, taskStatusCodeEnum);
                }
            });
        }

        public /* synthetic */ void lambda$onDownLoadStatus$1$MapDataOperator$3(int i, TaskStatusCodeEnum taskStatusCodeEnum) {
            MapDataOperator.this.mDataRecorder.onDownLoadStatusChange(i, taskStatusCodeEnum);
            MapDataOperator.this.mDataSizeKeeper.onDownLoadStatusChange();
            MapDataOperator.this.mDataDownloader.onDownLoadStatusChange(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.IMapDataOperator
    public void initAutoDownload() {
        this.mMapDataInfoUploader = new MapDataInfoUploader(this);
        this.mMapOperateHandler = new Handler(WorkThreadUtil.getInstance().getDataProcessThreadLooper());
        this.mDataSizeKeeper = new MapDataSizeKeeper(this, RootUtil.DIR_OFFLINE_RELATIVE_PATH);
        this.mDataRecorder = new MapDataRecorder(MapDataManager.getInstance().getCurrentCityAdCode(), this, this.mMapDataInfoUploader);
        this.mDataDownloader = new MapDataDownloader(MapDataManager.getInstance().getCurrentCityAdCode(), this);
        this.mIsPowerOn = CarServiceManager.getInstance().getIgStatus() == 1;
        onInit();
        XPNetworkManager.INSTANCE.addNetworkListener(this.mNetworkListener);
        CarServiceManager.getInstance().addCarStateListener(this.mCarStateListener);
        MapDataManager.getInstance().registerDownloadDataChangeObserver(this.mMapDataListener);
    }

    private void onInit() {
        runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator.4
            @Override // java.lang.Runnable
            public void run() {
                if (MapDataOperator.this.mIsPowerOn) {
                    L.i(MapDataOperator.TAG, "onInit");
                    MapDataOperator.this.mDataRecorder.startCityUseRecord();
                    MapDataOperator.this.mDataDownloader.prepareDownload();
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.IMapDataOperator
    public void handlePushMessage(@NonNull final MapDataContent mapDataContent) {
        runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator.5
            @Override // java.lang.Runnable
            public void run() {
                if (mapDataContent.getAdCode() >= 0) {
                    L.Tag tag = MapDataOperator.TAG;
                    L.i(tag, "handlePushMessage:" + GsonUtil.toJson(mapDataContent));
                    if (mapDataContent.getOperate() == MapDataOperateEnum.OPERATE_DELETE.getOperate()) {
                        MapDataManager.getInstance().deleteDownload(Integer.valueOf(mapDataContent.getAdCode()));
                    } else if (mapDataContent.getOperate() == MapDataOperateEnum.OPERATE_DOWNLOAD.getOperate()) {
                        MapDataOperator.this.mDataDownloader.downloadPushMapData(mapDataContent.getAdCode());
                    }
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.IMapDataOperator
    public void onAdCodeChanged(final int i) {
        if (this.mIsPowerOn) {
            runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator.6
                @Override // java.lang.Runnable
                public void run() {
                    L.Tag tag = MapDataOperator.TAG;
                    L.i(tag, "onAdCodeChanged adCode:" + i);
                    MapDataOperator.this.mDataRecorder.onCurrentCityChanged(i);
                    MapDataOperator.this.mDataDownloader.onCurrentCityChanged(i);
                }
            });
        }
    }

    public Map<Integer, CityRecordBean> getMapDataRecordInfo() {
        return this.mDataRecorder.getMapDataRecordInfo();
    }

    public List<CityRecordBean> getMapDataRecordListDescByRecordCount() {
        Map<Integer, CityRecordBean> mapDataRecordInfo = this.mDataRecorder.getMapDataRecordInfo();
        ArrayList arrayList = new ArrayList();
        if (mapDataRecordInfo.size() > 0) {
            arrayList.addAll(mapDataRecordInfo.values());
            arrayList.sort(new Comparator() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.-$$Lambda$MapDataOperator$KZ6d6YoiMQ_-cqEintNbRC_ABzs
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int compare;
                    compare = Long.compare(((CityRecordBean) obj2).getRecordCount(), ((CityRecordBean) obj).getRecordCount());
                    return compare;
                }
            });
        }
        return arrayList;
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.IMapDataOperator
    public void onOOBE() {
        runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator.7
            @Override // java.lang.Runnable
            public void run() {
                L.i(MapDataOperator.TAG, "onOOBE");
                MapDataOperator.this.mDataDownloader.onInitDownload();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPowerOn() {
        runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator.8
            @Override // java.lang.Runnable
            public void run() {
                L.i(MapDataOperator.TAG, "onPowerOn");
                MapDataOperator mapDataOperator = MapDataOperator.this;
                mapDataOperator.mIsPowerOn = true;
                mapDataOperator.mDataRecorder.startCityUseRecord();
                MapDataOperator.this.mDataDownloader.startUpdate();
                MapDataOperator.this.mMapDataInfoUploader.uploadCityVisitInfo();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPowerOff() {
        runOnDataThread(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataOperator.9
            @Override // java.lang.Runnable
            public void run() {
                L.i(MapDataOperator.TAG, "onPowerOff");
                MapDataOperator mapDataOperator = MapDataOperator.this;
                mapDataOperator.mIsPowerOn = false;
                mapDataOperator.mDataRecorder.stopCityUseRecord();
            }
        });
    }

    public void runOnDataThread(Runnable runnable) {
        if (Looper.myLooper() == this.mMapOperateHandler.getLooper()) {
            runnable.run();
        } else {
            this.mMapOperateHandler.post(runnable);
        }
    }
}
