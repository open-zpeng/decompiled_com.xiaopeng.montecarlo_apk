package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.guide.model.NaviType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NaviInfo implements Serializable {
    public ArrayList<TimeAndDist> ChargeStationRemain;
    public ArrayList<NaviInfoPanel> NaviInfoData;
    public int NaviInfoFlag;
    public String aoiName;
    public int cityCode;
    public int crossManeuverID;
    public int curLinkIdx;
    public int curLinkSpeed;
    public int curPointIdx;
    @RoadClass.RoadClass1
    public int curRoadClass;
    public String curRouteName;
    public int curSegIdx;
    public int driveDist;
    public int driveTime;
    public String gateName;
    public boolean innerRoad;
    public int linkRemainDist;
    public ArrayList<CrossNaviInfo> nextCrossInfo;
    public NotAvoidInfo notAvoidInfo;
    public long pathID;
    public int ringOutCnt;
    public TimeAndDist routeRemain;
    public int routeRemainLightCount;
    public int segTipsDis;
    @NaviType.NaviType1
    public int type;
    public ArrayList<TimeAndDist> viaRemain;

    public NaviInfo() {
        this.pathID = 0L;
        this.type = 0;
        this.routeRemain = new TimeAndDist();
        this.viaRemain = new ArrayList<>();
        this.ChargeStationRemain = new ArrayList<>();
        this.routeRemainLightCount = 0;
        this.linkRemainDist = 0;
        this.curSegIdx = 0;
        this.curLinkIdx = 0;
        this.curPointIdx = 0;
        this.curRoadClass = -1;
        this.curRouteName = "";
        this.ringOutCnt = 0;
        this.driveTime = 0;
        this.driveDist = 0;
        this.cityCode = 0;
        this.curLinkSpeed = 0;
        this.segTipsDis = 0;
        this.notAvoidInfo = new NotAvoidInfo();
        this.crossManeuverID = 0;
        this.nextCrossInfo = new ArrayList<>();
        this.NaviInfoFlag = 0;
        this.NaviInfoData = new ArrayList<>();
        this.gateName = "";
        this.aoiName = "";
        this.innerRoad = false;
    }

    public NaviInfo(long j, @NaviType.NaviType1 int i, TimeAndDist timeAndDist, ArrayList<TimeAndDist> arrayList, ArrayList<TimeAndDist> arrayList2, int i2, int i3, int i4, int i5, int i6, @RoadClass.RoadClass1 int i7, String str, int i8, int i9, int i10, int i11, int i12, int i13, NotAvoidInfo notAvoidInfo, int i14, ArrayList<CrossNaviInfo> arrayList3, int i15, ArrayList<NaviInfoPanel> arrayList4, String str2, String str3, boolean z) {
        this.pathID = j;
        this.type = i;
        this.routeRemain = timeAndDist;
        this.viaRemain = arrayList;
        this.ChargeStationRemain = arrayList2;
        this.routeRemainLightCount = i2;
        this.linkRemainDist = i3;
        this.curSegIdx = i4;
        this.curLinkIdx = i5;
        this.curPointIdx = i6;
        this.curRoadClass = i7;
        this.curRouteName = str;
        this.ringOutCnt = i8;
        this.driveTime = i9;
        this.driveDist = i10;
        this.cityCode = i11;
        this.curLinkSpeed = i12;
        this.segTipsDis = i13;
        this.notAvoidInfo = notAvoidInfo;
        this.crossManeuverID = i14;
        this.nextCrossInfo = arrayList3;
        this.NaviInfoFlag = i15;
        this.NaviInfoData = arrayList4;
        this.gateName = str2;
        this.aoiName = str3;
        this.innerRoad = z;
    }
}
