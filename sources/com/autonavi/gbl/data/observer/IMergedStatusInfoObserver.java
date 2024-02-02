package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.MergedStatusInfo;
import com.autonavi.gbl.data.router.MergedStatusInfoObserverRouter;
@IntfAuto(target = MergedStatusInfoObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IMergedStatusInfoObserver {
    void onMergedStatusInfo(MergedStatusInfo mergedStatusInfo);
}
