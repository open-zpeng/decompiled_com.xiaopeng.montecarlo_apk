package com.autonavi.common.tool.upload;

import com.autonavi.common.tool.ICrashLogController;
import com.autonavi.common.tool.Utils;
import com.autonavi.common.tool.upload.uploadfile.BaseUploadFile;
import com.autonavi.common.tool.upload.uploadfile.UploadFileFactory;
import com.autonavi.common.tool.util.CrashFileManager;
import com.autonavi.common.tool.util.LogUtil;
import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import java.io.File;
import java.util.ArrayList;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: classes.dex */
public class UploadFileManager {
    private static final String ZIP_FILE_NAME = "upload.zip";
    private static UploadFileManager mInstance;
    private ICrashLogController mController;
    private Thread mUpThread;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface OnUploadListener {
        void onUpload();
    }

    private UploadFileManager(ICrashLogController iCrashLogController) {
        this.mController = iCrashLogController;
    }

    public static UploadFileManager getInstance(ICrashLogController iCrashLogController) {
        if (mInstance == null) {
            synchronized (UploadFileManager.class) {
                mInstance = new UploadFileManager(iCrashLogController);
            }
        }
        return mInstance;
    }

    public void uploadSingleCrash() {
        LogUtil.log("begin uploadSingleCrash");
        upLoadCrashTask(new OnUploadListener() { // from class: com.autonavi.common.tool.upload.UploadFileManager.1
            @Override // com.autonavi.common.tool.upload.UploadFileManager.OnUploadListener
            public void onUpload() {
                UploadFileManager.this.mController.onUploadStart();
                UploadFileManager.this.mController.onUploadFinish(UploadFileManager.this.realUpLoadCrash());
            }
        });
    }

    public void uploadAllCrash() {
        LogUtil.log("begin uploadAllCrash");
        upLoadCrashTask(new OnUploadListener() { // from class: com.autonavi.common.tool.upload.UploadFileManager.2
            @Override // com.autonavi.common.tool.upload.UploadFileManager.OnUploadListener
            public void onUpload() {
                UploadFileManager.this.mController.onUploadStart();
                UploadFileFilter uploadFileFilter = new UploadFileFilter(UploadFileManager.this.mController.getUploadCrashDir());
                for (File[] uploadFiles = uploadFileFilter.getUploadFiles(); !Utils.isEmptyArray(uploadFiles); uploadFiles = uploadFileFilter.getUploadFiles()) {
                    LogUtil.log("begin realUploadCrash");
                    if (!UploadFileManager.this.realUpLoadCrash()) {
                        LogUtil.log("realUploadCrash error, break uploadAllCrash");
                        UploadFileManager.this.mController.onUploadFinish(false);
                        return;
                    }
                }
                UploadFileManager.this.mController.onUploadFinish(true);
            }
        });
    }

    private synchronized void upLoadCrashTask(final OnUploadListener onUploadListener) {
        if (this.mController.isDebug()) {
            return;
        }
        if (this.mUpThread == null || !this.mUpThread.isAlive()) {
            this.mUpThread = new Thread(new Runnable() { // from class: com.autonavi.common.tool.upload.UploadFileManager.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (onUploadListener != null) {
                            onUploadListener.onUpload();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, "DP-UP");
            this.mUpThread.start();
        }
    }

    public synchronized void waitForUploadComplete() {
        if (this.mUpThread != null) {
            try {
                this.mUpThread.join(UILooperObserver.ANR_TRIGGER_TIME);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean realUpLoadCrash() {
        if (!this.mController.isDebug() && this.mController.isInternetConnected()) {
            try {
                File uploadCrashDir = this.mController.getUploadCrashDir();
                ArrayList arrayList = new ArrayList();
                File uploadFilesAndZip = new UploadFileFilter(uploadCrashDir).getUploadFilesAndZip(arrayList, uploadCrashDir + MqttTopic.TOPIC_LEVEL_SEPARATOR + ZIP_FILE_NAME);
                if (arrayList.isEmpty()) {
                    LogUtil.log("crash file is empty");
                    return false;
                }
                if (uploadFilesAndZip != null && uploadFilesAndZip.exists() && uploadFilesAndZip.length() != 0) {
                    LogUtil.log("upload.zip size = " + uploadFilesAndZip.length());
                    File[] fileArr = (File[]) arrayList.toArray(new File[0]);
                    CrashFileManager.getInstance().appendUploadFlag(fileArr);
                    BaseUploadFile createUploadFile = new UploadFileFactory().createUploadFile(uploadFilesAndZip, fileArr, this.mController);
                    if (createUploadFile != null) {
                        createUploadFile.doUpload();
                        return createUploadFile.isUploadSucess();
                    }
                    return false;
                }
                LogUtil.log("upload zip file generate error");
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
