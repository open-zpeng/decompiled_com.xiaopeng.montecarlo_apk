package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GReStrictedAreaDataRuleRes implements Serializable {
    public ArrayList<GRestrictCity> cities;
    public int citynums;

    public GReStrictedAreaDataRuleRes() {
        this.citynums = 0;
        this.cities = new ArrayList<>();
    }

    public GReStrictedAreaDataRuleRes(int i, ArrayList<GRestrictCity> arrayList) {
        this.citynums = i;
        this.cities = arrayList;
    }
}
