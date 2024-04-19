package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalDataModule implements Serializable {
    public WsShieldSearchRanklistPortalModuleClassify classify;
    public WsShieldSearchRanklistPortalModuleCoreRank core_rank;
    public WsShieldSearchRanklistPortalModuleHeader header;
    public WsShieldSearchRanklistPortalModuleRecommend recommend;

    public WsShieldSearchRanklistPortalDataModule() {
        this.header = new WsShieldSearchRanklistPortalModuleHeader();
        this.core_rank = new WsShieldSearchRanklistPortalModuleCoreRank();
        this.classify = new WsShieldSearchRanklistPortalModuleClassify();
        this.recommend = new WsShieldSearchRanklistPortalModuleRecommend();
    }

    public WsShieldSearchRanklistPortalDataModule(WsShieldSearchRanklistPortalModuleHeader wsShieldSearchRanklistPortalModuleHeader, WsShieldSearchRanklistPortalModuleCoreRank wsShieldSearchRanklistPortalModuleCoreRank, WsShieldSearchRanklistPortalModuleClassify wsShieldSearchRanklistPortalModuleClassify, WsShieldSearchRanklistPortalModuleRecommend wsShieldSearchRanklistPortalModuleRecommend) {
        this.header = wsShieldSearchRanklistPortalModuleHeader;
        this.core_rank = wsShieldSearchRanklistPortalModuleCoreRank;
        this.classify = wsShieldSearchRanklistPortalModuleClassify;
        this.recommend = wsShieldSearchRanklistPortalModuleRecommend;
    }
}
