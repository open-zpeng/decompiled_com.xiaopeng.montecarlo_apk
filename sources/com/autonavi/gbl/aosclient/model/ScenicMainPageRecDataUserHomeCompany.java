package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ScenicMainPageRecDataUserHomeCompany implements Serializable {
    public PointItem company;
    public PointItem home;

    public ScenicMainPageRecDataUserHomeCompany() {
        this.home = new PointItem();
        this.company = new PointItem();
    }

    public ScenicMainPageRecDataUserHomeCompany(PointItem pointItem, PointItem pointItem2) {
        this.home = pointItem;
        this.company = pointItem2;
    }
}
