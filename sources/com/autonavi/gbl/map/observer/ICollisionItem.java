package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.map.router.CollisionItemRouter;
import java.util.ArrayList;
@IntfAuto(target = CollisionItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICollisionItem {
    ArrayList<PixelPoint> getBound();

    int getPriority();

    boolean getVisible();

    boolean isAreaCollision();

    void onVisible(boolean z);

    void setAreaCollision(boolean z);
}
