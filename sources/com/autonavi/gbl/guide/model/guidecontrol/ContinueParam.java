package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ContinueParam extends BaseParam implements Serializable {
    public boolean enableContinue = false;
    public boolean enableSapaContinue = false;

    public ContinueParam() {
        this.paramType = 30;
    }
}
