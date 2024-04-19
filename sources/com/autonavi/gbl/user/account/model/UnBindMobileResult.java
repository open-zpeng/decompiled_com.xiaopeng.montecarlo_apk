package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class UnBindMobileResult extends AccountAosResult implements Serializable {
    public String errmsg = "";
    public String errOrderId = "";
    public OrderConfInfo orderConf = new OrderConfInfo();
}
