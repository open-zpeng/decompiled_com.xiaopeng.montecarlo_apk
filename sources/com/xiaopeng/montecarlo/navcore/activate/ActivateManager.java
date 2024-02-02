package com.xiaopeng.montecarlo.navcore.activate;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.autonavi.gbl.activation.ActivationModule;
import com.autonavi.gbl.activation.model.ActivateReturnParam;
import com.autonavi.gbl.activation.model.ActivationInitParam;
import com.autonavi.gbl.activation.observer.INetActivateObserver;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.INaviVehicleService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviFeedbackResultRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviGetSdkActivationCodeResponse;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.network.IXPNetworkListener;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.AfterSalesUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileIOUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: classes2.dex */
public class ActivateManager {
    private static final String ACTIVATE_ASSET_FILE_PATH = "activate";
    public static final int ACTIVATE_BATCH = 0;
    private static final String ACTIVATE_BATCH_FILE_NAME = "ReLoginCode.csv";
    private static final int ACTIVATE_CHECK_MAX = 3;
    private static final long ACTIVATE_CHECK_TIMER = 1000;
    private static final String ACTIVATE_FILE_NAME = "value.dat";
    private static final String ACTIVATE_INFO_FILE_NAME = "activateInfo.txt";
    public static final int ACTIVATE_MANUAL = 3;
    public static final int ACTIVATE_MANUAL_SILENT = 2;
    public static final int ACTIVATE_NET = 1;
    public static final int ACTIVATE_NONE = -1;
    private static final int MSG_ACTIVATE_BEGIN = 1002;
    private static final int MSG_ACTIVATE_MANUAL_BEGIN = 1003;
    private static final int MSG_ACTIVATE_MANUAL_SLIENT_CHECK = 1001;
    private static final int MSG_ACTIVATE_NET_CHECK = 1000;
    private static final L.Tag TAG = new L.Tag("ActivateManager");
    private static final ActivateManager sInstance = new ActivateManager();
    private int mActivateCode;
    private boolean mIsActivateSuccess;
    private IActivateResultListener mListener;
    private String mLoginCode;
    private String mUserCode;
    private String mUuid;
    private INaviVehicleService mNaviVehicleService = (INaviVehicleService) HttpClientManager.getInstance().getService(INaviVehicleService.class);
    private INetActivateObserver mNetActivateObserver = new INetActivateObserver() { // from class: com.xiaopeng.montecarlo.navcore.activate.ActivateManager.1
        @Override // com.autonavi.gbl.activation.observer.INetActivateObserver
        public void onNetActivateResponse(int i) {
            L.Tag tag = ActivateManager.TAG;
            L.i(tag, ">>> onNetActivateResponse i = " + i);
            ActivateManager.this.mActivateCode = i;
            if (1 == i) {
                ActivateManager.this.mActivateCount = 0;
                ActivateManager.this.sendActivateSuccess();
            } else if ((20 != i && 100 != i) || ActivateManager.this.mActivateCount >= 3) {
                ActivateManager.this.mActivateCount = 0;
                ActivateManager.this.sendStatDataForActivate(1, false);
                ActivateManager.this.checkManualActiveInfo();
            } else {
                ActivateManager.access$208(ActivateManager.this);
                ActivateManager.this.sendActivateFail(i);
                ActivateManager.this.mCheckHandler.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    };
    private IXPNetworkListener mNetworkListener = new IXPNetworkListener() { // from class: com.xiaopeng.montecarlo.navcore.activate.ActivateManager.2
        @Override // com.xiaopeng.montecarlo.root.network.IXPNetworkListener
        public void onNetworkChanged(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
            if (z) {
                if ((ActivateManager.this.mActivateType == 0 || 1 == ActivateManager.this.mActivateType) && 1 != ActivateManager.this.mActivateCode) {
                    ActivateManager.this.mCheckHandler.sendEmptyMessage(1000);
                }
            }
        }
    };
    private final Handler mCheckHandler = new Handler(WorkThreadUtil.getInstance().getNavThreadLooper()) { // from class: com.xiaopeng.montecarlo.navcore.activate.ActivateManager.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            L.Tag tag = ActivateManager.TAG;
            L.i(tag, ">>> handleMessage msg.what = " + message.what);
            switch (message.what) {
                case 1000:
                    ActivateManager.this.startNetActivate();
                    return;
                case 1001:
                    ActivateManager.access$208(ActivateManager.this);
                    if (ActivateManager.this.mActivateCount < 3) {
                        ActivateManager.this.checkManualActiveInfo();
                        return;
                    } else {
                        ActivateManager.this.startManualActivateSilent();
                        return;
                    }
                case 1002:
                    ActivateManager.this.checkActivate();
                    return;
                case 1003:
                    ActivateManager activateManager = ActivateManager.this;
                    activateManager.mActivateCode = activateManager.manualActivate(activateManager.mUserCode, ActivateManager.this.getUUID(), ActivateManager.this.mLoginCode);
                    if (1 == ActivateManager.this.mActivateCode) {
                        ActivateManager.this.sendActivateSuccess();
                        return;
                    }
                    ActivateManager.this.sendStatDataForActivate(3, false);
                    ActivateManager activateManager2 = ActivateManager.this;
                    activateManager2.sendActivateFail(activateManager2.mActivateCode);
                    return;
                default:
                    return;
            }
        }
    };
    private ActivationModule mActivationModule = ActivationModule.getInstance();
    private int mActivateType = -1;
    private int mActivateCount = 0;

    static /* synthetic */ int access$208(ActivateManager activateManager) {
        int i = activateManager.mActivateCount;
        activateManager.mActivateCount = i + 1;
        return i;
    }

    private ActivateManager() {
        this.mIsActivateSuccess = false;
        this.mIsActivateSuccess = false;
    }

    public static ActivateManager getInstance() {
        return sInstance;
    }

    public void setActivateListener(IActivateResultListener iActivateResultListener) {
        this.mListener = iActivateResultListener;
    }

    public int getActivateType() {
        return this.mActivateType;
    }

    public int getActivateCode() {
        return this.mActivateCode;
    }

    public boolean isActivateSuccess() {
        return this.mIsActivateSuccess;
    }

    public String getUUID() {
        String hardwareUuid;
        if (!TextUtils.isEmpty(this.mUuid)) {
            hardwareUuid = this.mUuid;
        } else {
            hardwareUuid = SystemPropertyUtil.getHardwareUuid();
        }
        L.Tag tag = TAG;
        L.i(tag, ">>> getUUID = " + hardwareUuid);
        return hardwareUuid;
    }

    public void startCheckActivate() {
        L.i(TAG, ">>> startCheckActivate begin");
        this.mCheckHandler.sendEmptyMessage(1002);
    }

    public void startCheckActivateAsync() {
        boolean initActivateData = initActivateData();
        L.Tag tag = TAG;
        L.i(tag, ">>> startCheckActivateAsync needCheck = " + initActivateData);
        if (initActivateData) {
            this.mActivateCode = batchActivate();
            L.Tag tag2 = TAG;
            L.i(tag2, ">>> checkActivate batchActivate mActivateCode = " + this.mActivateCode);
            if (1 == this.mActivateCode) {
                sendActivateSuccess();
                return;
            } else {
                sendStatDataForActivate(0, false);
                return;
            }
        }
        sendActivateSuccess();
    }

    public void manualActivate(String str, String str2) {
        this.mUserCode = str;
        this.mLoginCode = str2;
        this.mCheckHandler.sendEmptyMessage(1003);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void checkActivate() {
        boolean initActivateData = initActivateData();
        L.Tag tag = TAG;
        L.i(tag, ">>> checkActivate needCheck = " + initActivateData);
        if (initActivateData) {
            this.mActivateCode = batchActivate();
            L.Tag tag2 = TAG;
            L.i(tag2, ">>> checkActivate batchActivate mActivateCode = " + this.mActivateCode);
            if (1 == this.mActivateCode) {
                sendActivateSuccess();
                return;
            }
            sendStatDataForActivate(0, false);
            startNetActivate();
            return;
        }
        sendActivateSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNetActivate() {
        if (XPNetworkManager.INSTANCE.isNetworkConnected()) {
            int netActivate = netActivate(this.mNetActivateObserver);
            L.i(TAG, ">>> startNetActivate netActivate net = " + netActivate);
            if (netActivate != 0) {
                this.mActivateCode = 0;
                sendActivateFail(this.mActivateCode);
                this.mActivateCount++;
                if (this.mActivateCount < 3) {
                    this.mCheckHandler.sendEmptyMessageDelayed(1000, 1000L);
                    return;
                }
                this.mActivateCount = 0;
                checkManualActiveInfo();
                return;
            }
            return;
        }
        L.i(TAG, ">>> startNetActivate but network was offline!");
        XPNetworkManager.INSTANCE.addNetworkListener(this.mNetworkListener);
        sendActivateFail(this.mActivateCode);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0078, code lost:
        if (com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.existFile(com.xiaopeng.montecarlo.root.util.RootUtil.ACTIVATE_BACKUP_DIR + org.eclipse.paho.client.mqttv3.MqttTopic.TOPIC_LEVEL_SEPARATOR + com.xiaopeng.montecarlo.navcore.activate.ActivateManager.ACTIVATE_FILE_NAME) != false) goto L20;
     */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean initActivateData() {
        /*
            r9 = this;
            java.lang.String r0 = com.xiaopeng.montecarlo.root.util.RootUtil.ACTIVATE_SDCARD_DIR
            com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.createFileDir(r0)
            r9.getActivateInfoFormSDCard()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.xiaopeng.montecarlo.root.util.RootUtil.ACTIVATE_SDCARD_DIR
            r0.append(r1)
            java.lang.String r1 = "/"
            r0.append(r1)
            java.lang.String r2 = "ReLoginCode.csv"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            boolean r0 = com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.existFile(r0)
            r3 = 1
            if (r0 != 0) goto Lda
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = com.xiaopeng.montecarlo.root.util.RootUtil.ACTIVATE_SDCARD_DIR
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = "value.dat"
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            boolean r0 = com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.existFile(r0)
            if (r0 == 0) goto L46
            goto Lda
        L46:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = com.xiaopeng.montecarlo.root.util.RootUtil.ACTIVATE_BACKUP_DIR
            r0.append(r5)
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            boolean r0 = com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.existFile(r0)
            if (r0 != 0) goto L7a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = com.xiaopeng.montecarlo.root.util.RootUtil.ACTIVATE_BACKUP_DIR
            r0.append(r5)
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            boolean r0 = com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.existFile(r0)
            if (r0 == 0) goto L8c
        L7a:
            java.lang.String r0 = com.xiaopeng.montecarlo.root.util.RootUtil.ACTIVATE_SDCARD_DIR
            java.lang.String r4 = com.xiaopeng.montecarlo.root.util.RootUtil.ACTIVATE_BACKUP_DIR
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L8c
            java.lang.String r0 = com.xiaopeng.montecarlo.root.util.RootUtil.ACTIVATE_BACKUP_DIR
            java.lang.String r1 = com.xiaopeng.montecarlo.root.util.RootUtil.ACTIVATE_SDCARD_DIR
            com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.copyFolder(r0, r1)
            goto Lda
        L8c:
            java.lang.String r0 = "activate"
            java.lang.String[] r0 = com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.getFileNameFromAssets(r0)
            if (r0 == 0) goto Lda
            int r4 = r0.length
            r5 = 0
            r6 = r5
        L97:
            if (r6 >= r4) goto Lda
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "activate/"
            r7.append(r8)
            r8 = r0[r6]
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            byte[] r7 = com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.loadDataFromAssets(r7)
            java.lang.String r8 = com.xiaopeng.montecarlo.root.util.RootUtil.ACTIVATE_SDCARD_DIR
            com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.createFileWithByte(r8, r2, r7)
            int r7 = r9.batchActivate()
            r9.mActivateCode = r7
            int r7 = r9.mActivateCode
            if (r3 != r7) goto Lc0
            return r5
        Lc0:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = com.xiaopeng.montecarlo.root.util.RootUtil.ACTIVATE_SDCARD_DIR
            r7.append(r8)
            r7.append(r1)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.deleteFile(r7)
            int r6 = r6 + 1
            goto L97
        Lda:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.activate.ActivateManager.initActivateData():boolean");
    }

    @WorkerThread
    private void backUpActivateData() {
        FileUtil.copyFolder(RootUtil.ACTIVATE_SDCARD_DIR, RootUtil.ACTIVATE_BACKUP_DIR);
    }

    @WorkerThread
    private void postActivateResult(final boolean z, final String str) {
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.activate.-$$Lambda$ActivateManager$L1DAgTcDTcCQjUuxk_RyD3cqkeI
            @Override // java.lang.Runnable
            public final void run() {
                ActivateManager.this.lambda$postActivateResult$0$ActivateManager(z, str);
            }
        });
    }

    public /* synthetic */ void lambda$postActivateResult$0$ActivateManager(boolean z, String str) {
        if (this.mNaviVehicleService.feedbackSdkActivation(new NaviFeedbackResultRequest().setResult(Boolean.valueOf(z)).setUuid(str)).getCode() == 200) {
            L.Tag tag = TAG;
            L.i(tag, ">>> postActivateResult success result = " + z);
            saveActivateResult(z);
            return;
        }
        L.i(TAG, ">>> postActivateResult onFailure");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void checkManualActiveInfo() {
        if (TextUtils.isEmpty(this.mLoginCode) || TextUtils.isEmpty(this.mUserCode)) {
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.activate.-$$Lambda$ActivateManager$NRY9KaeM27PdRygLyipMyUWSAdk
                @Override // java.lang.Runnable
                public final void run() {
                    ActivateManager.this.lambda$checkManualActiveInfo$1$ActivateManager();
                }
            });
        } else {
            startManualActivateSilent();
        }
    }

    public /* synthetic */ void lambda$checkManualActiveInfo$1$ActivateManager() {
        NaviGetSdkActivationCodeResponse sdkActivationCode = this.mNaviVehicleService.getSdkActivationCode();
        if (sdkActivationCode != null) {
            L.i(TAG, ">>> checkManualActiveInfo onSuccess");
            this.mUuid = sdkActivationCode.getUuid();
            this.mUserCode = sdkActivationCode.getSeqNo();
            this.mLoginCode = sdkActivationCode.getActiveCode();
            saveActivateInfo();
            checkActivate();
            return;
        }
        L.i(TAG, ">>> checkManualActiveInfo onFailure");
        this.mCheckHandler.sendEmptyMessageDelayed(1001, 1000L);
    }

    private void saveActivateInfo() {
        if (TextUtils.isEmpty(this.mUserCode) || TextUtils.isEmpty(this.mLoginCode)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mUuid);
        arrayList.add(this.mUserCode);
        arrayList.add(this.mLoginCode);
        FileIOUtil fileIOUtil = new FileIOUtil();
        fileIOUtil.writeList2SDCard(RootUtil.ACTIVATE_SDCARD_DIR + MqttTopic.TOPIC_LEVEL_SEPARATOR, ACTIVATE_INFO_FILE_NAME, arrayList);
    }

    private void getActivateInfoFormSDCard() {
        String str = RootUtil.ACTIVATE_SDCARD_DIR + MqttTopic.TOPIC_LEVEL_SEPARATOR + ACTIVATE_INFO_FILE_NAME;
        String str2 = RootUtil.ACTIVATE_BACKUP_DIR + MqttTopic.TOPIC_LEVEL_SEPARATOR + ACTIVATE_INFO_FILE_NAME;
        if (!FileUtil.existFile(str) && FileUtil.existFile(str2)) {
            FileUtil.copyFile(RootUtil.ACTIVATE_BACKUP_DIR, RootUtil.ACTIVATE_SDCARD_DIR, ACTIVATE_INFO_FILE_NAME, null);
        }
        List readListFromSDCard = new FileIOUtil().readListFromSDCard(str);
        if (readListFromSDCard == null || readListFromSDCard.size() < 3) {
            return;
        }
        this.mUuid = (String) readListFromSDCard.get(0);
        this.mUserCode = (String) readListFromSDCard.get(1);
        this.mLoginCode = (String) readListFromSDCard.get(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void startManualActivateSilent() {
        this.mActivateCode = manualSilentActivate();
        L.Tag tag = TAG;
        L.i(tag, ">>> startManualActivateSilent mActivateCode = " + this.mActivateCode);
        int i = this.mActivateCode;
        if (1 == i) {
            sendActivateSuccess();
        } else {
            sendActivateFail(i);
        }
    }

    @WorkerThread
    private int batchActivate() {
        this.mActivateType = 0;
        int init = this.mActivationModule.init(createBatchActivateParams());
        L.Tag tag = TAG;
        L.i(tag, "init code " + init);
        return this.mActivationModule.getActivateStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public int manualActivate(String str, String str2, String str3) {
        this.mActivateType = 3;
        ActivateReturnParam manualActivate = this.mActivationModule.manualActivate(str, str3);
        if (manualActivate != null) {
            return manualActivate.iErrorCode;
        }
        return 0;
    }

    @WorkerThread
    private int manualSilentActivate() {
        this.mActivateType = 2;
        ActivateReturnParam manualActivate = this.mActivationModule.manualActivate(this.mUserCode, this.mLoginCode);
        if (manualActivate != null) {
            return manualActivate.iErrorCode;
        }
        return 0;
    }

    @WorkerThread
    private int netActivate(INetActivateObserver iNetActivateObserver) {
        this.mActivateType = 1;
        this.mActivationModule.setNetActivateObserver(iNetActivateObserver);
        return this.mActivationModule.netActivate(createNetActivateCode());
    }

    private ActivationInitParam createBatchActivateParams() {
        ActivationInitParam activationInitParam = new ActivationInitParam();
        activationInitParam.isCheckClientNo = true;
        activationInitParam.isCheckModelNo = true;
        activationInitParam.isSupportVolumeAct = true;
        activationInitParam.iCodeLength = 24;
        activationInitParam.szDeviceID = getUUID();
        activationInitParam.szUserDataFileDir = RootUtil.ACTIVATE_SDCARD_DIR + MqttTopic.TOPIC_LEVEL_SEPARATOR;
        return activationInitParam;
    }

    private String createNetActivateCode() {
        return "0000000000";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void sendActivateSuccess() {
        backUpActivateData();
        this.mIsActivateSuccess = true;
        IActivateResultListener iActivateResultListener = this.mListener;
        if (iActivateResultListener != null) {
            iActivateResultListener.onActivateResult(this.mActivateType, 1);
        }
        sendStatDataForActivate(this.mActivateType, true);
        if (!getActivateResult()) {
            postActivateResult(true, getUUID());
        }
        this.mActivateType = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void sendActivateFail(int i) {
        this.mIsActivateSuccess = false;
        IActivateResultListener iActivateResultListener = this.mListener;
        if (iActivateResultListener != null) {
            iActivateResultListener.onActivateResult(this.mActivateType, i);
        }
        AfterSalesUtil.getInstance().recordDiagnosisError(9002, "autoMap activate fail");
        postActivateResult(false, getUUID());
    }

    private void saveActivateResult(boolean z) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_BLSDK_ACTIVATE_RESULT, z);
    }

    private boolean getActivateResult() {
        return DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_BLSDK_ACTIVATE_RESULT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendStatDataForActivate(int i, boolean z) {
        int i2 = -1;
        if (i == 0) {
            i2 = 1;
        } else if (i == 1) {
            i2 = 2;
        } else if (i == 2 || i == 3) {
            i2 = 3;
        }
        DataLogUtil.sendStatData(PageType.BLSDK_ACTIVATE_RESULT, BtnType.BLSDK_ACTIVATE_ACTION, Integer.valueOf(z ? 1 : 0), Integer.valueOf(i2));
    }
}
