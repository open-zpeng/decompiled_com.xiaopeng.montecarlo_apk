package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchCacheDirective implements Serializable {
    public SearchCacheAll cache_all;
    public SearchCacheFilter cache_filter;

    public SearchCacheDirective() {
        this.cache_filter = new SearchCacheFilter();
        this.cache_all = new SearchCacheAll();
    }

    public SearchCacheDirective(SearchCacheFilter searchCacheFilter, SearchCacheAll searchCacheAll) {
        this.cache_filter = searchCacheFilter;
        this.cache_all = searchCacheAll;
    }
}
