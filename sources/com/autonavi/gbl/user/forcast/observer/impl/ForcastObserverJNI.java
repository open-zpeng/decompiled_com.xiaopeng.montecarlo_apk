package com.autonavi.gbl.user.forcast.observer.impl;

import com.autonavi.gbl.user.forcast.model.ForcastArrivedData;
import com.autonavi.gbl.util.model.ErrorCode;
/* loaded from: classes2.dex */
public class ForcastObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IForcastServiceObserverImpl_onInit(IForcastServiceObserverImpl iForcastServiceObserverImpl, @ErrorCode.ErrorCode1 int i) {
        iForcastServiceObserverImpl.onInit(i);
    }

    public static void SwigDirector_IForcastServiceObserverImpl_onSetLoginInfo(IForcastServiceObserverImpl iForcastServiceObserverImpl, @ErrorCode.ErrorCode1 int i) {
        iForcastServiceObserverImpl.onSetLoginInfo(i);
    }

    public static void SwigDirector_IForcastServiceObserverImpl_onForcastArrivedData(IForcastServiceObserverImpl iForcastServiceObserverImpl, ForcastArrivedData forcastArrivedData) {
        iForcastServiceObserverImpl.onForcastArrivedData(forcastArrivedData);
    }
}
