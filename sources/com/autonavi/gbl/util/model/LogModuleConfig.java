package com.autonavi.gbl.util.model;

import com.autonavi.gbl.util.model.EGcoLogLevel;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LogModuleConfig implements Serializable {
    @EGcoLogLevel.EGcoLogLevel1
    public int level;
    public boolean onoff;

    public LogModuleConfig() {
        this.level = 3;
        this.onoff = true;
    }

    public LogModuleConfig(@EGcoLogLevel.EGcoLogLevel1 int i, boolean z) {
        this.level = i;
        this.onoff = z;
    }
}
