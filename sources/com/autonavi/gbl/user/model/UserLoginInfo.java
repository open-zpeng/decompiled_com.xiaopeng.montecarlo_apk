package com.autonavi.gbl.user.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class UserLoginInfo implements Serializable {
    public String userId;

    public UserLoginInfo() {
        this.userId = "";
    }

    public UserLoginInfo(String str) {
        this.userId = str;
    }
}
