package com.autonavi.gbl.information.nearby.model;

import com.autonavi.gbl.information.nearby.model.NearbyRecommendBannerType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NearbyRecommendBanner implements Serializable {
    public ArrayList<String> imageUrlList;
    public String schema;
    @NearbyRecommendBannerType.NearbyRecommendBannerType1
    public int type;

    public NearbyRecommendBanner() {
        this.imageUrlList = new ArrayList<>();
        this.type = 0;
        this.schema = "";
    }

    public NearbyRecommendBanner(ArrayList<String> arrayList, @NearbyRecommendBannerType.NearbyRecommendBannerType1 int i, String str) {
        this.imageUrlList = arrayList;
        this.type = i;
        this.schema = str;
    }
}
