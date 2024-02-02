package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RealCityTmcParam implements Serializable {
    public long tmcColor;
    public long tmcSideColor;
    public byte tmcStatus;

    public RealCityTmcParam() {
        this.tmcStatus = (byte) 0;
        this.tmcColor = 0L;
        this.tmcSideColor = 0L;
    }

    public RealCityTmcParam(byte b, long j, long j2) {
        this.tmcStatus = b;
        this.tmcColor = j;
        this.tmcSideColor = j2;
    }
}
