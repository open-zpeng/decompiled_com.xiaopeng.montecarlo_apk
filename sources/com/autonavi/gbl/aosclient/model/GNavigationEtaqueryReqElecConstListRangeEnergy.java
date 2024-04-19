package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GNavigationEtaqueryReqElecConstListRangeEnergy implements Serializable {
    public String speed;
    public String value;

    public GNavigationEtaqueryReqElecConstListRangeEnergy() {
        this.value = "";
        this.speed = "";
    }

    public GNavigationEtaqueryReqElecConstListRangeEnergy(String str, String str2) {
        this.value = str;
        this.speed = str2;
    }
}
