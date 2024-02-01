package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class JamSegment implements Serializable {
    public int endLinkIndex;
    public int endSegIndex;
    public long jamETA;
    public long jamLen;
    public int startLinkIndex;
    public int startSegIndex;

    public JamSegment() {
        this.startSegIndex = 0;
        this.startLinkIndex = 0;
        this.endSegIndex = 0;
        this.endLinkIndex = 0;
        this.jamLen = 0L;
        this.jamETA = 0L;
    }

    public JamSegment(int i, int i2, int i3, int i4, long j, long j2) {
        this.startSegIndex = i;
        this.startLinkIndex = i2;
        this.endSegIndex = i3;
        this.endLinkIndex = i4;
        this.jamLen = j;
        this.jamETA = j2;
    }
}
