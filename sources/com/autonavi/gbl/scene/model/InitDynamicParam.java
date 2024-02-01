package com.autonavi.gbl.scene.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class InitDynamicParam implements Serializable {
    public String cachePath;
    public ArrayList<CmbInfo> cmbInfoList;
    public ArrayList<FontInfo> fontInfoList;
    public String layerAssetPath;
    public String pathDSL;
    public String screenConfigPath;

    public InitDynamicParam() {
        this.pathDSL = "";
        this.screenConfigPath = "";
        this.layerAssetPath = "";
        this.cachePath = "";
        this.fontInfoList = new ArrayList<>();
        this.cmbInfoList = new ArrayList<>();
    }

    public InitDynamicParam(String str, String str2, String str3, String str4, ArrayList<FontInfo> arrayList, ArrayList<CmbInfo> arrayList2) {
        this.pathDSL = str;
        this.screenConfigPath = str2;
        this.layerAssetPath = str3;
        this.cachePath = str4;
        this.fontInfoList = arrayList;
        this.cmbInfoList = arrayList2;
    }
}
