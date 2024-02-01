package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ClickViewIdInfo implements Serializable {
    public String bgMarkerClickViewId;
    public String bubbleMarkerClickViewId;
    public String poiMarkerClickViewId;

    public ClickViewIdInfo() {
        this.poiMarkerClickViewId = "";
        this.bgMarkerClickViewId = "";
        this.bubbleMarkerClickViewId = "";
    }

    public ClickViewIdInfo(String str, String str2, String str3) {
        this.poiMarkerClickViewId = str;
        this.bgMarkerClickViewId = str2;
        this.bubbleMarkerClickViewId = str3;
    }
}
