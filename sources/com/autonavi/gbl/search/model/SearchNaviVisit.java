package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchNaviVisit implements Serializable {
    public String gaoDeTagRate;
    public String gaoDeTravelScore;
    public String goodMoretimesRate;
    public String goodTagRate;
    public String hotTagRate;
    public String lastTag;

    public SearchNaviVisit() {
        this.gaoDeTagRate = "";
        this.gaoDeTravelScore = "";
        this.goodMoretimesRate = "";
        this.goodTagRate = "";
        this.hotTagRate = "";
        this.lastTag = "";
    }

    public SearchNaviVisit(String str, String str2, String str3, String str4, String str5, String str6) {
        this.gaoDeTagRate = str;
        this.gaoDeTravelScore = str2;
        this.goodMoretimesRate = str3;
        this.goodTagRate = str4;
        this.hotTagRate = str5;
        this.lastTag = str6;
    }
}
