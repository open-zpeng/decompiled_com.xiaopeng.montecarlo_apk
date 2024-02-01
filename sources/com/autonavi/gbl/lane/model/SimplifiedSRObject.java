package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.SRType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SimplifiedSRObject implements Serializable {
    public float heading;
    public boolean isHighlight;
    public int modelResID;
    public int objectID;
    public ArrayList<SRPartsAnimation> partsAnimation;
    public ArrayList<SRPartsStyle> partsStyle;
    public float speed;
    @SRType.SRType1
    public int srType;

    public SimplifiedSRObject() {
        this.objectID = -1;
        this.modelResID = -1;
        this.srType = 0;
        this.heading = 0.0f;
        this.isHighlight = false;
        this.partsStyle = new ArrayList<>();
        this.partsAnimation = new ArrayList<>();
        this.speed = 0.0f;
    }

    public SimplifiedSRObject(int i, int i2, @SRType.SRType1 int i3, float f, boolean z, ArrayList<SRPartsStyle> arrayList, ArrayList<SRPartsAnimation> arrayList2, float f2) {
        this.objectID = i;
        this.modelResID = i2;
        this.srType = i3;
        this.heading = f;
        this.isHighlight = z;
        this.partsStyle = arrayList;
        this.partsAnimation = arrayList2;
        this.speed = f2;
    }
}
