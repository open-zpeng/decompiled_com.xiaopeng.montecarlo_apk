package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SceneSearchParam implements Serializable {
    public SearchClassifyParam classifyParam;
    public String dataType;
    public String keywords;
    public SearchPageParam pageParam;
    public String uid;
    public String userCity;
    public Coord2DDouble userLoc;

    public SceneSearchParam() {
        this.keywords = "";
        this.userLoc = new Coord2DDouble();
        this.userCity = "";
        this.dataType = "poi";
        this.uid = "";
        this.pageParam = new SearchPageParam();
        this.classifyParam = new SearchClassifyParam();
    }

    public SceneSearchParam(String str, Coord2DDouble coord2DDouble, String str2, String str3, String str4, SearchPageParam searchPageParam, SearchClassifyParam searchClassifyParam) {
        this.keywords = str;
        this.userLoc = coord2DDouble;
        this.userCity = str2;
        this.dataType = str3;
        this.uid = str4;
        this.pageParam = searchPageParam;
        this.classifyParam = searchClassifyParam;
    }
}
