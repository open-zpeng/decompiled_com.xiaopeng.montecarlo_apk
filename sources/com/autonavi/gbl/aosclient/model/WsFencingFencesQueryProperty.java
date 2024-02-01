package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsFencingFencesQueryProperty implements Serializable {
    public int radius;
    public String radiusUnits;
    public WsFencingFencesQueryRectangle rectangle;
    public String type;

    public WsFencingFencesQueryProperty() {
        this.rectangle = new WsFencingFencesQueryRectangle();
        this.type = "";
        this.radius = 0;
        this.radiusUnits = "";
    }

    public WsFencingFencesQueryProperty(WsFencingFencesQueryRectangle wsFencingFencesQueryRectangle, String str, int i, String str2) {
        this.rectangle = wsFencingFencesQueryRectangle;
        this.type = str;
        this.radius = i;
        this.radiusUnits = str2;
    }
}
