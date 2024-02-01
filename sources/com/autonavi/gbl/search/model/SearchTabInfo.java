package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchTabInfo implements Serializable {
    public int index;
    public ArrayList<SearchTabItem> tabItemList;

    public SearchTabInfo() {
        this.index = -1;
        this.tabItemList = new ArrayList<>();
    }

    public SearchTabInfo(int i, ArrayList<SearchTabItem> arrayList) {
        this.index = i;
        this.tabItemList = arrayList;
    }
}
