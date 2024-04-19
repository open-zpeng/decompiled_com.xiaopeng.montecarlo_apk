package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LayerListItem implements Serializable {
    public String action_url;
    public String data;
    public long end_time;
    public String icon;
    public int id;
    public int layer_id;
    public int layer_type;
    public int level;
    public String name;
    public long start_time;
    public int switchValue;
    public String toast;

    public LayerListItem() {
        this.id = 0;
        this.layer_id = 0;
        this.layer_type = 0;
        this.name = "";
        this.icon = "";
        this.data = "";
        this.action_url = "";
        this.start_time = 0L;
        this.end_time = 0L;
        this.switchValue = 0;
        this.level = 0;
        this.toast = "";
    }

    public LayerListItem(int i, int i2, int i3, String str, String str2, String str3, String str4, long j, long j2, int i4, int i5, String str5) {
        this.id = i;
        this.layer_id = i2;
        this.layer_type = i3;
        this.name = str;
        this.icon = str2;
        this.data = str3;
        this.action_url = str4;
        this.start_time = j;
        this.end_time = j2;
        this.switchValue = i4;
        this.level = i5;
        this.toast = str5;
    }
}
