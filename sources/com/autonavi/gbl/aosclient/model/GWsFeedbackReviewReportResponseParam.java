package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsFeedbackReviewReportResponseParam extends BLResponseBase implements Serializable {
    public WsFeedbackReviewReportAckData data = new WsFeedbackReviewReportAckData();

    public GWsFeedbackReviewReportResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_FEEDBACK_REVIEW_REPORT;
        this.mNetworkStatus = 0;
    }
}
