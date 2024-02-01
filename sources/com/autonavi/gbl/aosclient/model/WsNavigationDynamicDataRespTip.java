package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataRespTip implements Serializable {
    public WsNavigationDynamicDataRespMore more;
    public WsNavigationDynamicDataRespStyle style;
    public WsNavigationDynamicDataRespTitle title;

    public WsNavigationDynamicDataRespTip() {
        this.style = new WsNavigationDynamicDataRespStyle();
        this.title = new WsNavigationDynamicDataRespTitle();
        this.more = new WsNavigationDynamicDataRespMore();
    }

    public WsNavigationDynamicDataRespTip(WsNavigationDynamicDataRespStyle wsNavigationDynamicDataRespStyle, WsNavigationDynamicDataRespTitle wsNavigationDynamicDataRespTitle, WsNavigationDynamicDataRespMore wsNavigationDynamicDataRespMore) {
        this.style = wsNavigationDynamicDataRespStyle;
        this.title = wsNavigationDynamicDataRespTitle;
        this.more = wsNavigationDynamicDataRespMore;
    }
}
