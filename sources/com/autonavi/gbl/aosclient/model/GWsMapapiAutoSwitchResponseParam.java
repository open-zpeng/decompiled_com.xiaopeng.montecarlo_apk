package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsMapapiAutoSwitchResponseParam extends BLResponseBase implements Serializable {
    public String auto_socol_switch = "";

    public GWsMapapiAutoSwitchResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WSMAPAPIAUTOSWITCH;
    }
}
