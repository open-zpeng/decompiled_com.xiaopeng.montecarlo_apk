package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsMapapiConfOfflineRequestParam extends BLRequestBase implements Serializable {
    public String div = "";
    public String diu = "";
    public String conf_data_keys = "";

    public GWsMapapiConfOfflineRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_MAPAPI_CONF_OFFLINE;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
