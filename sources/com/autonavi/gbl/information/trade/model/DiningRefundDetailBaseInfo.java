package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.information.trade.model.DiningRefundStatus;
import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningRefundDetailBaseInfo implements Serializable {
    public DiningRefundTimeInfo beginTime;
    public DiningRefundTimeInfo finishTime;
    public String orderId;
    public String poiName;
    public DiningRefundTimeInfo processTime;
    public DiningProductBaseInfo productInfo;
    public TradePrice refundAmount;
    public int refundCount;
    @DiningRefundStatus.DiningRefundStatus1
    public int status;
    public DiningRefundDetailTextInfo textInfo;

    public DiningRefundDetailBaseInfo() {
        this.orderId = "";
        this.poiName = "";
        this.beginTime = new DiningRefundTimeInfo();
        this.processTime = new DiningRefundTimeInfo();
        this.finishTime = new DiningRefundTimeInfo();
        this.status = 0;
        this.textInfo = new DiningRefundDetailTextInfo();
        this.productInfo = new DiningProductBaseInfo();
        this.refundAmount = new TradePrice();
        this.refundCount = 0;
    }

    public DiningRefundDetailBaseInfo(String str, String str2, DiningRefundTimeInfo diningRefundTimeInfo, DiningRefundTimeInfo diningRefundTimeInfo2, DiningRefundTimeInfo diningRefundTimeInfo3, @DiningRefundStatus.DiningRefundStatus1 int i, DiningRefundDetailTextInfo diningRefundDetailTextInfo, DiningProductBaseInfo diningProductBaseInfo, TradePrice tradePrice, int i2) {
        this.orderId = str;
        this.poiName = str2;
        this.beginTime = diningRefundTimeInfo;
        this.processTime = diningRefundTimeInfo2;
        this.finishTime = diningRefundTimeInfo3;
        this.status = i;
        this.textInfo = diningRefundDetailTextInfo;
        this.productInfo = diningProductBaseInfo;
        this.refundAmount = tradePrice;
        this.refundCount = i2;
    }
}
