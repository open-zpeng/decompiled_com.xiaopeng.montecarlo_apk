package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GCodepointInfo implements Serializable {
    public ArrayList<GCodepointBlock> blocks;
    public String category;

    public GCodepointInfo() {
        this.category = "";
        this.blocks = new ArrayList<>();
    }

    public GCodepointInfo(String str, ArrayList<GCodepointBlock> arrayList) {
        this.category = str;
        this.blocks = arrayList;
    }
}
