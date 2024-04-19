package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class EventSyncCommonPushDetailItem implements Serializable {
    public String key;
    public String value;

    public EventSyncCommonPushDetailItem() {
        this.key = "";
        this.value = "";
    }

    public EventSyncCommonPushDetailItem(String str, String str2) {
        this.key = str;
        this.value = str2;
    }
}
