package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.LaneUniversalAnimationType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class DecisionDirectionStyle implements Serializable {
    @LaneUniversalAnimationType.LaneUniversalAnimationType1
    public int animationType;
    public int resID;

    public DecisionDirectionStyle() {
        this.resID = -1;
        this.animationType = 0;
    }

    public DecisionDirectionStyle(int i, @LaneUniversalAnimationType.LaneUniversalAnimationType1 int i2) {
        this.resID = i;
        this.animationType = i2;
    }
}
