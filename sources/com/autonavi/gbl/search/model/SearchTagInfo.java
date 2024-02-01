package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchTagInfo implements Serializable {
    public ArrayList<String> dateTimeList;
    public SearchTabItem item;
    public ArrayList<String> packageName;
    public ArrayList<String> rightList;
    public String subTitle;

    public SearchTagInfo() {
        this.rightList = new ArrayList<>();
        this.packageName = new ArrayList<>();
        this.dateTimeList = new ArrayList<>();
        this.subTitle = "";
        this.item = new SearchTabItem();
    }

    public SearchTagInfo(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str, SearchTabItem searchTabItem) {
        this.rightList = arrayList;
        this.packageName = arrayList2;
        this.dateTimeList = arrayList3;
        this.subTitle = str;
        this.item = searchTabItem;
    }
}
