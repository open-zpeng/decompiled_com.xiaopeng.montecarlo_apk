package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class CarltdCheckBindRequest extends AccountRequest implements Serializable {
    public String sourceId = "";
    public String authId = "";

    public CarltdCheckBindRequest() {
        this.reqType = 13;
    }
}
