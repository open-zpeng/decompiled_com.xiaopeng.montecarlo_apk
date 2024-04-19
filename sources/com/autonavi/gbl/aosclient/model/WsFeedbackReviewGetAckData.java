package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsFeedbackReviewGetAckData implements Serializable {
    public ContentItem content;
    public String template_id;
    public String title;
    public int type;

    public WsFeedbackReviewGetAckData() {
        this.template_id = "";
        this.title = "";
        this.type = 0;
        this.content = new ContentItem();
    }

    public WsFeedbackReviewGetAckData(String str, String str2, int i, ContentItem contentItem) {
        this.template_id = str;
        this.title = str2;
        this.type = i;
        this.content = contentItem;
    }
}
