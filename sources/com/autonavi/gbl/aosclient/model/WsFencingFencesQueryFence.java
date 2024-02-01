package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsFencingFencesQueryFence implements Serializable {
    public String adcode;
    public ArrayList<Double> centerCoordinate;
    public WsFencingFencesQueryContent content;
    public int enable;
    public String fid;
    public ArrayList<String> gids;
    public String name;
    public WsFencingFencesQueryStatus status;
    public String type;
    public long updateTime;

    public WsFencingFencesQueryFence() {
        this.fid = "";
        this.name = "";
        this.gids = new ArrayList<>();
        this.enable = 0;
        this.updateTime = 0L;
        this.status = new WsFencingFencesQueryStatus();
        this.type = "";
        this.content = new WsFencingFencesQueryContent();
        this.adcode = "";
        this.centerCoordinate = new ArrayList<>();
    }

    public WsFencingFencesQueryFence(String str, String str2, ArrayList<String> arrayList, int i, long j, WsFencingFencesQueryStatus wsFencingFencesQueryStatus, String str3, WsFencingFencesQueryContent wsFencingFencesQueryContent, String str4, ArrayList<Double> arrayList2) {
        this.fid = str;
        this.name = str2;
        this.gids = arrayList;
        this.enable = i;
        this.updateTime = j;
        this.status = wsFencingFencesQueryStatus;
        this.type = str3;
        this.content = wsFencingFencesQueryContent;
        this.adcode = str4;
        this.centerCoordinate = arrayList2;
    }
}
