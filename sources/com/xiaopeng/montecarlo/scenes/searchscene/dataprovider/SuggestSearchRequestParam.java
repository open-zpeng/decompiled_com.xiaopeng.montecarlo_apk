package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SuggestSearchRequestParam extends SearchRequestParam {
    private XPCoordinate2DDouble mCarLocation;
    private String mKey;
    protected int mSearchId;
    private int mSearchMode;
    private SearchResponseEvent mSearchResponseEvent;
    private XPPoiInfo mXPPoiInfo;
    private ArrayList<XPPoiInfo> mXpPoiInfosFromCached;

    public SuggestSearchRequestParam(String str, int i, XPPoiInfo xPPoiInfo, XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mSearchType = 3;
        this.mIsFromCache = true;
        this.mKey = str;
        this.mSearchMode = i;
        this.mXPPoiInfo = xPPoiInfo;
        this.mCarLocation = xPCoordinate2DDouble;
    }

    public ArrayList<XPPoiInfo> getXpPoiInfosFromCached() {
        return this.mXpPoiInfosFromCached;
    }

    public void setXpPoiInfosFromCached(ArrayList<XPPoiInfo> arrayList) {
        this.mXpPoiInfosFromCached = arrayList;
    }

    public SearchResponseEvent getSearchResponseEvent() {
        return this.mSearchResponseEvent;
    }

    public void setSearchResponseEvent(SearchResponseEvent searchResponseEvent) {
        this.mSearchResponseEvent = searchResponseEvent;
    }

    public String getKey() {
        return this.mKey;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchRequestParam
    public int getSearchMode() {
        return this.mSearchMode;
    }

    public XPPoiInfo getXPPoiInfo() {
        return this.mXPPoiInfo;
    }

    public XPCoordinate2DDouble getCarLocation() {
        return this.mCarLocation;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchRequestParam
    public int getSearchId() {
        return this.mSearchId;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchRequestParam
    public void setSearchId(int i) {
        this.mSearchId = i;
    }
}
