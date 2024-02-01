package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchRetainParam implements Serializable {
    public String keywordBizType;

    public SearchRetainParam() {
        this.keywordBizType = "";
    }

    public SearchRetainParam(String str) {
        this.keywordBizType = str;
    }
}
