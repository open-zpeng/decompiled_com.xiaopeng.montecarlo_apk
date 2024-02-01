package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcPoiInfoRequestParam extends BLRequestBase implements Serializable {
    public WsTcPoiInfoRequestData data = new WsTcPoiInfoRequestData();

    public GWsTcPoiInfoRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_POI_INFO;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
