package com.xiaopeng.montecarlo.navcore.download.helper;

import androidx.annotation.WorkerThread;
import com.autonavi.gbl.data.model.DataErrorType;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationErrCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import com.xiaopeng.montecarlo.root.network.IXPNetworkListener;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class ErrorMapDataHelper {
    private static final int ERROR_STATUS_DELETING = 1;
    private static final int ERROR_STATUS_DOWNLOADING = 2;
    private static final int ERROR_STATUS_DOWNLOAD_ERROR = 3;
    private static final L.Tag TAG = new L.Tag("ErrorMapDataHandler");
    private final ConcurrentHashMap<Integer, Integer> mErrorHandleStatusMap = new ConcurrentHashMap<>();
    IDownloadDataChangeCallback mDownloadDataChangeCallback = new IDownloadDataChangeCallback() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.ErrorMapDataHelper.1
        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onCityDataFetched() {
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onCityListCreated() {
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onOperated(OperationTypeEnum operationTypeEnum, ArrayList<Integer> arrayList) {
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onPercent(Integer num, Integer num2, Float f) {
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.callback.IDownloadDataChangeCallback
        public void onDownLoadStatus(int i, TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum) {
            ErrorMapDataHelper.this.handleDownloadStatusChange(Integer.valueOf(i), taskStatusCodeEnum, operationErrCodeEnum);
        }
    };
    IXPNetworkListener mNetworkChangeListener = new IXPNetworkListener() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.-$$Lambda$ErrorMapDataHelper$O08OZF6FBU5F_ap0Byx7QU-Zjlg
        @Override // com.xiaopeng.montecarlo.root.network.IXPNetworkListener
        public final void onNetworkChanged(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
            ErrorMapDataHelper.this.lambda$new$0$ErrorMapDataHelper(xPNetworkType, z);
        }
    };

    public /* synthetic */ void lambda$new$0$ErrorMapDataHelper(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
        if (z) {
            retryDownload();
        }
    }

    public ErrorMapDataHelper() {
        MapDataManager.getInstance().registerDownloadDataChangeObserver(this.mDownloadDataChangeCallback);
        XPNetworkManager.INSTANCE.addNetworkListener(this.mNetworkChangeListener);
    }

    @WorkerThread
    public synchronized void handlerDataError(int i, @DataErrorType.DataErrorType1 int i2) {
        if (this.mErrorHandleStatusMap.containsKey(Integer.valueOf(i))) {
            L.Tag tag = TAG;
            L.e(tag, "adCode:" + i + " - data error handle is in progress, ignore error!");
            return;
        }
        int urcodeByAdcode = MapDataManager.getInstance().getUrcodeByAdcode(i);
        if (urcodeByAdcode >= 0 && i2 >= 0) {
            this.mErrorHandleStatusMap.put(Integer.valueOf(i), 1);
            MapDataManager.getInstance().deleteErrorData(Integer.valueOf(i));
            File file = new File(RootUtil.DIR_OFFLINE_RELATIVE_PATH + "a" + urcodeByAdcode);
            if (file.exists() && file.isDirectory()) {
                FileUtil.deleteDir(file);
            }
            this.mErrorHandleStatusMap.put(Integer.valueOf(i), 2);
            MapDataManager.getInstance().startDownload(Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public synchronized void handleDownloadStatusChange(Integer num, TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum) {
        if (this.mErrorHandleStatusMap.containsKey(num)) {
            Integer num2 = this.mErrorHandleStatusMap.get(num);
            if (num2 == null) {
                return;
            }
            if (TaskStatusCodeEnum.TASK_STATUS_CODE_READY == taskStatusCodeEnum && num2.intValue() == 1) {
                L.Tag tag = TAG;
                L.i(tag, num + "data delete ok,start downloading adCode:" + num);
                this.mErrorHandleStatusMap.put(num, 2);
                MapDataManager.getInstance().startDownload(num);
            } else if (TaskStatusCodeEnum.TASK_STATUS_CODE_SUCCESS == taskStatusCodeEnum) {
                L.Tag tag2 = TAG;
                L.i(tag2, "download success adCode:" + num);
                this.mErrorHandleStatusMap.remove(num);
            } else if (operationErrCodeEnum != OperationErrCodeEnum.OPERATION_ERR_CODE_CORRECT) {
                if (XPNetworkManager.INSTANCE.isNetworkConnected()) {
                    this.mErrorHandleStatusMap.put(num, 2);
                    MapDataManager.getInstance().startDownload(num);
                } else {
                    this.mErrorHandleStatusMap.put(num, 3);
                }
            }
        }
    }

    @WorkerThread
    private synchronized void retryDownload() {
        for (Integer num : this.mErrorHandleStatusMap.keySet()) {
            int intValue = num.intValue();
            Integer num2 = this.mErrorHandleStatusMap.get(Integer.valueOf(intValue));
            if (num2 != null && num2.intValue() == 3) {
                this.mErrorHandleStatusMap.put(Integer.valueOf(intValue), 2);
                MapDataManager.getInstance().startDownload(Integer.valueOf(intValue));
            }
        }
    }
}
