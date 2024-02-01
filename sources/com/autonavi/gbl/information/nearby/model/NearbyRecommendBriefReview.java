package com.autonavi.gbl.information.nearby.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class NearbyRecommendBriefReview implements Serializable {
    public double rating;
    public String ratingDescription;
    public int reviewCount;
    public String travelRankingDescription;

    public NearbyRecommendBriefReview() {
        this.reviewCount = 0;
        this.rating = 0.0d;
        this.ratingDescription = "";
        this.travelRankingDescription = "";
    }

    public NearbyRecommendBriefReview(int i, double d, String str, String str2) {
        this.reviewCount = i;
        this.rating = d;
        this.ratingDescription = str;
        this.travelRankingDescription = str2;
    }
}
