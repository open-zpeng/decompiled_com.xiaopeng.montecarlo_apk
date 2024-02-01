package com.autonavi.gbl.scene.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.scene.model.ClickedInfo;
import com.autonavi.gbl.scene.model.DisplayInfo;
import com.autonavi.gbl.scene.router.DisplayObserverRouter;
@IntfAuto(target = DisplayObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IDisplayObserver {
    default void onClick(ClickedInfo clickedInfo) {
    }

    default void onHide(DisplayInfo displayInfo) {
    }

    default void onShow(DisplayInfo displayInfo) {
    }
}
