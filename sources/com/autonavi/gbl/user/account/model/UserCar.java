package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class UserCar implements Serializable {
    public String device;
    public String manufacture;
    public String model;

    public UserCar() {
        this.model = "";
        this.device = "";
        this.manufacture = "";
    }

    public UserCar(String str, String str2, String str3) {
        this.model = str;
        this.device = str2;
        this.manufacture = str3;
    }
}
