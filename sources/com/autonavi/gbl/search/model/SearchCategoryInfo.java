package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchCategoryInfo implements Serializable {
    public SearchCategoryInfoBase baseInfo;
    public ArrayList<SearchChildCategoryInfo> childCategoryInfo;

    public SearchCategoryInfo() {
        this.baseInfo = new SearchCategoryInfoBase();
        this.childCategoryInfo = new ArrayList<>();
    }

    public SearchCategoryInfo(SearchCategoryInfoBase searchCategoryInfoBase, ArrayList<SearchChildCategoryInfo> arrayList) {
        this.baseInfo = searchCategoryInfoBase;
        this.childCategoryInfo = arrayList;
    }
}
