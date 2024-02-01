package com.autonavi.gbl.activation.model;

import com.autonavi.gbl.activation.model.AuthenticationStatus;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AuthenticationInfo implements Serializable {
    public long endTime;
    @AuthenticationStatus.AuthenticationStatus1
    public int status;

    public AuthenticationInfo() {
        this.status = -1;
        this.endTime = 0L;
    }

    public AuthenticationInfo(@AuthenticationStatus.AuthenticationStatus1 int i, long j) {
        this.status = i;
        this.endTime = j;
    }
}
