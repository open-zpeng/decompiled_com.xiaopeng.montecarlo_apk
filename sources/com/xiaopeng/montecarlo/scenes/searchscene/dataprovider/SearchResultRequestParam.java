package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.search.AroundInfoRequest;
import com.xiaopeng.montecarlo.navcore.search.DetailInfoRequest;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.request.AlongWayRequest;
import com.xiaopeng.montecarlo.navcore.search.request.KeywordQueryRequest;
/* loaded from: classes3.dex */
public class SearchResultRequestParam extends SearchRequestParam {
    protected int mSearchId;
    private KeywordQueryRequest mKeywordQueryRequest = null;
    private DetailInfoRequest mDetailInfoRequest = null;
    private AroundInfoRequest mAroundInfoRequest = null;
    private AlongWayRequest mAlongWayRequest = null;

    public DetailInfoRequest getDetailInfoRequest() {
        return this.mDetailInfoRequest;
    }

    public void setKeywordRequest(KeywordQueryRequest keywordQueryRequest) {
        setSearchType(4);
        this.mKeywordQueryRequest = keywordQueryRequest;
        this.mKeywordQueryRequest.setRequestId(SearchClient.getInstance().getRequestId());
        this.mSearchId = this.mKeywordQueryRequest.getRequestId();
    }

    public void setDetailInfoRequest(DetailInfoRequest detailInfoRequest) {
        setSearchType(12);
        this.mDetailInfoRequest = detailInfoRequest;
        this.mSearchId = detailInfoRequest.mSearchId;
    }

    public KeywordQueryRequest getKeywordQueryRequest() {
        return this.mKeywordQueryRequest;
    }

    public AroundInfoRequest getAroundInfoRequest() {
        return this.mAroundInfoRequest;
    }

    public void setAroundInfoRequest(AroundInfoRequest aroundInfoRequest) {
        setSearchType(13);
        this.mAroundInfoRequest = aroundInfoRequest;
        this.mSearchId = this.mAroundInfoRequest.mSearchId;
    }

    public void setAlongWayRequest(AlongWayRequest alongWayRequest) {
        setSearchType(2);
        this.mAlongWayRequest = alongWayRequest;
        this.mSearchId = alongWayRequest.getRequestId();
    }
}
