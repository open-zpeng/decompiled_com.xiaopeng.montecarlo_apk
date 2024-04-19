package com.autonavi.gbl.common.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChargerPlugsInfo implements Serializable {
    public ArrayList<ChargerPlug> suggestedPlugs;
    public ArrayList<ChargerPlug> supportedPlugs;

    public ChargerPlugsInfo() {
        this.suggestedPlugs = new ArrayList<>();
        this.supportedPlugs = new ArrayList<>();
    }

    public ChargerPlugsInfo(ArrayList<ChargerPlug> arrayList, ArrayList<ChargerPlug> arrayList2) {
        this.suggestedPlugs = arrayList;
        this.supportedPlugs = arrayList2;
    }
}
