package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class SkinListItem implements Serializable {
    public long end_time;
    public String icon;
    public int id;
    public String name;
    public long start_time;
    public int state_id;

    public SkinListItem() {
        this.id = 0;
        this.state_id = 0;
        this.name = "";
        this.icon = "";
        this.start_time = 0L;
        this.end_time = 0L;
    }

    public SkinListItem(int i, int i2, String str, String str2, long j, long j2) {
        this.id = i;
        this.state_id = i2;
        this.name = str;
        this.icon = str2;
        this.start_time = j;
        this.end_time = j2;
    }
}
