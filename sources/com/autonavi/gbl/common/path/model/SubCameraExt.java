package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.path.model.SubCameraExtType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SubCameraExt implements Serializable {
    public long appearance;
    public long createTime;
    public ArrayList<IntervalCameraPair> intervalLimits;
    public CameraPenaltyInfo penalty;
    public int source;
    public ArrayList<CameraSpeedLimit> speedLimits;
    public long subCameraId;
    @SubCameraExtType.SubCameraExtType1
    public int type;
    public boolean variable;
    public long visual;

    public SubCameraExt() {
        this.subCameraId = 0L;
        this.type = 0;
        this.source = 0;
        this.visual = 0L;
        this.appearance = 0L;
        this.variable = false;
        this.createTime = 0L;
        this.penalty = new CameraPenaltyInfo();
        this.speedLimits = new ArrayList<>();
        this.intervalLimits = new ArrayList<>();
    }

    public SubCameraExt(long j, @SubCameraExtType.SubCameraExtType1 int i, int i2, long j2, long j3, boolean z, long j4, CameraPenaltyInfo cameraPenaltyInfo, ArrayList<CameraSpeedLimit> arrayList, ArrayList<IntervalCameraPair> arrayList2) {
        this.subCameraId = j;
        this.type = i;
        this.source = i2;
        this.visual = j2;
        this.appearance = j3;
        this.variable = z;
        this.createTime = j4;
        this.penalty = cameraPenaltyInfo;
        this.speedLimits = arrayList;
        this.intervalLimits = arrayList2;
    }
}
