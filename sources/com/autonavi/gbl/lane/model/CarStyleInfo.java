package com.autonavi.gbl.lane.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CarStyleInfo implements Serializable {
    public int modelResID;
    public ArrayList<CarPartsAnimation> partsAnimation;
    public ArrayList<CarPartsStyle> partsStyle;

    public CarStyleInfo() {
        this.modelResID = -1;
        this.partsStyle = new ArrayList<>();
        this.partsAnimation = new ArrayList<>();
    }

    public CarStyleInfo(int i, ArrayList<CarPartsStyle> arrayList, ArrayList<CarPartsAnimation> arrayList2) {
        this.modelResID = i;
        this.partsStyle = arrayList;
        this.partsAnimation = arrayList2;
    }
}
