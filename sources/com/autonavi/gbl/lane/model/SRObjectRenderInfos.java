package com.autonavi.gbl.lane.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SRObjectRenderInfos implements Serializable {
    public ArrayList<SRObjectRenderInfo> objects;

    public SRObjectRenderInfos() {
        this.objects = new ArrayList<>();
    }

    public SRObjectRenderInfos(ArrayList<SRObjectRenderInfo> arrayList) {
        this.objects = arrayList;
    }
}
