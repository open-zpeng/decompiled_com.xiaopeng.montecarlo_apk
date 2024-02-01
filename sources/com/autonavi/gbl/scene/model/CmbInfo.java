package com.autonavi.gbl.scene.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class CmbInfo implements Serializable {
    public long cacheSize;
    public boolean isMergeRes;
    public String strPkgName;
    public long type;
    public ArrayList<String> vecResPath;

    public CmbInfo() {
        this.vecResPath = new ArrayList<>();
        this.strPkgName = "";
        this.isMergeRes = true;
        this.cacheSize = 0L;
        this.type = 0L;
    }

    public CmbInfo(ArrayList<String> arrayList, String str, boolean z, long j, long j2) {
        this.vecResPath = arrayList;
        this.strPkgName = str;
        this.isMergeRes = z;
        this.cacheSize = j;
        this.type = j2;
    }
}
