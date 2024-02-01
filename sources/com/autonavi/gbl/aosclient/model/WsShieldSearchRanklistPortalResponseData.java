package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalResponseData implements Serializable {
    public WsShieldSearchRanklistPortalDataMeta meta;
    public WsShieldSearchRanklistPortalDataModule modules;
    public ArrayList<String> need_modules;
    public ArrayList<String> sort;

    public WsShieldSearchRanklistPortalResponseData() {
        this.sort = new ArrayList<>();
        this.need_modules = new ArrayList<>();
        this.meta = new WsShieldSearchRanklistPortalDataMeta();
        this.modules = new WsShieldSearchRanklistPortalDataModule();
    }

    public WsShieldSearchRanklistPortalResponseData(ArrayList<String> arrayList, ArrayList<String> arrayList2, WsShieldSearchRanklistPortalDataMeta wsShieldSearchRanklistPortalDataMeta, WsShieldSearchRanklistPortalDataModule wsShieldSearchRanklistPortalDataModule) {
        this.sort = arrayList;
        this.need_modules = arrayList2;
        this.meta = wsShieldSearchRanklistPortalDataMeta;
        this.modules = wsShieldSearchRanklistPortalDataModule;
    }
}
