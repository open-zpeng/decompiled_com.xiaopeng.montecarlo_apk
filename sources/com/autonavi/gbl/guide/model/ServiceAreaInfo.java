package com.autonavi.gbl.guide.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ServiceAreaInfo implements Serializable {
    public long remainFreewayDistance;
    public long remainFreewayTime;
    public short remainServiceAreaNum;
    public ArrayList<NaviFacility> serviceAreaList;

    public ServiceAreaInfo() {
        this.serviceAreaList = new ArrayList<>();
        this.remainServiceAreaNum = (short) 0;
        this.remainFreewayDistance = 0L;
        this.remainFreewayTime = 0L;
    }

    public ServiceAreaInfo(ArrayList<NaviFacility> arrayList, short s, long j, long j2) {
        this.serviceAreaList = arrayList;
        this.remainServiceAreaNum = s;
        this.remainFreewayDistance = j;
        this.remainFreewayTime = j2;
    }
}
