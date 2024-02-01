package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsFeedbackReviewReportPubParam implements Serializable {
    public String abtest;
    public int adCode;
    public int cityAdcode;
    public WsFeedbackReviewReportSeletcteCloud seletcte_cloud;
    public int sub_key;

    public WsFeedbackReviewReportPubParam() {
        this.abtest = "";
        this.adCode = 0;
        this.cityAdcode = 0;
        this.seletcte_cloud = new WsFeedbackReviewReportSeletcteCloud();
        this.sub_key = 0;
    }

    public WsFeedbackReviewReportPubParam(String str, int i, int i2, WsFeedbackReviewReportSeletcteCloud wsFeedbackReviewReportSeletcteCloud, int i3) {
        this.abtest = str;
        this.adCode = i;
        this.cityAdcode = i2;
        this.seletcte_cloud = wsFeedbackReviewReportSeletcteCloud;
        this.sub_key = i3;
    }
}
