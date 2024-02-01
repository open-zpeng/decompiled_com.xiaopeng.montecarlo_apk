package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsFeedbackReviewGetResponseParam extends BLResponseBase implements Serializable {
    public WsFeedbackReviewGetAckData data = new WsFeedbackReviewGetAckData();

    public GWsFeedbackReviewGetResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_FEEDBACK_REVIEW_GET;
        this.mNetworkStatus = 0;
    }
}
