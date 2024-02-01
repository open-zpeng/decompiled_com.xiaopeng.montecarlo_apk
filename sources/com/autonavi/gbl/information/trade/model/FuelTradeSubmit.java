package com.autonavi.gbl.information.trade.model;

import com.autonavi.gbl.information.trade.model.TradePayAgreement;
import java.io.Serializable;
/* loaded from: classes.dex */
public class FuelTradeSubmit implements Serializable {
    @TradePayAgreement.TradePayAgreement1
    public int payAgreement;

    public FuelTradeSubmit() {
        this.payAgreement = 0;
    }

    public FuelTradeSubmit(@TradePayAgreement.TradePayAgreement1 int i) {
        this.payAgreement = i;
    }
}
