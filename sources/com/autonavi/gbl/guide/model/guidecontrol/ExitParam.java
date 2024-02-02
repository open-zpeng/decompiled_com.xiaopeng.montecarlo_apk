package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ExitParam extends BaseParam implements Serializable {
    public boolean enableExit = true;
    public boolean enableDirection = true;
    public int maxExitNameCount = 5;
    public int maxDirectionNameCount = 4;

    public ExitParam() {
        this.paramType = 9;
    }
}
