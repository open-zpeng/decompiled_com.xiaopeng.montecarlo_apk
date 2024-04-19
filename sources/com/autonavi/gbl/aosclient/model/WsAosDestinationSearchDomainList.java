package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsAosDestinationSearchDomainList implements Serializable {
    public String id;
    public String name;
    public String type;
    public String value;

    public WsAosDestinationSearchDomainList() {
        this.name = "";
        this.id = "";
        this.type = "";
        this.value = "";
    }

    public WsAosDestinationSearchDomainList(String str, String str2, String str3, String str4) {
        this.name = str;
        this.id = str2;
        this.type = str3;
        this.value = str4;
    }
}
