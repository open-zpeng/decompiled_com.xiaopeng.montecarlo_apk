package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class JiliAutoParam extends BaseParam implements Serializable {
    public int highWayDist = 700;
    public int commonWayDist = 300;

    public JiliAutoParam() {
        this.paramType = 16;
    }
}
