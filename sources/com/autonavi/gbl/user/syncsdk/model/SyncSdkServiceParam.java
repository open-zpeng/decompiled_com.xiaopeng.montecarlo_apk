package com.autonavi.gbl.user.syncsdk.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SyncSdkServiceParam implements Serializable {
    public String dataPath;

    public SyncSdkServiceParam() {
        this.dataPath = "";
    }

    public SyncSdkServiceParam(String str) {
        this.dataPath = str;
    }
}
