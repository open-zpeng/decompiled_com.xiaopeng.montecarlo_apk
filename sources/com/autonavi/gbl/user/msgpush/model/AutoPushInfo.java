package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AutoPushInfo implements Serializable {
    public String actionUri;
    public String imgUrl;
    public String subContent;
    public String text;
    public String title;

    public AutoPushInfo() {
        this.imgUrl = "";
        this.actionUri = "";
        this.text = "";
        this.title = "";
        this.subContent = "";
    }

    public AutoPushInfo(String str, String str2, String str3, String str4, String str5) {
        this.imgUrl = str;
        this.actionUri = str2;
        this.text = str3;
        this.title = str4;
        this.subContent = str5;
    }
}
