package com.autonavi.gbl.user.group.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GroupRequestDissolve extends GroupRequest implements Serializable {
    public String teamId = "";

    public GroupRequestDissolve() {
        this.reqType = 3;
    }
}
