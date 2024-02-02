package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AvatarRequest extends AccountRequest implements Serializable {
    public String url = "";

    public AvatarRequest() {
        this.reqType = 10;
    }
}
