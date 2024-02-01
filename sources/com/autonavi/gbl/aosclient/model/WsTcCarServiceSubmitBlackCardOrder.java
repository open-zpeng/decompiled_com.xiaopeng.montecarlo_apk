package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcCarServiceSubmitBlackCardOrder implements Serializable {
    public String bizType;
    public String priceOrder;
    public String priceOrig;

    public WsTcCarServiceSubmitBlackCardOrder() {
        this.bizType = "";
        this.priceOrder = "";
        this.priceOrig = "";
    }

    public WsTcCarServiceSubmitBlackCardOrder(String str, String str2, String str3) {
        this.bizType = str;
        this.priceOrder = str2;
        this.priceOrig = str3;
    }
}
