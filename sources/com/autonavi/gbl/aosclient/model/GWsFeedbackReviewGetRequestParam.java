package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsFeedbackReviewGetRequestParam extends BLRequestBase implements Serializable {
    public String tid = "";
    public String review_id = "";
    public WsFeedbackReviewDataBizParam biz_param = new WsFeedbackReviewDataBizParam();
    public WsFeedbackReviewDataPubParam pub_param = new WsFeedbackReviewDataPubParam();
}
