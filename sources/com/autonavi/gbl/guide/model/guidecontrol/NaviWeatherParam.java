package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class NaviWeatherParam extends BaseParam implements Serializable {
    public boolean enable = true;
    public int updateFreqency = 900;
    public int updateDriveLength = 5000;

    public NaviWeatherParam() {
        this.paramType = 17;
    }
}
