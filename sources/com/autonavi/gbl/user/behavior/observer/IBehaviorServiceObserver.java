package com.autonavi.gbl.user.behavior.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.user.behavior.model.FavoriteType;
import com.autonavi.gbl.user.behavior.model.SimpleFavoriteItem;
import com.autonavi.gbl.user.router.BehaviorServiceObserverRouter;
import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
import java.util.ArrayList;
@IntfAuto(target = BehaviorServiceObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IBehaviorServiceObserver {
    void notify(@SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2);

    void notify(@FavoriteType.FavoriteType1 int i, ArrayList<SimpleFavoriteItem> arrayList, boolean z);
}
