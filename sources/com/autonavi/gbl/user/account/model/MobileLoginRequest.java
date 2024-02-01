package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MobileLoginRequest extends AccountRequest implements Serializable {
    public String mobileNum = "";
    public String code = "";
    public long mode = 0;

    public MobileLoginRequest() {
        this.reqType = 4;
    }
}
