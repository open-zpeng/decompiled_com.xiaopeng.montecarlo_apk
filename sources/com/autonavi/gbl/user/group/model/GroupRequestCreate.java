package com.autonavi.gbl.user.group.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GroupRequestCreate extends GroupRequest implements Serializable {
    public GroupDestination destination = new GroupDestination();

    public GroupRequestCreate() {
        this.reqType = 2;
    }
}
