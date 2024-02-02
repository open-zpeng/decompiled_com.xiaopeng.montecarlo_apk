package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamResponseAnnouncement implements Serializable {
    public String content;
    public long ts;

    public GWsTserviceTeamResponseAnnouncement() {
        this.content = "";
        this.ts = 0L;
    }

    public GWsTserviceTeamResponseAnnouncement(String str, long j) {
        this.content = str;
        this.ts = j;
    }
}
