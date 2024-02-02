package com.autonavi.gbl.lane.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WarnInfos implements Serializable {
    public ArrayList<WarnInfo> info;

    public WarnInfos() {
        this.info = new ArrayList<>();
    }

    public WarnInfos(ArrayList<WarnInfo> arrayList) {
        this.info = arrayList;
    }
}
