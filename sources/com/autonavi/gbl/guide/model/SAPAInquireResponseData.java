package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class SAPAInquireResponseData implements Serializable {
    public boolean bValid;
    public boolean isfindRemainPath;
    public int requestID;
    public ServiceAreaInfo serviceAreaInfo;

    public SAPAInquireResponseData() {
        this.requestID = 0;
        this.serviceAreaInfo = new ServiceAreaInfo();
        this.bValid = false;
        this.isfindRemainPath = false;
    }

    public SAPAInquireResponseData(int i, ServiceAreaInfo serviceAreaInfo, boolean z, boolean z2) {
        this.requestID = i;
        this.serviceAreaInfo = serviceAreaInfo;
        this.bValid = z;
        this.isfindRemainPath = z2;
    }
}
