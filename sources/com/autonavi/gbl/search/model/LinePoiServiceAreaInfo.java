package com.autonavi.gbl.search.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LinePoiServiceAreaInfo extends LinePoiBase implements Serializable {
    public int building = 0;
    public String serviceStar = "";
    public String brand = "";
    public String address = "";
    public ArrayList<LinePoiServiceAreaChild> children = new ArrayList<>();

    public LinePoiServiceAreaInfo() {
        this.queryType = 1;
    }
}
