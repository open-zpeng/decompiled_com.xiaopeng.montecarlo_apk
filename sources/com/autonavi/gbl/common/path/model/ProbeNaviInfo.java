package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ProbeNaviInfo implements Serializable {
    public int curLinkIndex;
    public int curPointIndex;
    public int curSegIndex;
    public boolean isNavi;
    public int linkRemainDist;
    public int routeRemainDist;

    public ProbeNaviInfo() {
        this.curSegIndex = 0;
        this.curLinkIndex = 0;
        this.curPointIndex = 0;
        this.routeRemainDist = 0;
        this.linkRemainDist = 0;
        this.isNavi = false;
    }

    public ProbeNaviInfo(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.curSegIndex = i;
        this.curLinkIndex = i2;
        this.curPointIndex = i3;
        this.routeRemainDist = i4;
        this.linkRemainDist = i5;
        this.isNavi = z;
    }
}
