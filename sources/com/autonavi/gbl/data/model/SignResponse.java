package com.autonavi.gbl.data.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class SignResponse implements Serializable {
    public String data;
    public int nStatus;

    public SignResponse() {
        this.nStatus = -1;
        this.data = "";
    }

    public SignResponse(int i, String str) {
        this.nStatus = i;
        this.data = str;
    }
}
