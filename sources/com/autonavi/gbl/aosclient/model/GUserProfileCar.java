package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GUserProfileCar implements Serializable {
    public String device;
    public String manufacture;
    public String model;

    public GUserProfileCar() {
        this.model = "";
        this.device = "";
        this.manufacture = "";
    }

    public GUserProfileCar(String str, String str2, String str3) {
        this.model = str;
        this.device = str2;
        this.manufacture = str3;
    }
}
