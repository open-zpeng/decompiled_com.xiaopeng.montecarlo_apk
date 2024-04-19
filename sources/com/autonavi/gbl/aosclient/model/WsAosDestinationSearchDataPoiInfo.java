package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsAosDestinationSearchDataPoiInfo implements Serializable {
    public ArrayList<WsAosDestinationSearchDomainList> domain_list;

    public WsAosDestinationSearchDataPoiInfo() {
        this.domain_list = new ArrayList<>();
    }

    public WsAosDestinationSearchDataPoiInfo(ArrayList<WsAosDestinationSearchDomainList> arrayList) {
        this.domain_list = arrayList;
    }
}
