package com.autonavi.gbl.activation.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AuthenticationFunctionInfo implements Serializable {
    public String description;
    public int functionId;
    public String functionName;

    public AuthenticationFunctionInfo() {
        this.functionId = 0;
        this.functionName = "";
        this.description = "";
    }

    public AuthenticationFunctionInfo(int i, String str, String str2) {
        this.functionId = i;
        this.functionName = str;
        this.description = str2;
    }
}
