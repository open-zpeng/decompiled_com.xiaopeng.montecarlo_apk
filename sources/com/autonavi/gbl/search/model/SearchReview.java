package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchReview implements Serializable {
    public String author;
    public String authorId;
    public String authorProfileUrl;
    public int gaoDeCoin;
    public String goldType;
    public int highQuality;
    public String likeNum;
    public ArrayList<SearchReviewPicInfo> picInfo;
    public int qualityFlag;
    public String recommend;
    public String review;
    public String reviewId;
    public String score;
    public String srcName;
    public String srcType;
    public String time;

    public SearchReview() {
        this.gaoDeCoin = 0;
        this.highQuality = 0;
        this.qualityFlag = 0;
        this.goldType = "";
        this.author = "";
        this.recommend = "";
        this.reviewId = "";
        this.authorProfileUrl = "";
        this.review = "";
        this.score = "";
        this.likeNum = "";
        this.time = "";
        this.srcType = "";
        this.srcName = "";
        this.authorId = "";
        this.picInfo = new ArrayList<>();
    }

    public SearchReview(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, ArrayList<SearchReviewPicInfo> arrayList) {
        this.gaoDeCoin = i;
        this.highQuality = i2;
        this.qualityFlag = i3;
        this.goldType = str;
        this.author = str2;
        this.recommend = str3;
        this.reviewId = str4;
        this.authorProfileUrl = str5;
        this.review = str6;
        this.score = str7;
        this.likeNum = str8;
        this.time = str9;
        this.srcType = str10;
        this.srcName = str11;
        this.authorId = str12;
        this.picInfo = arrayList;
    }
}
