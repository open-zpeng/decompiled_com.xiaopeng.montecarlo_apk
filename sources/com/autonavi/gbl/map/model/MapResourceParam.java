package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.MapResourceType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapResourceParam implements Serializable {
    public String name;
    public int subType;
    @MapResourceType.MapResourceType1
    public int type;

    public MapResourceParam() {
        this.subType = 0;
        this.type = 0;
        this.name = "";
    }

    public MapResourceParam(int i, @MapResourceType.MapResourceType1 int i2, String str) {
        this.subType = i;
        this.type = i2;
        this.name = str;
    }
}
