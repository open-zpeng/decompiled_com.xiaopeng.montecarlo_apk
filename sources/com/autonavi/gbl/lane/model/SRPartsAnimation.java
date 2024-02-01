package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.AnimationActionType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class SRPartsAnimation implements Serializable {
    public String animationName;
    @AnimationActionType.AnimationActionType1
    public int animationType;
    public String name;
    public int repeatTimes;

    public SRPartsAnimation() {
        this.name = "";
        this.animationName = "";
        this.animationType = 0;
        this.repeatTimes = 0;
    }

    public SRPartsAnimation(String str, String str2, @AnimationActionType.AnimationActionType1 int i, int i2) {
        this.name = str;
        this.animationName = str2;
        this.animationType = i;
        this.repeatTimes = i2;
    }
}
