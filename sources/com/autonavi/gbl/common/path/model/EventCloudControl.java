package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EventCloudControl implements Serializable {
    public EventDetail detail;
    public PointDetail pointDetail;
    public String strContent;
    public String strRoadName;
    public TipsCloudControl tipsControl;
    public ArrayList<RelDetail> vecRelTipDetail;
    public ArrayList<RelDetail> vecRelTipPoint;

    public EventCloudControl() {
        this.tipsControl = new TipsCloudControl();
        this.strRoadName = "";
        this.vecRelTipPoint = new ArrayList<>();
        this.vecRelTipDetail = new ArrayList<>();
        this.strContent = "";
        this.pointDetail = new PointDetail();
        this.detail = new EventDetail();
    }

    public EventCloudControl(TipsCloudControl tipsCloudControl, String str, ArrayList<RelDetail> arrayList, ArrayList<RelDetail> arrayList2, String str2, PointDetail pointDetail, EventDetail eventDetail) {
        this.tipsControl = tipsCloudControl;
        this.strRoadName = str;
        this.vecRelTipPoint = arrayList;
        this.vecRelTipDetail = arrayList2;
        this.strContent = str2;
        this.pointDetail = pointDetail;
        this.detail = eventDetail;
    }
}
