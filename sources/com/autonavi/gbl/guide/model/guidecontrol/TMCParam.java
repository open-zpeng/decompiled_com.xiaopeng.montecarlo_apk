package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TMCParam extends BaseParam implements Serializable {
    public boolean enable = true;
    public boolean congestionTime = true;
    public boolean congestionReroute = true;
    public boolean ETARestriction = false;
    public boolean roadCloseReroute = true;
    public boolean forbidAreaReroute = true;
    public boolean restrictAreaReroute = true;
    public boolean showLightBar = true;
    public int updateFreqency = 65;

    public TMCParam() {
        this.paramType = 2;
    }
}
