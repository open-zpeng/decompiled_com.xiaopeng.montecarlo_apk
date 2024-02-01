package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class BLKeyValue implements Serializable {
    public String m_strKey;
    public String m_strValue;

    public BLKeyValue() {
        this.m_strKey = "";
        this.m_strValue = "";
    }

    public BLKeyValue(String str, String str2) {
        this.m_strKey = str;
        this.m_strValue = str2;
    }
}
