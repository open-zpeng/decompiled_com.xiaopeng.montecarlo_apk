package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TollGateLaneParam extends BaseParam implements Serializable {
    public int[] checkDistance;
    public boolean enable = true;

    public TollGateLaneParam() {
        this.paramType = 5;
        this.checkDistance = new int[]{1000, 1000, 500};
    }
}
