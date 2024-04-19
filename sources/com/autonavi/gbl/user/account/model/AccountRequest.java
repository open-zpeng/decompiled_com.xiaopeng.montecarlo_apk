package com.autonavi.gbl.user.account.model;

import com.autonavi.gbl.user.account.model.AccountRequestType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class AccountRequest implements Serializable {
    @AccountRequestType.AccountRequestType1
    public int reqType;
    public long taskId;

    public AccountRequest() {
        this.reqType = -1;
        this.taskId = 0L;
    }

    public AccountRequest(@AccountRequestType.AccountRequestType1 int i, long j) {
        this.reqType = i;
        this.taskId = j;
    }
}
