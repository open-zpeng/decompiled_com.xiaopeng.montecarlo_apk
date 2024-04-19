package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCodepointRequestKeyword implements Serializable {
    public String blocks;
    public String keywords;
    public int maxnum_limit;
    public String slayer_brand;

    public GCodepointRequestKeyword() {
        this.blocks = "";
        this.keywords = "";
        this.maxnum_limit = 20;
        this.slayer_brand = "";
    }

    public GCodepointRequestKeyword(String str, String str2, int i, String str3) {
        this.blocks = str;
        this.keywords = str2;
        this.maxnum_limit = i;
        this.slayer_brand = str3;
    }
}
