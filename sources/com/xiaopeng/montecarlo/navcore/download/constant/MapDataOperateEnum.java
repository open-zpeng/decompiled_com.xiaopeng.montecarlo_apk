package com.xiaopeng.montecarlo.navcore.download.constant;

import io.reactivex.annotations.NonNull;
/* loaded from: classes2.dex */
public enum MapDataOperateEnum {
    OPERATE_DELETE(0, "DELETE "),
    OPERATE_DOWNLOAD(1, "DOWNLOAD");
    
    private final String mName;
    private final int mOperate;

    public int getOperate() {
        return this.mOperate;
    }

    public String getName() {
        return this.mName;
    }

    MapDataOperateEnum(int i, String str) {
        this.mOperate = i;
        this.mName = str;
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return this.mName;
    }
}
