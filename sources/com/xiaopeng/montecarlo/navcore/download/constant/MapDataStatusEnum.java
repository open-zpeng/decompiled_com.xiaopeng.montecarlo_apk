package com.xiaopeng.montecarlo.navcore.download.constant;

import io.reactivex.annotations.NonNull;
/* loaded from: classes2.dex */
public enum MapDataStatusEnum {
    STATUS_UNKNOWN(0, "UNKNOWN"),
    STATUS_DOWNLOAD_COMPLETE(1, "DOWNLOAD_COMPLETE"),
    STATUS_DELETED(2, "DELETED");
    
    private final String mName;
    private final int mStatus;

    public int getStatus() {
        return this.mStatus;
    }

    public String getName() {
        return this.mName;
    }

    MapDataStatusEnum(int i, String str) {
        this.mStatus = i;
        this.mName = str;
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return this.mName;
    }
}
