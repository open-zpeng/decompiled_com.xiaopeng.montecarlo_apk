package com.autonavi.gbl.user.account.model;

import com.autonavi.gbl.user.account.model.QRBizType;
import com.autonavi.gbl.user.account.model.QRCodeType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class QRCodeLoginRequest extends AccountRequest implements Serializable {
    @QRCodeType.QRCodeType1
    public int codeType = 0;
    @QRBizType.QRBizType1
    public int bizType = -1;

    public QRCodeLoginRequest() {
        this.reqType = 5;
    }
}
