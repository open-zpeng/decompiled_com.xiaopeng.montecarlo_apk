package com.xiaopeng.montecarlo.scenes.mapscene;

import android.app.Application;
import androidx.annotation.Nullable;
import com.autonavi.gbl.map.adapter.MapSurfaceView;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MiniMapViewWrapper;
import com.xiaopeng.montecarlo.root.network.IXPNetworkListener;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.util.XpCacheConsts;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class MapDisplayManager {
    private static final int TRAFFIC_OFFLINE_CACHE_TIME = 120000;
    private static final L.Tag TAG = new L.Tag("MapDspManager");
    private static MapDisplayManager sInstance = new MapDisplayManager();
    private HashMap<String, MapViewWrapper> mMapViewControlMap = new HashMap<>();
    @Nullable
    private IXPNetworkListener mNetworkStateListener = new IXPNetworkListener() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapDisplayManager.1
        @Override // com.xiaopeng.montecarlo.root.network.IXPNetworkListener
        public void onNetworkChanged(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
            if (MapDisplayManager.this.mMapViewControlMap.isEmpty()) {
                return;
            }
            if (z) {
                MapDisplayManager.this.setMapViewWrapperTrafficState(true);
                MapDisplayManager.this.mTimer.pause();
                return;
            }
            MapDisplayManager.this.mTimer.reset();
        }
    };
    private XCountDownTimer.ITimerCallback mTimerListener = new XCountDownTimer.ITimerCallback() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapDisplayManager.2
        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTick(long j) {
        }

        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTimeOut() {
            MapDisplayManager.this.setMapViewWrapperTrafficState(false);
        }
    };
    private XCountDownTimer mTimer = new XCountDownTimer(XpCacheConsts.MAX_DISTANCE_FOR_HOME_COMUTTING_FORECAST, this.mTimerListener);

    private MapDisplayManager() {
        registerNetworkConnectChangeReceiver();
    }

    public static MapDisplayManager getInstance() {
        return sInstance;
    }

    private String getWrapperId(int i) {
        return String.valueOf(i);
    }

    public MapViewWrapper getMapViewControl(int i) {
        return this.mMapViewControlMap.get(getWrapperId(i));
    }

    public MapViewWrapper createMapEngineWrapper(Application application, MapSurfaceView mapSurfaceView, int i, int i2, IMapListener iMapListener, int i3, int i4) {
        String valueOf = String.valueOf(i4);
        MapViewWrapper mapViewWrapper = this.mMapViewControlMap.get(valueOf);
        if (mapViewWrapper == null) {
            mapViewWrapper = new MapViewWrapper();
            this.mMapViewControlMap.put(valueOf, mapViewWrapper);
        }
        mapViewWrapper.bindMapSurfaceView(application, mapSurfaceView, i, i2, iMapListener, i3, null);
        return mapViewWrapper;
    }

    public MapViewWrapper createMiniMapEngineWrapper(Application application, MapSurfaceView mapSurfaceView, int i, int i2, IMapListener iMapListener, int i3, int i4, MapViewWrapper.IXPMapSurfaceListener iXPMapSurfaceListener) {
        String valueOf = String.valueOf(i4);
        MapViewWrapper mapViewWrapper = this.mMapViewControlMap.get(valueOf);
        if (mapViewWrapper == null) {
            mapViewWrapper = new MiniMapViewWrapper();
            this.mMapViewControlMap.put(valueOf, mapViewWrapper);
        }
        mapViewWrapper.bindMapSurfaceView(application, mapSurfaceView, i, i2, iMapListener, i3, iXPMapSurfaceListener);
        return mapViewWrapper;
    }

    public void unbindMapSurfaceView(MapSurfaceView mapSurfaceView, int i) {
        MapViewWrapper mapViewControl = getMapViewControl(i);
        if (mapViewControl != null) {
            mapViewControl.unInitMapView(mapSurfaceView);
        }
    }

    public void destroyMapEngine(int i) {
        String wrapperId = getWrapperId(i);
        this.mMapViewControlMap.remove(wrapperId);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "map wrapper instance removed, id: " + wrapperId);
        }
    }

    private void registerNetworkConnectChangeReceiver() {
        XPNetworkManager.INSTANCE.addNetworkListener(this.mNetworkStateListener);
    }

    private void unregisterNetworkConnectChangeReceiver() {
        XPNetworkManager.INSTANCE.removeNetworkListener(this.mNetworkStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMapViewWrapperTrafficState(boolean z) {
        for (MapViewWrapper mapViewWrapper : this.mMapViewControlMap.values()) {
            mapViewWrapper.updateTrafficEventLayerState();
        }
    }
}
