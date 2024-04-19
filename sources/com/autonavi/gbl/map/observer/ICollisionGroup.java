package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.router.CollisionGroupRouter;
import java.util.ArrayList;
@IntfAuto(target = CollisionGroupRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICollisionGroup extends ICollisionEntity {
    void applyItemsOnVisible();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    void caculateCollision();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    void enableAreaCollision(boolean z);

    float getIntersectAreaThreshold();

    LayerPriority getPriority();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    @CollisionType.CollisionType1
    int getType();

    boolean hasAppliedItemsOnVisible();

    void intersectUI(ArrayList<RectDouble> arrayList);

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    boolean isAreaCollision();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    void lockItems();

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    void resetNextPair();

    void setApplyItemsOnVisible(boolean z);

    void setIntersectAreaThreshold(float f);

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    boolean testIntersect(ICollisionItem iCollisionItem);

    @Override // com.autonavi.gbl.map.observer.ICollisionEntity
    void unLockItems();

    void updateQuadrantItems();
}
