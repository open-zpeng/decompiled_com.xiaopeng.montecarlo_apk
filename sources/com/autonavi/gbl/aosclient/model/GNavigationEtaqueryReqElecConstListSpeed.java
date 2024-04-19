package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GNavigationEtaqueryReqElecConstListSpeed implements Serializable {
    public ArrayList<GNavigationEtaqueryReqElecConstListRangeEnergy> cost;

    public GNavigationEtaqueryReqElecConstListSpeed() {
        this.cost = new ArrayList<>();
    }

    public GNavigationEtaqueryReqElecConstListSpeed(ArrayList<GNavigationEtaqueryReqElecConstListRangeEnergy> arrayList) {
        this.cost = arrayList;
    }
}
