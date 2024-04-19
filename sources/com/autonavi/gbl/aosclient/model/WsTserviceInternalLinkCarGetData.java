package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTserviceInternalLinkCarGetData implements Serializable {
    public int linkStatus;
    public int userid;

    public WsTserviceInternalLinkCarGetData() {
        this.linkStatus = 0;
        this.userid = 0;
    }

    public WsTserviceInternalLinkCarGetData(int i, int i2) {
        this.linkStatus = i;
        this.userid = i2;
    }
}
