package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PurchaseItem implements Serializable {
    public ArrayList<String> desc;
    public String title;

    public PurchaseItem() {
        this.title = "";
        this.desc = new ArrayList<>();
    }

    public PurchaseItem(String str, ArrayList<String> arrayList) {
        this.title = str;
        this.desc = arrayList;
    }
}
