package com.autonavi.gbl.information.nearby.model;

import com.autonavi.gbl.information.nearby.model.NearbyRecommendPoiType;
import com.autonavi.gbl.search.model.SearchBasicInfoBase;
import com.autonavi.gbl.search.model.SearchRankInfoBase;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NearbyRecommendPoiInfo extends SearchBasicInfoBase implements Serializable {
    @NearbyRecommendPoiType.NearbyRecommendPoiType1
    public int type = 0;
    public String recommendReason = "";
    public String businessArea = "";
    public NearbyRecommendBriefReview briefReview = new NearbyRecommendBriefReview();
    public ArrayList<NearbyRecommendImage> imageInfo = new ArrayList<>();
    public String category = "";
    public NearbyRecommendHotInfo hotInfo = new NearbyRecommendHotInfo();
    public SearchRankInfoBase rankInfo = new SearchRankInfoBase();
    public ArrayList<String> tags = new ArrayList<>();
    public NearbyRecommendVisitors visitors = new NearbyRecommendVisitors();
    public ArrayList<NearbyRecommendProductInfo> productList = new ArrayList<>();
    public NearbyRecommendPoiRetainParam retainParam = new NearbyRecommendPoiRetainParam();
}
