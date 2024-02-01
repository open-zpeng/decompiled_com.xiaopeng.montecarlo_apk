package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class CarltdAuthInfoRequest extends AccountRequest implements Serializable {
    public String sourceId = "";
    public String uid = "";

    public CarltdAuthInfoRequest() {
        this.reqType = 17;
    }
}
