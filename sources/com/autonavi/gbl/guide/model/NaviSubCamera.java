package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.path.model.BreakRuleCameraSubType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class NaviSubCamera implements Serializable {
    public int makeSound;
    @BreakRuleCameraSubType.BreakRuleCameraSubType1
    public int subType;

    public NaviSubCamera() {
        this.subType = 0;
        this.makeSound = 0;
    }

    public NaviSubCamera(@BreakRuleCameraSubType.BreakRuleCameraSubType1 int i, int i2) {
        this.subType = i;
        this.makeSound = i2;
    }
}
