package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsFeedbackReviewReportBizParam implements Serializable {
    public String navID;
    public WsFeedbackReviewReportNaviParams naviParams;

    public WsFeedbackReviewReportBizParam() {
        this.navID = "";
        this.naviParams = new WsFeedbackReviewReportNaviParams();
    }

    public WsFeedbackReviewReportBizParam(String str, WsFeedbackReviewReportNaviParams wsFeedbackReviewReportNaviParams) {
        this.navID = str;
        this.naviParams = wsFeedbackReviewReportNaviParams;
    }
}
