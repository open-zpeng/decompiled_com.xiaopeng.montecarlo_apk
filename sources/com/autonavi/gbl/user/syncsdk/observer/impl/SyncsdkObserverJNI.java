package com.autonavi.gbl.user.syncsdk.observer.impl;

import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
/* loaded from: classes2.dex */
public class SyncsdkObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_ISyncSDKServiceObserverImpl_notify(ISyncSDKServiceObserverImpl iSyncSDKServiceObserverImpl, @SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2) {
        iSyncSDKServiceObserverImpl.notify(i, i2);
    }
}
