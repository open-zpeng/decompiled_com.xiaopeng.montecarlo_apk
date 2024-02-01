package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PoiDetailBasicInfo implements Serializable {
    public SearchPicGallery galleryInfo;
    public PoiDetailPoiInfo poiInfo;
    public ArrayList<SearchRankInfoBase> rankBarInfo;

    public PoiDetailBasicInfo() {
        this.rankBarInfo = new ArrayList<>();
        this.poiInfo = new PoiDetailPoiInfo();
        this.galleryInfo = new SearchPicGallery();
    }

    public PoiDetailBasicInfo(ArrayList<SearchRankInfoBase> arrayList, PoiDetailPoiInfo poiDetailPoiInfo, SearchPicGallery searchPicGallery) {
        this.rankBarInfo = arrayList;
        this.poiInfo = poiDetailPoiInfo;
        this.galleryInfo = searchPicGallery;
    }
}
