package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.router.CollisonRemoveObseverRouter;
import java.util.ArrayList;
@IntfAuto(target = CollisonRemoveObseverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICollisonRemoveObsever {
    void onRecoverCollisonItem(ICollisionItem iCollisionItem);

    void removeCollisionItems(ArrayList<ICollisionItem> arrayList);
}
