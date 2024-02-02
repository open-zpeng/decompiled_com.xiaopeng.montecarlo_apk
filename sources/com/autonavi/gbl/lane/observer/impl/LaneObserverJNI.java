package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.gbl.lane.model.AnchorScaleTime;
import com.autonavi.gbl.lane.model.LanePositionStatus;
/* loaded from: classes.dex */
public class LaneObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_ILaneObserverImpl_onAnchorScaleChange(ILaneObserverImpl iLaneObserverImpl, @AnchorScaleTime.AnchorScaleTime1 int i) {
        iLaneObserverImpl.onAnchorScaleChange(i);
    }

    public static void SwigDirector_ILaneObserverImpl_onLanePositionStatus(ILaneObserverImpl iLaneObserverImpl, @LanePositionStatus.LanePositionStatus1 int i) {
        iLaneObserverImpl.onLanePositionStatus(i);
    }

    public static void SwigDirector_ILaneObserverImpl_onLaneLndsDataDistance(ILaneObserverImpl iLaneObserverImpl, float f) {
        iLaneObserverImpl.onLaneLndsDataDistance(f);
    }
}
