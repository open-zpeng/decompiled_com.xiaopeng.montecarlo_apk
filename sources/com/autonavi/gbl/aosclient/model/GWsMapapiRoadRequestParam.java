package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsMapapiRoadRequestParam extends BLRequestBase implements Serializable {
    public int flag = 31;
    public String tid = "";

    public GWsMapapiRoadRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_MAPAPI_CUSTOM2_ROAD;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
