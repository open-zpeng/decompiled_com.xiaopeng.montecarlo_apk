package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GReStrictedAreaDataCityAllRuleRes implements Serializable {
    public int platecity;
    public int rulecity;
    public ArrayList<GRestrictCity> typelist;

    public GReStrictedAreaDataCityAllRuleRes() {
        this.platecity = 0;
        this.rulecity = 0;
        this.typelist = new ArrayList<>();
    }

    public GReStrictedAreaDataCityAllRuleRes(int i, int i2, ArrayList<GRestrictCity> arrayList) {
        this.platecity = i;
        this.rulecity = i2;
        this.typelist = arrayList;
    }
}
