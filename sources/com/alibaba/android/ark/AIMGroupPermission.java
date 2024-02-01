package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMGroupPermission implements Serializable {
    private static final long serialVersionUID = -4433331435923632221L;
    public String permissionGroup;
    public int status;

    public AIMGroupPermission(String str, int i) {
        this.status = 0;
        this.permissionGroup = str;
        this.status = i;
    }

    public AIMGroupPermission() {
        this.status = 0;
    }

    public String getPermissionGroup() {
        return this.permissionGroup;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "AIMGroupPermission{permissionGroup=" + this.permissionGroup + ",status=" + this.status + "}";
    }
}
