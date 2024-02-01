package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsSdsFilesData implements Serializable {
    public ArrayList<WsSdsFilesContentItem> content;
    public String domain;
    public String lastVer;

    public WsSdsFilesData() {
        this.domain = "";
        this.lastVer = "";
        this.content = new ArrayList<>();
    }

    public WsSdsFilesData(String str, String str2, ArrayList<WsSdsFilesContentItem> arrayList) {
        this.domain = str;
        this.lastVer = str2;
        this.content = arrayList;
    }
}
