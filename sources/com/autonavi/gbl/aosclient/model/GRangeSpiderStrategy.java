package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GRangeSpiderStrategy implements Serializable {
    public int flag;
    public String time;
    public int type;

    public GRangeSpiderStrategy() {
        this.type = 0;
        this.flag = 0;
        this.time = "";
    }

    public GRangeSpiderStrategy(int i, int i2, String str) {
        this.type = i;
        this.flag = i2;
        this.time = str;
    }
}
