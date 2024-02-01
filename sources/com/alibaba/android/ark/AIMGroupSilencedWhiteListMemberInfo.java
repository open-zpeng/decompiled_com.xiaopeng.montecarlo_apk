package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMGroupSilencedWhiteListMemberInfo implements Serializable {
    private static final long serialVersionUID = 3523765568382788686L;
    public long operateTime;
    public AIMUserId uid;

    public AIMGroupSilencedWhiteListMemberInfo(AIMUserId aIMUserId, long j) {
        this.operateTime = 0L;
        this.uid = aIMUserId;
        this.operateTime = j;
    }

    public AIMGroupSilencedWhiteListMemberInfo() {
        this.operateTime = 0L;
    }

    public AIMUserId getUid() {
        return this.uid;
    }

    public long getOperateTime() {
        return this.operateTime;
    }

    public String toString() {
        return "AIMGroupSilencedWhiteListMemberInfo{uid=" + this.uid + ",operateTime=" + this.operateTime + "}";
    }
}
