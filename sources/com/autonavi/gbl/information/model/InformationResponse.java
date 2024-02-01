package com.autonavi.gbl.information.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class InformationResponse implements Serializable {
    public int errorCode;
    public String errorMessage;
    public long taskId;

    public InformationResponse() {
        this.taskId = 0L;
        this.errorCode = 0;
        this.errorMessage = "";
    }

    public InformationResponse(long j, int i, String str) {
        this.taskId = j;
        this.errorCode = i;
        this.errorMessage = str;
    }
}
