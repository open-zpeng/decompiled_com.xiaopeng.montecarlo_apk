package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PathDescriptionInfo implements Serializable {
    public short flag1;
    public short flag2;
    public short path_type;

    public PathDescriptionInfo() {
        this.path_type = (short) 0;
        this.flag1 = (short) 0;
        this.flag2 = (short) 0;
    }

    public PathDescriptionInfo(short s, short s2, short s3) {
        this.path_type = s;
        this.flag1 = s2;
        this.flag2 = s3;
    }
}
