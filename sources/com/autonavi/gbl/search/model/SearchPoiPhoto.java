package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPoiPhoto implements Serializable {
    public SearchPoiPhotoInfo cover;
    public ArrayList<SearchPoiPhotoInfo> gallery;

    public SearchPoiPhoto() {
        this.cover = new SearchPoiPhotoInfo();
        this.gallery = new ArrayList<>();
    }

    public SearchPoiPhoto(SearchPoiPhotoInfo searchPoiPhotoInfo, ArrayList<SearchPoiPhotoInfo> arrayList) {
        this.cover = searchPoiPhotoInfo;
        this.gallery = arrayList;
    }
}
