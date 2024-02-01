package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class CarltdCheckTokenResult extends AccountAosResult implements Serializable {
    public boolean isAmap = false;
    public String mobile = "";
    public String authId = "";
    public AccountProfile profile = new AccountProfile();
}
