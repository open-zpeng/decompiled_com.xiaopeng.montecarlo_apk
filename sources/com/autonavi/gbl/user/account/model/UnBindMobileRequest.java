package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class UnBindMobileRequest extends AccountRequest implements Serializable {
    public int check = 0;

    public UnBindMobileRequest() {
        this.reqType = 2;
    }
}
