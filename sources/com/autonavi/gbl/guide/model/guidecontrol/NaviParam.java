package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class NaviParam extends BaseParam implements Serializable {
    public int requestRouteType = 0;
    public int constrainCondition = 0;
    public int model = 0;
    public int naviInfoCnt = 1;
    public boolean familiarRoute = false;
    public byte naviScene = 0;
    public int customSource = 16;
    public int aimDriver = 1;

    public NaviParam() {
        this.paramType = 7;
    }
}
