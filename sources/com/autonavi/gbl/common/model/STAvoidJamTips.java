package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class STAvoidJamTips extends STBaseTips implements Serializable {
    public String strJamRoadName = "";
    public String strJamDist = "";
    public String strJamTime = "";

    public STAvoidJamTips() {
        this.tipsCategory = 2;
    }
}
