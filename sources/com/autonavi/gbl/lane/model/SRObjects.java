package com.autonavi.gbl.lane.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SRObjects implements Serializable {
    public RelativePos carPos;
    public boolean isUseRotation;
    public RelativePos localRefPos;
    public ArrayList<SRObject> objects;
    public LanePosRotation rotation;

    public SRObjects() {
        this.objects = new ArrayList<>();
        this.carPos = new RelativePos();
        this.localRefPos = new RelativePos();
        this.isUseRotation = false;
        this.rotation = new LanePosRotation();
    }

    public SRObjects(ArrayList<SRObject> arrayList, RelativePos relativePos, RelativePos relativePos2, boolean z, LanePosRotation lanePosRotation) {
        this.objects = arrayList;
        this.carPos = relativePos;
        this.localRefPos = relativePos2;
        this.isUseRotation = z;
        this.rotation = lanePosRotation;
    }
}
