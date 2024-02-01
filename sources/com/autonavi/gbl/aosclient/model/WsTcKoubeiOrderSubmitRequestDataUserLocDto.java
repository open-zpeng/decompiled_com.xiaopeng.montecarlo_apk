package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcKoubeiOrderSubmitRequestDataUserLocDto implements Serializable {
    public double latitude;
    public double longitude;

    public WsTcKoubeiOrderSubmitRequestDataUserLocDto() {
        this.latitude = -999.0d;
        this.longitude = -999.0d;
    }

    public WsTcKoubeiOrderSubmitRequestDataUserLocDto(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }
}
