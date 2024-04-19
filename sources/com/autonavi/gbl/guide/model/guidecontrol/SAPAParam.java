package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class SAPAParam extends BaseParam implements Serializable {
    public boolean enableServiceArea = true;
    public boolean enableTollgate = true;
    public int maxCount = 2;

    public SAPAParam() {
        this.paramType = 4;
    }
}
