package com.autonavi.gbl.user.usertrack.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class HistoryRecvPoiItem implements Serializable {
    public String address;
    public int childType;
    public int endPoiExtension;
    public String floorNo;
    public String itemId;
    public String name;
    public Coord2DDouble navLoc;
    public String parent;
    public String poiId;
    public Coord2DDouble poiLoc;
    public String towardsAngle;
    public String typeCode;
    public long updateTime;

    public HistoryRecvPoiItem() {
        this.itemId = "";
        this.poiId = "";
        this.typeCode = "";
        this.name = "";
        this.address = "";
        this.poiLoc = new Coord2DDouble();
        this.navLoc = new Coord2DDouble();
        this.parent = "";
        this.childType = 0;
        this.towardsAngle = "";
        this.floorNo = "";
        this.endPoiExtension = 0;
        this.updateTime = 0L;
    }

    public HistoryRecvPoiItem(String str, String str2, String str3, String str4, String str5, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, String str6, int i, String str7, String str8, int i2, long j) {
        this.itemId = str;
        this.poiId = str2;
        this.typeCode = str3;
        this.name = str4;
        this.address = str5;
        this.poiLoc = coord2DDouble;
        this.navLoc = coord2DDouble2;
        this.parent = str6;
        this.childType = i;
        this.towardsAngle = str7;
        this.floorNo = str8;
        this.endPoiExtension = i2;
        this.updateTime = j;
    }
}
