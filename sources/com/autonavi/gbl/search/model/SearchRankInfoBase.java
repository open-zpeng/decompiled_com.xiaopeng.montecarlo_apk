package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchRankInfoBase implements Serializable {
    public String iconUrl;
    public String rankListName;
    public String rankName;
    public String rankNo;

    public SearchRankInfoBase() {
        this.rankListName = "";
        this.rankName = "";
        this.rankNo = "";
        this.iconUrl = "";
    }

    public SearchRankInfoBase(String str, String str2, String str3, String str4) {
        this.rankListName = str;
        this.rankName = str2;
        this.rankNo = str3;
        this.iconUrl = str4;
    }
}
