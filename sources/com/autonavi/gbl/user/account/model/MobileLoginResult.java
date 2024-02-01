package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MobileLoginResult extends AccountAosResult implements Serializable {
    public int remain = 0;
    public boolean repwd = false;
    public AccountProfile profile = new AccountProfile();
}
