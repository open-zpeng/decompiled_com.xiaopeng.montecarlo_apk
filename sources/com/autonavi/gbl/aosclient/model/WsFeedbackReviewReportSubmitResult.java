package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsFeedbackReviewReportSubmitResult implements Serializable {
    public ArrayList<FeedbackReviewReportTextItem> review_options;
    public String star_level;

    public WsFeedbackReviewReportSubmitResult() {
        this.star_level = "";
        this.review_options = new ArrayList<>();
    }

    public WsFeedbackReviewReportSubmitResult(String str, ArrayList<FeedbackReviewReportTextItem> arrayList) {
        this.star_level = str;
        this.review_options = arrayList;
    }
}
