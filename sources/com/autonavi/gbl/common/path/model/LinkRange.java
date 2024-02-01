package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LinkRange implements Serializable {
    public int m_endLnkIdx;
    public int m_endSegIdx;
    public int m_startLnkIdx;
    public int m_startSegIdx;

    public LinkRange() {
        this.m_startSegIdx = -1;
        this.m_startLnkIdx = -1;
        this.m_endSegIdx = -1;
        this.m_endLnkIdx = -1;
    }

    public LinkRange(int i, int i2, int i3, int i4) {
        this.m_startSegIdx = i;
        this.m_startLnkIdx = i2;
        this.m_endSegIdx = i3;
        this.m_endLnkIdx = i4;
    }
}
