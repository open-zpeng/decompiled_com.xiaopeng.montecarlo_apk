package com.xiaopeng.lib.apirouter;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class UriStruct {
    public String applicationId;
    public String processTag;
    public String serviceName;
    public int targetUid;

    @NonNull
    public String toString() {
        return this.targetUid + "@" + this.applicationId + "." + this.serviceName;
    }
}
