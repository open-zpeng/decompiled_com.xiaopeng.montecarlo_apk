package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsMapapiAutoInitRequestParam extends BLRequestBase implements Serializable {
    public String dic = "";
    public String dip = "";
    public String tbt_version = "";
    public long tbt_data_version = 0;

    public GWsMapapiAutoInitRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_MAPAPI_AUTO_INIT;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
