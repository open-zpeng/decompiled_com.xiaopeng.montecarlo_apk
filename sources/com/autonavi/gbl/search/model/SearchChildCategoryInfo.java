package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchChildCategoryInfo implements Serializable {
    public SearchChildCategoryInfoBase baseInfo;
    public ArrayList<SearchChildCategoryInfoBase> childCategoryInfo;

    public SearchChildCategoryInfo() {
        this.baseInfo = new SearchChildCategoryInfoBase();
        this.childCategoryInfo = new ArrayList<>();
    }

    public SearchChildCategoryInfo(SearchChildCategoryInfoBase searchChildCategoryInfoBase, ArrayList<SearchChildCategoryInfoBase> arrayList) {
        this.baseInfo = searchChildCategoryInfoBase;
        this.childCategoryInfo = arrayList;
    }
}
