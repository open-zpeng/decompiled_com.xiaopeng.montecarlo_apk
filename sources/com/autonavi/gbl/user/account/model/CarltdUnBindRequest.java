package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class CarltdUnBindRequest extends AccountRequest implements Serializable {
    public String sourceId = "";
    public String authId = "";
    public String deviceCode = "";

    public CarltdUnBindRequest() {
        this.reqType = 12;
    }
}
