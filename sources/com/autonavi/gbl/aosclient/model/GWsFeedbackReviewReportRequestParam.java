package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsFeedbackReviewReportRequestParam extends BLRequestBase implements Serializable {
    public String tid = "";
    public String template_id = "";
    public String event_id = "";
    public ArrayList<WsFeedbackReviewReportSubmitResult> submit_result = new ArrayList<>();
    public String review_id = "";
    public String show_time = "";
    public String submit_time = "";
    public WsFeedbackReviewReportBizParam biz_param = new WsFeedbackReviewReportBizParam();
    public WsFeedbackReviewReportPubParam pub_param = new WsFeedbackReviewReportPubParam();

    public GWsFeedbackReviewReportRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_FEEDBACK_REVIEW_REPORT;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
