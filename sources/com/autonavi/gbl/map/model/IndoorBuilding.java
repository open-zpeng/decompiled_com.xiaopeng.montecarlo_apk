package com.autonavi.gbl.map.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class IndoorBuilding implements Serializable {
    public int activeFloorIndex;
    public String buildingTypes;
    public float buildingZoom;
    public String cnName;
    public String enName;
    public ArrayList<IndoorBuildingFloor> floors;
    public Coord2DDouble leftTop;
    public Coord2DDouble parkPosition;
    public String poiid;
    public Coord2DDouble rightBottom;
    public int visiableFloorIndex;

    public IndoorBuilding() {
        this.poiid = "";
        this.buildingTypes = "";
        this.enName = "";
        this.cnName = "";
        this.activeFloorIndex = 0;
        this.visiableFloorIndex = 0;
        this.buildingZoom = 0.0f;
        this.floors = new ArrayList<>();
        this.parkPosition = new Coord2DDouble();
        this.leftTop = new Coord2DDouble();
        this.rightBottom = new Coord2DDouble();
    }

    public IndoorBuilding(String str, String str2, String str3, String str4, int i, int i2, float f, ArrayList<IndoorBuildingFloor> arrayList, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, Coord2DDouble coord2DDouble3) {
        this.poiid = str;
        this.buildingTypes = str2;
        this.enName = str3;
        this.cnName = str4;
        this.activeFloorIndex = i;
        this.visiableFloorIndex = i2;
        this.buildingZoom = f;
        this.floors = arrayList;
        this.parkPosition = coord2DDouble;
        this.leftTop = coord2DDouble2;
        this.rightBottom = coord2DDouble3;
    }
}
