package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPoiHospitalTel implements Serializable {
    public ArrayList<SearchPoiTelephone> emergency;
    public ArrayList<SearchPoiTelephone> outpatient;
    public ArrayList<SearchPoiTelephone> registration;
    public ArrayList<SearchPoiTelephone> switchboard;

    public SearchPoiHospitalTel() {
        this.switchboard = new ArrayList<>();
        this.emergency = new ArrayList<>();
        this.outpatient = new ArrayList<>();
        this.registration = new ArrayList<>();
    }

    public SearchPoiHospitalTel(ArrayList<SearchPoiTelephone> arrayList, ArrayList<SearchPoiTelephone> arrayList2, ArrayList<SearchPoiTelephone> arrayList3, ArrayList<SearchPoiTelephone> arrayList4) {
        this.switchboard = arrayList;
        this.emergency = arrayList2;
        this.outpatient = arrayList3;
        this.registration = arrayList4;
    }
}
