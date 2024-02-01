package com.xiaopeng.montecarlo.scenes.mapscene;

import android.os.Bundle;
/* loaded from: classes3.dex */
public class SceneMapEvent {
    public static final int EVENT_LONGPRESS = 0;
    public static final int EVENT_MAP_CENTER_CHANGED = 0;
    public static final int EVENT_MAP_LEVEL_CHANGED = 1;
    public static final int EVENT_MOTION = 2;
    public static final int EVENT_MOVE = 3;

    /* loaded from: classes3.dex */
    public static class MapEvent {
        public Bundle data;
        public int type = -1;
    }

    /* loaded from: classes3.dex */
    public interface SceneMapListener {
        void onMapEvent(MapEvent mapEvent);
    }

    public static MapEvent obtainLongPress(long j, long j2) {
        Bundle bundle = new Bundle();
        bundle.putLong("px", j);
        bundle.putLong("py", j2);
        MapEvent mapEvent = new MapEvent();
        mapEvent.type = 0;
        mapEvent.data = bundle;
        return mapEvent;
    }

    public static MapEvent obtainMapCenterChanged(double d, double d2) {
        Bundle bundle = new Bundle();
        bundle.putDouble("px", d);
        bundle.putDouble("py", d2);
        MapEvent mapEvent = new MapEvent();
        mapEvent.type = 0;
        mapEvent.data = bundle;
        return mapEvent;
    }

    public static MapEvent obtainMapLevelChanged() {
        MapEvent mapEvent = new MapEvent();
        mapEvent.type = 1;
        return mapEvent;
    }

    public static MapEvent obtainMotion() {
        MapEvent mapEvent = new MapEvent();
        mapEvent.type = 2;
        return mapEvent;
    }

    public static MapEvent obtainMove() {
        MapEvent mapEvent = new MapEvent();
        mapEvent.type = 3;
        return mapEvent;
    }
}
