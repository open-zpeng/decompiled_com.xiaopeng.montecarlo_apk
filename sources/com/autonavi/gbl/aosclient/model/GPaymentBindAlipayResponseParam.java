package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GPaymentBindAlipayResponseParam extends BLResponseBase implements Serializable {
    public String url = "";
    public GAosQRCode qRCode = new GAosQRCode();
}
