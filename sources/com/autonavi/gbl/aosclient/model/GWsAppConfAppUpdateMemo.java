package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsAppConfAppUpdateMemo implements Serializable {
    public String apk_type;
    public String app_download;
    public String app_name;
    public String app_package;
    public String app_url;
    public String appver;
    public boolean beta;
    public int build;
    public String dataver;
    public int days;
    public String div;
    public GWsAppConfAppUpdateDoc doc;
    public boolean force;
    public String icon;
    public int interval;
    public String md5;
    public int msgid;
    public String para1;
    public String para2;
    public String para3;
    public String scheme;
    public int size;
    public int span;
    public String title;

    public GWsAppConfAppUpdateMemo() {
        this.msgid = 0;
        this.para1 = "";
        this.para2 = "";
        this.para3 = "";
        this.div = "";
        this.days = 0;
        this.build = 0;
        this.beta = false;
        this.span = 0;
        this.force = false;
        this.title = "";
        this.icon = "";
        this.app_name = "";
        this.app_url = "";
        this.app_download = "";
        this.app_package = "";
        this.md5 = "";
        this.interval = 0;
        this.dataver = "";
        this.size = 0;
        this.appver = "";
        this.scheme = "";
        this.doc = new GWsAppConfAppUpdateDoc();
        this.apk_type = "";
    }

    public GWsAppConfAppUpdateMemo(int i, String str, String str2, String str3, String str4, int i2, int i3, boolean z, int i4, boolean z2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i5, String str12, int i6, String str13, String str14, GWsAppConfAppUpdateDoc gWsAppConfAppUpdateDoc, String str15) {
        this.msgid = i;
        this.para1 = str;
        this.para2 = str2;
        this.para3 = str3;
        this.div = str4;
        this.days = i2;
        this.build = i3;
        this.beta = z;
        this.span = i4;
        this.force = z2;
        this.title = str5;
        this.icon = str6;
        this.app_name = str7;
        this.app_url = str8;
        this.app_download = str9;
        this.app_package = str10;
        this.md5 = str11;
        this.interval = i5;
        this.dataver = str12;
        this.size = i6;
        this.appver = str13;
        this.scheme = str14;
        this.doc = gWsAppConfAppUpdateDoc;
        this.apk_type = str15;
    }
}
