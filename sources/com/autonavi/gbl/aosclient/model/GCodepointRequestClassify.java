package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCodepointRequestClassify implements Serializable {
    public String blocks;
    public String category;
    public int maxnum_limit;
    public String slayer_brand;

    public GCodepointRequestClassify() {
        this.blocks = "";
        this.category = "";
        this.maxnum_limit = 20;
        this.slayer_brand = "";
    }

    public GCodepointRequestClassify(String str, String str2, int i, String str3) {
        this.blocks = str;
        this.category = str2;
        this.maxnum_limit = i;
        this.slayer_brand = str3;
    }
}
