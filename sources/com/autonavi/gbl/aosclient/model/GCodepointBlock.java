package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GCodepointBlock implements Serializable {
    public String name;
    public ArrayList<GCodepointPOIInfo> poilist;
    public int poinum;

    public GCodepointBlock() {
        this.name = "";
        this.poinum = 0;
        this.poilist = new ArrayList<>();
    }

    public GCodepointBlock(String str, int i, ArrayList<GCodepointPOIInfo> arrayList) {
        this.name = str;
        this.poinum = i;
        this.poilist = arrayList;
    }
}
