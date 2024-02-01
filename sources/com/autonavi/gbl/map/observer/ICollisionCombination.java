package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.CollisionCombination;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.router.CollisionCombinationRouter;
@IntfAuto(target = CollisionCombinationRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICollisionCombination extends ICollisionEntity {
    default void applyItemsOnVisible() {
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    default void caculateCollision() {
    }

    @Deprecated
    default void clearAreaCollisionRecord() {
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    default void enableAreaCollision(boolean z) {
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    default void enableCollision(boolean z) {
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    @CollisionType.CollisionType1
    int getType();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    boolean isAreaCollision();

    boolean isCollidedByFocusItem();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    boolean isCollision();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    default void lockItems() {
    }

    @Deprecated
    default void onRecoverCollisonItem(ICollisionItem iCollisionItem) {
    }

    @Deprecated
    default void recoverAreaCollisionRecord(ICollisionItem iCollisionItem, CollisionCombination collisionCombination) {
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    default void resetNextPair() {
    }

    default void setCollidedByFocusItem(boolean z) {
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    boolean testIntersect(ICollisionItem iCollisionItem);

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    default void unLockItems() {
    }
}
