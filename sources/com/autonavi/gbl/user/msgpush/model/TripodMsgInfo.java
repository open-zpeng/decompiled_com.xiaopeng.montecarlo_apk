package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class TripodMsgInfo implements Serializable {
    public String location;
    public String message;
    public int type;

    public TripodMsgInfo() {
        this.type = 0;
        this.message = "";
        this.location = "";
    }

    public TripodMsgInfo(int i, String str, String str2) {
        this.type = i;
        this.message = str;
        this.location = str2;
    }
}
