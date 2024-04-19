package com.autonavi.gbl.guide.model.guidecontrol;

import java.io.Serializable;
/* loaded from: classes.dex */
public class NaviPointInfo extends BaseParam implements Serializable {
    public double realPosLon = 0.0d;
    public double realPosLat = 0.0d;
    public double naviPosLon = 0.0d;
    public double naviPosLat = 0.0d;
    public String poiID = "";
    public String name = "";

    public NaviPointInfo() {
        this.paramType = 20;
    }
}
