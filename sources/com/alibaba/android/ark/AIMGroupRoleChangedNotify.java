package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMGroupRoleChangedNotify implements Serializable {
    private static final long serialVersionUID = -1558160197244577025L;
    public String cid;
    public AIMGroupMemberRole role;
    public ArrayList<AIMUserId> uids;

    public AIMGroupRoleChangedNotify(String str, AIMGroupMemberRole aIMGroupMemberRole, ArrayList<AIMUserId> arrayList) {
        this.role = AIMGroupMemberRole.GROUP_MEMBER_ROLE_NORMAL;
        this.cid = str;
        if (aIMGroupMemberRole != null) {
            this.role = aIMGroupMemberRole;
        }
        this.uids = arrayList;
    }

    public AIMGroupRoleChangedNotify() {
        this.role = AIMGroupMemberRole.GROUP_MEMBER_ROLE_NORMAL;
    }

    public String getCid() {
        return this.cid;
    }

    public AIMGroupMemberRole getRole() {
        return this.role;
    }

    public ArrayList<AIMUserId> getUids() {
        return this.uids;
    }

    public String toString() {
        return "AIMGroupRoleChangedNotify{cid=" + this.cid + ",role=" + this.role + ",uids=" + this.uids + "}";
    }
}
