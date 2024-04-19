package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChargeRecordsWaitingEnableResponseData implements Serializable {
    public ArrayList<ChargeRecordsWaitingEnableChargeRecord> charge_records;

    public ChargeRecordsWaitingEnableResponseData() {
        this.charge_records = new ArrayList<>();
    }

    public ChargeRecordsWaitingEnableResponseData(ArrayList<ChargeRecordsWaitingEnableChargeRecord> arrayList) {
        this.charge_records = arrayList;
    }
}
