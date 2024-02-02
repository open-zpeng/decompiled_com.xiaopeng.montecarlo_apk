package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DataUserProfile implements Serializable {
    public String avatar;
    public String email;
    public String mobile;
    public String nickname;
    public String uid;
    public String username;

    public DataUserProfile() {
        this.username = "";
        this.uid = "";
        this.mobile = "";
        this.nickname = "";
        this.email = "";
        this.avatar = "";
    }

    public DataUserProfile(String str, String str2, String str3, String str4, String str5, String str6) {
        this.username = str;
        this.uid = str2;
        this.mobile = str3;
        this.nickname = str4;
        this.email = str5;
        this.avatar = str6;
    }
}
