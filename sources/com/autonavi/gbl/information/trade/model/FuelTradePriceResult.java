package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.information.model.InformationResponse;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FuelTradePriceResult extends InformationResponse implements Serializable {
    public int code = 0;
    public ArrayList<OilGunInfo> oilGunInfos = new ArrayList<>();
    public DiscountPriceInfo discountPriceInfo = new DiscountPriceInfo();
}
