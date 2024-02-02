package com.autonavi.gbl.user.usertrack.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.user.router.UserTrackObserverRouter;
import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
import com.autonavi.gbl.user.usertrack.model.GpsTrackDepthInfo;
@IntfAuto(target = UserTrackObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IUserTrackObserver {
    void notify(@SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2);

    void onCloseGpsTrack(int i, String str, String str2, GpsTrackDepthInfo gpsTrackDepthInfo);

    void onGpsTrackDepInfo(int i, String str, String str2, GpsTrackDepthInfo gpsTrackDepthInfo);

    void onStartGpsTrack(int i, String str, String str2);
}
