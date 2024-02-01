package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataFrontEnd implements Serializable {
    public ArrayList<WsNavigationDynamicDataDownloadItem> download;
    public ArrayList<WsNavigationDynamicDataPerceiveTips> perceive_tips;
    public ArrayList<WsNavigationDynamicDataPowerTrendItem> power_trend;
    public ArrayList<WsNavigationDynamicDataToastItem> toast;
    public WsNavigationDynamicDataTrafficJamBubbles traffic_jam_bubbles;

    public WsNavigationDynamicDataFrontEnd() {
        this.perceive_tips = new ArrayList<>();
        this.toast = new ArrayList<>();
        this.power_trend = new ArrayList<>();
        this.download = new ArrayList<>();
        this.traffic_jam_bubbles = new WsNavigationDynamicDataTrafficJamBubbles();
    }

    public WsNavigationDynamicDataFrontEnd(ArrayList<WsNavigationDynamicDataPerceiveTips> arrayList, ArrayList<WsNavigationDynamicDataToastItem> arrayList2, ArrayList<WsNavigationDynamicDataPowerTrendItem> arrayList3, ArrayList<WsNavigationDynamicDataDownloadItem> arrayList4, WsNavigationDynamicDataTrafficJamBubbles wsNavigationDynamicDataTrafficJamBubbles) {
        this.perceive_tips = arrayList;
        this.toast = arrayList2;
        this.power_trend = arrayList3;
        this.download = arrayList4;
        this.traffic_jam_bubbles = wsNavigationDynamicDataTrafficJamBubbles;
    }
}
