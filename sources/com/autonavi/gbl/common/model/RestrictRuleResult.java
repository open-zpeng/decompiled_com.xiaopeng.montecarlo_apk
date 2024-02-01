package com.autonavi.gbl.common.model;

import com.autonavi.gbl.common.model.CloudInfoErrorCode;
import java.io.Serializable;
/* loaded from: classes.dex */
public class RestrictRuleResult implements Serializable {
    @CloudInfoErrorCode.CloudInfoErrorCode1
    public int errorCode;
    public long reqId;

    public RestrictRuleResult() {
        this.reqId = 0L;
        this.errorCode = 0;
    }

    public RestrictRuleResult(long j, @CloudInfoErrorCode.CloudInfoErrorCode1 int i) {
        this.reqId = j;
        this.errorCode = i;
    }
}
