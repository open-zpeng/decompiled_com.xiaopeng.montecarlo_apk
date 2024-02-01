package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsChargeListData implements Serializable {
    public ArrayList<WsChargeListContentItem> content;
    public int total;

    public WsChargeListData() {
        this.content = new ArrayList<>();
        this.total = 0;
    }

    public WsChargeListData(ArrayList<WsChargeListContentItem> arrayList, int i) {
        this.content = arrayList;
        this.total = i;
    }
}
