package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPoiBrand implements Serializable {
    public ArrayList<String> brandCodeList;
    public ArrayList<String> brandNameList;

    public SearchPoiBrand() {
        this.brandCodeList = new ArrayList<>();
        this.brandNameList = new ArrayList<>();
    }

    public SearchPoiBrand(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.brandCodeList = arrayList;
        this.brandNameList = arrayList2;
    }
}
