package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsTcOrderDetailUserInfoItem implements Serializable {
    public String BirthPlace;
    public String Birthday;
    public String CardValidUntil;
    public String ChineseName;
    public String EnglishName;
    public String Nationality;
    public int Sex;
    public String UserName;
    public String credentialNo;
    public int credentialType;
    public String email;
    public String mobile;
    public String name;

    public WsTcOrderDetailUserInfoItem() {
        this.name = "";
        this.mobile = "";
        this.credentialType = 0;
        this.credentialNo = "";
        this.ChineseName = "";
        this.EnglishName = "";
        this.UserName = "";
        this.Nationality = "";
        this.Sex = 0;
        this.Birthday = "";
        this.BirthPlace = "";
        this.CardValidUntil = "";
        this.email = "";
    }

    public WsTcOrderDetailUserInfoItem(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, int i2, String str8, String str9, String str10, String str11) {
        this.name = str;
        this.mobile = str2;
        this.credentialType = i;
        this.credentialNo = str3;
        this.ChineseName = str4;
        this.EnglishName = str5;
        this.UserName = str6;
        this.Nationality = str7;
        this.Sex = i2;
        this.Birthday = str8;
        this.BirthPlace = str9;
        this.CardValidUntil = str10;
        this.email = str11;
    }
}
