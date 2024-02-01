package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CEtaRequestReponseParam extends BLResponseBase implements Serializable {
    public String status = "";
    public String distance = "";
    public int taxi_price = 0;
    public String travel_time = "";

    public CEtaRequestReponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_ETAREQUEST;
    }
}
