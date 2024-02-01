package com.autonavi.gbl.data.model;

import com.autonavi.gbl.data.model.TaskStatusCode;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class CityDownLoadItem implements Serializable {
    public boolean IsCompltelyHighVer;
    public int adcode;
    public boolean bIsDataUsed;
    public boolean bUpdate;
    public boolean bValidItem;
    public int errCode;
    public BigInteger nFullUnpackSize;
    public BigInteger nFullZipSize;
    public BigInteger nUnpackSize;
    public BigInteger nZipSize;
    public float percent;
    @TaskStatusCode.TaskStatusCode1
    public int taskState;

    public CityDownLoadItem() {
        this.adcode = 0;
        this.bValidItem = false;
        this.taskState = 0;
        this.errCode = 0;
        this.percent = 0.0f;
        this.bUpdate = false;
        this.bIsDataUsed = false;
        this.IsCompltelyHighVer = false;
        this.nFullUnpackSize = new BigInteger("0");
        this.nFullZipSize = new BigInteger("0");
        this.nUnpackSize = new BigInteger("0");
        this.nZipSize = new BigInteger("0");
    }

    public CityDownLoadItem(int i, boolean z, @TaskStatusCode.TaskStatusCode1 int i2, int i3, float f, boolean z2, boolean z3, boolean z4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.adcode = i;
        this.bValidItem = z;
        this.taskState = i2;
        this.errCode = i3;
        this.percent = f;
        this.bUpdate = z2;
        this.bIsDataUsed = z3;
        this.IsCompltelyHighVer = z4;
        this.nFullUnpackSize = bigInteger;
        this.nFullZipSize = bigInteger2;
        this.nUnpackSize = bigInteger3;
        this.nZipSize = bigInteger4;
    }
}
