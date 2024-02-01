package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsSearchPoiAutoCmallFillOrderPayChannelList implements Serializable {
    public String channel;
    public boolean checked;
    public String display_name;
    public String name;
    public String pay_option_code;
    public boolean recommend;

    public WsSearchPoiAutoCmallFillOrderPayChannelList() {
        this.channel = "";
        this.name = "";
        this.display_name = "";
        this.checked = false;
        this.recommend = false;
        this.pay_option_code = "";
    }

    public WsSearchPoiAutoCmallFillOrderPayChannelList(String str, String str2, String str3, boolean z, boolean z2, String str4) {
        this.channel = str;
        this.name = str2;
        this.display_name = str3;
        this.checked = z;
        this.recommend = z2;
        this.pay_option_code = str4;
    }
}
