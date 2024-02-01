package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class DynamicLayerObserverParam implements Serializable {
    public String bizDataDSL;
    public long bizType;
    public String itemDataDSL;
    public String itemId;
    public String layerName;
    public String sysDataDSL;
    public String userDataDSL;

    public DynamicLayerObserverParam() {
        this.bizType = 0L;
        this.layerName = "";
        this.itemId = "";
        this.itemDataDSL = "";
        this.bizDataDSL = "";
        this.sysDataDSL = "";
        this.userDataDSL = "";
    }

    public DynamicLayerObserverParam(long j, String str, String str2, String str3, String str4, String str5, String str6) {
        this.bizType = j;
        this.layerName = str;
        this.itemId = str2;
        this.itemDataDSL = str3;
        this.bizDataDSL = str4;
        this.sysDataDSL = str5;
        this.userDataDSL = str6;
    }
}
