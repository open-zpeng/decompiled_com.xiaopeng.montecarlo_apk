package com.autonavi.gbl.user.group.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GroupRequestJoin extends GroupRequest implements Serializable {
    public String teamNumber = "";

    public GroupRequestJoin() {
        this.reqType = 4;
    }
}
