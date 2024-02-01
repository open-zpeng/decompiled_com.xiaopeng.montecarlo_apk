package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CommonParam extends BaseParam implements Serializable {
    public String userCode = "";
    @Deprecated
    public String cifa = "";
    @Deprecated
    public String cachePath = "";
    @Deprecated
    public String password = "";
    public boolean enableAuto = false;
    @Deprecated
    public boolean enableDriveAnalysis = false;
    public boolean supportAirPressureGauge = false;

    public CommonParam() {
        this.paramType = 1;
    }
}
