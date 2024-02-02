package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsFeedbackReviewReportAckData implements Serializable {
    public String result_template;

    public WsFeedbackReviewReportAckData() {
        this.result_template = "";
    }

    public WsFeedbackReviewReportAckData(String str) {
        this.result_template = str;
    }
}
