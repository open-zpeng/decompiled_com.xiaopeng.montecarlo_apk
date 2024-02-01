package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
/* loaded from: classes3.dex */
public class SearchFavouriteParam extends SearchRequestParam {
    private int mFavouriteType;
    private XPCoordinate2DDouble mLocation;

    public XPCoordinate2DDouble getLocation() {
        return this.mLocation;
    }

    public void setLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mLocation = xPCoordinate2DDouble;
    }

    public int getFavouriteType() {
        return this.mFavouriteType;
    }

    public void setFavouriteType(int i) {
        this.mFavouriteType = i;
    }
}
