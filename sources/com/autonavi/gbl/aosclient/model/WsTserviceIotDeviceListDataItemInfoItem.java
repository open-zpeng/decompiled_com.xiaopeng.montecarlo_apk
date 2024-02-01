package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTserviceIotDeviceListDataItemInfoItem implements Serializable {
    public String adiu;
    public String diu;
    public String sn;
    public int status;
    public String uid;

    public WsTserviceIotDeviceListDataItemInfoItem() {
        this.uid = "";
        this.diu = "";
        this.adiu = "";
        this.status = 0;
        this.sn = "";
    }

    public WsTserviceIotDeviceListDataItemInfoItem(String str, String str2, String str3, int i, String str4) {
        this.uid = str;
        this.diu = str2;
        this.adiu = str3;
        this.status = i;
        this.sn = str4;
    }
}
