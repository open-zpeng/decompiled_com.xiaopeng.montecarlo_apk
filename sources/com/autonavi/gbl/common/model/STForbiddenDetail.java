package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class STForbiddenDetail extends STDetail implements Serializable {
    public String strRoadName = "";
    public String strCurRoadName = "";
    public int nForbVT = 0;
    public int nForbSubType = 0;
    public String strForbTime = "";
    public String strEnterRoadName = "";
    public String strNxtRoadName = "";
    public long segIdx = 0;
    public long linkIdx = 0;

    public STForbiddenDetail() {
        this.detailCategory = 3;
    }
}
