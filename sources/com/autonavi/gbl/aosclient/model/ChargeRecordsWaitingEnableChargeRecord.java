package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ChargeRecordsWaitingEnableChargeRecord implements Serializable {
    public int amount;
    public String charge_record_no;
    public int charge_unit;
    public String pid;
    public String service_name;
    public String sid;
    public int unified_amount;
    public String vid;

    public ChargeRecordsWaitingEnableChargeRecord() {
        this.charge_record_no = "";
        this.sid = "";
        this.pid = "";
        this.vid = "";
        this.amount = 0;
        this.charge_unit = 0;
        this.unified_amount = 0;
        this.service_name = "";
    }

    public ChargeRecordsWaitingEnableChargeRecord(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5) {
        this.charge_record_no = str;
        this.sid = str2;
        this.pid = str3;
        this.vid = str4;
        this.amount = i;
        this.charge_unit = i2;
        this.unified_amount = i3;
        this.service_name = str5;
    }
}
