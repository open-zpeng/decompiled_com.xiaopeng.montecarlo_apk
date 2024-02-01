package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsAosDestinationSearchDataAoiDetail implements Serializable {
    public String aoiId;
    public String id;
    public String name;
    public String type;
    public String value;

    public WsAosDestinationSearchDataAoiDetail() {
        this.name = "";
        this.id = "";
        this.aoiId = "";
        this.type = "";
        this.value = "";
    }

    public WsAosDestinationSearchDataAoiDetail(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.id = str2;
        this.aoiId = str3;
        this.type = str4;
        this.value = str5;
    }
}
