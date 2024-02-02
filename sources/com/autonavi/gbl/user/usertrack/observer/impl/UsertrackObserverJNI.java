package com.autonavi.gbl.user.usertrack.observer.impl;

import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
import com.autonavi.gbl.user.usertrack.model.GpsTrackDepthInfo;
import com.autonavi.gbl.user.usertrack.model.GpsTrackPoint;
/* loaded from: classes2.dex */
public class UsertrackObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static GpsTrackPoint SwigDirector_IGpsInfoGetterImpl_getGpsTrackPoint(IGpsInfoGetterImpl iGpsInfoGetterImpl) {
        return iGpsInfoGetterImpl.getGpsTrackPoint();
    }

    public static void SwigDirector_IUserTrackObserverImpl_onStartGpsTrack(IUserTrackObserverImpl iUserTrackObserverImpl, int i, String str, String str2) {
        iUserTrackObserverImpl.onStartGpsTrack(i, str, str2);
    }

    public static void SwigDirector_IUserTrackObserverImpl_onCloseGpsTrack(IUserTrackObserverImpl iUserTrackObserverImpl, int i, String str, String str2, GpsTrackDepthInfo gpsTrackDepthInfo) {
        iUserTrackObserverImpl.onCloseGpsTrack(i, str, str2, gpsTrackDepthInfo);
    }

    public static void SwigDirector_IUserTrackObserverImpl_onGpsTrackDepInfo(IUserTrackObserverImpl iUserTrackObserverImpl, int i, String str, String str2, GpsTrackDepthInfo gpsTrackDepthInfo) {
        iUserTrackObserverImpl.onGpsTrackDepInfo(i, str, str2, gpsTrackDepthInfo);
    }

    public static void SwigDirector_IUserTrackObserverImpl_notify(IUserTrackObserverImpl iUserTrackObserverImpl, @SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2) {
        iUserTrackObserverImpl.notify(i, i2);
    }
}
