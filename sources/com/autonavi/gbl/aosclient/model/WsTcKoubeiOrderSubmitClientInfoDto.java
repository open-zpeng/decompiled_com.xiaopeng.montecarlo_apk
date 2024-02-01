package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcKoubeiOrderSubmitClientInfoDto implements Serializable {
    public String adiu;
    public String ajxVersion;
    public String appVersion;
    public String deviceType;
    public String diu;
    public String tid;
    public String ttid;

    public WsTcKoubeiOrderSubmitClientInfoDto() {
        this.adiu = "";
        this.ajxVersion = "";
        this.appVersion = "";
        this.deviceType = "";
        this.diu = "";
        this.tid = "";
        this.ttid = "";
    }

    public WsTcKoubeiOrderSubmitClientInfoDto(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.adiu = str;
        this.ajxVersion = str2;
        this.appVersion = str3;
        this.deviceType = str4;
        this.diu = str5;
        this.tid = str6;
        this.ttid = str7;
    }
}
