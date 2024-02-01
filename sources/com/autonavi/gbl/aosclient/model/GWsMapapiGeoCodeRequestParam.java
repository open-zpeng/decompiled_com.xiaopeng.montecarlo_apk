package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsMapapiGeoCodeRequestParam extends BLRequestBase implements Serializable {
    public String address = "";
    public String adcode = "";
    public String onerow = "";

    public GWsMapapiGeoCodeRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WSMAPAPIGEOCODE;
    }
}
