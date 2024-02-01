package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class EmulatorParam extends BaseParam implements Serializable {
    public int speed = 0;
    @Deprecated
    public boolean locFrameFilter = true;

    public EmulatorParam() {
        this.paramType = 15;
    }
}
