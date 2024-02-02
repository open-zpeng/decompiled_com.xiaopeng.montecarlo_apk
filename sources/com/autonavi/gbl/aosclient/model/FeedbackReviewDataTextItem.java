package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FeedbackReviewDataTextItem implements Serializable {
    public ArrayList<Integer> exclusion;
    public String icon_id;
    public String text;
    public int value;

    public FeedbackReviewDataTextItem() {
        this.text = "";
        this.value = 0;
        this.icon_id = "";
        this.exclusion = new ArrayList<>();
    }

    public FeedbackReviewDataTextItem(String str, int i, String str2, ArrayList<Integer> arrayList) {
        this.text = str;
        this.value = i;
        this.icon_id = str2;
        this.exclusion = arrayList;
    }
}
