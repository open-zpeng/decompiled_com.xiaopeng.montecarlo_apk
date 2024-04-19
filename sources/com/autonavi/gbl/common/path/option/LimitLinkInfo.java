package com.autonavi.gbl.common.path.option;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LimitLinkInfo implements Serializable {
    public int endLink;
    public int endSeg;
    public int startLink;
    public int startSeg;

    public LimitLinkInfo() {
        this.startSeg = -1;
        this.startLink = -1;
        this.endSeg = -1;
        this.endLink = -1;
    }

    public LimitLinkInfo(int i, int i2, int i3, int i4) {
        this.startSeg = i;
        this.startLink = i2;
        this.endSeg = i3;
        this.endLink = i4;
    }
}
