package com.autonavi.gbl.map.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgDataHighlightSubways implements Serializable {
    public ArrayList<Long> subwayIds;

    public MsgDataHighlightSubways() {
        this.subwayIds = new ArrayList<>();
    }

    public MsgDataHighlightSubways(ArrayList<Long> arrayList) {
        this.subwayIds = arrayList;
    }
}
