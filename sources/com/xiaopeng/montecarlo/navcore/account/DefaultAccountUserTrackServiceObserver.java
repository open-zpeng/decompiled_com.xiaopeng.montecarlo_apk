package com.xiaopeng.montecarlo.navcore.account;

import com.autonavi.gbl.user.usertrack.model.GpsTrackDepthInfo;
import com.autonavi.gbl.user.usertrack.observer.IUserTrackObserver;
/* loaded from: classes2.dex */
public class DefaultAccountUserTrackServiceObserver implements IUserTrackObserver {
    @Override // com.autonavi.gbl.user.usertrack.observer.IUserTrackObserver
    public void notify(int i, int i2) {
    }

    @Override // com.autonavi.gbl.user.usertrack.observer.IUserTrackObserver
    public void onCloseGpsTrack(int i, String str, String str2, GpsTrackDepthInfo gpsTrackDepthInfo) {
    }

    @Override // com.autonavi.gbl.user.usertrack.observer.IUserTrackObserver
    public void onGpsTrackDepInfo(int i, String str, String str2, GpsTrackDepthInfo gpsTrackDepthInfo) {
    }

    @Override // com.autonavi.gbl.user.usertrack.observer.IUserTrackObserver
    public void onStartGpsTrack(int i, String str, String str2) {
    }
}
