package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AccountProfileRequest extends AccountRequest implements Serializable {
    public long mode = 0;

    public AccountProfileRequest() {
        this.reqType = 9;
    }
}
