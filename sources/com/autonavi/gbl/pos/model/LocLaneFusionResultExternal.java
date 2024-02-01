package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocLaneFusionResultExternal implements Serializable {
    public float boundaryHeadingLeft;
    public float boundaryHeadingRight;
    @LocDataType.LocDataType1
    public int dataType;
    public boolean isLaneNumValid;
    public float lateralOffsetLeft;
    public float lateralOffsetLeftAcc;
    public float lateralOffsetRight;
    public float lateralOffsetRightAcc;
    public LocLaneNum leftLaneNum;
    public BigInteger localTickTime;
    public LocLaneNum rightLaneNum;
    public float stdLateralPos;
    public float stdLongitudinalPos;
    public BigInteger tickTime;

    public LocLaneFusionResultExternal() {
        this.dataType = LocDataType.LocDataLaneResExternal;
        this.tickTime = new BigInteger("0");
        this.isLaneNumValid = false;
        this.leftLaneNum = new LocLaneNum();
        this.rightLaneNum = new LocLaneNum();
        this.lateralOffsetLeft = 0.0f;
        this.lateralOffsetLeftAcc = 0.0f;
        this.lateralOffsetRight = 0.0f;
        this.lateralOffsetRightAcc = 0.0f;
        this.boundaryHeadingLeft = 0.0f;
        this.boundaryHeadingRight = 0.0f;
        this.stdLateralPos = 0.0f;
        this.stdLongitudinalPos = 0.0f;
        this.localTickTime = new BigInteger("0");
    }

    public LocLaneFusionResultExternal(@LocDataType.LocDataType1 int i, BigInteger bigInteger, boolean z, LocLaneNum locLaneNum, LocLaneNum locLaneNum2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, BigInteger bigInteger2) {
        this.dataType = i;
        this.tickTime = bigInteger;
        this.isLaneNumValid = z;
        this.leftLaneNum = locLaneNum;
        this.rightLaneNum = locLaneNum2;
        this.lateralOffsetLeft = f;
        this.lateralOffsetLeftAcc = f2;
        this.lateralOffsetRight = f3;
        this.lateralOffsetRightAcc = f4;
        this.boundaryHeadingLeft = f5;
        this.boundaryHeadingRight = f6;
        this.stdLateralPos = f7;
        this.stdLongitudinalPos = f8;
        this.localTickTime = bigInteger2;
    }
}
