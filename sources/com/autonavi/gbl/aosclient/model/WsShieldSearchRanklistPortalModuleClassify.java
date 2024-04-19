package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalModuleClassify implements Serializable {
    public WsShieldSearchRanklistPortalClassifyArea area;
    public ArrayList<WsShieldSearchRanklistPortalClassifyCategory> category;
    public int is_union;
    public WsShieldSearchRanklistPortalPoiRankMethod poi_rank_method;
    public ArrayList<WsShieldSearchRanklistPortalSubCategory> sub_category;

    public WsShieldSearchRanklistPortalModuleClassify() {
        this.is_union = 0;
        this.category = new ArrayList<>();
        this.sub_category = new ArrayList<>();
        this.area = new WsShieldSearchRanklistPortalClassifyArea();
        this.poi_rank_method = new WsShieldSearchRanklistPortalPoiRankMethod();
    }

    public WsShieldSearchRanklistPortalModuleClassify(int i, ArrayList<WsShieldSearchRanklistPortalClassifyCategory> arrayList, ArrayList<WsShieldSearchRanklistPortalSubCategory> arrayList2, WsShieldSearchRanklistPortalClassifyArea wsShieldSearchRanklistPortalClassifyArea, WsShieldSearchRanklistPortalPoiRankMethod wsShieldSearchRanklistPortalPoiRankMethod) {
        this.is_union = i;
        this.category = arrayList;
        this.sub_category = arrayList2;
        this.area = wsShieldSearchRanklistPortalClassifyArea;
        this.poi_rank_method = wsShieldSearchRanklistPortalPoiRankMethod;
    }
}
