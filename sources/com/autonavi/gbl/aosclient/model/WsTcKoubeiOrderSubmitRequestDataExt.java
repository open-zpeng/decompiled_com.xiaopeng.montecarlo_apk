package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcKoubeiOrderSubmitRequestDataExt implements Serializable {
    public String cityId;
    public String fromScene;
    public String storeId;

    public WsTcKoubeiOrderSubmitRequestDataExt() {
        this.storeId = "";
        this.cityId = "";
        this.fromScene = "";
    }

    public WsTcKoubeiOrderSubmitRequestDataExt(String str, String str2, String str3) {
        this.storeId = str;
        this.cityId = str2;
        this.fromScene = str3;
    }
}
