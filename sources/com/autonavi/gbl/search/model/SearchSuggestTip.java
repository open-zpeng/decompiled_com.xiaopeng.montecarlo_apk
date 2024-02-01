package com.autonavi.gbl.search.model;

import com.autonavi.gbl.search.model.SearchSuggestMark;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchSuggestTip extends SearchSuggestPoiBase implements Serializable {
    public int ignore_district = -1;
    public int citycode = -1;
    public int endPoiExtension = 0;
    public int childType = 0;
    public int sugPos = -1;
    public int sugLen = -1;
    public int u8CateCandiFlag = -1;
    @SearchSuggestMark.SearchSuggestMark1
    public int mark = 0;
    public String poi_tag = "";
    public String district = "";
    public String terminals = "";
    public String taginfo = "";
    public String parent = "";
    public String towardsAngle = "";
    public String floorNo = "";
    public String rich_rating = "";
    public String num_review = "";
    public double straightLineDistance = 0.0d;
    public SearchSuggestGasStation gasInfo = new SearchSuggestGasStation();
    public ArrayList<SearchSuggestPoiBase> childPois = new ArrayList<>();
}
