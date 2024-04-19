package com.autonavi.gbl.data.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LNDSInitConfig implements Serializable {
    public boolean loadOnlineData;
    public long nThresholdValue;
    public long nTileNumValue;
    public String strConfigPath;
    public String strOffStoredPath;
    public String strOnlineStoredPath;
    public String strProject;

    public LNDSInitConfig() {
        this.strConfigPath = "";
        this.strOffStoredPath = "";
        this.nThresholdValue = 80L;
        this.strOnlineStoredPath = "";
        this.nTileNumValue = 1000L;
        this.loadOnlineData = true;
        this.strProject = "";
    }

    public LNDSInitConfig(String str, String str2, long j, String str3, long j2, boolean z, String str4) {
        this.strConfigPath = str;
        this.strOffStoredPath = str2;
        this.nThresholdValue = j;
        this.strOnlineStoredPath = str3;
        this.nTileNumValue = j2;
        this.loadOnlineData = z;
        this.strProject = str4;
    }
}
