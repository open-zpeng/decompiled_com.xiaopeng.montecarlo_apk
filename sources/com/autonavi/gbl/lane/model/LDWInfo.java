package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LDWDirection;
import com.autonavi.gbl.lane.model.LDWStatus;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LDWInfo implements Serializable {
    @LDWDirection.LDWDirection1
    public int direction;
    @LDWStatus.LDWStatus1
    public int status;

    public LDWInfo() {
        this.status = 0;
        this.direction = 0;
    }

    public LDWInfo(@LDWStatus.LDWStatus1 int i, @LDWDirection.LDWDirection1 int i2) {
        this.status = i;
        this.direction = i2;
    }
}
