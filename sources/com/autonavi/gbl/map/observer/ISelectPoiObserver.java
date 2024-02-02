package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.SelectOutInfo;
import com.autonavi.gbl.map.router.SelectPoiObserverRouter;
@IntfAuto(target = SelectPoiObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ISelectPoiObserver {
    void onSelectPoiOut(long j, SelectOutInfo selectOutInfo);
}
