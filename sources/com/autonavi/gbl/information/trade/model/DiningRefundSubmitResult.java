package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningRefundSubmitResult extends OrderRefundSubmitResult implements Serializable {
    public String title = "";
    public String tip = "";
    public DiningRefundDetailBaseInfo detailInfo = new DiningRefundDetailBaseInfo();
    public String accountInfo = "";
    public TradePrice expectedRefundAmount = new TradePrice();
}
