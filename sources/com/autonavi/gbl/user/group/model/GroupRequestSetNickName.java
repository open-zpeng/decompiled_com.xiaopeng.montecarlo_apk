package com.autonavi.gbl.user.group.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GroupRequestSetNickName extends GroupRequest implements Serializable {
    public String teamNick = "";

    public GroupRequestSetNickName() {
        this.reqType = 10;
    }
}
