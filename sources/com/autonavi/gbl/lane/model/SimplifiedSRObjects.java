package com.autonavi.gbl.lane.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SimplifiedSRObjects implements Serializable {
    public boolean isUseAbsoluteHeading;
    public boolean isUseSpeedSmooth;
    public ArrayList<SimplifiedSRObject> objects;

    public SimplifiedSRObjects() {
        this.isUseSpeedSmooth = false;
        this.isUseAbsoluteHeading = false;
        this.objects = new ArrayList<>();
    }

    public SimplifiedSRObjects(boolean z, boolean z2, ArrayList<SimplifiedSRObject> arrayList) {
        this.isUseSpeedSmooth = z;
        this.isUseAbsoluteHeading = z2;
        this.objects = arrayList;
    }
}
