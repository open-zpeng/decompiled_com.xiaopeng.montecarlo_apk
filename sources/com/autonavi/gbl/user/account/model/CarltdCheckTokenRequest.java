package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class CarltdCheckTokenRequest extends AccountRequest implements Serializable {
    public String sourceId = "";
    public String token = "";
    public String authId = "";
    public String deviceCode = "";
    public String envParam = "";

    public CarltdCheckTokenRequest() {
        this.reqType = 14;
    }
}
