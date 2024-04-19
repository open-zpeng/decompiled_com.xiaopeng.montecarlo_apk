package com.autonavi.gbl.card.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CustomTextureParam implements Serializable {
    public CustomTextureAttr attrs;
    public CustomMarkerKeyParam markerKey;
    public ArrayList<CustomUpdatePair> updateList;

    public CustomTextureParam() {
        this.markerKey = new CustomMarkerKeyParam();
        this.attrs = new CustomTextureAttr();
        this.updateList = new ArrayList<>();
    }

    public CustomTextureParam(CustomMarkerKeyParam customMarkerKeyParam, CustomTextureAttr customTextureAttr, ArrayList<CustomUpdatePair> arrayList) {
        this.markerKey = customMarkerKeyParam;
        this.attrs = customTextureAttr;
        this.updateList = arrayList;
    }
}
