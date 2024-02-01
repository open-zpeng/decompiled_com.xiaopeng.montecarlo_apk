package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WarningPartsStyle implements Serializable {
    public String name;
    public int textureId;

    public WarningPartsStyle() {
        this.name = "";
        this.textureId = -1;
    }

    public WarningPartsStyle(String str, int i) {
        this.name = str;
        this.textureId = i;
    }
}
