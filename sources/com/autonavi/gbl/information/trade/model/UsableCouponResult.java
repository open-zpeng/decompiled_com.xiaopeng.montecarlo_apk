package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.information.model.InformationResponse;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UsableCouponResult extends InformationResponse implements Serializable {
    public ArrayList<UsableCoupon> usableCoupon = new ArrayList<>();
    public ArrayList<UnusableCoupon> unUsableCoupon = new ArrayList<>();
}
