package com.autonavi.gbl.data.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AreaExtraInfo implements Serializable {
    public String cityName;
    public String provName;
    public AdminCode stAdCode;
    public AdMapPoint stCenterPoint;
    public String townName;

    public AreaExtraInfo() {
        this.stAdCode = new AdminCode();
        this.stCenterPoint = new AdMapPoint();
        this.provName = "";
        this.cityName = "";
        this.townName = "";
        AdminCode adminCode = this.stAdCode;
        adminCode.euRegionCode = 0;
        adminCode.nCityAdCode = -1;
        adminCode.nAdCode = -1;
    }

    public AreaExtraInfo(AdminCode adminCode, AdMapPoint adMapPoint, String str, String str2, String str3) {
        this.stAdCode = adminCode;
        this.stCenterPoint = adMapPoint;
        this.provName = str;
        this.cityName = str2;
        this.townName = str3;
    }
}
