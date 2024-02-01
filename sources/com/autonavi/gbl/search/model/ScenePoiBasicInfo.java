package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ScenePoiBasicInfo extends SearchBasicInfoBase implements Serializable {
    public int sales = -1;
    public int endPoiExtension = 0;
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
}
