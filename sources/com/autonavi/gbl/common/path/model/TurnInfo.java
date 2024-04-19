package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.path.model.TurnType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TurnInfo implements Serializable {
    public int lat;
    public int lon;
    @TurnType.TurnType1
    public int type;

    public TurnInfo() {
        this.type = 0;
        this.lon = 0;
        this.lat = 0;
    }

    public TurnInfo(@TurnType.TurnType1 int i, int i2, int i3) {
        this.type = i;
        this.lon = i2;
        this.lat = i3;
    }
}
