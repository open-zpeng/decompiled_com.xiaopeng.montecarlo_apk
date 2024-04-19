package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsPpCarltdLogin4bindAckData implements Serializable {
    public String avatar;
    public String nickname;
    public String uid;
    public String username;

    public WsPpCarltdLogin4bindAckData() {
        this.avatar = "";
        this.nickname = "";
        this.uid = "";
        this.username = "";
    }

    public WsPpCarltdLogin4bindAckData(String str, String str2, String str3, String str4) {
        this.avatar = str;
        this.nickname = str2;
        this.uid = str3;
        this.username = str4;
    }
}
