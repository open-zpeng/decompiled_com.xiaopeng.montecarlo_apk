package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ForbiddenDetail implements Serializable {
    public DetailCloudControl detailCloudControl;
    public int nForbSubType;
    public int nForbVT;
    public String strForbTime;
    public String strInRoadName;
    public String strNxtRoadName;

    public ForbiddenDetail() {
        this.detailCloudControl = new DetailCloudControl();
        this.nForbVT = 0;
        this.nForbSubType = 0;
        this.strForbTime = "";
        this.strInRoadName = "";
        this.strNxtRoadName = "";
    }

    public ForbiddenDetail(DetailCloudControl detailCloudControl, int i, int i2, String str, String str2, String str3) {
        this.detailCloudControl = detailCloudControl;
        this.nForbVT = i;
        this.nForbSubType = i2;
        this.strForbTime = str;
        this.strInRoadName = str2;
        this.strNxtRoadName = str3;
    }
}
