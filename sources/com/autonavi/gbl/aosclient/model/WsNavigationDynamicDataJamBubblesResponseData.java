package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataJamBubblesResponseData implements Serializable {
    public long pathId;
    public ArrayList<WsNavigationDynamicDataJamBubblesDataSegment> segments;

    public WsNavigationDynamicDataJamBubblesResponseData() {
        this.pathId = 0L;
        this.segments = new ArrayList<>();
    }

    public WsNavigationDynamicDataJamBubblesResponseData(long j, ArrayList<WsNavigationDynamicDataJamBubblesDataSegment> arrayList) {
        this.pathId = j;
        this.segments = arrayList;
    }
}
