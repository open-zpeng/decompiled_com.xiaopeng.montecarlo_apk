package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcPoiInfoResponseParam extends BLResponseBase implements Serializable {
    public WsTcPoiInfoResponseData data = new WsTcPoiInfoResponseData();

    public GWsTcPoiInfoResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_POI_INFO;
        this.mNetworkStatus = 0;
    }
}
