package com.autonavi.gbl.map.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PoiLinearGradientParam implements Serializable {
    public ArrayList<Float> alphaInfoArray;
    public float percent;
    public ArrayList<Float> positionInfoArray;

    public PoiLinearGradientParam() {
        this.positionInfoArray = new ArrayList<>();
        this.alphaInfoArray = new ArrayList<>();
        this.percent = 1.0f;
    }

    public PoiLinearGradientParam(ArrayList<Float> arrayList, ArrayList<Float> arrayList2, float f) {
        this.positionInfoArray = arrayList;
        this.alphaInfoArray = arrayList2;
        this.percent = f;
    }
}
