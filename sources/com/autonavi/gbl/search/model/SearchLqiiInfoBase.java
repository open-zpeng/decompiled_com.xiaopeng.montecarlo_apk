package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.RectFloat;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchLqiiInfoBase implements Serializable {
    public int intentionType;
    public int isCurrentCity;
    public int isUserCity;
    public ArrayList<String> queryTypeList;
    public String targetViewCity;
    public RectFloat viewRegion;

    public SearchLqiiInfoBase() {
        this.isCurrentCity = -1;
        this.isUserCity = -1;
        this.intentionType = -1;
        this.viewRegion = new RectFloat();
        this.targetViewCity = "";
        this.queryTypeList = new ArrayList<>();
    }

    public SearchLqiiInfoBase(int i, int i2, int i3, RectFloat rectFloat, String str, ArrayList<String> arrayList) {
        this.isCurrentCity = i;
        this.isUserCity = i2;
        this.intentionType = i3;
        this.viewRegion = rectFloat;
        this.targetViewCity = str;
        this.queryTypeList = arrayList;
    }
}
