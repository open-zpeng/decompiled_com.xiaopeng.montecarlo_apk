package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class OddSegInfo implements Serializable {
    public long m_EndLinkIdx;
    public float m_EndOffSet;
    public long m_EndSegIdx;
    public long m_OddLen;
    public long m_StartLinkIdx;
    public float m_StartOffSet;
    public long m_StartSegIdx;

    public OddSegInfo() {
        this.m_OddLen = 0L;
        this.m_StartSegIdx = 0L;
        this.m_StartLinkIdx = 0L;
        this.m_StartOffSet = 0.0f;
        this.m_EndSegIdx = 0L;
        this.m_EndLinkIdx = 0L;
        this.m_EndOffSet = 0.0f;
    }

    public OddSegInfo(long j, long j2, long j3, float f, long j4, long j5, float f2) {
        this.m_OddLen = j;
        this.m_StartSegIdx = j2;
        this.m_StartLinkIdx = j3;
        this.m_StartOffSet = f;
        this.m_EndSegIdx = j4;
        this.m_EndLinkIdx = j5;
        this.m_EndOffSet = f2;
    }
}
