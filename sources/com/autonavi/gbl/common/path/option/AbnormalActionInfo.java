package com.autonavi.gbl.common.path.option;

import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class AbnormalActionInfo implements Serializable {
    public long abnormalType;
    public BigInteger linkID;

    public AbnormalActionInfo() {
        this.abnormalType = 0L;
        this.linkID = new BigInteger("0");
    }

    public AbnormalActionInfo(long j, BigInteger bigInteger) {
        this.abnormalType = j;
        this.linkID = bigInteger;
    }
}
