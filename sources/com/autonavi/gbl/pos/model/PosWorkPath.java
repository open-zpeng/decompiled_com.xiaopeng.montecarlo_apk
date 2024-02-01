package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PosWorkPath implements Serializable {
    public String contextPath;
    public String locPath;

    public PosWorkPath() {
        this.locPath = "";
        this.contextPath = "";
    }

    public PosWorkPath(String str, String str2) {
        this.locPath = str;
        this.contextPath = str2;
    }
}
