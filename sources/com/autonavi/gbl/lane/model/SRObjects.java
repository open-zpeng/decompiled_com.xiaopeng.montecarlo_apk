package com.autonavi.gbl.lane.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SRObjects implements Serializable {
    public RelativePos carPos;
    public boolean isUseAbsoluteHeading;
    public boolean isUseRotation;
    public boolean isUseSpeedSmooth;
    public RelativePos localRefPos;
    public ArrayList<SRObject> objects;
    public LanePosRotation rotation;

    public SRObjects() {
        this.objects = new ArrayList<>();
        this.carPos = new RelativePos();
        this.localRefPos = new RelativePos();
        this.isUseRotation = false;
        this.rotation = new LanePosRotation();
        this.isUseSpeedSmooth = false;
        this.isUseAbsoluteHeading = false;
    }

    public SRObjects(ArrayList<SRObject> arrayList, RelativePos relativePos, RelativePos relativePos2, boolean z, LanePosRotation lanePosRotation, boolean z2, boolean z3) {
        this.objects = arrayList;
        this.carPos = relativePos;
        this.localRefPos = relativePos2;
        this.isUseRotation = z;
        this.rotation = lanePosRotation;
        this.isUseSpeedSmooth = z2;
        this.isUseAbsoluteHeading = z3;
    }
}
