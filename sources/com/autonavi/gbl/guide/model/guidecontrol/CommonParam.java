package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CommonParam extends BaseParam implements Serializable {
    public String userCode = null;
    public String cifa = null;
    public String cachePath = null;
    public String password = null;
    public boolean enableAuto = false;
    public boolean enableDriveAnalysis = false;
    public boolean supportAirPressureGauge = false;

    public CommonParam() {
        this.paramType = 1;
    }
}
