package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PurchaseNotes implements Serializable {
    public ArrayList<PurchaseItem> itemList;

    public PurchaseNotes() {
        this.itemList = new ArrayList<>();
    }

    public PurchaseNotes(ArrayList<PurchaseItem> arrayList) {
        this.itemList = arrayList;
    }
}
