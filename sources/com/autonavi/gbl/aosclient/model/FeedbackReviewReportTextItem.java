package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class FeedbackReviewReportTextItem implements Serializable {
    public String text;
    public int value;

    public FeedbackReviewReportTextItem() {
        this.text = "";
        this.value = 0;
    }

    public FeedbackReviewReportTextItem(String str, int i) {
        this.text = str;
        this.value = i;
    }
}
