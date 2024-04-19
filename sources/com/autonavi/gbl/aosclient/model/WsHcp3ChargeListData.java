package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsHcp3ChargeListData implements Serializable {
    public ArrayList<WsHcp3ChargeListContentItem> content;
    public int total;

    public WsHcp3ChargeListData() {
        this.content = new ArrayList<>();
        this.total = 0;
    }

    public WsHcp3ChargeListData(ArrayList<WsHcp3ChargeListContentItem> arrayList, int i) {
        this.content = arrayList;
        this.total = i;
    }
}
