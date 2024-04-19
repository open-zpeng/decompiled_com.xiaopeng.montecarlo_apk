package com.xiaopeng.montecarlo.navcore.download.constant;

import com.xiaopeng.montecarlo.util.SpeechRecognizerHelper;
/* loaded from: classes2.dex */
public enum TaskStatusCodeEnum {
    TASK_STATUS_CODE_READY(0, "READY"),
    TASK_STATUS_CODE_WAITING(1, "WAITING"),
    TASK_STATUS_CODE_DOING(2, "DOING"),
    TASK_STATUS_CODE_PAUSE(3, "PAUSE"),
    TASK_STATUS_CODE_DONE(4, "DONE"),
    TASK_STATUS_CODE_CHECKING(5, "CHECKING"),
    TASK_STATUS_CODE_CHECKED(6, "CHECKED"),
    TASK_STATUS_CODE_UNZIPPING(7, "UNZIPPING"),
    TASK_STATUS_CODE_UNZIPPED(8, "UNZIPPED"),
    TASK_STATUS_CODE_SUCCESS(9, SpeechRecognizerHelper.TTS_SPEAK_SUCCESS),
    TASK_STATUS_CODE_ERR(10, "ERR"),
    TASK_STATUS_CODE_MAX(11, "MAX");
    
    private int mId;
    private String mName;

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    TaskStatusCodeEnum(int i, String str) {
        this.mId = i;
        this.mName = str;
    }

    public Integer getValue() {
        return Integer.valueOf(this.mId);
    }

    public static TaskStatusCodeEnum parse(int i) {
        TaskStatusCodeEnum[] values;
        for (TaskStatusCodeEnum taskStatusCodeEnum : values()) {
            if (taskStatusCodeEnum.getId() == i) {
                return taskStatusCodeEnum;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mName;
    }
}
