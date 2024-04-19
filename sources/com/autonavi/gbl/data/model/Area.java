package com.autonavi.gbl.data.model;

import com.autonavi.gbl.data.model.AreaType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Area implements Serializable {
    public int adcode;
    @AreaType.AreaType1
    public int areaType;
    public String jianPin;
    public String name;
    public String pinYin;
    public int upperAdcode;
    public ArrayList<Integer> vecLowerAdcodeList;
    public ArrayList<Integer> vecNearAdcodeList;

    public Area() {
        this.adcode = 0;
        this.areaType = 0;
        this.name = "";
        this.jianPin = "";
        this.pinYin = "";
        this.upperAdcode = 0;
        this.vecNearAdcodeList = new ArrayList<>();
        this.vecLowerAdcodeList = new ArrayList<>();
    }

    public Area(int i, @AreaType.AreaType1 int i2, String str, String str2, String str3, int i3, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        this.adcode = i;
        this.areaType = i2;
        this.name = str;
        this.jianPin = str2;
        this.pinYin = str3;
        this.upperAdcode = i3;
        this.vecNearAdcodeList = arrayList;
        this.vecLowerAdcodeList = arrayList2;
    }
}
