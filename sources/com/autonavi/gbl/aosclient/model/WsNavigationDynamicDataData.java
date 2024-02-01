package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataData implements Serializable {
    public WsNavigationDynamicDataDataAutoData auto_data;
    public WsNavigationDynamicDataCommonData common_data;
    public WsNavigationDynamicDataFrontEnd front_end;
    public WsNavigationDynamicDataHorus horus;
    public WsNavigationDynamicDataLaneEngine lane_engine;
    public String tbt;

    public WsNavigationDynamicDataData() {
        this.horus = new WsNavigationDynamicDataHorus();
        this.tbt = "";
        this.common_data = new WsNavigationDynamicDataCommonData();
        this.front_end = new WsNavigationDynamicDataFrontEnd();
        this.lane_engine = new WsNavigationDynamicDataLaneEngine();
        this.auto_data = new WsNavigationDynamicDataDataAutoData();
    }

    public WsNavigationDynamicDataData(WsNavigationDynamicDataHorus wsNavigationDynamicDataHorus, String str, WsNavigationDynamicDataCommonData wsNavigationDynamicDataCommonData, WsNavigationDynamicDataFrontEnd wsNavigationDynamicDataFrontEnd, WsNavigationDynamicDataLaneEngine wsNavigationDynamicDataLaneEngine, WsNavigationDynamicDataDataAutoData wsNavigationDynamicDataDataAutoData) {
        this.horus = wsNavigationDynamicDataHorus;
        this.tbt = str;
        this.common_data = wsNavigationDynamicDataCommonData;
        this.front_end = wsNavigationDynamicDataFrontEnd;
        this.lane_engine = wsNavigationDynamicDataLaneEngine;
        this.auto_data = wsNavigationDynamicDataDataAutoData;
    }
}
