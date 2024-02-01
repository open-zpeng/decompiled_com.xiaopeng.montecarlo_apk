package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.information.model.InformationResponse;
import com.autonavi.gbl.information.trade.model.DiningRenderMode;
import java.io.Serializable;
/* loaded from: classes.dex */
public class DiningTradePriceResult extends InformationResponse implements Serializable {
    @DiningRenderMode.DiningRenderMode1
    public int renderMode = 0;
    public DiningTradeSubErrorInfo errorInfo = new DiningTradeSubErrorInfo();
    public DiningTradeProductInfo productInfo = new DiningTradeProductInfo();
    public DiningTradePriceInfo priceInfo = new DiningTradePriceInfo();
    public DiningTradeDiscountCouponInfo couponInfo = new DiningTradeDiscountCouponInfo();
    public DiningOrderAgreementInfo agreementInfo = new DiningOrderAgreementInfo();
}
