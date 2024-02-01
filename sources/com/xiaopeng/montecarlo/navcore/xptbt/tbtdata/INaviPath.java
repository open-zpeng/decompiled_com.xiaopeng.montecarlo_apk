package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;
/* loaded from: classes3.dex */
public interface INaviPath {
    void createNaviPath(IPathResult iPathResult, RouteParams routeParams, int i);

    void createNaviPathPoint(RouteParams routeParams);

    int getNaviPathCount();

    long getPathId(int i);

    IVariantPath getVariantPath(long j);

    void recycle();

    void setNaviPathStrategy(int i);

    void setNaviPathType(int i);
}
