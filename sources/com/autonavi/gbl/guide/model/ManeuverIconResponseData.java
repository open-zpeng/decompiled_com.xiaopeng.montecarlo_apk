package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ManeuverIconResponseData implements Serializable {
    public boolean bValid;
    public byte[] data;
    public ManeuverConfig requestConfig;
    public int requestID;

    public ManeuverIconResponseData() {
        this.requestID = 0;
        this.requestConfig = new ManeuverConfig();
        this.bValid = false;
        this.data = null;
    }

    public ManeuverIconResponseData(int i, byte[] bArr, ManeuverConfig maneuverConfig, boolean z) {
        this.requestID = i;
        this.data = bArr;
        this.requestConfig = maneuverConfig;
        this.bValid = z;
    }
}
