package com.autonavi.gbl.card.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class MarkerKeyParam implements Serializable {
    public String imageName;
    public VectorGraphParam vecAttr;

    public MarkerKeyParam() {
        this.imageName = "";
        this.vecAttr = new VectorGraphParam();
    }

    public MarkerKeyParam(String str, VectorGraphParam vectorGraphParam) {
        this.imageName = str;
        this.vecAttr = vectorGraphParam;
    }
}
