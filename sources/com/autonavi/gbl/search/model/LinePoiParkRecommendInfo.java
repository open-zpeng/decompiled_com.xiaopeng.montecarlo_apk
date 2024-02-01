package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LinePoiParkRecommendInfo extends LinePoiBase implements Serializable {
    public String address = "";
    public ArrayList<LinePoiParkRecommendChild> children = new ArrayList<>();

    public LinePoiParkRecommendInfo() {
        this.queryType = 4;
    }
}
