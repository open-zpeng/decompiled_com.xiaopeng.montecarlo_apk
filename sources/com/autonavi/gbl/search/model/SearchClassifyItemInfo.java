package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchClassifyItemInfo implements Serializable {
    public ArrayList<SearchCategoryInfo> categoryInfoList;
    public SearchCheckedClassifyInfo checkedClassify;
    public ArrayList<SearchCategoryInfo> defaultClassifyInfoList;
    public ArrayList<SearchCategoryInfo> level2CategoryInfoList;
    public SearchCategoryInfo level3Data;

    public SearchClassifyItemInfo() {
        this.checkedClassify = new SearchCheckedClassifyInfo();
        this.defaultClassifyInfoList = new ArrayList<>();
        this.level3Data = new SearchCategoryInfo();
        this.level2CategoryInfoList = new ArrayList<>();
        this.categoryInfoList = new ArrayList<>();
    }

    public SearchClassifyItemInfo(SearchCheckedClassifyInfo searchCheckedClassifyInfo, ArrayList<SearchCategoryInfo> arrayList, SearchCategoryInfo searchCategoryInfo, ArrayList<SearchCategoryInfo> arrayList2, ArrayList<SearchCategoryInfo> arrayList3) {
        this.checkedClassify = searchCheckedClassifyInfo;
        this.defaultClassifyInfoList = arrayList;
        this.level3Data = searchCategoryInfo;
        this.level2CategoryInfoList = arrayList2;
        this.categoryInfoList = arrayList3;
    }
}
