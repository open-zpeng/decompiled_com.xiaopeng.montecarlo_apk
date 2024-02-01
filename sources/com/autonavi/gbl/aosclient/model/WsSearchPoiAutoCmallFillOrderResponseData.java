package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsSearchPoiAutoCmallFillOrderResponseData implements Serializable {
    public WsSearchPoiAutoCmallFillOrderDataAuth auth;
    public WsSearchPoiAutoCmallFillOrderDataItemInfo item_info;
    public WsSearchPoiAutoCmallFillOrderDataMeta meta;
    public WsSearchPoiAutoCmallFillOrderPayChannelInfo pay_channel_info;
    public WsSearchPoiAutoCmallFillOrderDataPhoneInfo phone_info;
    public WsSearchPoiAutoCmallFillOrderProtocolInfo protocol_info;

    public WsSearchPoiAutoCmallFillOrderResponseData() {
        this.meta = new WsSearchPoiAutoCmallFillOrderDataMeta();
        this.phone_info = new WsSearchPoiAutoCmallFillOrderDataPhoneInfo();
        this.auth = new WsSearchPoiAutoCmallFillOrderDataAuth();
        this.pay_channel_info = new WsSearchPoiAutoCmallFillOrderPayChannelInfo();
        this.item_info = new WsSearchPoiAutoCmallFillOrderDataItemInfo();
        this.protocol_info = new WsSearchPoiAutoCmallFillOrderProtocolInfo();
    }

    public WsSearchPoiAutoCmallFillOrderResponseData(WsSearchPoiAutoCmallFillOrderDataMeta wsSearchPoiAutoCmallFillOrderDataMeta, WsSearchPoiAutoCmallFillOrderDataPhoneInfo wsSearchPoiAutoCmallFillOrderDataPhoneInfo, WsSearchPoiAutoCmallFillOrderDataAuth wsSearchPoiAutoCmallFillOrderDataAuth, WsSearchPoiAutoCmallFillOrderPayChannelInfo wsSearchPoiAutoCmallFillOrderPayChannelInfo, WsSearchPoiAutoCmallFillOrderDataItemInfo wsSearchPoiAutoCmallFillOrderDataItemInfo, WsSearchPoiAutoCmallFillOrderProtocolInfo wsSearchPoiAutoCmallFillOrderProtocolInfo) {
        this.meta = wsSearchPoiAutoCmallFillOrderDataMeta;
        this.phone_info = wsSearchPoiAutoCmallFillOrderDataPhoneInfo;
        this.auth = wsSearchPoiAutoCmallFillOrderDataAuth;
        this.pay_channel_info = wsSearchPoiAutoCmallFillOrderPayChannelInfo;
        this.item_info = wsSearchPoiAutoCmallFillOrderDataItemInfo;
        this.protocol_info = wsSearchPoiAutoCmallFillOrderProtocolInfo;
    }
}
