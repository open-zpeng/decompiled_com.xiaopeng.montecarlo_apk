package com.autonavi.gbl.data.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class MapNum implements Serializable {
    public String strContent;
    public String strKey;
    public String strVersion;

    public MapNum() {
        this.strKey = "";
        this.strVersion = "";
        this.strContent = "";
    }

    public MapNum(String str, String str2, String str3) {
        this.strKey = str;
        this.strVersion = str2;
        this.strContent = str3;
    }
}
