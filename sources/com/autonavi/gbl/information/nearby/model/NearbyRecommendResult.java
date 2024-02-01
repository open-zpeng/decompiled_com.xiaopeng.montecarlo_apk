package com.autonavi.gbl.information.nearby.model;

import com.autonavi.gbl.search.model.SearchTabInfo;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NearbyRecommendResult implements Serializable {
    public ArrayList<NearbyRecommendBanner> bannerList;
    public NearbyRecommendLocationInfo currentLocation;
    public int errorCode;
    public String errorMessage;
    public boolean hasMore;
    public int pageNumber;
    public ArrayList<NearbyRecommendPoiInfo> poiList;
    public SearchTabInfo tab;

    public NearbyRecommendResult() {
        this.errorCode = 0;
        this.errorMessage = "";
        this.bannerList = new ArrayList<>();
        this.tab = new SearchTabInfo();
        this.hasMore = false;
        this.pageNumber = 0;
        this.currentLocation = new NearbyRecommendLocationInfo();
        this.poiList = new ArrayList<>();
    }

    public NearbyRecommendResult(int i, String str, ArrayList<NearbyRecommendBanner> arrayList, SearchTabInfo searchTabInfo, boolean z, int i2, NearbyRecommendLocationInfo nearbyRecommendLocationInfo, ArrayList<NearbyRecommendPoiInfo> arrayList2) {
        this.errorCode = i;
        this.errorMessage = str;
        this.bannerList = arrayList;
        this.tab = searchTabInfo;
        this.hasMore = z;
        this.pageNumber = i2;
        this.currentLocation = nearbyRecommendLocationInfo;
        this.poiList = arrayList2;
    }
}
