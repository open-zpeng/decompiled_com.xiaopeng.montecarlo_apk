package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPoiClassify implements Serializable {
    public ArrayList<SearchClassifyCategory> category;
    public String checkedvalue;
    public String ctype;
    public String name;

    public SearchPoiClassify() {
        this.checkedvalue = "";
        this.category = new ArrayList<>();
        this.name = "";
        this.ctype = "";
    }

    public SearchPoiClassify(String str, ArrayList<SearchClassifyCategory> arrayList, String str2, String str3) {
        this.checkedvalue = str;
        this.category = arrayList;
        this.name = str2;
        this.ctype = str3;
    }
}
