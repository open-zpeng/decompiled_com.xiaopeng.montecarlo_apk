package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsFencingGroupsQueryAction implements Serializable {
    public String content;
    public String name;
    public String type;

    public WsFencingGroupsQueryAction() {
        this.name = "";
        this.type = "";
        this.content = "";
    }

    public WsFencingGroupsQueryAction(String str, String str2, String str3) {
        this.name = str;
        this.type = str2;
        this.content = str3;
    }
}
