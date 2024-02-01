package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class BLAosCookie implements Serializable {
    public String mAosHostName;
    public String mCookie;

    public BLAosCookie() {
        this.mAosHostName = "";
        this.mCookie = "";
    }

    public BLAosCookie(String str, String str2) {
        this.mAosHostName = str;
        this.mCookie = str2;
    }
}
