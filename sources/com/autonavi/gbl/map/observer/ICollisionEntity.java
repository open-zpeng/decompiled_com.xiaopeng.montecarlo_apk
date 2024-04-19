package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.router.CollisionEntityRouter;
@IntfAuto(target = CollisionEntityRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICollisionEntity {
    void caculateCollision();

    void enableAreaCollision(boolean z);

    @CollisionType.CollisionType1
    int getType();

    boolean isAreaCollision();

    void lockItems();

    void resetNextPair();

    boolean testIntersect(ICollisionItem iCollisionItem);

    void unLockItems();
}
