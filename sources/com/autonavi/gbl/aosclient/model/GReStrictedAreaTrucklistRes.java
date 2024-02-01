package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GReStrictedAreaTrucklistRes implements Serializable {
    public int adcode;
    public String name;
    public String pinyin;

    public GReStrictedAreaTrucklistRes() {
        this.name = "";
        this.pinyin = "";
        this.adcode = 0;
    }

    public GReStrictedAreaTrucklistRes(String str, String str2, int i) {
        this.name = str;
        this.pinyin = str2;
        this.adcode = i;
    }
}
