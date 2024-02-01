package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class STEventDetail extends STDetail implements Serializable {
    public long eventID = 0;
    public String strRoadName = "";
    public int orgType = 0;
    public int eventType = 0;
    public String source = "";
    public long segIdx = 0;
    public long linkIdx = 0;
    public String rdClass = "";
    public int lane = 0;
    public String title = "";
    public int titleType = 0;

    public STEventDetail() {
        this.detailCategory = 2;
    }
}
