package com.xiaopeng.montecarlo.scenes.mapscene;
/* loaded from: classes2.dex */
public class MapStateObserver {
    private OnMapStateChangeListener mListener;

    /* loaded from: classes2.dex */
    public interface OnMapStateChangeListener {
        void notifyRefreshGifGuider();
    }

    public static MapStateObserver getInstance() {
        return SingletonHolder.sInstance;
    }

    /* loaded from: classes2.dex */
    private static class SingletonHolder {
        private static final MapStateObserver sInstance = new MapStateObserver();

        private SingletonHolder() {
        }
    }

    public synchronized void registerMapStateObserver(OnMapStateChangeListener onMapStateChangeListener) {
        this.mListener = onMapStateChangeListener;
    }

    public synchronized void unregisterMapStateObserver() {
        this.mListener = null;
    }

    public synchronized void notifyRefreshGifGuider() {
        if (this.mListener != null) {
            this.mListener.notifyRefreshGifGuider();
        }
    }
}
