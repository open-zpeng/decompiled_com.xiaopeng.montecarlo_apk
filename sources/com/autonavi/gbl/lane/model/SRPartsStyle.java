package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class SRPartsStyle implements Serializable {
    public String name;
    public int textureId;

    public SRPartsStyle() {
        this.name = "";
        this.textureId = -1;
    }

    public SRPartsStyle(String str, int i) {
        this.name = str;
        this.textureId = i;
    }
}
