package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class BindMobileResult extends AccountAosResult implements Serializable {
    public int credit = 0;
    public int remain = 0;
    public String errmsg = "";
    public String errOrderId = "";
    public UserProfile profile = new UserProfile();
    public OrderConfInfo orderConf = new OrderConfInfo();
}
