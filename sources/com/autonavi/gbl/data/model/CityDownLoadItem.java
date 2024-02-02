package com.autonavi.gbl.data.model;

import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.model.TaskStatusCode;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CityDownLoadItem implements Serializable {
    public boolean IsCompltelyHighVer;
    public int adcode;
    public boolean bIsDataUsed;
    public boolean bUpdate;
    public boolean bValidItem;
    @OperationErrCode.OperationErrCode1
    public int errCode;
    public int nFullUnpackSize;
    public int nFullZipSize;
    public int nUnpackSize;
    public int nZipSize;
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
        this.nFullUnpackSize = 0;
        this.nFullZipSize = 0;
        this.nUnpackSize = 0;
        this.nZipSize = 0;
    }

    public CityDownLoadItem(int i, boolean z, @TaskStatusCode.TaskStatusCode1 int i2, @OperationErrCode.OperationErrCode1 int i3, float f, boolean z2, boolean z3, boolean z4, int i4, int i5, int i6, int i7) {
        this.adcode = i;
        this.bValidItem = z;
        this.taskState = i2;
        this.errCode = i3;
        this.percent = f;
        this.bUpdate = z2;
        this.bIsDataUsed = z3;
        this.IsCompltelyHighVer = z4;
        this.nFullUnpackSize = i4;
        this.nFullZipSize = i5;
        this.nUnpackSize = i6;
        this.nZipSize = i7;
    }
}
