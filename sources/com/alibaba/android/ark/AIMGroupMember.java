package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMGroupMember implements Serializable {
    private static final long serialVersionUID = -6697732237453465525L;
    public String cid;
    public long createdAt;
    public HashMap<String, String> extension;
    public String groupNick;
    public AIMGroupMemberRole role;
    public AIMUserId uid;

    public AIMGroupMember(String str, AIMUserId aIMUserId, AIMGroupMemberRole aIMGroupMemberRole, long j, String str2, HashMap<String, String> hashMap) {
        this.role = AIMGroupMemberRole.GROUP_MEMBER_ROLE_UNKNOW;
        this.createdAt = 0L;
        this.cid = str;
        this.uid = aIMUserId;
        if (aIMGroupMemberRole != null) {
            this.role = aIMGroupMemberRole;
        }
        this.createdAt = j;
        this.groupNick = str2;
        this.extension = hashMap;
    }

    public AIMGroupMember() {
        this.role = AIMGroupMemberRole.GROUP_MEMBER_ROLE_UNKNOW;
        this.createdAt = 0L;
    }

    public String getCid() {
        return this.cid;
    }

    public AIMUserId getUid() {
        return this.uid;
    }

    public AIMGroupMemberRole getRole() {
        return this.role;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getGroupNick() {
        return this.groupNick;
    }

    public HashMap<String, String> getExtension() {
        return this.extension;
    }

    public String toString() {
        return "AIMGroupMember{cid=" + this.cid + ",uid=" + this.uid + ",role=" + this.role + ",createdAt=" + this.createdAt + ",groupNick=" + this.groupNick + ",extension=" + this.extension + "}";
    }
}
