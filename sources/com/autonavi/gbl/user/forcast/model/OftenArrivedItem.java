package com.autonavi.gbl.user.forcast.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.util.model.DateTime;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class OftenArrivedItem implements Serializable {
    public int childType;
    public DateTime dateTime;
    public int endPoiExtension;
    public String floorNo;
    public String parent;
    public Coord2DDouble stDisplayCoord;
    public Coord2DDouble stNaviCoord;
    public long topTime;
    public String towardsAngle;
    public ArrayList<Long> uTimeList;
    public String wstrAddress;
    public String wstrPoiID;
    public String wstrPoiName;
    public String wstrPoiType;

    public OftenArrivedItem() {
        this.wstrPoiID = "";
        this.wstrPoiName = "";
        this.wstrPoiType = "";
        this.wstrAddress = "";
        this.stDisplayCoord = new Coord2DDouble();
        this.stNaviCoord = new Coord2DDouble();
        this.parent = "";
        this.towardsAngle = "";
        this.floorNo = "";
        this.childType = 0;
        this.endPoiExtension = 0;
        this.topTime = 0L;
        this.dateTime = new DateTime();
        this.uTimeList = new ArrayList<>();
    }

    public OftenArrivedItem(String str, String str2, String str3, String str4, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, String str5, String str6, String str7, int i, int i2, long j, DateTime dateTime, ArrayList<Long> arrayList) {
        this.wstrPoiID = str;
        this.wstrPoiName = str2;
        this.wstrPoiType = str3;
        this.wstrAddress = str4;
        this.stDisplayCoord = coord2DDouble;
        this.stNaviCoord = coord2DDouble2;
        this.parent = str5;
        this.towardsAngle = str6;
        this.floorNo = str7;
        this.childType = i;
        this.endPoiExtension = i2;
        this.topTime = j;
        this.dateTime = dateTime;
        this.uTimeList = arrayList;
    }
}
