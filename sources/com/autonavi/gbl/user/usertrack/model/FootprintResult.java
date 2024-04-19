package com.autonavi.gbl.user.usertrack.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class FootprintResult implements Serializable {
    public int code;
    public String message;

    public FootprintResult() {
        this.code = 0;
        this.message = "";
    }

    public FootprintResult(int i, String str) {
        this.code = i;
        this.message = str;
    }
}
