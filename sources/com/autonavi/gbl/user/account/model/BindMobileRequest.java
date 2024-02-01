package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class BindMobileRequest extends AccountRequest implements Serializable {
    public String mobile = "";
    public String code = "";
    public int replaceType = 0;

    public BindMobileRequest() {
        this.reqType = 1;
    }
}
