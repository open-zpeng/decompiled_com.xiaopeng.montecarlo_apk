package com.autonavi.gbl.route.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ConsisPathIdentity implements Serializable {
    public boolean isOnline;
    public String offlineIdentityId;
    public long pathId;
    public String planChannelId;

    public ConsisPathIdentity() {
        this.isOnline = false;
        this.pathId = 0L;
        this.planChannelId = "";
        this.offlineIdentityId = "";
    }

    public ConsisPathIdentity(boolean z, long j, String str, String str2) {
        this.isOnline = z;
        this.pathId = j;
        this.planChannelId = str;
        this.offlineIdentityId = str2;
    }
}
