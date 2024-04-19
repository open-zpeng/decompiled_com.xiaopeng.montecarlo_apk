package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchNaviInfoItem implements Serializable {
    public ArrayList<SearchNaviInfoBase> childrenItem;
    public SearchNaviInfoBase naviInfo;

    public SearchNaviInfoItem() {
        this.naviInfo = new SearchNaviInfoBase();
        this.childrenItem = new ArrayList<>();
    }

    public SearchNaviInfoItem(SearchNaviInfoBase searchNaviInfoBase, ArrayList<SearchNaviInfoBase> arrayList) {
        this.naviInfo = searchNaviInfoBase;
        this.childrenItem = arrayList;
    }
}
