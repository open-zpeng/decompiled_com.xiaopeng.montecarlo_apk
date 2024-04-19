package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class EventSyncCommonRequestPush implements Serializable {
    public EventSyncCommonPushDetail detail;
    public String div;
    public String endTime;
    public String id;
    public String tag;
    public long timestamp;
    public String type;
    public String uid;
    public String uidType;

    public EventSyncCommonRequestPush() {
        this.type = "";
        this.tag = "";
        this.uid = "";
        this.uidType = "";
        this.div = "";
        this.id = "";
        this.timestamp = 0L;
        this.endTime = "";
        this.detail = new EventSyncCommonPushDetail();
    }

    public EventSyncCommonRequestPush(String str, String str2, String str3, String str4, String str5, String str6, long j, String str7, EventSyncCommonPushDetail eventSyncCommonPushDetail) {
        this.type = str;
        this.tag = str2;
        this.uid = str3;
        this.uidType = str4;
        this.div = str5;
        this.id = str6;
        this.timestamp = j;
        this.endTime = str7;
        this.detail = eventSyncCommonPushDetail;
    }
}
