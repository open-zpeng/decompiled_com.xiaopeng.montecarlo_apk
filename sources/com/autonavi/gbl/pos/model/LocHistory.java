package com.autonavi.gbl.pos.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LocHistory implements Serializable {
    public long count;
    public ArrayList<LocPoint> historyBuffer;

    public LocHistory() {
        this.historyBuffer = new ArrayList<>();
        this.count = 0L;
    }

    public LocHistory(ArrayList<LocPoint> arrayList, long j) {
        this.historyBuffer = arrayList;
        this.count = j;
    }
}
