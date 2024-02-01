package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcAlscOrderCancelRequestData implements Serializable {
    public String amapOrderId;
    public String bizScene;
    public String reason;
    public String ttid;

    public WsTcAlscOrderCancelRequestData() {
        this.amapOrderId = "";
        this.ttid = "";
        this.reason = "";
        this.bizScene = "";
    }

    public WsTcAlscOrderCancelRequestData(String str, String str2, String str3, String str4) {
        this.amapOrderId = str;
        this.ttid = str2;
        this.reason = str3;
        this.bizScene = str4;
    }
}
