package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsFeedbackReviewReportSeletcteCloud implements Serializable {
    public String abtestid;
    public ArrayList<FeedbackReviewReportTextItem> textInfo;
    public String title;
    public int type;

    public WsFeedbackReviewReportSeletcteCloud() {
        this.abtestid = "";
        this.textInfo = new ArrayList<>();
        this.title = "";
        this.type = 0;
    }

    public WsFeedbackReviewReportSeletcteCloud(String str, ArrayList<FeedbackReviewReportTextItem> arrayList, String str2, int i) {
        this.abtestid = str;
        this.textInfo = arrayList;
        this.title = str2;
        this.type = i;
    }
}
