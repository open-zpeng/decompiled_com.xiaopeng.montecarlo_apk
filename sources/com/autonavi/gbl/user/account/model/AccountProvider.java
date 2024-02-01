package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AccountProvider implements Serializable {
    public int auth_id;
    public String auth_username;
    public int provider;

    public AccountProvider() {
        this.provider = 0;
        this.auth_id = 0;
        this.auth_username = "";
    }

    public AccountProvider(int i, int i2, String str) {
        this.provider = i;
        this.auth_id = i2;
        this.auth_username = str;
    }
}
