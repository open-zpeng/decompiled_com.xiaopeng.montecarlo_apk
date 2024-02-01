package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class GraphicDetailsInfo implements Serializable {
    public String desc;
    public ArrayList<String> picUrlList;

    public GraphicDetailsInfo() {
        this.desc = "";
        this.picUrlList = new ArrayList<>();
    }

    public GraphicDetailsInfo(String str, ArrayList<String> arrayList) {
        this.desc = str;
        this.picUrlList = arrayList;
    }
}
