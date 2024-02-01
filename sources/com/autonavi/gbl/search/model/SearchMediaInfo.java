package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchMediaInfo implements Serializable {
    public ArrayList<GraphicDetailsInfo> graphicDetails;
    public ArrayList<String> imageUrlList;

    public SearchMediaInfo() {
        this.imageUrlList = new ArrayList<>();
        this.graphicDetails = new ArrayList<>();
    }

    public SearchMediaInfo(ArrayList<String> arrayList, ArrayList<GraphicDetailsInfo> arrayList2) {
        this.imageUrlList = arrayList;
        this.graphicDetails = arrayList2;
    }
}
