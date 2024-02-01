package com.autonavi.gbl.search.model;

import com.xiaopeng.montecarlo.navcore.search.policy.KeywordSearchType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class KeywordSearchTQueryParam extends SearchKeywordParamV2 implements Serializable {
    public String sceneId = "";

    public KeywordSearchTQueryParam() {
        this.queryType = KeywordSearchType.KEYWORD_SEARCH_TYPE_KEYWORD;
    }
}
