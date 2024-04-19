package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class DeepAirport implements Serializable {
    public DeepAirportRti dynInfo;

    public DeepAirport() {
        this.dynInfo = new DeepAirportRti();
    }

    public DeepAirport(DeepAirportRti deepAirportRti) {
        this.dynInfo = deepAirportRti;
    }
}
