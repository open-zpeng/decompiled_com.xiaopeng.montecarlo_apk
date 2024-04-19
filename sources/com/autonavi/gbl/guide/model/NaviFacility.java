package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.guide.model.NaviFacilityType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class NaviFacility implements Serializable {
    public int buildingStatus;
    public String children;
    public int energyConsume;
    public int isCharge;
    public String name;
    public short payTip;
    public Coord2DDouble pos;
    public int remainDist;
    public long remainTime;
    public short sapaChargeCount;
    public short sapaChargeUsable;
    public long sapaDetail;
    public String servicePOIID;
    @NaviFacilityType.NaviFacilityType1
    public int type;

    public NaviFacility() {
        this.remainDist = 0;
        this.type = 0;
        this.name = "";
        this.pos = new Coord2DDouble();
        this.sapaDetail = 0L;
        this.payTip = (short) 0;
        this.remainTime = 0L;
        this.energyConsume = 0;
        this.servicePOIID = "";
        this.isCharge = 0;
        this.sapaChargeCount = (short) 0;
        this.sapaChargeUsable = (short) 0;
        this.buildingStatus = 0;
        this.children = "";
    }

    public NaviFacility(int i, @NaviFacilityType.NaviFacilityType1 int i2, String str, Coord2DDouble coord2DDouble, long j, short s, long j2, int i3, String str2, int i4, short s2, short s3, int i5, String str3) {
        this.remainDist = i;
        this.type = i2;
        this.name = str;
        this.pos = coord2DDouble;
        this.sapaDetail = j;
        this.payTip = s;
        this.remainTime = j2;
        this.energyConsume = i3;
        this.servicePOIID = str2;
        this.isCharge = i4;
        this.sapaChargeCount = s2;
        this.sapaChargeUsable = s3;
        this.buildingStatus = i5;
        this.children = str3;
    }
}
