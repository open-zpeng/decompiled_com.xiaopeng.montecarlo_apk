package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.model.IntersectThresholdType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.UIRectRecord;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.router.CollisionGroupRouter;
import java.util.ArrayList;
@IntfAuto(target = CollisionGroupRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICollisionGroup extends ICollisionEntity {
    default void applyItemsOnVisible() {
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    default void caculateCollision() {
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    default void enableAreaCollision(boolean z) {
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    default void enableCollision(boolean z) {
    }

    float getIntersectAreaThreshold();

    float getIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i);

    LayerPriority getPriority();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    @CollisionType.CollisionType1
    int getType();

    boolean hasAppliedItemsOnVisible();

    default void intersectUI(ArrayList<UIRectRecord> arrayList) {
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    boolean isAreaCollision();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    boolean isCollision();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    default void lockItems() {
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    default void resetNextPair() {
    }

    default void setApplyItemsOnVisible(boolean z) {
    }

    default void setIntersectAreaThreshold(float f) {
    }

    default void setIntersectThreshold(@IntersectThresholdType.IntersectThresholdType1 int i, float f) {
    }

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    boolean testIntersect(ICollisionItem iCollisionItem);

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    default void unLockItems() {
    }

    default void updateQuadrantItems() {
    }
}
