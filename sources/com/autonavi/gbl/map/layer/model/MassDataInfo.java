package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MassDataInfo implements Serializable {
    public int bizType;
    public String extraData;
    public String groupId;
    public String id;
    public int priority;

    public MassDataInfo() {
        this.bizType = -1;
        this.priority = -1;
        this.id = "";
        this.groupId = "";
        this.extraData = "";
    }

    public MassDataInfo(int i, int i2, String str, String str2, String str3) {
        this.bizType = i;
        this.priority = i2;
        this.id = str;
        this.groupId = str2;
        this.extraData = str3;
    }
}
