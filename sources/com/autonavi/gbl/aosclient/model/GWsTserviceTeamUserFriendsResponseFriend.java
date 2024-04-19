package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamUserFriendsResponseFriend implements Serializable {
    public String imgUrl;
    public String nickName;
    public String uid;
    public String username;

    public GWsTserviceTeamUserFriendsResponseFriend() {
        this.nickName = "";
        this.imgUrl = "";
        this.uid = "";
        this.username = "";
    }

    public GWsTserviceTeamUserFriendsResponseFriend(String str, String str2, String str3, String str4) {
        this.nickName = str;
        this.imgUrl = str2;
        this.uid = str3;
        this.username = str4;
    }
}
