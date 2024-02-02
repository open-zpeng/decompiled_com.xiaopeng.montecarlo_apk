package com.xiaopeng.montecarlo.scenes.mapscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
/* loaded from: classes2.dex */
public class MapStatus {
    private XPCoordinate2DDouble mCarLocation;
    private int mHeight;
    private int mLevel;
    private int mWidth;

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public XPCoordinate2DDouble getCarLocation() {
        return this.mCarLocation;
    }

    public void setCarLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mCarLocation = xPCoordinate2DDouble;
    }
}
