package com.autonavi.gbl.data.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class InitConfigBase implements Serializable {
    public String configfilePath;
    public int maxConcurrentCount;
    public int thresholdValue;

    public InitConfigBase() {
        this.maxConcurrentCount = 0;
        this.thresholdValue = 0;
        this.configfilePath = "";
    }

    public InitConfigBase(int i, int i2, String str) {
        this.maxConcurrentCount = i;
        this.thresholdValue = i2;
        this.configfilePath = str;
    }
}
