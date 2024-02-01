package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsFeedbackReviewDataPubParam implements Serializable {
    public String abtest;
    public int adCode;
    public int cityAdcode;
    public WsFeedbackReviewDataSeletcteCloud seletcte_cloud;
    public int sub_key;

    public WsFeedbackReviewDataPubParam() {
        this.abtest = "";
        this.adCode = 0;
        this.cityAdcode = 0;
        this.seletcte_cloud = new WsFeedbackReviewDataSeletcteCloud();
        this.sub_key = 0;
    }

    public WsFeedbackReviewDataPubParam(String str, int i, int i2, WsFeedbackReviewDataSeletcteCloud wsFeedbackReviewDataSeletcteCloud, int i3) {
        this.abtest = str;
        this.adCode = i;
        this.cityAdcode = i2;
        this.seletcte_cloud = wsFeedbackReviewDataSeletcteCloud;
        this.sub_key = i3;
    }
}
