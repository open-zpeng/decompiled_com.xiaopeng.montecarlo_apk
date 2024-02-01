package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsDeviceAdiusResponseParam extends BLResponseBase implements Serializable {
    public String adiu = "";

    public GWsDeviceAdiusResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_ADIU_WSDEVICEADIUS;
    }
}
