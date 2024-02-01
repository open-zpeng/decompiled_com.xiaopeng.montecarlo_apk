package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingResponseData implements Serializable {
    public WsShieldSearchRanklist_landingDataMeta meta;
    public WsShieldSearchRanklist_landingDataModule modules;
    public ArrayList<String> need_modules;
    public ArrayList<String> sort;

    public WsShieldSearchRanklist_landingResponseData() {
        this.sort = new ArrayList<>();
        this.need_modules = new ArrayList<>();
        this.meta = new WsShieldSearchRanklist_landingDataMeta();
        this.modules = new WsShieldSearchRanklist_landingDataModule();
    }

    public WsShieldSearchRanklist_landingResponseData(ArrayList<String> arrayList, ArrayList<String> arrayList2, WsShieldSearchRanklist_landingDataMeta wsShieldSearchRanklist_landingDataMeta, WsShieldSearchRanklist_landingDataModule wsShieldSearchRanklist_landingDataModule) {
        this.sort = arrayList;
        this.need_modules = arrayList2;
        this.meta = wsShieldSearchRanklist_landingDataMeta;
        this.modules = wsShieldSearchRanklist_landingDataModule;
    }
}
