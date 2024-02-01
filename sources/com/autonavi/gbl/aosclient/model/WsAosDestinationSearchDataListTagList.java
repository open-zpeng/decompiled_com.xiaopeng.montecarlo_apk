package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsAosDestinationSearchDataListTagList implements Serializable {
    public String backgroundColor;
    public String color;
    public String text;

    public WsAosDestinationSearchDataListTagList() {
        this.backgroundColor = "";
        this.color = "";
        this.text = "";
    }

    public WsAosDestinationSearchDataListTagList(String str, String str2, String str3) {
        this.backgroundColor = str;
        this.color = str2;
        this.text = str3;
    }
}
