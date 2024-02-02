package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchChargingLiveStatusParam implements Serializable {
    public String src_id;
    public String src_type;

    public SearchChargingLiveStatusParam() {
        this.src_type = "";
        this.src_id = "";
    }

    public SearchChargingLiveStatusParam(String str, String str2) {
        this.src_type = str;
        this.src_id = str2;
    }
}
