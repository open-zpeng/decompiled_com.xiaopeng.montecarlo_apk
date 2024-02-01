package com.xiaopeng.montecarlo.navcore.sr.data;
/* loaded from: classes3.dex */
public enum LaneDownloadTaskStatusCodeEnum {
    TASK_STATUS_CODE_UNKNOWN(-1, "Unknown"),
    TASK_STATUS_CODE_READY(0, "Ready"),
    TASK_STATUS_CODE_WAITING(1, "Waiting"),
    TASK_STATUS_CODE_DOING(2, "Start_Download"),
    TASK_STATUS_CODE_PAUSE(3, "Pause_Download"),
    TASK_STATUS_CODE_DONE(4, "Download_Finish"),
    TASK_STATUS_CODE_CHECKING(5, "Checking"),
    TASK_STATUS_CODE_CHECKED(6, "Checked"),
    TASK_STATUS_CODE_UNZIPPING(7, "Unzipping"),
    TASK_STATUS_CODE_UNZIPPED(8, "Unzipped"),
    TASK_STATUS_CODE_SUCCESS(9, "All_finish"),
    TASK_STATUS_CODE_ERR(10, "Err"),
    TASK_STATUS_CODE_MAX(11, "Max");
    
    private final int mStatusCode;
    private final String mStatusName;

    LaneDownloadTaskStatusCodeEnum(int i, String str) {
        this.mStatusCode = i;
        this.mStatusName = str;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public static LaneDownloadTaskStatusCodeEnum parse(int i) {
        LaneDownloadTaskStatusCodeEnum[] values;
        for (LaneDownloadTaskStatusCodeEnum laneDownloadTaskStatusCodeEnum : values()) {
            if (laneDownloadTaskStatusCodeEnum.getStatusCode() == i) {
                return laneDownloadTaskStatusCodeEnum;
            }
        }
        return null;
    }
}
