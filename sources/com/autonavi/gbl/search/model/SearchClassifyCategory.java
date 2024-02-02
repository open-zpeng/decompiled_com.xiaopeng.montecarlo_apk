package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchClassifyCategory implements Serializable {
    public String alias;
    public ArrayList<SearchClassifyDetailCategory> category;
    public String defaults;
    public String display;
    public String multiselect;
    public String name;
    public String value;

    public SearchClassifyCategory() {
        this.defaults = "";
        this.name = "";
        this.value = "";
        this.alias = "";
        this.multiselect = "";
        this.display = "";
        this.category = new ArrayList<>();
    }

    public SearchClassifyCategory(String str, String str2, String str3, String str4, String str5, String str6, ArrayList<SearchClassifyDetailCategory> arrayList) {
        this.defaults = str;
        this.name = str2;
        this.value = str3;
        this.alias = str4;
        this.multiselect = str5;
        this.display = str6;
        this.category = arrayList;
    }
}
