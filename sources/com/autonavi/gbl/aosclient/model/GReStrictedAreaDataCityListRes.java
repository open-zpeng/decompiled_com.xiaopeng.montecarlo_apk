package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GReStrictedAreaDataCityListRes implements Serializable {
    public ArrayList<GReStrictedAreaCarlistRes> carlist;
    public ArrayList<GReStrictedAreaTrucklistRes> trucklist;

    public GReStrictedAreaDataCityListRes() {
        this.trucklist = new ArrayList<>();
        this.carlist = new ArrayList<>();
    }

    public GReStrictedAreaDataCityListRes(ArrayList<GReStrictedAreaTrucklistRes> arrayList, ArrayList<GReStrictedAreaCarlistRes> arrayList2) {
        this.trucklist = arrayList;
        this.carlist = arrayList2;
    }
}
