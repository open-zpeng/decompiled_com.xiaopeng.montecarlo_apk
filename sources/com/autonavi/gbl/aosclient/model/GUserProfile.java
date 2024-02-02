package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GUserProfile implements Serializable {
    public String avatar;
    public String birthday;
    public GUserProfileCar car;
    public int checkin_count;
    public String description;
    public String email;
    public int gender;
    public int level;
    public String mobile;
    public String nickname;
    public ArrayList<GProvider> providers;
    public String uid;
    public String username;

    public GUserProfile() {
        this.uid = "";
        this.username = "";
        this.nickname = "";
        this.avatar = "";
        this.gender = 0;
        this.birthday = "";
        this.description = "";
        this.email = "";
        this.mobile = "";
        this.providers = new ArrayList<>();
        this.level = 0;
        this.checkin_count = 0;
        this.car = new GUserProfileCar();
    }

    public GUserProfile(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, ArrayList<GProvider> arrayList, int i2, int i3, GUserProfileCar gUserProfileCar) {
        this.uid = str;
        this.username = str2;
        this.nickname = str3;
        this.avatar = str4;
        this.gender = i;
        this.birthday = str5;
        this.description = str6;
        this.email = str7;
        this.mobile = str8;
        this.providers = arrayList;
        this.level = i2;
        this.checkin_count = i3;
        this.car = gUserProfileCar;
    }
}
