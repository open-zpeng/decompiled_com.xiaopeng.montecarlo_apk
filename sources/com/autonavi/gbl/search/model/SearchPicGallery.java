package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPicGallery implements Serializable {
    public ArrayList<SearchGalleryInfo> gallery;
    public int picTotal;
    public int videoTotal;

    public SearchPicGallery() {
        this.picTotal = 0;
        this.videoTotal = 0;
        this.gallery = new ArrayList<>();
    }

    public SearchPicGallery(int i, int i2, ArrayList<SearchGalleryInfo> arrayList) {
        this.picTotal = i;
        this.videoTotal = i2;
        this.gallery = arrayList;
    }
}
