package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class STRestrictDetail extends STDetail implements Serializable {
    public String strRoadName = "";
    public String strEnterRoadName = "";
    public String strCurRoadName = "";
    public String strNxtRoadName = "";
    public String strForbTime = "";
    public int subType = 0;
    public int OrgType = 0;

    public STRestrictDetail() {
        this.detailCategory = 4;
    }
}
