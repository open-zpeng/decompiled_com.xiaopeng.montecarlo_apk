package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class KeywordSearchCustomParam implements Serializable {
    public String autoAttrFilter;
    public SearchClassifyParam classifyParam;
    public String custom;
    public String customAnd;
    public int flagTerm;

    public KeywordSearchCustomParam() {
        this.flagTerm = 0;
        this.custom = "";
        this.customAnd = "";
        this.autoAttrFilter = "";
        this.classifyParam = new SearchClassifyParam();
    }

    public KeywordSearchCustomParam(int i, String str, String str2, String str3, SearchClassifyParam searchClassifyParam) {
        this.flagTerm = i;
        this.custom = str;
        this.customAnd = str2;
        this.autoAttrFilter = str3;
        this.classifyParam = searchClassifyParam;
    }
}
