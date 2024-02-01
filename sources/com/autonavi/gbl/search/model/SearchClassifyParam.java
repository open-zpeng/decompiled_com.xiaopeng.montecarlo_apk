package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchClassifyParam implements Serializable {
    public String checkedLevel;
    public String claissfyV2Level3Data;
    public String classifyV2Data;
    public String classifyV2Level2Data;
    public String retainState;

    public SearchClassifyParam() {
        this.retainState = "";
        this.checkedLevel = "";
        this.classifyV2Data = "";
        this.classifyV2Level2Data = "";
        this.claissfyV2Level3Data = "";
    }

    public SearchClassifyParam(String str, String str2, String str3, String str4, String str5) {
        this.retainState = str;
        this.checkedLevel = str2;
        this.classifyV2Data = str3;
        this.classifyV2Level2Data = str4;
        this.claissfyV2Level3Data = str5;
    }
}
