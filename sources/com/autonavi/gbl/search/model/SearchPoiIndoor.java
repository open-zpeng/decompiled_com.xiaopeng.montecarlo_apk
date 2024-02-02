package com.autonavi.gbl.search.model;

import com.autonavi.gbl.search.model.SearchPoiIndoorType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiIndoor implements Serializable {
    public String floorName;
    public int floorNo;
    public String id;
    public String parentId;
    @SearchPoiIndoorType.SearchPoiIndoorType1
    public int type;
    public String typeCode;

    public SearchPoiIndoor() {
        this.type = 0;
        this.id = "";
        this.parentId = "";
        this.typeCode = "";
        this.floorName = "";
        this.floorNo = 0;
    }

    public SearchPoiIndoor(@SearchPoiIndoorType.SearchPoiIndoorType1 int i, String str, String str2, String str3, String str4, int i2) {
        this.type = i;
        this.id = str;
        this.parentId = str2;
        this.typeCode = str3;
        this.floorName = str4;
        this.floorNo = i2;
    }
}
