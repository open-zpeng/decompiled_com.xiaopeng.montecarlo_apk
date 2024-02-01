package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.map.router.CollisionItemRouter;
import java.util.ArrayList;
@IntfAuto(target = CollisionItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICollisionItem extends IMixtureSharedBase {
    default void applyOnVisible() {
    }

    boolean canAreaCollision();

    boolean canCollision();

    ArrayList<PixelPoint> getBound();

    boolean getOnVisible();

    int getPriority();

    boolean getVisible();

    boolean isAreaCollision();

    default void onVisible(boolean z) {
    }

    default void resetOnVisible(boolean z) {
    }

    default void setAreaCollision(boolean z) {
    }
}
