package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class NaviFacilityParam extends BaseParam implements Serializable {
    public int[] checkDistance;
    @Deprecated
    public int[] filter;
    @Deprecated
    public boolean enable = true;
    @Deprecated
    public int maxCount = 2;

    public NaviFacilityParam() {
        this.paramType = 23;
        this.checkDistance = new int[3];
        int[] iArr = this.checkDistance;
        iArr[0] = 1000;
        iArr[1] = 1000;
        iArr[2] = 500;
        this.filter = new int[36];
    }
}
