package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class KeywordSearchOfflineParam implements Serializable {
    public int adcode;
    public String custom;
    public int resultMaxCount;

    public KeywordSearchOfflineParam() {
        this.adcode = 0;
        this.resultMaxCount = 20;
        this.custom = "";
    }

    public KeywordSearchOfflineParam(int i, int i2, String str) {
        this.adcode = i;
        this.resultMaxCount = i2;
        this.custom = str;
    }
}
