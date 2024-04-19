package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ScenicMainPageRecDataScenic implements Serializable {
    public int effective_level;
    public String schema;
    public int showScenicEntrance;
    public String text;

    public ScenicMainPageRecDataScenic() {
        this.showScenicEntrance = 0;
        this.schema = "";
        this.text = "";
        this.effective_level = 0;
    }

    public ScenicMainPageRecDataScenic(int i, String str, String str2, int i2) {
        this.showScenicEntrance = i;
        this.schema = str;
        this.text = str2;
        this.effective_level = i2;
    }
}
