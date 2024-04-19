package com.autonavi.gbl.pos.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LocParallelRoadInfo implements Serializable {
    public int count;
    public int flag;
    public int hwFlag;
    public ArrayList<LocParallelRoad> parallelRoadList;
    public int status;

    public LocParallelRoadInfo() {
        this.status = 0;
        this.flag = 0;
        this.hwFlag = 0;
        this.count = 0;
        this.parallelRoadList = new ArrayList<>();
    }

    public LocParallelRoadInfo(int i, int i2, int i3, int i4, ArrayList<LocParallelRoad> arrayList) {
        this.status = i;
        this.flag = i2;
        this.hwFlag = i3;
        this.count = i4;
        this.parallelRoadList = arrayList;
    }
}
