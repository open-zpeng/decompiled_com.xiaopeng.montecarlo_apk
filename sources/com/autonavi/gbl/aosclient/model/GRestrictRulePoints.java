package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GRestrictRulePoints implements Serializable {
    public ArrayList<GCoord3DDouble> lstPoints;

    public GRestrictRulePoints() {
        this.lstPoints = new ArrayList<>();
    }

    public GRestrictRulePoints(ArrayList<GCoord3DDouble> arrayList) {
        this.lstPoints = arrayList;
    }
}
