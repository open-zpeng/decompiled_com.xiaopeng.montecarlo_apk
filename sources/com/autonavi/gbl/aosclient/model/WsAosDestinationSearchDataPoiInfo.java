package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsAosDestinationSearchDataPoiInfo implements Serializable {
    public String address;
    public String display_icon_name_state;
    public ArrayList<WsAosDestinationSearchDomainList> domain_list;
    public String id;
    public double latitude;
    public double longitude;
    public String name;
    public String typecode;

    public WsAosDestinationSearchDataPoiInfo() {
        this.typecode = "";
        this.address = "";
        this.display_icon_name_state = "";
        this.latitude = 0.0d;
        this.name = "";
        this.domain_list = new ArrayList<>();
        this.id = "";
        this.longitude = 0.0d;
    }

    public WsAosDestinationSearchDataPoiInfo(String str, String str2, String str3, double d, String str4, ArrayList<WsAosDestinationSearchDomainList> arrayList, String str5, double d2) {
        this.typecode = str;
        this.address = str2;
        this.display_icon_name_state = str3;
        this.latitude = d;
        this.name = str4;
        this.domain_list = arrayList;
        this.id = str5;
        this.longitude = d2;
    }
}
