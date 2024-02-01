package com.autonavi.gbl.user.account.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class UserProfile implements Serializable {
    public String avatar;
    public String email;
    public String mobile;
    public String nickname;
    public String uid;
    public String username;

    public UserProfile() {
        this.uid = "";
        this.username = "";
        this.nickname = "";
        this.avatar = "";
        this.mobile = "";
        this.email = "";
    }

    public UserProfile(String str, String str2, String str3, String str4, String str5, String str6) {
        this.uid = str;
        this.username = str2;
        this.nickname = str3;
        this.avatar = str4;
        this.mobile = str5;
        this.email = str6;
    }
}
