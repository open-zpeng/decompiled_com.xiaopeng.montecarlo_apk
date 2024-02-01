package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsSearchPoiAutoCmallFillOrderPayChannelInfo implements Serializable {
    public String pay_channel_ext;
    public ArrayList<WsSearchPoiAutoCmallFillOrderPayChannelList> pay_channel_list;

    public WsSearchPoiAutoCmallFillOrderPayChannelInfo() {
        this.pay_channel_list = new ArrayList<>();
        this.pay_channel_ext = "";
    }

    public WsSearchPoiAutoCmallFillOrderPayChannelInfo(ArrayList<WsSearchPoiAutoCmallFillOrderPayChannelList> arrayList, String str) {
        this.pay_channel_list = arrayList;
        this.pay_channel_ext = str;
    }
}
