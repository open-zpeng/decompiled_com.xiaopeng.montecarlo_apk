package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchTabItem implements Serializable {
    public ArrayList<SearchTabItem> childTabItemList;
    public int index;
    public String name;
    public String value;

    public SearchTabItem() {
        this.name = "";
        this.value = "";
        this.index = -1;
        this.childTabItemList = new ArrayList<>();
    }

    public SearchTabItem(String str, String str2, int i, ArrayList<SearchTabItem> arrayList) {
        this.name = str;
        this.value = str2;
        this.index = i;
        this.childTabItemList = arrayList;
    }
}
