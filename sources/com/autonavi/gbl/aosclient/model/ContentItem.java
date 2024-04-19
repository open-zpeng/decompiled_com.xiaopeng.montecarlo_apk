package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ContentItem implements Serializable {
    public InitItem init;
    public ArrayList<StarsItem> stars;

    public ContentItem() {
        this.init = new InitItem();
        this.stars = new ArrayList<>();
    }

    public ContentItem(InitItem initItem, ArrayList<StarsItem> arrayList) {
        this.init = initItem;
        this.stars = arrayList;
    }
}
