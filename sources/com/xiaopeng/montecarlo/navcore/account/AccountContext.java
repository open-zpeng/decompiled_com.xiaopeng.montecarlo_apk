package com.xiaopeng.montecarlo.navcore.account;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord2DInt32;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate;
/* loaded from: classes2.dex */
public class AccountContext {
    private static AccountContext sInstance = new AccountContext();
    private IMapDelegate mMapDelegate;

    private AccountContext() {
    }

    public static AccountContext getInstance() {
        return sInstance;
    }

    public void setMapMode(int i) {
        IMapDelegate mapDelegate = getMapDelegate();
        if (mapDelegate != null) {
            mapDelegate.setMapMode(i);
        }
    }

    public void syncMapMode() {
        IMapDelegate mapDelegate = getMapDelegate();
        if (mapDelegate != null) {
            mapDelegate.syncMapMode();
        }
    }

    public Coord2DInt32 transLonLatToP20(double d, double d2) {
        IMapDelegate mapDelegate = getMapDelegate();
        if (mapDelegate != null) {
            return mapDelegate.transLonLatToP20(d, d2);
        }
        return null;
    }

    public Coord2DDouble transP20ToLonLat(int i, int i2) {
        IMapDelegate mapDelegate = getMapDelegate();
        if (mapDelegate != null) {
            return mapDelegate.transP20ToLonLat(i, i2);
        }
        return null;
    }

    private IMapDelegate getMapDelegate() {
        return this.mMapDelegate;
    }

    public void setMapDelegate(IMapDelegate iMapDelegate) {
        this.mMapDelegate = iMapDelegate;
    }
}
