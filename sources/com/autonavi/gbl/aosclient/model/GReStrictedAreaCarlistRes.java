package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GReStrictedAreaCarlistRes implements Serializable {
    public int adcode;
    public String name;
    public String pinyin;

    public GReStrictedAreaCarlistRes() {
        this.name = "";
        this.pinyin = "";
        this.adcode = 0;
    }

    public GReStrictedAreaCarlistRes(String str, String str2, int i) {
        this.name = str;
        this.pinyin = str2;
        this.adcode = i;
    }
}
