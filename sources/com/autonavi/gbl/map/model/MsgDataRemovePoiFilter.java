package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class MsgDataRemovePoiFilter implements Serializable {
    public int filterType;
    public String keyName;

    public MsgDataRemovePoiFilter() {
        this.keyName = "";
        this.filterType = 0;
    }

    public MsgDataRemovePoiFilter(String str, int i) {
        this.keyName = str;
        this.filterType = i;
    }
}
