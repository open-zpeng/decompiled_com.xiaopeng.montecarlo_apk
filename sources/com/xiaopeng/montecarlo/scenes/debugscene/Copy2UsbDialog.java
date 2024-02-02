package com.xiaopeng.montecarlo.scenes.debugscene;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.autonavi.common.tool.FDManager;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.lib.utils.view.ToastUtils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.logcat.ILogFileOperationCallback;
import com.xiaopeng.montecarlo.root.util.logcat.LogFileStatus;
import com.xiaopeng.montecarlo.root.util.logcat.LogHelper;
import com.xiaopeng.montecarlo.root.util.storage.IUsbStorageListener;
import com.xiaopeng.montecarlo.views.dialog.XBaseDialog;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes2.dex */
public class Copy2UsbDialog extends XBaseDialog implements ILogFileOperationCallback, IUsbStorageListener {
    private static final L.Tag TAG = new L.Tag("Copy2UsbDialog");
    private static final String USB_READ_ONLY = "persist.xiaopeng.usb.rdonly";
    private final Context mContext;
    private long mLogCopiedSize;
    private long mLogSize;
    private final XTextView mTextView;
    private WorkStatus mWorkStatus;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum WorkStatus {
        IDLE,
        COPY,
        REBOOTING
    }

    @Override // com.xiaopeng.xui.app.XDialog
    public void dismiss() {
    }

    public Copy2UsbDialog(Context context) {
        super(context, -1, false);
        this.mLogSize = 0L;
        this.mLogCopiedSize = 0L;
        this.mWorkStatus = WorkStatus.IDLE;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.debug_copy_log_to_usb_layout, (ViewGroup) null);
        setContentView(inflate, true);
        this.mTextView = (XTextView) inflate.findViewById(R.id.debug_copy_log_to_usb_view);
        this.mTextView.setText(R.string.debug_msg_tv_start_copy_2_usb);
        showTitle(false);
        LogHelper.getInstance().addUsbStorageListener(this);
    }

    public void onCancel() {
        LogHelper.getInstance().removeUsbStorageListener(this);
        if (AnonymousClass4.$SwitchMap$com$xiaopeng$montecarlo$scenes$debugscene$Copy2UsbDialog$WorkStatus[this.mWorkStatus.ordinal()] == 1) {
            LogHelper.clearAllLog(true);
            RootUtil.delayExitApp(RootUtil.KILL_NAVI_COPY_AMAP_LOG_DONE);
        }
        if (WorkStatus.COPY != this.mWorkStatus) {
            UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.Copy2UsbDialog.1
                @Override // java.lang.Runnable
                public void run() {
                    Copy2UsbDialog.super.dismiss();
                }
            }, 100L);
        } else {
            UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.Copy2UsbDialog.2
                @Override // java.lang.Runnable
                public void run() {
                    ToastUtils.showToast(Copy2UsbDialog.this.mContext, (int) R.string.debug_copy_2_usb_toast_copying_can_not_quit);
                }
            }, 1000L);
        }
    }

    public void onOK() {
        int i = AnonymousClass4.$SwitchMap$com$xiaopeng$montecarlo$scenes$debugscene$Copy2UsbDialog$WorkStatus[this.mWorkStatus.ordinal()];
        if (i == 1) {
            LogHelper.clearAllLog(true);
            RootUtil.delayExitApp(RootUtil.KILL_NAVI_COPY_AMAP_LOG_DONE);
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            L.i(TAG, "ignore ok during COPY");
        } else {
            if (SystemProperties.getBoolean(USB_READ_ONLY, false)) {
                this.mTextView.setText(ContextUtils.getString(R.string.debug_copy_2_usb_msg_u_disk_read_only));
                L.w(TAG, "usb driver read only!");
            } else {
                this.mWorkStatus = WorkStatus.COPY;
                if (!LogHelper.getInstance().copyLogToUsb(this)) {
                    L.i(TAG, "copy log process is not finished");
                    this.mTextView.setText(ContextUtils.getString(R.string.debug_copy_2_usb_msg_continue));
                }
                L.i(TAG, "start COPY");
            }
            hideCancelButton();
        }
    }

    @Override // com.xiaopeng.montecarlo.root.util.logcat.ILogFileOperationCallback
    public void onStatusChange(LogFileStatus.CopyLogFileStatus copyLogFileStatus, LogFileStatus.CopyLogFileErrCode copyLogFileErrCode, long j, String str) {
        final String generateErrorMsg;
        boolean z;
        String format;
        L.i(TAG, "status:" + copyLogFileStatus + " err:" + copyLogFileErrCode + " intValue:" + j + " strValue:" + str);
        if (LogFileStatus.CopyLogFileErrCode.LOG_FILE_NO_ERROR == copyLogFileErrCode) {
            this.mLogCopiedSize += j;
            int i = AnonymousClass4.$SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileStatus[copyLogFileStatus.ordinal()];
            if (i == 1) {
                this.mLogSize = j;
                this.mLogCopiedSize = 0L;
                format = String.format(ContextUtils.getString(R.string.debug_copy_2_usb_msg_start), new Object[0]);
            } else if (i == 2) {
                format = String.format(ContextUtils.getString(R.string.debug_copy_2_usb_msg_copy_process), str);
            } else if (i != 3) {
                if (i != 4) {
                    if (i == 5) {
                        format = ContextUtils.getString(R.string.debug_copy_2_usb_msg_stop_amap_logs);
                        z = true;
                        generateErrorMsg = String.format(ContextUtils.getString(R.string.debug_copy_2_usb_msg_process), Float.valueOf((((float) this.mLogCopiedSize) / 1024.0f) / 1024.0f), Long.valueOf((this.mLogSize / 1024) / 1024)) + FDManager.LINE_SEPERATOR + format;
                    }
                } else if (!TextUtils.isEmpty(str)) {
                    format = String.format(ContextUtils.getString(R.string.debug_copy_2_usb_msg_zip_process), str);
                }
                format = "";
            } else {
                format = String.format(ContextUtils.getString(R.string.debug_copy_2_usb_msg_done), new Object[0]);
                this.mLogCopiedSize = this.mLogSize;
                this.mWorkStatus = WorkStatus.REBOOTING;
            }
            z = false;
            generateErrorMsg = String.format(ContextUtils.getString(R.string.debug_copy_2_usb_msg_process), Float.valueOf((((float) this.mLogCopiedSize) / 1024.0f) / 1024.0f), Long.valueOf((this.mLogSize / 1024) / 1024)) + FDManager.LINE_SEPERATOR + format;
        } else {
            generateErrorMsg = generateErrorMsg(copyLogFileStatus, copyLogFileErrCode, j);
            this.mWorkStatus = WorkStatus.IDLE;
            z = false;
        }
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.Copy2UsbDialog.3
            @Override // java.lang.Runnable
            public void run() {
                if (generateErrorMsg != null) {
                    Copy2UsbDialog.this.mTextView.setText(generateErrorMsg);
                }
            }
        }, 1000L);
        if (z) {
            L.i(TAG, "stop amap log");
            ServiceMgr.logStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.scenes.debugscene.Copy2UsbDialog$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileErrCode = new int[LogFileStatus.CopyLogFileErrCode.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileStatus;
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$scenes$debugscene$Copy2UsbDialog$WorkStatus;

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileErrCode[LogFileStatus.CopyLogFileErrCode.LOG_FILE_NO_USB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileErrCode[LogFileStatus.CopyLogFileErrCode.LOG_FILE_COPY_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileErrCode[LogFileStatus.CopyLogFileErrCode.LOG_FILE_ZIP_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileErrCode[LogFileStatus.CopyLogFileErrCode.LOG_FILE_NO_ENOUGH_SPACE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileStatus = new int[LogFileStatus.CopyLogFileStatus.values().length];
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileStatus[LogFileStatus.CopyLogFileStatus.LOG_FILE_COPY_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileStatus[LogFileStatus.CopyLogFileStatus.LOG_FILE_COPY_PROCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileStatus[LogFileStatus.CopyLogFileStatus.LOG_FILE_COPY_DONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileStatus[LogFileStatus.CopyLogFileStatus.LOG_FILE_ZIP_PROCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileStatus[LogFileStatus.CopyLogFileStatus.LOG_FILE_COPY_PREPARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            $SwitchMap$com$xiaopeng$montecarlo$scenes$debugscene$Copy2UsbDialog$WorkStatus = new int[WorkStatus.values().length];
            try {
                $SwitchMap$com$xiaopeng$montecarlo$scenes$debugscene$Copy2UsbDialog$WorkStatus[WorkStatus.REBOOTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$scenes$debugscene$Copy2UsbDialog$WorkStatus[WorkStatus.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$scenes$debugscene$Copy2UsbDialog$WorkStatus[WorkStatus.COPY.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private String generateErrorMsg(LogFileStatus.CopyLogFileStatus copyLogFileStatus, LogFileStatus.CopyLogFileErrCode copyLogFileErrCode, long j) {
        String string;
        if (LogFileStatus.CopyLogFileStatus.LOG_FILE_COPY_PROCESS == copyLogFileStatus) {
            int i = AnonymousClass4.$SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileErrCode[copyLogFileErrCode.ordinal()];
            if (i == 1) {
                string = ContextUtils.getString(R.string.debug_copy_2_usb_error_msg_err_usb_device_and_skip);
            } else if (i == 2) {
                string = ContextUtils.getString(R.string.debug_copy_2_usb_error_msg_err_copy_failed_and_skip);
            } else if (i != 3) {
                return null;
            } else {
                string = ContextUtils.getString(R.string.debug_copy_2_usb_error_msg_err_zip_failed_and_skip);
            }
            return string;
        }
        int i2 = AnonymousClass4.$SwitchMap$com$xiaopeng$montecarlo$root$util$logcat$LogFileStatus$CopyLogFileErrCode[copyLogFileErrCode.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return null;
                    }
                    return String.format(ContextUtils.getString(R.string.debug_copy_2_usb_error_msg_err_no_enough_space_and_try), Long.valueOf((j / 1024) / 1024));
                }
                return ContextUtils.getString(R.string.debug_copy_2_usb_error_msg_err_zip_failed_and_try);
            }
            return ContextUtils.getString(R.string.debug_copy_2_usb_error_msg_err_copy_failed_and_try);
        }
        return ContextUtils.getString(R.string.debug_copy_2_usb_error_msg_err_usb_device_and_try);
    }

    @Override // com.xiaopeng.montecarlo.root.util.storage.IUsbStorageListener
    public void onMount(String str) {
        ToastUtils.showToast(this.mContext, (int) R.string.debug_copy_2_usb_toast_usb_device_inserted);
    }

    @Override // com.xiaopeng.montecarlo.root.util.storage.IUsbStorageListener
    public void onUnmount() {
        ToastUtils.showToast(this.mContext, (int) R.string.debug_copy_2_usb_toast_usb_device_unplug);
    }
}
