package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNtg6SdsFilesData implements Serializable {
    public ArrayList<WsNtg6SdsFilesContentItem> content;
    public String domain;
    public String lastVer;

    public WsNtg6SdsFilesData() {
        this.domain = "";
        this.lastVer = "";
        this.content = new ArrayList<>();
    }

    public WsNtg6SdsFilesData(String str, String str2, ArrayList<WsNtg6SdsFilesContentItem> arrayList) {
        this.domain = str;
        this.lastVer = str2;
        this.content = arrayList;
    }
}
