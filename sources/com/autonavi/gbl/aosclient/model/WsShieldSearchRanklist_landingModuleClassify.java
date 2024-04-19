package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingModuleClassify implements Serializable {
    public WsShieldSearchRanklist_landingClassifyArea area;
    public ArrayList<WsShieldSearchRanklist_landingClassifyCategory> category;
    public int is_union;
    public WsShieldSearchRanklist_landingPoiRankMethod poi_rank_method;
    public ArrayList<WsShieldSearchRanklist_landingSubCategory> sub_category;

    public WsShieldSearchRanklist_landingModuleClassify() {
        this.is_union = 0;
        this.category = new ArrayList<>();
        this.sub_category = new ArrayList<>();
        this.area = new WsShieldSearchRanklist_landingClassifyArea();
        this.poi_rank_method = new WsShieldSearchRanklist_landingPoiRankMethod();
    }

    public WsShieldSearchRanklist_landingModuleClassify(int i, ArrayList<WsShieldSearchRanklist_landingClassifyCategory> arrayList, ArrayList<WsShieldSearchRanklist_landingSubCategory> arrayList2, WsShieldSearchRanklist_landingClassifyArea wsShieldSearchRanklist_landingClassifyArea, WsShieldSearchRanklist_landingPoiRankMethod wsShieldSearchRanklist_landingPoiRankMethod) {
        this.is_union = i;
        this.category = arrayList;
        this.sub_category = arrayList2;
        this.area = wsShieldSearchRanklist_landingClassifyArea;
        this.poi_rank_method = wsShieldSearchRanklist_landingPoiRankMethod;
    }
}
