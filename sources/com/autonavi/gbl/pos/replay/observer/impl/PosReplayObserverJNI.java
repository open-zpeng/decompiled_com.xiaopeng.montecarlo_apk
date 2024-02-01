package com.autonavi.gbl.pos.replay.observer.impl;

import com.autonavi.gbl.pos.model.LocSignData;
import com.autonavi.gbl.pos.replay.model.PosReplayStatus;
/* loaded from: classes2.dex */
public class PosReplayObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IPosReplayObserverImpl_onLocSignDataUpdate(IPosReplayObserverImpl iPosReplayObserverImpl, LocSignData locSignData) {
        iPosReplayObserverImpl.onLocSignDataUpdate(locSignData);
    }

    public static void SwigDirector_IPosReplayObserverImpl_onGpsReplayStatusUpdate(IPosReplayObserverImpl iPosReplayObserverImpl, @PosReplayStatus.PosReplayStatus1 int i) {
        iPosReplayObserverImpl.onGpsReplayStatusUpdate(i);
    }
}
