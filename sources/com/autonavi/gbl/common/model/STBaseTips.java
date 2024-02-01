package com.autonavi.gbl.common.model;

import com.autonavi.gbl.common.model.TipsCategory;
import com.autonavi.gbl.common.model.TipsType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class STBaseTips implements Serializable {
    public STTipsBaseInfo baseInfo;
    public ArrayList<STDetail> detailList;
    public ArrayList<STLine> line;
    public ArrayList<STPoint> point;
    @TipsCategory.TipsCategory1
    public int tipsCategory;
    @TipsType.TipsType1
    public int tipsType;

    public STBaseTips() {
        this.line = new ArrayList<>();
        this.point = new ArrayList<>();
        this.detailList = new ArrayList<>();
        this.baseInfo = new STTipsBaseInfo();
        this.tipsCategory = 0;
        this.tipsType = 0;
    }

    public STBaseTips(ArrayList<STLine> arrayList, ArrayList<STPoint> arrayList2, ArrayList<STDetail> arrayList3, STTipsBaseInfo sTTipsBaseInfo, @TipsCategory.TipsCategory1 int i, @TipsType.TipsType1 int i2) {
        this.line = arrayList;
        this.point = arrayList2;
        this.detailList = arrayList3;
        this.baseInfo = sTTipsBaseInfo;
        this.tipsCategory = i;
        this.tipsType = i2;
    }
}
