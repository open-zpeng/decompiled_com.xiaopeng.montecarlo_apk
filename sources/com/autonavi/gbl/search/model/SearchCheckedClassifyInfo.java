package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchCheckedClassifyInfo implements Serializable {
    public ArrayList<SearchCheckedClassifyItem> checkedClassifyList;
    public String level1Data;
    public String level2Data;
    public String level3Data;

    public SearchCheckedClassifyInfo() {
        this.level1Data = "";
        this.level2Data = "";
        this.level3Data = "";
        this.checkedClassifyList = new ArrayList<>();
    }

    public SearchCheckedClassifyInfo(String str, String str2, String str3, ArrayList<SearchCheckedClassifyItem> arrayList) {
        this.level1Data = str;
        this.level2Data = str2;
        this.level3Data = str3;
        this.checkedClassifyList = arrayList;
    }
}
