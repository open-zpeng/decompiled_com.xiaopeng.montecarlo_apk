package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsMapapiLinkidsRequestParam extends BLRequestBase implements Serializable {
    public int projected_route = 0;
    public ArrayList<WSMapapiLinkidsGp> gps = new ArrayList<>();

    public GWsMapapiLinkidsRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_MAPAPI_CUSTOM2_LINKIDS;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}
