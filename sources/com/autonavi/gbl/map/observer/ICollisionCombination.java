package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.CollisionCombination;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.router.CollisionCombinationRouter;
@IntfAuto(target = CollisionCombinationRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICollisionCombination extends ICollisionEntity {
    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    void caculateCollision();

    void clearAreaCollisionRecord();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    void enableAreaCollision(boolean z);

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    @CollisionType.CollisionType1
    int getType();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    boolean isAreaCollision();

    boolean isCollidedByFocusItem();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    void lockItems();

    void onRecoverCollisonItem(ICollisionItem iCollisionItem);

    void recoverAreaCollisionRecord(ICollisionItem iCollisionItem, CollisionCombination collisionCombination);

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    void resetNextPair();

    void setCollidedByFocusItem(boolean z);

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    boolean testIntersect(ICollisionItem iCollisionItem);

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    void unLockItems();
}
