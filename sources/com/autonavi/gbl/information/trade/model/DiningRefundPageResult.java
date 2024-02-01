package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DiningRefundPageResult extends OrderRefundPageResult implements Serializable {
    public String orderId = "";
    public String poiName = "";
    public int refundCount = 0;
    public DiningProductBaseInfo productInfo = new DiningProductBaseInfo();
    public ArrayList<CancelTradeReason> reasons = new ArrayList<>();
    public ArrayList<String> tips = new ArrayList<>();
    public DiningRefundAmountInfo amountInfo = new DiningRefundAmountInfo();
}
