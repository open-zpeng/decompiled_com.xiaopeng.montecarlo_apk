package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchClassifyInfo implements Serializable {
    public SearchClassifyItemInfo classifyItemInfo;
    public String retainState;

    public SearchClassifyInfo() {
        this.classifyItemInfo = new SearchClassifyItemInfo();
        this.retainState = "";
    }

    public SearchClassifyInfo(SearchClassifyItemInfo searchClassifyItemInfo, String str) {
        this.classifyItemInfo = searchClassifyItemInfo;
        this.retainState = str;
    }
}
