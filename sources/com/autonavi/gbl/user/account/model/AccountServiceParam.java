package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AccountServiceParam implements Serializable {
    public String dataPath;

    public AccountServiceParam() {
        this.dataPath = "";
    }

    public AccountServiceParam(String str) {
        this.dataPath = str;
    }
}
