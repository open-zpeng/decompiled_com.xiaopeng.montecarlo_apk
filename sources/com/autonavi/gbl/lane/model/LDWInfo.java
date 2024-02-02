package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LDW_DIRECTION;
import com.autonavi.gbl.lane.model.LDW_STATUS;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LDWInfo implements Serializable {
    @LDW_DIRECTION.LDW_DIRECTION1
    public int direction;
    @LDW_STATUS.LDW_STATUS1
    public int status;

    public LDWInfo() {
        this.status = 0;
        this.direction = 0;
    }

    public LDWInfo(@LDW_STATUS.LDW_STATUS1 int i, @LDW_DIRECTION.LDW_DIRECTION1 int i2) {
        this.status = i;
        this.direction = i2;
    }
}
