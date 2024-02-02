package com.xiaopeng.montecarlo.navcore.sr.data;

import android.os.Bundle;
import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class LaneDataAction {
    public static final String KEY_DOWNLOAD_TASK_CURRENT_SIZE = "KEY_DOWNLOAD_TASK_CURRENT_SIZE";
    public static final String KEY_DOWNLOAD_TASK_ERROR_CODE = "KEY_DOWNLOAD_TASK_ERROR_CODE";
    public static final String KEY_DOWNLOAD_TASK_MERGE_PERCENT = "KEY_DOWNLOAD_TASK_MERGE_PERCENT";
    public static final String KEY_DOWNLOAD_TASK_PERCENT = "KEY_DOWNLOAD_TASK_PERCENT";
    public static final String KEY_DOWNLOAD_TASK_STATUS_CODE = "KEY_DOWNLOAD_TASK_STATUS_CODE";
    public static final String KEY_DOWNLOAD_TASK_TOTAL_SIZE = "KEY_DOWNLOAD_TASK_TOTAL_SIZE";
    public static final String KEY_DOWNLOAD_TASK_URID = "KEY_DOWNLOAD_TASK_URID";
    public static final String KEY_DOWNLOAD_TASK_VERSION = "KEY_DOWNLOAD_TASK_VERSION";
    public static final int LANE_ACTION_GET_DOWNLOAD_ERROR = 4;
    public static final int LANE_ACTION_GET_DOWNLOAD_PROGRESS = 5;
    public static final int LANE_ACTION_GET_DOWNLOAD_STATUS = 3;
    public static final int LANE_ACTION_GET_DOWNLOAD_VERSION = 2;
    public static final int LANE_ACTION_GET_MERGE_PROGRESS = 6;
    public static final int LANE_ACTION_INIT_FINISH = 1;
    private int mActionCode;
    private volatile Bundle mActionData;

    private LaneDataAction() {
    }

    public static LaneDataAction obtain() {
        return new LaneDataAction();
    }

    public static LaneDataAction obtain(int i) {
        LaneDataAction obtain = obtain();
        obtain.mActionCode = i;
        return obtain;
    }

    public int getActionCode() {
        return this.mActionCode;
    }

    public void setDownloadTaskUrId(int i) {
        getActionData().putInt(KEY_DOWNLOAD_TASK_URID, i);
    }

    public int getDownloadTaskUrId() {
        return getActionData().getInt(KEY_DOWNLOAD_TASK_URID, -1);
    }

    public void setDownloadTaskVersion(String str) {
        getActionData().putString(KEY_DOWNLOAD_TASK_VERSION, str);
    }

    public String getDownloadTaskVersion() {
        return getActionData().getString(KEY_DOWNLOAD_TASK_VERSION, "");
    }

    public void setDownloadTaskStatus(int i) {
        getActionData().putInt(KEY_DOWNLOAD_TASK_STATUS_CODE, i);
    }

    public int getDownloadTaskStatus() {
        return getActionData().getInt(KEY_DOWNLOAD_TASK_STATUS_CODE, LaneDownloadTaskStatusCodeEnum.TASK_STATUS_CODE_UNKNOWN.getStatusCode());
    }

    public void setDownloadTaskErrorCode(int i) {
        getActionData().putInt(KEY_DOWNLOAD_TASK_ERROR_CODE, i);
    }

    public int getDownloadTaskErrorCode() {
        return getActionData().getInt(KEY_DOWNLOAD_TASK_ERROR_CODE, LaneDownloadTaskErrorCodeEnum.OPERATION_ERR_CODE_UNKNOWN.getErrorCode());
    }

    public void setDownloadTaskTotalSize(long j) {
        getActionData().putLong(KEY_DOWNLOAD_TASK_TOTAL_SIZE, j);
    }

    public long getDownloadTaskTotalSize() {
        return getActionData().getLong(KEY_DOWNLOAD_TASK_TOTAL_SIZE, -1L);
    }

    public void setDownloadTaskPercent(float f) {
        getActionData().putFloat(KEY_DOWNLOAD_TASK_PERCENT, f);
    }

    public float getDownloadTaskPercent() {
        return getActionData().getFloat(KEY_DOWNLOAD_TASK_PERCENT, -1.0f);
    }

    public void setAllDownloadTaskCurrentSize(double d) {
        getActionData().putDouble(KEY_DOWNLOAD_TASK_CURRENT_SIZE, d);
    }

    public double getAllDownloadTaskCurrentSize() {
        return getActionData().getDouble(KEY_DOWNLOAD_TASK_CURRENT_SIZE, -1.0d);
    }

    public void setDownloadTaskMergePercent(float f) {
        getActionData().putFloat(KEY_DOWNLOAD_TASK_MERGE_PERCENT, f);
    }

    public float getDownloadTaskMergePercent() {
        return getActionData().getFloat(KEY_DOWNLOAD_TASK_MERGE_PERCENT, -1.0f);
    }

    @NonNull
    private Bundle getActionData() {
        if (this.mActionData == null) {
            synchronized (this) {
                if (this.mActionData == null) {
                    this.mActionData = new Bundle();
                }
            }
        }
        return this.mActionData;
    }
}
