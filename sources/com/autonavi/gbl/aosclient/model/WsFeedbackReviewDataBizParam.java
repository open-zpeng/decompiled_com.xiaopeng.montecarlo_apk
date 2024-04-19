package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsFeedbackReviewDataBizParam implements Serializable {
    public String navID;
    public WsFeedbackReviewDataNaviParams naviParams;

    public WsFeedbackReviewDataBizParam() {
        this.navID = "";
        this.naviParams = new WsFeedbackReviewDataNaviParams();
    }

    public WsFeedbackReviewDataBizParam(String str, WsFeedbackReviewDataNaviParams wsFeedbackReviewDataNaviParams) {
        this.navID = str;
        this.naviParams = wsFeedbackReviewDataNaviParams;
    }
}
