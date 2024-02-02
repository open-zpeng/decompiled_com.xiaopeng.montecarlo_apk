package com.autonavi.gbl.card.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CustomUpdateParam implements Serializable {
    public boolean isChangeNightForAsvg;
    public float scaleFactor;
    public ArrayList<CustomUpdatePair> updateList;

    public CustomUpdateParam() {
        this.updateList = new ArrayList<>();
        this.scaleFactor = 1.0f;
        this.isChangeNightForAsvg = false;
    }

    public CustomUpdateParam(ArrayList<CustomUpdatePair> arrayList, float f, boolean z) {
        this.updateList = arrayList;
        this.scaleFactor = f;
        this.isChangeNightForAsvg = z;
    }
}
