package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MobileRoutePointType implements Serializable {
    public int endType;
    public int startType;
    public int viaType;

    public MobileRoutePointType() {
        this.startType = 0;
        this.viaType = 0;
        this.endType = 0;
    }

    public MobileRoutePointType(int i, int i2, int i3) {
        this.startType = i;
        this.viaType = i2;
        this.endType = i3;
    }
}
