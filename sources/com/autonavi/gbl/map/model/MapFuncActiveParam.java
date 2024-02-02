package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.MapFuncActiveType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class MapFuncActiveParam implements Serializable {
    public long param;
    @MapFuncActiveType.MapFuncActiveType1
    public int type;

    public MapFuncActiveParam() {
        this.type = 0;
        this.param = 0L;
    }

    public MapFuncActiveParam(@MapFuncActiveType.MapFuncActiveType1 int i, long j) {
        this.type = i;
        this.param = j;
    }
}
