package com.autonavi.gbl.information.nearby.observer.impl;

import com.autonavi.gbl.information.nearby.model.NearbyRecommendResult;
/* loaded from: classes.dex */
public class InformationNearbyObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_INearbyRecommendObserverImpl_onResult(INearbyRecommendObserverImpl iNearbyRecommendObserverImpl, int i, NearbyRecommendResult nearbyRecommendResult) {
        iNearbyRecommendObserverImpl.onResult(i, nearbyRecommendResult);
    }
}
