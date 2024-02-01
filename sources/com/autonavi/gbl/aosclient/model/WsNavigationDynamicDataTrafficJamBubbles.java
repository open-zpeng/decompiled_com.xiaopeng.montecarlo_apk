package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataTrafficJamBubbles implements Serializable {
    public ArrayList<WsNavigationDynamicDataJamBubblesResponseData> data;
    public String message;
    public int status;
    public long timestamp;
    public String traceID;

    public WsNavigationDynamicDataTrafficJamBubbles() {
        this.status = 0;
        this.timestamp = 0L;
        this.message = "";
        this.traceID = "";
        this.data = new ArrayList<>();
    }

    public WsNavigationDynamicDataTrafficJamBubbles(int i, long j, String str, String str2, ArrayList<WsNavigationDynamicDataJamBubblesResponseData> arrayList) {
        this.status = i;
        this.timestamp = j;
        this.message = str;
        this.traceID = str2;
        this.data = arrayList;
    }
}
