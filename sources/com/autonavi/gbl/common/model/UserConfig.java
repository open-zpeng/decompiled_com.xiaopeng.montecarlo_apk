package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class UserConfig implements Serializable {
    public String deviceID;
    public String password;
    public String userBatch;
    public String userCode;

    public UserConfig() {
        this.userCode = "";
        this.userBatch = "";
        this.deviceID = "";
        this.password = "";
    }

    public UserConfig(String str, String str2, String str3, String str4) {
        this.userCode = str;
        this.userBatch = str2;
        this.deviceID = str3;
        this.password = str4;
    }
}
