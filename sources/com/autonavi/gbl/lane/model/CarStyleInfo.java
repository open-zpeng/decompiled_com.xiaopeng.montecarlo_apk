package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CarStyleInfo implements Serializable {
    public int bsdLeftTextureResID;
    public int bsdRightTextureResID;
    public int carDoorAndTireTextureResID;
    public int carFrameTextureResID;
    public int carLightTextureResID;
    public int fcwAndAEBtextureResID;
    public int modelResID;
    public int rcwTextureResID;
    public int shadowTextureResID;

    public CarStyleInfo() {
        this.modelResID = -1;
        this.carFrameTextureResID = -1;
        this.carDoorAndTireTextureResID = -1;
        this.carLightTextureResID = -1;
        this.shadowTextureResID = -1;
        this.fcwAndAEBtextureResID = -1;
        this.bsdLeftTextureResID = -1;
        this.bsdRightTextureResID = -1;
        this.rcwTextureResID = -1;
    }

    public CarStyleInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.modelResID = i;
        this.carFrameTextureResID = i2;
        this.carDoorAndTireTextureResID = i3;
        this.carLightTextureResID = i4;
        this.shadowTextureResID = i5;
        this.fcwAndAEBtextureResID = i6;
        this.bsdLeftTextureResID = i7;
        this.bsdRightTextureResID = i8;
        this.rcwTextureResID = i9;
    }
}
