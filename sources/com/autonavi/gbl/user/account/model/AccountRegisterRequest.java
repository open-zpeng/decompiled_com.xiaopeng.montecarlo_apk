package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AccountRegisterRequest extends AccountRequest implements Serializable {
    public String mobileNum = "";
    public String code = "";

    public AccountRegisterRequest() {
        this.reqType = 8;
    }
}
