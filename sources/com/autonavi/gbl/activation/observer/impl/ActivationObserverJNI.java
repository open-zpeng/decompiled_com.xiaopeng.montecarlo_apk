package com.autonavi.gbl.activation.observer.impl;

import com.autonavi.gbl.activation.model.ActivateErrorCode;
/* loaded from: classes.dex */
public class ActivationObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_INetActivateObserverImpl_onNetActivateResponse(INetActivateObserverImpl iNetActivateObserverImpl, @ActivateErrorCode.ActivateErrorCode1 int i) {
        iNetActivateObserverImpl.onNetActivateResponse(i);
    }
}
