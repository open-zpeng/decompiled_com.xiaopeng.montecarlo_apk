package com.autonavi.gbl.activation.observer.impl;

import com.autonavi.gbl.activation.model.AuthenticationGoodsInfo;
import com.autonavi.gbl.activation.model.AuthenticationResult;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ActivationObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IAuthenticationObserverImpl_onStatusUpdated(IAuthenticationObserverImpl iAuthenticationObserverImpl, int i, ArrayList<AuthenticationGoodsInfo> arrayList) {
        iAuthenticationObserverImpl.onStatusUpdated(i, arrayList);
    }

    public static void SwigDirector_IAuthenticationObserverImpl_onError(IAuthenticationObserverImpl iAuthenticationObserverImpl, AuthenticationResult authenticationResult) {
        iAuthenticationObserverImpl.onError(authenticationResult);
    }

    public static void SwigDirector_INetActivateObserverImpl_onNetActivateResponse(INetActivateObserverImpl iNetActivateObserverImpl, int i) {
        iNetActivateObserverImpl.onNetActivateResponse(i);
    }
}
