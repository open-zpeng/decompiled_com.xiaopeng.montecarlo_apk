package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AvoidJamCloudControl implements Serializable {
    public AvoidJamDetail avoidJamDetail;
    public LineDetail lineDetail;
    public PointDetail pointDetail;
    public String strJamDist;
    public String strJamRoadName;
    public String strJamTime;
    public TipsCloudControl tipsControl;
    public ArrayList<RelDetail> vecRelTipDetail;
    public ArrayList<RelDetail> vecRelTipLine;
    public ArrayList<RelDetail> vecRelTipPoint;

    public AvoidJamCloudControl() {
        this.tipsControl = new TipsCloudControl();
        this.strJamRoadName = "";
        this.strJamDist = "";
        this.strJamTime = "";
        this.vecRelTipPoint = new ArrayList<>();
        this.vecRelTipLine = new ArrayList<>();
        this.vecRelTipDetail = new ArrayList<>();
        this.pointDetail = new PointDetail();
        this.lineDetail = new LineDetail();
        this.avoidJamDetail = new AvoidJamDetail();
    }

    public AvoidJamCloudControl(TipsCloudControl tipsCloudControl, String str, String str2, String str3, ArrayList<RelDetail> arrayList, ArrayList<RelDetail> arrayList2, ArrayList<RelDetail> arrayList3, PointDetail pointDetail, LineDetail lineDetail, AvoidJamDetail avoidJamDetail) {
        this.tipsControl = tipsCloudControl;
        this.strJamRoadName = str;
        this.strJamDist = str2;
        this.strJamTime = str3;
        this.vecRelTipPoint = arrayList;
        this.vecRelTipLine = arrayList2;
        this.vecRelTipDetail = arrayList3;
        this.pointDetail = pointDetail;
        this.lineDetail = lineDetail;
        this.avoidJamDetail = avoidJamDetail;
    }
}
