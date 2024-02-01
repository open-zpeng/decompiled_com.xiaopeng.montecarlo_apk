package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GRangeSpiderAckMetaInfo implements Serializable {
    public String dataversion;
    public String interfaceversion;
    public String timestamp;

    public GRangeSpiderAckMetaInfo() {
        this.dataversion = "";
        this.timestamp = "";
        this.interfaceversion = "";
    }

    public GRangeSpiderAckMetaInfo(String str, String str2, String str3) {
        this.dataversion = str;
        this.timestamp = str2;
        this.interfaceversion = str3;
    }
}
