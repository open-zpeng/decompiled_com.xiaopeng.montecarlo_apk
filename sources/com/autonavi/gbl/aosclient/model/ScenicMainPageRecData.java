package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ScenicMainPageRecData implements Serializable {
    public ScenicMainPageRecDataCommute commute;
    public ScenicMainPageRecDataScenic scenic;
    public ScenicMainPageRecDataUserHomeCompany user_home_company;

    public ScenicMainPageRecData() {
        this.scenic = new ScenicMainPageRecDataScenic();
        this.user_home_company = new ScenicMainPageRecDataUserHomeCompany();
        this.commute = new ScenicMainPageRecDataCommute();
    }

    public ScenicMainPageRecData(ScenicMainPageRecDataScenic scenicMainPageRecDataScenic, ScenicMainPageRecDataUserHomeCompany scenicMainPageRecDataUserHomeCompany, ScenicMainPageRecDataCommute scenicMainPageRecDataCommute) {
        this.scenic = scenicMainPageRecDataScenic;
        this.user_home_company = scenicMainPageRecDataUserHomeCompany;
        this.commute = scenicMainPageRecDataCommute;
    }
}
