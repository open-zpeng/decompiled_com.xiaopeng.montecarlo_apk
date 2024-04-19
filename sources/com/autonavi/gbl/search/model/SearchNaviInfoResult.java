package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchNaviInfoResult implements Serializable {
    public int code;
    public String message;
    public ArrayList<SearchNaviInfoItem> naviInfoItem;
    public String result;
    public String timestamp;
    public String version;

    public SearchNaviInfoResult() {
        this.code = -1;
        this.message = "";
        this.result = "";
        this.version = "";
        this.timestamp = "";
        this.naviInfoItem = new ArrayList<>();
    }

    public SearchNaviInfoResult(int i, String str, String str2, String str3, String str4, ArrayList<SearchNaviInfoItem> arrayList) {
        this.code = i;
        this.message = str;
        this.result = str2;
        this.version = str3;
        this.timestamp = str4;
        this.naviInfoItem = arrayList;
    }
}
