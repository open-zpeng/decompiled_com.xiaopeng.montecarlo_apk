package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.information.trade.model.CouponType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ObtainedCouponItem extends CouponItem implements Serializable {
    public String rule = "";
    public String description = "";
    public String promotionRule = "";
    public double discountAmount = 0.0d;
    @CouponType.CouponType1
    public int type = 0;
}
