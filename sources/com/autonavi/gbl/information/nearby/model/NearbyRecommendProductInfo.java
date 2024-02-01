package com.autonavi.gbl.information.nearby.model;

import com.autonavi.gbl.search.model.SearchProductInfoBase;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NearbyRecommendProductInfo extends SearchProductInfoBase implements Serializable {
    public ArrayList<String> images = new ArrayList<>();
    public int sales = 0;
}
