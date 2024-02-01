package com.autonavi.gbl.user.usertrack.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class HistoryRoutePoiItem implements Serializable {
    public String address;
    public int childType;
    public int cityCode;
    public String cityName;
    public int endPoiExtension;
    public ArrayList<Coord2DDouble> entranceList;
    public String floorNo;
    public String name;
    public String parent;
    public String poiId;
    public Coord2DDouble poiLoc;
    public String towardsAngle;
    public String typeCode;

    public HistoryRoutePoiItem() {
        this.poiId = "";
        this.typeCode = "";
        this.address = "";
        this.name = "";
        this.cityName = "";
        this.cityCode = 0;
        this.poiLoc = new Coord2DDouble();
        this.entranceList = new ArrayList<>();
        this.parent = "";
        this.childType = 0;
        this.towardsAngle = "";
        this.floorNo = "";
        this.endPoiExtension = 0;
    }

    public HistoryRoutePoiItem(String str, String str2, String str3, String str4, String str5, int i, Coord2DDouble coord2DDouble, ArrayList<Coord2DDouble> arrayList, String str6, int i2, String str7, String str8, int i3) {
        this.poiId = str;
        this.typeCode = str2;
        this.address = str3;
        this.name = str4;
        this.cityName = str5;
        this.cityCode = i;
        this.poiLoc = coord2DDouble;
        this.entranceList = arrayList;
        this.parent = str6;
        this.childType = i2;
        this.towardsAngle = str7;
        this.floorNo = str8;
        this.endPoiExtension = i3;
    }
}
