package com.autonavi.gbl.user.account.model;

import com.autonavi.gbl.user.account.model.VerificationCodeType;
import com.autonavi.gbl.user.account.model.VerificationTargetType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class VerificationCodeRequest extends AccountRequest implements Serializable {
    @VerificationCodeType.VerificationCodeType1
    public int codeType = 0;
    @VerificationTargetType.VerificationTargetType1
    public int targetType = 0;
    public String targetValue = "";
    public boolean bindMode = false;
    public boolean skipNew = false;

    public VerificationCodeRequest() {
        this.reqType = 3;
    }
}
