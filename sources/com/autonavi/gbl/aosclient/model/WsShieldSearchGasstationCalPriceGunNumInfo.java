package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceGunNumInfo implements Serializable {
    public String code;
    public String name;

    public WsShieldSearchGasstationCalPriceGunNumInfo() {
        this.name = "";
        this.code = "";
    }

    public WsShieldSearchGasstationCalPriceGunNumInfo(String str, String str2) {
        this.name = str;
        this.code = str2;
    }
}
