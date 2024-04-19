package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CalcRouteResultData implements Serializable {
    public byte[] driveGuideData;
    public byte[] drivePlanData;
    public byte[] oddData;

    public CalcRouteResultData() {
        this.drivePlanData = null;
        this.driveGuideData = null;
        this.oddData = null;
    }

    public CalcRouteResultData(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.drivePlanData = bArr;
        this.driveGuideData = bArr2;
        this.oddData = bArr3;
    }
}
