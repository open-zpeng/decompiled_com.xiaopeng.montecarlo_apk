package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CarPartsStyle implements Serializable {
    public String name;
    public int textureId;

    public CarPartsStyle() {
        this.name = "";
        this.textureId = -1;
    }

    public CarPartsStyle(String str, int i) {
        this.name = str;
        this.textureId = i;
    }
}
