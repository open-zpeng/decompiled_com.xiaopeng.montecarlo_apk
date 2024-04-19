package com.autonavi.gbl.card.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CmbLoaderInitParam implements Serializable {
    public int cacheSize;
    public boolean isMergeRes;
    public String strPkgName;
    public ArrayList<String> vecResPath;

    public CmbLoaderInitParam() {
        this.vecResPath = new ArrayList<>();
        this.strPkgName = "";
        this.isMergeRes = true;
        this.cacheSize = 0;
    }

    public CmbLoaderInitParam(ArrayList<String> arrayList, String str, boolean z, int i) {
        this.vecResPath = arrayList;
        this.strPkgName = str;
        this.isMergeRes = z;
        this.cacheSize = i;
    }
}
