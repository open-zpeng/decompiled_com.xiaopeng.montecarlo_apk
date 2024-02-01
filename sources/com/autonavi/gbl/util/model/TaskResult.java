package com.autonavi.gbl.util.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class TaskResult implements Serializable {
    public int errorCode;
    public String errorMessage;
    public long taskId;

    public TaskResult() {
        this.errorCode = 16777215;
        this.errorMessage = "";
        this.taskId = 0L;
    }

    public TaskResult(int i, String str, long j) {
        this.errorCode = i;
        this.errorMessage = str;
        this.taskId = j;
    }
}
