package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocNema implements Serializable {
    public String cNemaInfo;
    @LocDataType.LocDataType1
    public int dataType;
    public BigInteger localTickTime;
    public BigInteger tickTime;

    public LocNema() {
        this.dataType = 0;
        this.tickTime = new BigInteger("0");
        this.localTickTime = new BigInteger("0");
        this.cNemaInfo = "";
    }

    public LocNema(@LocDataType.LocDataType1 int i, BigInteger bigInteger, BigInteger bigInteger2, String str) {
        this.dataType = i;
        this.tickTime = bigInteger;
        this.localTickTime = bigInteger2;
        this.cNemaInfo = str;
    }
}
