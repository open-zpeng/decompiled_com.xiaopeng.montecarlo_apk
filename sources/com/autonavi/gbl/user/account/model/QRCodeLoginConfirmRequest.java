package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class QRCodeLoginConfirmRequest extends AccountRequest implements Serializable {
    public String qrcodeId = "";

    public QRCodeLoginConfirmRequest() {
        this.reqType = 6;
    }
}
