package com.autonavi.gbl.user.forcast.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ForcastArrivedData implements Serializable {
    public OftenArrivedItem company;
    public OftenArrivedItem home;
    public ArrayList<OftenArrivedItem> others;

    public ForcastArrivedData() {
        this.home = new OftenArrivedItem();
        this.company = new OftenArrivedItem();
        this.others = new ArrayList<>();
    }

    public ForcastArrivedData(OftenArrivedItem oftenArrivedItem, OftenArrivedItem oftenArrivedItem2, ArrayList<OftenArrivedItem> arrayList) {
        this.home = oftenArrivedItem;
        this.company = oftenArrivedItem2;
        this.others = arrayList;
    }
}
