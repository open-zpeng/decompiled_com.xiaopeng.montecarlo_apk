package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CameraParam extends BaseParam implements Serializable {
    public int[] checkDistance;
    public int[] filter;
    public boolean enable = true;
    public int maxCount = 2;

    public CameraParam() {
        this.paramType = 8;
        this.checkDistance = new int[]{1000, 1000, 500};
        this.filter = new int[32];
    }
}
