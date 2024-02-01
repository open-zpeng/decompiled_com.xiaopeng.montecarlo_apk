package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TimeConversionParam extends BaseParam implements Serializable {
    public boolean enableNetworkTime2BJ = true;
    public boolean enableGpsTime2BJ = false;
    public boolean enableLocalTime2BJ = false;

    public TimeConversionParam() {
        this.paramType = 31;
    }
}
