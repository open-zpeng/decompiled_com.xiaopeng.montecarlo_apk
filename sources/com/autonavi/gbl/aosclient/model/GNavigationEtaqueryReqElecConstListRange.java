package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GNavigationEtaqueryReqElecConstListRange implements Serializable {
    public ArrayList<GNavigationEtaqueryReqElecConstListRangeEnergy> energy;

    public GNavigationEtaqueryReqElecConstListRange() {
        this.energy = new ArrayList<>();
    }

    public GNavigationEtaqueryReqElecConstListRange(ArrayList<GNavigationEtaqueryReqElecConstListRangeEnergy> arrayList) {
        this.energy = arrayList;
    }
}
