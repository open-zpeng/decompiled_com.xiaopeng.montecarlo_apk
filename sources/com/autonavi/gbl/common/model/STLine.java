package com.autonavi.gbl.common.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class STLine implements Serializable {
    public STTipsBaseInfo baseInfo;
    public ArrayList<STDetail> detail;
    public long lay;
    public ArrayList<Long> lnTypeList;
    public ArrayList<Coord2DDouble> posList;
    public ArrayList<Long> stIdxList;

    public STLine() {
        this.baseInfo = new STTipsBaseInfo();
        this.detail = new ArrayList<>();
        this.posList = new ArrayList<>();
        this.stIdxList = new ArrayList<>();
        this.lay = 0L;
        this.lnTypeList = new ArrayList<>();
    }

    public STLine(STTipsBaseInfo sTTipsBaseInfo, ArrayList<STDetail> arrayList, ArrayList<Coord2DDouble> arrayList2, ArrayList<Long> arrayList3, long j, ArrayList<Long> arrayList4) {
        this.baseInfo = sTTipsBaseInfo;
        this.detail = arrayList;
        this.posList = arrayList2;
        this.stIdxList = arrayList3;
        this.lay = j;
        this.lnTypeList = arrayList4;
    }
}
