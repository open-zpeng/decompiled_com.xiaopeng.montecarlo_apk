package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GTrafficRestrictItem implements Serializable {
    public int m_cityFlag;
    public String m_info;
    public String m_plateNo;
    public int m_restrictFlag;

    public GTrafficRestrictItem() {
        this.m_plateNo = "";
        this.m_info = "";
        this.m_cityFlag = 0;
        this.m_restrictFlag = 0;
    }

    public GTrafficRestrictItem(String str, String str2, int i, int i2) {
        this.m_plateNo = str;
        this.m_info = str2;
        this.m_cityFlag = i;
        this.m_restrictFlag = i2;
    }
}
