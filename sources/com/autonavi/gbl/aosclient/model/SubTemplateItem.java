package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SubTemplateItem implements Serializable {
    public ArrayList<FeedbackReviewDataTextItem> review_options;
    public String star_level;

    public SubTemplateItem() {
        this.star_level = "";
        this.review_options = new ArrayList<>();
    }

    public SubTemplateItem(String str, ArrayList<FeedbackReviewDataTextItem> arrayList) {
        this.star_level = str;
        this.review_options = arrayList;
    }
}
