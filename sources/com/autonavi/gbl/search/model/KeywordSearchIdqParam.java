package com.autonavi.gbl.search.model;

import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class KeywordSearchIdqParam extends SearchKeywordParamV2 implements Serializable {
    public String id = "";
    public String sug = "";
    public String sugAdcode = "";
    public String sugPoiName = "";

    public KeywordSearchIdqParam() {
        this.queryType = KeywordSearchType.KEYWORD_SEARCH_TYPE_POI;
    }
}
