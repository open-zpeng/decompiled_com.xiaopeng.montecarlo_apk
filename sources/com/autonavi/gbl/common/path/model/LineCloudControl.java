package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LineCloudControl implements Serializable {
    public long id;
    public long lay;
    public ArrayList<Long> lnTypeList;
    public int pathIdx;
    public ArrayList<Coord2DDouble> posList;
    public long prio;
    public long shwType;
    public ArrayList<Long> stIdxList;
    public long type;
    public long ver;

    public LineCloudControl() {
        this.type = 0L;
        this.id = 0L;
        this.shwType = 0L;
        this.pathIdx = 0;
        this.prio = 0L;
        this.ver = 0L;
        this.posList = new ArrayList<>();
        this.stIdxList = new ArrayList<>();
        this.lnTypeList = new ArrayList<>();
        this.lay = 0L;
    }

    public LineCloudControl(long j, long j2, long j3, int i, long j4, long j5, ArrayList<Coord2DDouble> arrayList, ArrayList<Long> arrayList2, ArrayList<Long> arrayList3, long j6) {
        this.type = j;
        this.id = j2;
        this.shwType = j3;
        this.pathIdx = i;
        this.prio = j4;
        this.ver = j5;
        this.posList = arrayList;
        this.stIdxList = arrayList2;
        this.lnTypeList = arrayList3;
        this.lay = j6;
    }
}
