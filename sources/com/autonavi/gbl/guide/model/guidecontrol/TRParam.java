package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TRParam extends BaseParam implements Serializable {
    public boolean enable = true;
    public boolean viewOpen = true;
    public boolean eventOpen = true;
    public boolean socolStatus = false;

    public TRParam() {
        this.paramType = 3;
    }
}
