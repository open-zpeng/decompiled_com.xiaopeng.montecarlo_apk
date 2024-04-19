package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.map.router.CollisionItemRouter;
import java.util.ArrayList;
@IntfAuto(target = CollisionItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICollisionItem {
    void applyOnVisible();

    ArrayList<PixelPoint> getBound();

    boolean getOnVisible();

    int getPriority();

    boolean getVisible();

    boolean isAreaCollision();

    void onVisible(boolean z);

    void resetOnVisible(boolean z);

    void setAreaCollision(boolean z);
}
