package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DetailBaseInfo implements Serializable {
    public int adcode;
    public String address;
    public int citycode;
    public String cityname;
    public int distance;
    public String districtname;
    public ArrayList<Coord2DDouble> enter;
    public ArrayList<Coord2DDouble> exit;
    public String id;
    public String name;
    public Coord2DDouble point;
    public int provincecode;
    public String provincename;
    public String tel;
    public String type;
    public String typecode;

    public DetailBaseInfo() {
        this.id = "";
        this.point = new Coord2DDouble();
        this.tel = "";
        this.name = "";
        this.address = "";
        this.citycode = 0;
        this.type = "";
        this.typecode = "";
        this.provincename = "";
        this.cityname = "";
        this.districtname = "";
        this.provincecode = 0;
        this.adcode = 0;
        this.distance = 0;
        this.enter = new ArrayList<>();
        this.exit = new ArrayList<>();
    }

    public DetailBaseInfo(String str, Coord2DDouble coord2DDouble, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, String str9, int i2, int i3, int i4, ArrayList<Coord2DDouble> arrayList, ArrayList<Coord2DDouble> arrayList2) {
        this.id = str;
        this.point = coord2DDouble;
        this.tel = str2;
        this.name = str3;
        this.address = str4;
        this.citycode = i;
        this.type = str5;
        this.typecode = str6;
        this.provincename = str7;
        this.cityname = str8;
        this.districtname = str9;
        this.provincecode = i2;
        this.adcode = i3;
        this.distance = i4;
        this.enter = arrayList;
        this.exit = arrayList2;
    }
}
