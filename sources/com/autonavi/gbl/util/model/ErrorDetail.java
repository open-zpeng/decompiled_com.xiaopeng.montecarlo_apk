package com.autonavi.gbl.util.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ErrorDetail implements Serializable {
    public String description;
    public String errorCode;
    public String suggesstion;

    public ErrorDetail() {
        this.errorCode = "";
        this.description = "";
        this.suggesstion = "";
    }

    public ErrorDetail(String str, String str2, String str3) {
        this.errorCode = str;
        this.description = str2;
        this.suggesstion = str3;
    }
}
