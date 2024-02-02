package com.autonavi.gbl.common.model;

import com.autonavi.gbl.common.model.OddRespState;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CalcRouteResultData implements Serializable {
    public byte[] driveGuideData;
    public byte[] drivePlanData;
    public byte[] oddData;
    @OddRespState.OddRespState1
    public int oddRespState;

    public CalcRouteResultData() {
        this.oddRespState = 0;
        this.drivePlanData = null;
        this.driveGuideData = null;
        this.oddData = null;
    }

    public CalcRouteResultData(byte[] bArr, byte[] bArr2, byte[] bArr3, @OddRespState.OddRespState1 int i) {
        this.drivePlanData = bArr;
        this.driveGuideData = bArr2;
        this.oddData = bArr3;
        this.oddRespState = i;
    }
}
