package com.autonavi.gbl.recorder.observer.impl;

import com.autonavi.gbl.recorder.model.PlayProgress;
/* loaded from: classes2.dex */
public class RecorderObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IPlayerObserverImpl_onPlayProgress(IPlayerObserverImpl iPlayerObserverImpl, PlayProgress playProgress) {
        iPlayerObserverImpl.onPlayProgress(playProgress);
    }
}
