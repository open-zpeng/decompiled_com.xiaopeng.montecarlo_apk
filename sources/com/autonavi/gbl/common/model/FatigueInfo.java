package com.autonavi.gbl.common.model;

import com.autonavi.gbl.common.model.DynamicalType;
import com.autonavi.gbl.common.model.PlayErrorCode;
import com.autonavi.gbl.common.model.PlayStatus;
import java.io.Serializable;
/* loaded from: classes.dex */
public class FatigueInfo implements Serializable {
    public String dynamicId;
    @DynamicalType.DynamicalType1
    public int dynamicalType;
    @PlayErrorCode.PlayErrorCode1
    public int playErrorCode;
    @PlayStatus.PlayStatus1
    public int playStatus;

    public FatigueInfo() {
        this.dynamicId = "";
        this.dynamicalType = 4;
        this.playStatus = 0;
        this.playErrorCode = 0;
    }

    public FatigueInfo(String str, @DynamicalType.DynamicalType1 int i, @PlayStatus.PlayStatus1 int i2, @PlayErrorCode.PlayErrorCode1 int i3) {
        this.dynamicId = str;
        this.dynamicalType = i;
        this.playStatus = i2;
        this.playErrorCode = i3;
    }
}
