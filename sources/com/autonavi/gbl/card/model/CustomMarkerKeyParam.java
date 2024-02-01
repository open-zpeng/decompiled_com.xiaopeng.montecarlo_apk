package com.autonavi.gbl.card.model;

import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class CustomMarkerKeyParam implements Serializable {
    public String customXmlStr;
    public BigInteger markerKey;

    public CustomMarkerKeyParam() {
        this.markerKey = new BigInteger("0");
        this.customXmlStr = "";
    }

    public CustomMarkerKeyParam(BigInteger bigInteger, String str) {
        this.markerKey = bigInteger;
        this.customXmlStr = str;
    }
}
