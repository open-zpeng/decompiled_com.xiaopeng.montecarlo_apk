package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CameraSpeedLimit implements Serializable {
    public boolean flag;
    public long holiday;
    public ArrayList<Long> laneSpeedLimit;
    public ArrayList<GroupTimeRange> limitTimeRange;
    public long speed;

    public CameraSpeedLimit() {
        this.flag = false;
        this.speed = 0L;
        this.laneSpeedLimit = new ArrayList<>();
        this.holiday = 0L;
        this.limitTimeRange = new ArrayList<>();
    }

    public CameraSpeedLimit(boolean z, long j, ArrayList<Long> arrayList, long j2, ArrayList<GroupTimeRange> arrayList2) {
        this.flag = z;
        this.speed = j;
        this.laneSpeedLimit = arrayList;
        this.holiday = j2;
        this.limitTimeRange = arrayList2;
    }
}
