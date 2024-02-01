package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ManeuverParam extends BaseParam implements Serializable {
    public boolean enableAutoObtain = false;
    public boolean enableAdvancedRender = false;
    public long width = 400;
    public long height = 400;
    public long arrowColor = -5588020;
    public long backColor = -16729140;
    public long roadColor = -5588224;

    public ManeuverParam() {
        this.paramType = 29;
    }
}
