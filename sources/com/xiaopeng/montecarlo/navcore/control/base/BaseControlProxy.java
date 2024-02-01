package com.xiaopeng.montecarlo.navcore.control.base;

import androidx.annotation.NonNull;
import com.autonavi.gbl.layer.BizControlService;
import com.autonavi.gbl.map.MapView;
import com.xiaopeng.montecarlo.navcore.IMapListener;
/* loaded from: classes3.dex */
public class BaseControlProxy {
    protected BizControlService mBizService;
    protected IMapListener mMapListener;
    protected MapView mMapView;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkMapViewValid() {
        return (this.mBizService == null || this.mMapView == null) ? false : true;
    }

    public void init(@NonNull BizControlService bizControlService, @NonNull MapView mapView, IMapListener iMapListener) {
        this.mBizService = bizControlService;
        this.mMapView = mapView;
        this.mMapListener = iMapListener;
    }

    public void unInit() {
        this.mBizService = null;
        this.mMapView = null;
        this.mMapListener = null;
    }
}
