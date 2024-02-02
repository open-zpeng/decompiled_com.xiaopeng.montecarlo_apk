package com.autonavi.gbl.user.behavior.observer.impl;

import com.autonavi.gbl.user.behavior.model.FavoriteType;
import com.autonavi.gbl.user.behavior.model.SimpleFavoriteItem;
import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BehaviorObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IBehaviorServiceObserverImpl_notify__SWIG_0(IBehaviorServiceObserverImpl iBehaviorServiceObserverImpl, @SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2) {
        iBehaviorServiceObserverImpl.notify(i, i2);
    }

    public static void SwigDirector_IBehaviorServiceObserverImpl_notify__SWIG_1(IBehaviorServiceObserverImpl iBehaviorServiceObserverImpl, @FavoriteType.FavoriteType1 int i, ArrayList<SimpleFavoriteItem> arrayList, boolean z) {
        iBehaviorServiceObserverImpl.notify(i, arrayList, z);
    }
}
