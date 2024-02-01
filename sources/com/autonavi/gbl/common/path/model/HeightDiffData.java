package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class HeightDiffData implements Serializable {
    public int distToLinkStart;
    public int heightDiffDist;
    public byte heightDiffParellel;
    public byte heightDiffStraight;

    public HeightDiffData() {
        this.distToLinkStart = 0;
        this.heightDiffDist = 0;
        this.heightDiffStraight = (byte) 0;
        this.heightDiffParellel = (byte) 0;
    }

    public HeightDiffData(int i, int i2, byte b, byte b2) {
        this.distToLinkStart = i;
        this.heightDiffDist = i2;
        this.heightDiffStraight = b;
        this.heightDiffParellel = b2;
    }
}
