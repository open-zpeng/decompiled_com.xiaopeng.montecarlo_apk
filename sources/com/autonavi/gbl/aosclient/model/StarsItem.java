package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class StarsItem implements Serializable {
    public ArrayList<FeedbackReviewDataTextItem> review_options;
    public String star_level;
    public ArrayList<SubTemplateItem> sub_template;
    public String title;

    public StarsItem() {
        this.star_level = "";
        this.title = "";
        this.review_options = new ArrayList<>();
        this.sub_template = new ArrayList<>();
    }

    public StarsItem(String str, String str2, ArrayList<FeedbackReviewDataTextItem> arrayList, ArrayList<SubTemplateItem> arrayList2) {
        this.star_level = str;
        this.title = str2;
        this.review_options = arrayList;
        this.sub_template = arrayList2;
    }
}
