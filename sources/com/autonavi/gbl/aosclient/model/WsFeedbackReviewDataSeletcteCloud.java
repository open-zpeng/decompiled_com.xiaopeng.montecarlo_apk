package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsFeedbackReviewDataSeletcteCloud implements Serializable {
    public String abtestid;
    public ArrayList<FeedbackReviewDataTextItem> textInfo;
    public String title;
    public int type;

    public WsFeedbackReviewDataSeletcteCloud() {
        this.abtestid = "";
        this.textInfo = new ArrayList<>();
        this.title = "";
        this.type = 0;
    }

    public WsFeedbackReviewDataSeletcteCloud(String str, ArrayList<FeedbackReviewDataTextItem> arrayList, String str2, int i) {
        this.abtestid = str;
        this.textInfo = arrayList;
        this.title = str2;
        this.type = i;
    }
}
