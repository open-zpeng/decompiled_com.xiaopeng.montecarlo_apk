package com.xiaopeng.montecarlo.navcore;

import com.autonavi.gbl.map.model.GuideRoadNameBoardParam;
import com.autonavi.gbl.map.observer.IEGLScreenshotObserver;
import com.autonavi.gbl.map.observer.IMapGestureObserver;
import com.autonavi.gbl.map.observer.IMapviewObserver;
/* loaded from: classes2.dex */
public interface IMapListener extends IMapviewObserver, IMapGestureObserver, IEGLScreenshotObserver {
    void onCarOutOfScreen();

    void onFreeTrafficLayerStateUpdate(boolean z);

    @Override // com.autonavi.gbl.map.observer.IMapviewObserver
    default void onGuideRoadBoardNameProcessed(long j, GuideRoadNameBoardParam guideRoadNameBoardParam) {
    }

    void onMapFollowModeChanged(boolean z);
}
