package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BLHttpHeader implements Serializable {
    public ArrayList<BLKeyValue> property;

    public BLHttpHeader() {
        this.property = new ArrayList<>();
    }

    public BLHttpHeader(ArrayList<BLKeyValue> arrayList) {
        this.property = arrayList;
    }
}
