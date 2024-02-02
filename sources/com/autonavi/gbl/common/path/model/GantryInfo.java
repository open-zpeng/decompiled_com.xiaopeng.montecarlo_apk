package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GantryInfo implements Serializable {
    public long m_DistToEnd;
    public short m_Flag;
    public String m_Name;
    public String m_Num;
    public short m_Type;

    public GantryInfo() {
        this.m_Flag = (short) 0;
        this.m_Type = (short) 0;
        this.m_DistToEnd = 0L;
        this.m_Num = "";
        this.m_Name = "";
    }

    public GantryInfo(short s, short s2, long j, String str, String str2) {
        this.m_Flag = s;
        this.m_Type = s2;
        this.m_DistToEnd = j;
        this.m_Num = str;
        this.m_Name = str2;
    }
}
