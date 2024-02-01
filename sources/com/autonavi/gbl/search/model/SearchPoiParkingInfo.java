package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPoiParkingInfo implements Serializable {
    public String category;
    public String charge;
    public String dayCharge;
    public String fee;
    public String geometry;
    public ArrayList<SearchParkInOutInfo> inoutInfoList;
    public String nightCharge;
    public String parkingSrcType;
    public ArrayList<Integer> payTypeList;
    public ArrayList<Coord2DDouble> pointList;
    public int space;
    public int spaceFree;

    public SearchPoiParkingInfo() {
        this.space = -1;
        this.spaceFree = -1;
        this.fee = "";
        this.geometry = "";
        this.charge = "";
        this.dayCharge = "";
        this.nightCharge = "";
        this.category = "";
        this.parkingSrcType = "";
        this.pointList = new ArrayList<>();
        this.inoutInfoList = new ArrayList<>();
        this.payTypeList = new ArrayList<>();
    }

    public SearchPoiParkingInfo(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, ArrayList<Coord2DDouble> arrayList, ArrayList<SearchParkInOutInfo> arrayList2, ArrayList<Integer> arrayList3) {
        this.space = i;
        this.spaceFree = i2;
        this.fee = str;
        this.geometry = str2;
        this.charge = str3;
        this.dayCharge = str4;
        this.nightCharge = str5;
        this.category = str6;
        this.parkingSrcType = str7;
        this.pointList = arrayList;
        this.inoutInfoList = arrayList2;
        this.payTypeList = arrayList3;
    }
}
