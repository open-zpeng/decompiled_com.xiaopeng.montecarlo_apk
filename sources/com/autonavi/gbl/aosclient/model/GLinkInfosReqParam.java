package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GLinkInfosReqParam implements Serializable {
    public int eta;
    public int length;
    public long roadId;

    public GLinkInfosReqParam() {
        this.roadId = 0L;
        this.length = 0;
        this.eta = 0;
    }

    public GLinkInfosReqParam(long j, int i, int i2) {
        this.roadId = j;
        this.length = i;
        this.eta = i2;
    }
}
