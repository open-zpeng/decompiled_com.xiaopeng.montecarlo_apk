package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcFuelCreateUserInfo implements Serializable {
    public String phoneNumber;

    public WsTcFuelCreateUserInfo() {
        this.phoneNumber = "";
    }

    public WsTcFuelCreateUserInfo(String str) {
        this.phoneNumber = str;
    }
}
