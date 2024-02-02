package com.autonavi.gbl.data.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LNDSInitConfig implements Serializable {
    public boolean loadOnlineData;
    public long nThresholdValue;
    public long nTileNumValue;
    public String strOffStoredPath;
    public String strOnlineStoredPath;
    public String strProject;

    public LNDSInitConfig() {
        this.strOffStoredPath = "";
        this.nThresholdValue = 83886080L;
        this.strOnlineStoredPath = "";
        this.nTileNumValue = 1000L;
        this.loadOnlineData = true;
        this.strProject = "";
    }

    public LNDSInitConfig(String str, long j, String str2, long j2, boolean z, String str3) {
        this.strOffStoredPath = str;
        this.nThresholdValue = j;
        this.strOnlineStoredPath = str2;
        this.nTileNumValue = j2;
        this.loadOnlineData = z;
        this.strProject = str3;
    }
}
