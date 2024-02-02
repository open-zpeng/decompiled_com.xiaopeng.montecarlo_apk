package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class InitItem implements Serializable {
    public ArrayList<FeedbackReviewDataTextItem> review_options;
    public String title;
    public int type;

    public InitItem() {
        this.type = 0;
        this.title = "";
        this.review_options = new ArrayList<>();
    }

    public InitItem(int i, String str, ArrayList<FeedbackReviewDataTextItem> arrayList) {
        this.type = i;
        this.title = str;
        this.review_options = arrayList;
    }
}
