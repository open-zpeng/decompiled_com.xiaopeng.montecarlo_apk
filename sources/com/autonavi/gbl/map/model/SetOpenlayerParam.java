package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.SublayerDataType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SetOpenlayerParam implements Serializable {
    public float alpha;
    public int deepInfoCount;
    public int maxZoom;
    public int minZoom;
    public int openlayerID;
    public boolean showFilter;
    @SublayerDataType.SublayerDataType1
    public int subLayerDataType;

    public SetOpenlayerParam() {
        this.subLayerDataType = 1;
        this.openlayerID = 0;
        this.minZoom = 0;
        this.maxZoom = 0;
        this.alpha = 1.0f;
        this.deepInfoCount = -1;
        this.showFilter = false;
    }

    public SetOpenlayerParam(@SublayerDataType.SublayerDataType1 int i, int i2, int i3, int i4, float f, int i5, boolean z) {
        this.subLayerDataType = i;
        this.openlayerID = i2;
        this.minZoom = i3;
        this.maxZoom = i4;
        this.alpha = f;
        this.deepInfoCount = i5;
        this.showFilter = z;
    }
}
