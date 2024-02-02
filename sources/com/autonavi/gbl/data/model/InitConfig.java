package com.autonavi.gbl.data.model;

import com.autonavi.gbl.data.model.MapDataMode;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class InitConfig implements Serializable {
    public ArrayList<DataInitParam> extendedParamList;
    @MapDataMode.MapDataMode1
    public int mapDataMode;
    public int nMaxConcurrentCount;
    public int nThresholdValue;
    public String strConfigfilePath;
    public String strDownloadPath;
    public String strPiviFlag;
    public String strPiviVersion;
    public String strStoredPath;

    public InitConfig() {
        this.strStoredPath = "";
        this.strDownloadPath = "";
        this.strConfigfilePath = "";
        this.strPiviFlag = "";
        this.strPiviVersion = "";
        this.nMaxConcurrentCount = 1;
        this.nThresholdValue = 80;
        this.mapDataMode = 0;
        this.extendedParamList = new ArrayList<>();
    }

    public InitConfig(String str, String str2, String str3, String str4, String str5, int i, int i2, @MapDataMode.MapDataMode1 int i3, ArrayList<DataInitParam> arrayList) {
        this.strStoredPath = str;
        this.strDownloadPath = str2;
        this.strConfigfilePath = str3;
        this.strPiviFlag = str4;
        this.strPiviVersion = str5;
        this.nMaxConcurrentCount = i;
        this.nThresholdValue = i2;
        this.mapDataMode = i3;
        this.extendedParamList = arrayList;
    }
}
