package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingDataModule implements Serializable {
    public WsShieldSearchRanklist_landingModuleClassify classify;
    public WsShieldSearchRanklist_landingModuleCoreRank core_rank;
    public WsShieldSearchRanklist_landingModuleHeader header;
    public WsShieldSearchRanklist_landingModuleRecommend recommend;

    public WsShieldSearchRanklist_landingDataModule() {
        this.header = new WsShieldSearchRanklist_landingModuleHeader();
        this.core_rank = new WsShieldSearchRanklist_landingModuleCoreRank();
        this.classify = new WsShieldSearchRanklist_landingModuleClassify();
        this.recommend = new WsShieldSearchRanklist_landingModuleRecommend();
    }

    public WsShieldSearchRanklist_landingDataModule(WsShieldSearchRanklist_landingModuleHeader wsShieldSearchRanklist_landingModuleHeader, WsShieldSearchRanklist_landingModuleCoreRank wsShieldSearchRanklist_landingModuleCoreRank, WsShieldSearchRanklist_landingModuleClassify wsShieldSearchRanklist_landingModuleClassify, WsShieldSearchRanklist_landingModuleRecommend wsShieldSearchRanklist_landingModuleRecommend) {
        this.header = wsShieldSearchRanklist_landingModuleHeader;
        this.core_rank = wsShieldSearchRanklist_landingModuleCoreRank;
        this.classify = wsShieldSearchRanklist_landingModuleClassify;
        this.recommend = wsShieldSearchRanklist_landingModuleRecommend;
    }
}
