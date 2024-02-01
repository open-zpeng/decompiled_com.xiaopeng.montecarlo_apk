package com.autonavi.gbl.search.model;

import com.autonavi.gbl.search.model.SearchPoiEventType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiEventInfo implements Serializable {
    public String brief;
    public String endTime;
    @SearchPoiEventType.SearchPoiEventType1
    public int type;

    public SearchPoiEventInfo() {
        this.type = 0;
        this.endTime = "";
        this.brief = "";
    }

    public SearchPoiEventInfo(@SearchPoiEventType.SearchPoiEventType1 int i, String str, String str2) {
        this.type = i;
        this.endTime = str;
        this.brief = str2;
    }
}
