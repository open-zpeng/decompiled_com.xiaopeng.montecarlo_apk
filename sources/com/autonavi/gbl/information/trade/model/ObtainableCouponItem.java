package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ObtainableCouponItem extends CouponItem implements Serializable {
    public ArrayList<CouponDiscountRule> discountRules = new ArrayList<>();
    public String discountRuleDescription = "";
    public int instantAmount = 0;
    public int expirationDays = 0;
}
