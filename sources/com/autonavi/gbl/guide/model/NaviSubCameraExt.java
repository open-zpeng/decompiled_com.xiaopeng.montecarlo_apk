package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.path.model.SubCameraExtType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NaviSubCameraExt implements Serializable {
    public int buswayTimeEnable;
    public long cameraId;
    public boolean isMatch;
    public boolean isNew;
    public boolean isSpecial;
    public boolean isVariableSpeed;
    public int penalty;
    public int priority;
    public ArrayList<Short> speed;
    @SubCameraExtType.SubCameraExtType1
    public int subType;

    public NaviSubCameraExt() {
        this.cameraId = 0L;
        this.subType = 0;
        this.buswayTimeEnable = 0;
        this.penalty = 0;
        this.priority = 0;
        this.isNew = false;
        this.isVariableSpeed = false;
        this.isMatch = false;
        this.isSpecial = false;
        this.speed = new ArrayList<>();
    }

    public NaviSubCameraExt(long j, @SubCameraExtType.SubCameraExtType1 int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, ArrayList<Short> arrayList) {
        this.cameraId = j;
        this.subType = i;
        this.buswayTimeEnable = i2;
        this.penalty = i3;
        this.priority = i4;
        this.isNew = z;
        this.isVariableSpeed = z2;
        this.isMatch = z3;
        this.isSpecial = z4;
        this.speed = arrayList;
    }
}
