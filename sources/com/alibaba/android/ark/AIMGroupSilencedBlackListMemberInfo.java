package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMGroupSilencedBlackListMemberInfo implements Serializable {
    private static final long serialVersionUID = -2490386298424349314L;
    public long endTime;
    public long operateTime;
    public AIMUserId uid;

    public AIMGroupSilencedBlackListMemberInfo(AIMUserId aIMUserId, long j, long j2) {
        this.endTime = 0L;
        this.operateTime = 0L;
        this.uid = aIMUserId;
        this.endTime = j;
        this.operateTime = j2;
    }

    public AIMGroupSilencedBlackListMemberInfo() {
        this.endTime = 0L;
        this.operateTime = 0L;
    }

    public AIMUserId getUid() {
        return this.uid;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getOperateTime() {
        return this.operateTime;
    }

    public String toString() {
        return "AIMGroupSilencedBlackListMemberInfo{uid=" + this.uid + ",endTime=" + this.endTime + ",operateTime=" + this.operateTime + "}";
    }
}
