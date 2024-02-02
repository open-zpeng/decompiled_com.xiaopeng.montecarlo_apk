package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.layer.model.ItemIgnoreType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ItemIgnoreRegion implements Serializable {
    public RectInt mRect;
    @ItemIgnoreType.ItemIgnoreType1
    public int mType;

    public ItemIgnoreRegion() {
        this.mType = 0;
        this.mRect = new RectInt();
    }

    public ItemIgnoreRegion(@ItemIgnoreType.ItemIgnoreType1 int i, RectInt rectInt) {
        this.mType = i;
        this.mRect = rectInt;
    }
}
