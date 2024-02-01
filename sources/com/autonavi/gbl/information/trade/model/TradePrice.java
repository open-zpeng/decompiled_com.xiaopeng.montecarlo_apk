package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.information.trade.model.TradeCurrency;
import com.autonavi.gbl.information.trade.model.TradePriceUnit;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TradePrice implements Serializable {
    public String amount;
    @TradeCurrency.TradeCurrency1
    public int currency;
    public String text;
    @TradePriceUnit.TradePriceUnit1
    public int unit;

    public TradePrice() {
        this.unit = 0;
        this.currency = 0;
        this.amount = "";
        this.text = "";
    }

    public TradePrice(@TradePriceUnit.TradePriceUnit1 int i, @TradeCurrency.TradeCurrency1 int i2, String str, String str2) {
        this.unit = i;
        this.currency = i2;
        this.amount = str;
        this.text = str2;
    }
}
