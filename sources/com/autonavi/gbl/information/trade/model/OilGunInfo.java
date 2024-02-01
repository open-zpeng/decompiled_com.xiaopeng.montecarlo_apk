package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OilGunInfo implements Serializable {
    public TradePrice oilAmount;
    public String oilCategry;
    public ArrayList<OilGunNo> oilGunNos;
    public String oilNo;

    public OilGunInfo() {
        this.oilCategry = "";
        this.oilNo = "";
        this.oilAmount = new TradePrice();
        this.oilGunNos = new ArrayList<>();
    }

    public OilGunInfo(String str, String str2, TradePrice tradePrice, ArrayList<OilGunNo> arrayList) {
        this.oilCategry = str;
        this.oilNo = str2;
        this.oilAmount = tradePrice;
        this.oilGunNos = arrayList;
    }
}
