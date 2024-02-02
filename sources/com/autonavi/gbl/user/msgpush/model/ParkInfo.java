package com.autonavi.gbl.user.msgpush.model;

import com.autonavi.gbl.user.msgpush.model.ParkCode;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class ParkInfo implements Serializable {
    @ParkCode.ParkCode1
    public int code;
    public int cpCode;
    public String cpName;
    public ParkExtInfo ext;
    public String orderId;
    public String park;
    public String remark;

    public ParkInfo() {
        this.cpCode = 0;
        this.code = -1;
        this.orderId = "";
        this.park = "";
        this.remark = "";
        this.cpName = "";
        this.ext = new ParkExtInfo();
    }

    public ParkInfo(int i, @ParkCode.ParkCode1 int i2, String str, String str2, String str3, String str4, ParkExtInfo parkExtInfo) {
        this.cpCode = i;
        this.code = i2;
        this.orderId = str;
        this.park = str2;
        this.remark = str3;
        this.cpName = str4;
        this.ext = parkExtInfo;
    }
}
