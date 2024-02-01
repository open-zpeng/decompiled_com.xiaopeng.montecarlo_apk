package com.autonavi.gbl.user.group.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GroupFriend implements Serializable {
    public String imgUrl;
    public String nickName;
    public String uid;
    public String userName;

    public GroupFriend() {
        this.uid = "";
        this.imgUrl = "";
        this.userName = "";
        this.nickName = "";
    }

    public GroupFriend(String str, String str2, String str3, String str4) {
        this.uid = str;
        this.imgUrl = str2;
        this.userName = str3;
        this.nickName = str4;
    }
}
