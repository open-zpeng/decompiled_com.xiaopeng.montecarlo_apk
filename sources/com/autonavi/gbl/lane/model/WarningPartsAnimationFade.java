package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.AnimationFadeType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class WarningPartsAnimationFade implements Serializable {
    @AnimationFadeType.AnimationFadeType1
    public int fadeType;
    public String name;

    public WarningPartsAnimationFade() {
        this.name = "";
        this.fadeType = 0;
    }

    public WarningPartsAnimationFade(String str, @AnimationFadeType.AnimationFadeType1 int i) {
        this.name = str;
        this.fadeType = i;
    }
}
