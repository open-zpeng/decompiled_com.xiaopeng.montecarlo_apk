package com.autonavi.gbl.user.group.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class GroupRequestInvite extends GroupRequest implements Serializable {
    public String teamId = "";
    public ArrayList<String> inviteIds = new ArrayList<>();

    public GroupRequestInvite() {
        this.reqType = 6;
    }
}
