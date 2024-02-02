package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GParkOrderCreateResponseParam extends BLResponseBase implements Serializable {
    public String OrderId = "";
    public String AmapOrderId = "";
    public GAosQRCode QRCode = new GAosQRCode();
    public double Price = 0.0d;
    public int ParkDuration = 0;
}
