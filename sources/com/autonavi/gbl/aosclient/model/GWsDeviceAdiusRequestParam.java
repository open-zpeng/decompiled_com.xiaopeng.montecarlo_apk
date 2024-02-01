package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsDeviceAdiusRequestParam extends BLRequestBase implements Serializable {
    public String div = "";
    public String autodiv = "";
    public String tid = "";
    public String diu = "";
    public String diu2 = "";
    public String diu3 = "";
    public GWsDeviceAdiusRequestBody body = new GWsDeviceAdiusRequestBody();

    public GWsDeviceAdiusRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_ADIU_WSDEVICEADIUS;
    }
}
