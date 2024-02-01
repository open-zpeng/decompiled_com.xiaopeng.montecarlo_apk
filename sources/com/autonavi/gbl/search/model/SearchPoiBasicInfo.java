package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.search.model.SearchPoiRecommendFlag;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPoiBasicInfo extends SearchBasicInfoBase implements Serializable {
    @SearchPoiRecommendFlag.SearchPoiRecommendFlag1
    public int recommendFlag = 0;
    public int displayIconNameState = 0;
    public int sales = 0;
    public int endPoiExtension = 0;
    public int childType = 0;
    public ArrayList<Coord2DDouble> entranceList = new ArrayList<>();
    public String dispName = "";
    public String districtName = "";
    public String industry = "";
    public String floorNo = "";
    public String towardsAngle = "";
    public String imageUrl = "";
    public String parentPoiId = "";
    public String parentName = "";
    public String businessArea = "";
    public String brand = "";
    public String tag = "";
    @Deprecated
    public ArrayList<Coord2DDouble> polygonBounds = new ArrayList<>();
    public ArrayList<ArrayList<Coord2DDouble>> poiAoiBounds = new ArrayList<>();
    public ArrayList<ArrayList<Coord2DDouble>> roadPolygonBounds = new ArrayList<>();
    public SearchPoiBrand poiBrand = new SearchPoiBrand();
}
