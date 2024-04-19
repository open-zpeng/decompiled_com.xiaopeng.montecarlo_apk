package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DeepAirportRti implements Serializable {
    public ArrayList<DeepAirportTerminalInfo> terminalInfo;

    public DeepAirportRti() {
        this.terminalInfo = new ArrayList<>();
    }

    public DeepAirportRti(ArrayList<DeepAirportTerminalInfo> arrayList) {
        this.terminalInfo = arrayList;
    }
}
