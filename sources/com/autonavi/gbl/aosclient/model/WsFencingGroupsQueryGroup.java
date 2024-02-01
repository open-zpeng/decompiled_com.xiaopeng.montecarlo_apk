package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsFencingGroupsQueryGroup implements Serializable {
    public String actions;
    public String condition;
    public WsFencingGroupsQueryDetect detect;
    public String gid;
    public String name;
    public WsFencingGroupsQueryStatus status;
    public long updateTime;
    public ArrayList<WsFencingGroupsQueryValidatyPeriod> validatyPeriods;

    public WsFencingGroupsQueryGroup() {
        this.gid = "";
        this.name = "";
        this.updateTime = 0L;
        this.status = new WsFencingGroupsQueryStatus();
        this.detect = new WsFencingGroupsQueryDetect();
        this.validatyPeriods = new ArrayList<>();
        this.condition = "";
        this.actions = "";
    }

    public WsFencingGroupsQueryGroup(String str, String str2, long j, WsFencingGroupsQueryStatus wsFencingGroupsQueryStatus, WsFencingGroupsQueryDetect wsFencingGroupsQueryDetect, ArrayList<WsFencingGroupsQueryValidatyPeriod> arrayList, String str3, String str4) {
        this.gid = str;
        this.name = str2;
        this.updateTime = j;
        this.status = wsFencingGroupsQueryStatus;
        this.detect = wsFencingGroupsQueryDetect;
        this.validatyPeriods = arrayList;
        this.condition = str3;
        this.actions = str4;
    }
}
