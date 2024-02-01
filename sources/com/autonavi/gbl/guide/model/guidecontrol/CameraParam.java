package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CameraParam extends BaseParam implements Serializable {
    public int[] checkDistance;
    public boolean enable = true;
    public int maxCount = 2;

    public CameraParam() {
        this.paramType = 8;
        this.checkDistance = new int[3];
        int[] iArr = this.checkDistance;
        iArr[0] = 1000;
        iArr[1] = 1000;
        iArr[2] = 500;
    }
}
