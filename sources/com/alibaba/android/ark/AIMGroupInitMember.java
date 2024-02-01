package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMGroupInitMember implements Serializable {
    private static final long serialVersionUID = 8042240356255744274L;
    public AIMGroupMemberRole role;
    public AIMGroupUserInfo user;

    public AIMGroupInitMember(AIMGroupUserInfo aIMGroupUserInfo, AIMGroupMemberRole aIMGroupMemberRole) {
        this.role = AIMGroupMemberRole.GROUP_MEMBER_ROLE_NORMAL;
        this.user = aIMGroupUserInfo;
        if (aIMGroupMemberRole != null) {
            this.role = aIMGroupMemberRole;
        }
    }

    public AIMGroupInitMember() {
        this.role = AIMGroupMemberRole.GROUP_MEMBER_ROLE_NORMAL;
    }

    public AIMGroupUserInfo getUser() {
        return this.user;
    }

    public AIMGroupMemberRole getRole() {
        return this.role;
    }

    public String toString() {
        return "AIMGroupInitMember{user=" + this.user + ",role=" + this.role + "}";
    }
}
