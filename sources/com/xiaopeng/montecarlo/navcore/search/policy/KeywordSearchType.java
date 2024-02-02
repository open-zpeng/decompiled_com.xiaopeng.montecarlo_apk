package com.xiaopeng.montecarlo.navcore.search.policy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class KeywordSearchType {
    public static final String KEYWORD_SEARCH_TYPE_AROUND = "RQBXY";
    public static final String KEYWORD_SEARCH_TYPE_FRAME = "SPQ";
    public static final String KEYWORD_SEARCH_TYPE_KEYWORD = "TQUERY";
    public static final String KEYWORD_SEARCH_TYPE_POI = "IDQ";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Type {
    }
}
