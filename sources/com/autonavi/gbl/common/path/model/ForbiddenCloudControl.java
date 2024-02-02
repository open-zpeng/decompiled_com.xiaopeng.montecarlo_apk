package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ForbiddenCloudControl implements Serializable {
    public ForbiddenDetail forbiddenDetail;
    public PointDetail pointDetail;
    public String strReason;
    public TipsCloudControl tipsControl;
    public ArrayList<RelDetail> vecRelTipDetail;
    public ArrayList<RelDetail> vecRelTipPoint;

    public ForbiddenCloudControl() {
        this.tipsControl = new TipsCloudControl();
        this.strReason = "";
        this.vecRelTipPoint = new ArrayList<>();
        this.vecRelTipDetail = new ArrayList<>();
        this.pointDetail = new PointDetail();
        this.forbiddenDetail = new ForbiddenDetail();
    }

    public ForbiddenCloudControl(TipsCloudControl tipsCloudControl, String str, ArrayList<RelDetail> arrayList, ArrayList<RelDetail> arrayList2, PointDetail pointDetail, ForbiddenDetail forbiddenDetail) {
        this.tipsControl = tipsCloudControl;
        this.strReason = str;
        this.vecRelTipPoint = arrayList;
        this.vecRelTipDetail = arrayList2;
        this.pointDetail = pointDetail;
        this.forbiddenDetail = forbiddenDetail;
    }
}
