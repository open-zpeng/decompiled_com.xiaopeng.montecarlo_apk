package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AccountCheckRequest extends AccountRequest implements Serializable {
    public String mobileNum = "";
    public String email = "";
    public String userName = "";

    public AccountCheckRequest() {
        this.reqType = 0;
    }
}
