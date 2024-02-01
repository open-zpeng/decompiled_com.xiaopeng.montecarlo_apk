package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsAosDestinationSearchDataTabList implements Serializable {
    public ArrayList<WsAosDestinationSearchTabListDataList> dataList;
    public WsAosDestinationSearchTabListTabInfo tabInfo;
    public String tabName;

    public WsAosDestinationSearchDataTabList() {
        this.tabName = "";
        this.tabInfo = new WsAosDestinationSearchTabListTabInfo();
        this.dataList = new ArrayList<>();
    }

    public WsAosDestinationSearchDataTabList(String str, WsAosDestinationSearchTabListTabInfo wsAosDestinationSearchTabListTabInfo, ArrayList<WsAosDestinationSearchTabListDataList> arrayList) {
        this.tabName = str;
        this.tabInfo = wsAosDestinationSearchTabListTabInfo;
        this.dataList = arrayList;
    }
}
