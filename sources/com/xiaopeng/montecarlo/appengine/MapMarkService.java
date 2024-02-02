package com.xiaopeng.montecarlo.appengine;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public class MapMarkService implements IServicePublisher {
    private static final L.Tag TAG = new L.Tag("MapMarkService");
    private static final Map<Integer, MutableLiveData<List<MarkPoint>>> sPointMap = new HashMap();

    static {
        sPointMap.put(1, new MutableLiveData<>());
    }

    public static void observerMarkPoint(@NonNull final LifecycleOwner lifecycleOwner, final Observer<List<MarkPoint>> observer) {
        final ArrayList arrayList = new ArrayList();
        final LifecycleObserver lifecycleObserver = new LifecycleObserver() { // from class: com.xiaopeng.montecarlo.appengine.MapMarkService.1
            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            void resume() {
                Observer.this.onChanged(arrayList);
                lifecycleOwner.getLifecycle().removeObserver(this);
            }
        };
        for (final Map.Entry<Integer, MutableLiveData<List<MarkPoint>>> entry : sPointMap.entrySet()) {
            entry.getValue().observe(lifecycleOwner, new Observer() { // from class: com.xiaopeng.montecarlo.appengine.-$$Lambda$MapMarkService$NqXSAmHBERthUv74fqfJO0X2ABA
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MapMarkService.lambda$observerMarkPoint$0(arrayList, entry, lifecycleOwner, observer, lifecycleObserver, (List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$observerMarkPoint$0(List list, Map.Entry entry, @NonNull LifecycleOwner lifecycleOwner, Observer observer, LifecycleObserver lifecycleObserver, List list2) {
        if (list2 == null) {
            L.e(TAG, "observerMarkPoint points is null");
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((Integer) entry.getKey()).intValue() == ((MarkPoint) list.get(size)).mType) {
                list.remove(size);
            }
        }
        if (!list2.isEmpty()) {
            list.addAll(list2);
        }
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
            observer.onChanged(list);
        } else {
            lifecycleOwner.getLifecycle().addObserver(lifecycleObserver);
        }
    }

    @Publish
    public void drawMark(int i, String str, double d, double d2, double d3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MarkPoint(i, str, 0, d, d2, d3));
        postValue(i, arrayList);
    }

    @Publish
    public void clearMark(int i) {
        postValue(i, new ArrayList());
    }

    @Publish
    public void drawMarks(int i, String str) {
        postValue(i, (List) GsonUtil.fromJson(str, new TypeToken<List<MarkPoint>>() { // from class: com.xiaopeng.montecarlo.appengine.MapMarkService.2
        }.getType()));
    }

    private void postValue(int i, List<MarkPoint> list) {
        if (list == null) {
            L.Tag tag = TAG;
            L.e(tag, "postValue markPoints == null , type = " + i);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "postValue markPoints = " + list.toString());
        }
        MutableLiveData<List<MarkPoint>> livePoints = getLivePoints(i);
        if (livePoints != null) {
            livePoints.postValue(list);
        }
    }

    private MutableLiveData<List<MarkPoint>> getLivePoints(int i) {
        if (sPointMap.containsKey(Integer.valueOf(i))) {
            return sPointMap.get(Integer.valueOf(i));
        }
        L.Tag tag = TAG;
        L.e(tag, "getLivePoints == null , type = " + i);
        return null;
    }

    /* loaded from: classes2.dex */
    public static class MarkPoint {
        public static final String TYPE_GCJ02 = "gcj02";
        public static final String TYPE_WGS84 = "wgs84";
        private String mCoordinateType;
        private int mId;
        private double mLat;
        private double mLon;
        private int mType;
        private double mZ;

        public MarkPoint(int i, String str, int i2, double d, double d2, double d3) {
            this.mType = i;
            this.mCoordinateType = str;
            this.mId = i2;
            this.mLon = d;
            this.mLat = d2;
            this.mZ = d3;
        }

        public void setType(int i) {
            this.mType = i;
        }

        public void setCoordinateType(String str) {
            this.mCoordinateType = str;
        }

        public void setId(int i) {
            this.mId = i;
        }

        public void setLon(double d) {
            this.mLon = d;
        }

        public void setLat(double d) {
            this.mLat = d;
        }

        public void setZ(double d) {
            this.mZ = d;
        }

        public int getId() {
            return this.mId;
        }

        public int getType() {
            return this.mType;
        }

        public String getCoordinateType() {
            return this.mCoordinateType;
        }

        public double getLon() {
            return this.mLon;
        }

        public double getLat() {
            return this.mLat;
        }

        public double getZ() {
            return this.mZ;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MarkPoint markPoint = (MarkPoint) obj;
            return this.mType == markPoint.mType && this.mId == markPoint.mId;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.mType), Integer.valueOf(this.mId));
        }

        public String toString() {
            return "{\"mType\":" + this.mType + "\"mCoordinateType\":" + this.mCoordinateType + ",\"mId\":" + this.mId + ",\"mLon\":" + this.mLon + ",\"mLat\":" + this.mLat + ",\"mZ\":" + this.mZ + '}';
        }
    }
}
