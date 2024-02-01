package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GParkOrderDetailResponseParam extends BLResponseBase implements Serializable {
    public String orderId = "";
    public String parkName = "";
    public double totalFee = 0.0d;
    public double unpaidFee = 0.0d;
    public double paidFee = 0.0d;
    public double alipayFee = 0.0d;
    public double capFee = 0.0d;
    public double refundFee = 0.0d;
    public double discountFee = 0.0d;
    public int parkDuration = 0;
    public int freeParkDuration = 0;
    public int status = 0;
    public String enterTime = "";
    public String leaveTime = "";
    public String refundTime = "";
    public String licensePlate = "";
    public String servicePhone = "";

    public GParkOrderDetailResponseParam() {
        this.mEAosRequestType = 200010;
    }
}
