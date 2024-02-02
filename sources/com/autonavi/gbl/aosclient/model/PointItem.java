package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PointItem implements Serializable {
    public PointData data;
    public int type;

    public PointItem() {
        this.type = 0;
        this.data = new PointData();
    }

    public PointItem(int i, PointData pointData) {
        this.type = i;
        this.data = pointData;
    }
}
