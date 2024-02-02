package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocLogType;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocLogConf implements Serializable {
    public int fileLimit;
    public boolean isEncryption;
    public boolean isRedirectALC;
    public int logLevel;
    @LocLogType.LocLogType1
    public int logType;
    public int spaceLimit;

    public LocLogConf() {
        this.fileLimit = 60;
        this.spaceLimit = RouteChargeDecorator.TYPE_SELECTED_KEEPER;
        this.logLevel = 1;
        this.isEncryption = false;
        this.logType = 1;
        this.isRedirectALC = false;
    }

    public LocLogConf(int i, int i2, int i3, boolean z, @LocLogType.LocLogType1 int i4, boolean z2) {
        this.fileLimit = i;
        this.spaceLimit = i2;
        this.logLevel = i3;
        this.isEncryption = z;
        this.logType = i4;
        this.isRedirectALC = z2;
    }
}
