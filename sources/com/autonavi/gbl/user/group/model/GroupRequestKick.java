package com.autonavi.gbl.user.group.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class GroupRequestKick extends GroupRequest implements Serializable {
    public String teamId = "";
    public ArrayList<String> kickIds = new ArrayList<>();

    public GroupRequestKick() {
        this.reqType = 7;
    }
}
