package com.autonavi.gbl.ehp.observer.impl;
/* loaded from: classes.dex */
public class EhpObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IEHPOutputObserverImpl_output(IEHPOutputObserverImpl iEHPOutputObserverImpl, String str, byte[] bArr) {
        iEHPOutputObserverImpl.output(str, bArr);
    }

    public static void SwigDirector_IGEhpAdasDataCallbackImpl_adasDataResponse(IGEhpAdasDataCallbackImpl iGEhpAdasDataCallbackImpl, String str) {
        iGEhpAdasDataCallbackImpl.adasDataResponse(str);
    }

    public static void SwigDirector_IEHPHdDataVersionObserverImpl_onHdDataVersion(IEHPHdDataVersionObserverImpl iEHPHdDataVersionObserverImpl, String str) {
        iEHPHdDataVersionObserverImpl.onHdDataVersion(str);
    }
}
