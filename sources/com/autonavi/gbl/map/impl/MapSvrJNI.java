package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.TypeUtil;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.layer.model.LayerPriority;
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

    public static void SwigDirector_ICollisionItemImpl_resetOnVisible(ICollisionItemImpl iCollisionItemImpl, boolean z) {
        iCollisionItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_ICollisionItemImpl_onVisible(ICollisionItemImpl iCollisionItemImpl, boolean z) {
        iCollisionItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_ICollisionItemImpl_getOnVisible(ICollisionItemImpl iCollisionItemImpl) {
        return iCollisionItemImpl.getOnVisible();
    }

    public static void SwigDirector_ICollisionItemImpl_applyOnVisible(ICollisionItemImpl iCollisionItemImpl) {
        iCollisionItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_ICollisionItemImpl_getBound(ICollisionItemImpl iCollisionItemImpl) {
        return iCollisionItemImpl.getBound();
    }

    public static boolean SwigDirector_ICollisionItemImpl_getVisible(ICollisionItemImpl iCollisionItemImpl) {
        return iCollisionItemImpl.getVisible();
    }

    public static int SwigDirector_ICollisionItemImpl_getPriority(ICollisionItemImpl iCollisionItemImpl) {
        return iCollisionItemImpl.getPriority();
    }

    public static boolean SwigDirector_ICollisionItemImpl_isAreaCollision(ICollisionItemImpl iCollisionItemImpl) {
        return iCollisionItemImpl.isAreaCollision();
    }

    public static void SwigDirector_ICollisionItemImpl_setAreaCollision(ICollisionItemImpl iCollisionItemImpl, boolean z) {
        iCollisionItemImpl.setAreaCollision(z);
    }

    public static void SwigDirector_ICollisonRemoveObseverImpl_removeCollisionItems(ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl, ArrayList<ICollisionItemImpl> arrayList) {
        iCollisonRemoveObseverImpl.removeCollisionItems(arrayList);
    }

    public static void SwigDirector_ICollisonRemoveObseverImpl_onRecoverCollisonItem(ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl, ICollisionItemImpl iCollisionItemImpl) {
        iCollisonRemoveObseverImpl.onRecoverCollisonItem(iCollisionItemImpl);
    }

    public static void SwigDirector_ICollisionEntityImpl_resetNextPair(ICollisionEntityImpl iCollisionEntityImpl) {
        iCollisionEntityImpl.resetNextPair();
    }

    public static boolean SwigDirector_ICollisionEntityImpl_testIntersect(ICollisionEntityImpl iCollisionEntityImpl, ICollisionItemImpl iCollisionItemImpl) {
        return iCollisionEntityImpl.testIntersect(iCollisionItemImpl);
    }

    @CollisionType.CollisionType1
    public static int SwigDirector_ICollisionEntityImpl_getType(ICollisionEntityImpl iCollisionEntityImpl) {
        return iCollisionEntityImpl.getType();
    }

    public static void SwigDirector_ICollisionEntityImpl_enableAreaCollision(ICollisionEntityImpl iCollisionEntityImpl, boolean z) {
        iCollisionEntityImpl.enableAreaCollision(z);
    }

    public static boolean SwigDirector_ICollisionEntityImpl_isAreaCollision(ICollisionEntityImpl iCollisionEntityImpl) {
        return iCollisionEntityImpl.isAreaCollision();
    }

    public static void SwigDirector_ICollisionEntityImpl_lockItems(ICollisionEntityImpl iCollisionEntityImpl) {
        iCollisionEntityImpl.lockItems();
    }

    public static void SwigDirector_ICollisionEntityImpl_unLockItems(ICollisionEntityImpl iCollisionEntityImpl) {
        iCollisionEntityImpl.unLockItems();
    }

    public static void SwigDirector_ICollisionEntityImpl_caculateCollision(ICollisionEntityImpl iCollisionEntityImpl) {
        iCollisionEntityImpl.caculateCollision();
    }

    public static void SwigDirector_CollisionGroupImpl_resetNextPair(CollisionGroupImpl collisionGroupImpl) {
        collisionGroupImpl.resetNextPair();
    }

    public static boolean SwigDirector_CollisionGroupImpl_testIntersect(CollisionGroupImpl collisionGroupImpl, ICollisionItemImpl iCollisionItemImpl) {
        return collisionGroupImpl.testIntersect(iCollisionItemImpl);
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

    public static void SwigDirector_CollisionGroupImpl_lockItems(CollisionGroupImpl collisionGroupImpl) {
        collisionGroupImpl.lockItems();
    }

    public static void SwigDirector_CollisionGroupImpl_unLockItems(CollisionGroupImpl collisionGroupImpl) {
        collisionGroupImpl.unLockItems();
    }

    public static void SwigDirector_CollisionGroupImpl_caculateCollision(CollisionGroupImpl collisionGroupImpl) {
        collisionGroupImpl.caculateCollision();
    }

    public static void SwigDirector_CollisionGroupImpl_intersectUI(CollisionGroupImpl collisionGroupImpl, ArrayList<RectDouble> arrayList) {
        collisionGroupImpl.intersectUI(arrayList);
    }

    public static boolean SwigDirector_CollisionGroupImpl_addCollisionItem(CollisionGroupImpl collisionGroupImpl, ICollisionItemImpl iCollisionItemImpl) {
        return collisionGroupImpl.addCollisionItem(iCollisionItemImpl);
    }

    public static boolean SwigDirector_CollisionGroupImpl_removeCollisionItem(CollisionGroupImpl collisionGroupImpl, ICollisionItemImpl iCollisionItemImpl) {
        return collisionGroupImpl.removeCollisionItem(iCollisionItemImpl);
    }

    public static void SwigDirector_CollisionGroupImpl_clearAllCollisionItems(CollisionGroupImpl collisionGroupImpl) {
        collisionGroupImpl.clearAllCollisionItems();
    }

    public static long[] SwigDirector_CollisionGroupImpl_getCollisionItems(CollisionGroupImpl collisionGroupImpl) {
        ArrayList<ICollisionItemImpl> collisionItems = collisionGroupImpl.getCollisionItems();
        if (collisionItems != null) {
            int size = collisionItems.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = ICollisionItemImpl.getCPtr(collisionItems.get(i));
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

    public static void SwigDirector_CollisionGroupImpl_updateQuadrantItems(CollisionGroupImpl collisionGroupImpl) {
        collisionGroupImpl.updateQuadrantItems();
    }

    public static void SwigDirector_CollisionGroupImpl_getPriority(CollisionGroupImpl collisionGroupImpl, LayerPriority layerPriority) {
        try {
            TypeUtil.deepcopy(collisionGroupImpl.getPriority(), layerPriority);
        } catch (Exception unused) {
        }
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

    public static boolean SwigDirector_CollisionCombinationImpl_testIntersect(CollisionCombinationImpl collisionCombinationImpl, ICollisionItemImpl iCollisionItemImpl) {
        return collisionCombinationImpl.testIntersect(iCollisionItemImpl);
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

    public static void SwigDirector_CollisionCombinationImpl_removeCollisionItems(CollisionCombinationImpl collisionCombinationImpl, ArrayList<ICollisionItemImpl> arrayList) {
        collisionCombinationImpl.removeCollisionItems(arrayList);
    }

    public static void SwigDirector_CollisionCombinationImpl_onRecoverCollisonItem(CollisionCombinationImpl collisionCombinationImpl, ICollisionItemImpl iCollisionItemImpl) {
        collisionCombinationImpl.onRecoverCollisonItem(iCollisionItemImpl);
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
}
