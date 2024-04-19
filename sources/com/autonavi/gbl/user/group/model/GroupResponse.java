package com.autonavi.gbl.user.group.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GroupResponse implements Serializable {
    public int code;
    public String message;

    public GroupResponse() {
        this.code = 0;
        this.message = "";
    }

    public GroupResponse(int i, String str) {
        this.code = i;
        this.message = str;
    }
}
