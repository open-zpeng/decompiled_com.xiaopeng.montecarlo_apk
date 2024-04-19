package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ScenicMainPageRecDataScenicGuideListItem implements Serializable {
    public String back_args;
    public String icon_type;
    public String name;
    public String schema;
    public String widget_type;

    public ScenicMainPageRecDataScenicGuideListItem() {
        this.name = "";
        this.icon_type = "";
        this.widget_type = "";
        this.schema = "";
        this.back_args = "";
    }

    public ScenicMainPageRecDataScenicGuideListItem(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.icon_type = str2;
        this.widget_type = str3;
        this.schema = str4;
        this.back_args = str5;
    }
}
