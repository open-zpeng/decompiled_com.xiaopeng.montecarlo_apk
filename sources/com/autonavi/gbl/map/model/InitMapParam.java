package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class InitMapParam implements Serializable {
    public String assetPath;
    public String basePath;
    public float buildingHeight;
    public byte[] configBuffer;
    public String dataPath;
    public MapFontLoaderParam fontParam;
    public String fontPath;
    public String hardwareJsonParam;
    public String indoorPath;
    public String offlineDataButtonId;
    public SystemParam systemParam;

    public InitMapParam() {
        this.dataPath = "";
        this.fontPath = "";
        this.basePath = "";
        this.indoorPath = "";
        this.assetPath = "";
        this.offlineDataButtonId = "";
        this.buildingHeight = -1.0f;
        this.systemParam = new SystemParam();
        this.hardwareJsonParam = "";
        this.fontParam = new MapFontLoaderParam();
        this.configBuffer = null;
    }

    public InitMapParam(String str, String str2, String str3, String str4, String str5, String str6, float f, byte[] bArr, SystemParam systemParam, String str7, MapFontLoaderParam mapFontLoaderParam) {
        this.dataPath = str;
        this.fontPath = str2;
        this.basePath = str3;
        this.indoorPath = str4;
        this.assetPath = str5;
        this.offlineDataButtonId = str6;
        this.buildingHeight = f;
        this.configBuffer = bArr;
        this.systemParam = systemParam;
        this.hardwareJsonParam = str7;
        this.fontParam = mapFontLoaderParam;
    }
}
