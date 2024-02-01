package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCarLtdQuickLoginData implements Serializable {
    public String amap_token;
    public long amap_uid;

    public GCarLtdQuickLoginData() {
        this.amap_uid = 0L;
        this.amap_token = "";
    }

    public GCarLtdQuickLoginData(long j, String str) {
        this.amap_uid = j;
        this.amap_token = str;
    }
}
