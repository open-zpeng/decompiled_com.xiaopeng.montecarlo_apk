package com.xiaopeng.montecarlo.scenes.mapscene;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class MapSceneEvent {
    private Bundle mEventData;
    private EventType mEventType;

    /* loaded from: classes2.dex */
    public enum EventType {
        ZOOM_IN,
        ZOOM_OUT,
        VOLUME,
        MAP_STATUS,
        SETTING,
        ROAD_CHANGE,
        SWITCH_OVER_VIEW,
        OPEN_OVER_VIEW,
        CLOSE_OVER_VIEW
    }

    public MapSceneEvent(EventType eventType, Bundle bundle) {
        this.mEventData = new Bundle();
        this.mEventType = eventType;
        this.mEventData = bundle;
    }

    public MapSceneEvent(EventType eventType) {
        this.mEventData = new Bundle();
        this.mEventType = eventType;
    }

    public EventType getEventType() {
        return this.mEventType;
    }

    public Bundle getEventData() {
        return this.mEventData;
    }
}
