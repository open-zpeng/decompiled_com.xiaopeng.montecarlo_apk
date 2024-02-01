package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CrossCardChangeInfo implements Serializable {
    public CrossLinkLocation linkLoc;
    public String showInfo;

    public CrossCardChangeInfo() {
        this.linkLoc = new CrossLinkLocation();
        this.showInfo = "";
    }

    public CrossCardChangeInfo(CrossLinkLocation crossLinkLocation, String str) {
        this.linkLoc = crossLinkLocation;
        this.showInfo = str;
    }
}
