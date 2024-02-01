package com.autonavi.gbl.user.group.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GroupAnnouncement implements Serializable {
    public String content;
    public long editTime;

    public GroupAnnouncement() {
        this.editTime = 0L;
        this.content = "";
    }

    public GroupAnnouncement(long j, String str) {
        this.editTime = j;
        this.content = str;
    }
}
