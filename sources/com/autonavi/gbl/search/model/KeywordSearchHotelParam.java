package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class KeywordSearchHotelParam implements Serializable {
    public String CheckIn;
    public String CheckOut;

    public KeywordSearchHotelParam() {
        this.CheckIn = "";
        this.CheckOut = "";
    }

    public KeywordSearchHotelParam(String str, String str2) {
        this.CheckIn = str;
        this.CheckOut = str2;
    }
}
