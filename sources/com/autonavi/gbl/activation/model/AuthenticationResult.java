package com.autonavi.gbl.activation.model;

import com.autonavi.gbl.activation.model.AuthenticationStatus;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AuthenticationResult implements Serializable {
    public int functionId;
    @AuthenticationStatus.AuthenticationStatus1
    public int status;

    public AuthenticationResult() {
        this.status = -1;
        this.functionId = 0;
    }

    public AuthenticationResult(@AuthenticationStatus.AuthenticationStatus1 int i, int i2) {
        this.status = i;
        this.functionId = i2;
    }
}
