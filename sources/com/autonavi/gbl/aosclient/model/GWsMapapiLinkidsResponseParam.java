package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsMapapiLinkidsResponseParam extends BLResponseBase implements Serializable {
    public ArrayList<String> data = new ArrayList<>();

    public GWsMapapiLinkidsResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_MAPAPI_CUSTOM2_LINKIDS;
        this.mNetworkStatus = 0;
    }
}
