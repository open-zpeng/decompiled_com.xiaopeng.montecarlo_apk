package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LinePoiChargeInfo extends LinePoiBase implements Serializable {
    public int slow_free = 0;
    public int slow_total = 0;
    public int fast_free = 0;
    public int fast_total = 0;
    public String srcType = "";
    public String market = "";
    public String parkCategory = "";
    public String openTime = "";
    public boolean open24h = false;
    public LinePoiChargingPrice chargingPrice = new LinePoiChargingPrice();
    public LinePoiChargePlugInfo plugInfo = new LinePoiChargePlugInfo();
}
