package com.autonavi.gbl.util.model;

import com.autonavi.gbl.util.model.EGcoLogLevel;
import com.autonavi.gbl.util.model.LogModuleType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class RuntimeInfo implements Serializable {
    public String info;
    @EGcoLogLevel.EGcoLogLevel1
    public int level;
    @LogModuleType.LogModuleType1
    public int modType;
    public String subTag;

    public RuntimeInfo() {
        this.modType = -1;
        this.level = 0;
        this.subTag = "";
        this.info = "";
    }

    public RuntimeInfo(@LogModuleType.LogModuleType1 int i, @EGcoLogLevel.EGcoLogLevel1 int i2, String str, String str2) {
        this.modType = i;
        this.level = i2;
        this.subTag = str;
        this.info = str2;
    }
}
