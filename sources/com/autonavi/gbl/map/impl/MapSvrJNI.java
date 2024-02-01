package com.autonavi.gbl.map.impl;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.map.layer.model.IntersectThresholdType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.UIRectRecord;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.model.DAY_STATUS;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.util.model.DateTime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class MapSvrJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static boolean SwigDirector_IDayStatusListenerImpl_onDayStatus(IDayStatusListenerImpl iDayStatusListenerImpl, @DAY_STATUS.DAY_STATUS1 int i) {
        return iDayStatusListenerImpl.onDayStatus(i);
    }

    public static Coord2DDouble SwigDirector_IDayStatusSystemUtilImpl_getLonLat(IDayStatusSystemUtilImpl iDayStatusSystemUtilImpl) {
        return iDayStatusSystemUtilImpl.getLonLat();
    }

    public static boolean SwigDirector_IDayStatusSystemUtilImpl_getDateTime(IDayStatusSystemUtilImpl iDayStatusSystemUtilImpl, DateTime dateTime) {
        return iDayStatusSystemUtilImpl.getDateTime(dateTime);
    }

    public static void SwigDirector_CollisionItemImpl_resetOnVisible(CollisionItemImpl collisionItemImpl, boolean z) {
        collisionItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_CollisionItemImpl_onVisible(CollisionItemImpl collisionItemImpl, boolean z) {
        collisionItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_CollisionItemImpl_getOnVisible(CollisionItemImpl collisionItemImpl) {
        return collisionItemImpl.getOnVisible();
    }

    public static void SwigDirector_CollisionItemImpl_applyOnVisible(CollisionItemImpl collisionItemImpl) {
        collisionItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_CollisionItemImpl_getBound(CollisionItemImpl collisionItemImpl) {
        return collisionItemImpl.getBound();
    }

    public static boolean SwigDirector_CollisionItemImpl_getVisible(CollisionItemImpl collisionItemImpl) {
        return collisionItemImpl.getVisible();
    }

    public static int SwigDirector_CollisionItemImpl_getPriority(CollisionItemImpl collisionItemImpl) {
        return collisionItemImpl.getPriority();
    }

    public static boolean SwigDirector_CollisionItemImpl_isAreaCollision(CollisionItemImpl collisionItemImpl) {
        return collisionItemImpl.isAreaCollision();
    }

    public static void SwigDirector_CollisionItemImpl_setAreaCollision(CollisionItemImpl collisionItemImpl, boolean z) {
        collisionItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_CollisionItemImpl_canCollision(CollisionItemImpl collisionItemImpl) {
        return collisionItemImpl.canCollision();
    }

    public static boolean SwigDirector_CollisionItemImpl_canAreaCollision(CollisionItemImpl collisionItemImpl) {
        return collisionItemImpl.canAreaCollision();
    }

    public static void SwigDirector_ICollisonRemoveObseverImpl_removeCollisionItems(ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl, ArrayList<CollisionItemImpl> arrayList) {
        iCollisonRemoveObseverImpl.removeCollisionItems(arrayList);
    }

    public static void SwigDirector_ICollisonRemoveObseverImpl_onRecoverCollisonItem(ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl, CollisionItemImpl collisionItemImpl) {
        iCollisonRemoveObseverImpl.onRecoverCollisonItem(collisionItemImpl);
    }

    public static void SwigDirector_CollisionEntityImpl_resetNextPair(CollisionEntityImpl collisionEntityImpl) {
        collisionEntityImpl.resetNextPair();
    }

    public static boolean SwigDirector_CollisionEntityImpl_testIntersect(CollisionEntityImpl collisionEntityImpl, CollisionItemImpl collisionItemImpl) {
        return collisionEntityImpl.testIntersect(collisionItemImpl);
    }

    @CollisionType.CollisionType1
    public static int SwigDirector_CollisionEntityImpl_getType(CollisionEntityImpl collisionEntityImpl) {
        return collisionEntityImpl.getType();
    }

    public static void SwigDirector_CollisionEntityImpl_enableAreaCollision(CollisionEntityImpl collisionEntityImpl, boolean z) {
        collisionEntityImpl.enableAreaCollision(z);
    }

    public static boolean SwigDirector_CollisionEntityImpl_isAreaCollision(CollisionEntityImpl collisionEntityImpl) {
        return collisionEntityImpl.isAreaCollision();
    }

    public static void SwigDirector_CollisionEntityImpl_enableCollision(CollisionEntityImpl collisionEntityImpl, boolean z) {
        collisionEntityImpl.enableCollision(z);
    }

    public static boolean SwigDirector_CollisionEntityImpl_isCollision(CollisionEntityImpl collisionEntityImpl) {
        return collisionEntityImpl.isCollision();
    }

    public static void SwigDirector_CollisionEntityImpl_lockItems(CollisionEntityImpl collisionEntityImpl) {
        collisionEntityImpl.lockItems();
    }

    public static void SwigDirector_CollisionEntityImpl_unLockItems(CollisionEntityImpl collisionEntityImpl) {
        collisionEntityImpl.unLockItems();
    }

    public static void SwigDirector_CollisionEntityImpl_caculateCollision(CollisionEntityImpl collisionEntityImpl) {
        collisionEntityImpl.caculateCollision();
    }

    public static void SwigDirector_CollisionGroupImpl_resetNextPair(CollisionGroupImpl collisionGroupImpl) {
        collisionGroupImpl.resetNextPair();
    }

    public static boolean SwigDirector_CollisionGroupImpl_testIntersect(CollisionGroupImpl collisionGroupImpl, CollisionItemImpl collisionItemImpl) {
        return collisionGroupImpl.testIntersect(collisionItemImpl);
    }

    @CollisionType.CollisionType1
    public static int SwigDirector_CollisionGroupImpl_getType(CollisionGroupImpl collisionGroupImpl) {
        return collisionGroupImpl.getType();
    }

    public static void SwigDirector_CollisionGroupImpl_enableAreaCollision(CollisionGroupImpl collisionGroupImpl, boolean z) {
        collisionGroupImpl.enableAreaCollision(z);
    }

    public static boolean SwigDirector_CollisionGroupImpl_isAreaCollision(CollisionGroupImpl collisionGroupImpl) {
        return collisionGroupImpl.isAreaCollision();
    }

    public static void SwigDirector_CollisionGroupImpl_enableCollision(CollisionGroupImpl collisionGroupImpl, boolean z) {
        collisionGroupImpl.enableCollision(z);
    }

    public static boolean SwigDirector_CollisionGroupImpl_isCollision(CollisionGroupImpl collisionGroupImpl) {
        return collisionGroupImpl.isCollision();
    }

    public static void SwigDirector_CollisionGroupImpl_lockItems(CollisionGroupImpl collisionGroupImpl) {
        collisionGroupImpl.lockItems();
    }

    public static void SwigDirector_CollisionGroupImpl_unLockItems(CollisionGroupImpl collisionGroupImpl) {
        collisionGroupImpl.unLockItems();
    }

    public static void SwigDirector_CollisionGroupImpl_caculateCollision(CollisionGroupImpl collisionGroupImpl) {
        collisionGroupImpl.caculateCollision();
    }

    public static void SwigDirector_CollisionGroupImpl_intersectUI(CollisionGroupImpl collisionGroupImpl, ArrayList<UIRectRecord> arrayList) {
        collisionGroupImpl.intersectUI(arrayList);
    }

    public static boolean SwigDirector_CollisionGroupImpl_addCollisionItem(CollisionGroupImpl collisionGroupImpl, CollisionItemImpl collisionItemImpl) {
        return collisionGroupImpl.addCollisionItem(collisionItemImpl);
    }

    public static boolean SwigDirector_CollisionGroupImpl_removeCollisionItem(CollisionGroupImpl collisionGroupImpl, CollisionItemImpl collisionItemImpl) {
        return collisionGroupImpl.removeCollisionItem(collisionItemImpl);
    }

    public static void SwigDirector_CollisionGroupImpl_clearAllCollisionItems(CollisionGroupImpl collisionGroupImpl) {
        collisionGroupImpl.clearAllCollisionItems();
    }

    public static long[] SwigDirector_CollisionGroupImpl_getCollisionItems(CollisionGroupImpl collisionGroupImpl) {
        ArrayList<CollisionItemImpl> collisionItems = collisionGroupImpl.getCollisionItems();
        if (collisionItems != null) {
            int size = collisionItems.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = CollisionItemImpl.getCPtr(collisionItems.get(i));
            }
            return jArr;
        }
        return null;
    }

    public static void SwigDirector_CollisionGroupImpl_setIntersectAreaThreshold(CollisionGroupImpl collisionGroupImpl, float f) {
        collisionGroupImpl.setIntersectAreaThreshold(f);
    }

    public static float SwigDirector_CollisionGroupImpl_getIntersectAreaThreshold(CollisionGroupImpl collisionGroupImpl) {
        return collisionGroupImpl.getIntersectAreaThreshold();
    }

    public static void SwigDirector_CollisionGroupImpl_setIntersectThreshold(CollisionGroupImpl collisionGroupImpl, @IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        collisionGroupImpl.setIntersectThreshold(i, f);
    }

    public static float SwigDirector_CollisionGroupImpl_getIntersectThreshold(CollisionGroupImpl collisionGroupImpl, @IntersectThresholdType.IntersectThresholdType1 int i) {
        return collisionGroupImpl.getIntersectThreshold(i);
    }

    public static void SwigDirector_CollisionGroupImpl_updateQuadrantItems(CollisionGroupImpl collisionGroupImpl) {
        collisionGroupImpl.updateQuadrantItems();
    }

    public static void SwigDirector_CollisionGroupImpl_getPriority(CollisionGroupImpl collisionGroupImpl, LayerPriority layerPriority) {
        collisionGroupImpl.getPriority(layerPriority);
    }

    public static void SwigDirector_CollisionGroupImpl_applyItemsOnVisible(CollisionGroupImpl collisionGroupImpl) {
        collisionGroupImpl.applyItemsOnVisible();
    }

    public static void SwigDirector_CollisionGroupImpl_setApplyItemsOnVisible(CollisionGroupImpl collisionGroupImpl, boolean z) {
        collisionGroupImpl.setApplyItemsOnVisible(z);
    }

    public static boolean SwigDirector_CollisionGroupImpl_hasAppliedItemsOnVisible(CollisionGroupImpl collisionGroupImpl) {
        return collisionGroupImpl.hasAppliedItemsOnVisible();
    }

    public static void SwigDirector_CollisionCombinationImpl_resetNextPair(CollisionCombinationImpl collisionCombinationImpl) {
        collisionCombinationImpl.resetNextPair();
    }

    public static boolean SwigDirector_CollisionCombinationImpl_testIntersect(CollisionCombinationImpl collisionCombinationImpl, CollisionItemImpl collisionItemImpl) {
        return collisionCombinationImpl.testIntersect(collisionItemImpl);
    }

    @CollisionType.CollisionType1
    public static int SwigDirector_CollisionCombinationImpl_getType(CollisionCombinationImpl collisionCombinationImpl) {
        return collisionCombinationImpl.getType();
    }

    public static void SwigDirector_CollisionCombinationImpl_enableAreaCollision(CollisionCombinationImpl collisionCombinationImpl, boolean z) {
        collisionCombinationImpl.enableAreaCollision(z);
    }

    public static boolean SwigDirector_CollisionCombinationImpl_isAreaCollision(CollisionCombinationImpl collisionCombinationImpl) {
        return collisionCombinationImpl.isAreaCollision();
    }

    public static void SwigDirector_CollisionCombinationImpl_enableCollision(CollisionCombinationImpl collisionCombinationImpl, boolean z) {
        collisionCombinationImpl.enableCollision(z);
    }

    public static boolean SwigDirector_CollisionCombinationImpl_isCollision(CollisionCombinationImpl collisionCombinationImpl) {
        return collisionCombinationImpl.isCollision();
    }

    public static void SwigDirector_CollisionCombinationImpl_lockItems(CollisionCombinationImpl collisionCombinationImpl) {
        collisionCombinationImpl.lockItems();
    }

    public static void SwigDirector_CollisionCombinationImpl_unLockItems(CollisionCombinationImpl collisionCombinationImpl) {
        collisionCombinationImpl.unLockItems();
    }

    public static void SwigDirector_CollisionCombinationImpl_caculateCollision(CollisionCombinationImpl collisionCombinationImpl) {
        collisionCombinationImpl.caculateCollision();
    }

    public static boolean SwigDirector_CollisionCombinationImpl_addGroup(CollisionCombinationImpl collisionCombinationImpl, CollisionGroupImpl collisionGroupImpl) {
        return collisionCombinationImpl.addGroup(collisionGroupImpl);
    }

    public static boolean SwigDirector_CollisionCombinationImpl_removeGroup(CollisionCombinationImpl collisionCombinationImpl, CollisionGroupImpl collisionGroupImpl) {
        return collisionCombinationImpl.removeGroup(collisionGroupImpl);
    }

    public static long[] SwigDirector_CollisionCombinationImpl_getGroups(CollisionCombinationImpl collisionCombinationImpl) {
        ArrayList<CollisionGroupImpl> groups = collisionCombinationImpl.getGroups();
        if (groups != null) {
            int size = groups.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = CollisionGroupImpl.getCPtr(groups.get(i));
            }
            return jArr;
        }
        return null;
    }

    public static void SwigDirector_CollisionCombinationImpl_setCollidedByFocusItem(CollisionCombinationImpl collisionCombinationImpl, boolean z) {
        collisionCombinationImpl.setCollidedByFocusItem(z);
    }

    public static boolean SwigDirector_CollisionCombinationImpl_isCollidedByFocusItem(CollisionCombinationImpl collisionCombinationImpl) {
        return collisionCombinationImpl.isCollidedByFocusItem();
    }

    public static void SwigDirector_CollisionCombinationImpl_removeCollisionItems(CollisionCombinationImpl collisionCombinationImpl, ArrayList<CollisionItemImpl> arrayList) {
        collisionCombinationImpl.removeCollisionItems(arrayList);
    }

    public static void SwigDirector_CollisionCombinationImpl_onRecoverCollisonItem(CollisionCombinationImpl collisionCombinationImpl, CollisionItemImpl collisionItemImpl) {
        collisionCombinationImpl.onRecoverCollisonItem(collisionItemImpl);
    }
}
