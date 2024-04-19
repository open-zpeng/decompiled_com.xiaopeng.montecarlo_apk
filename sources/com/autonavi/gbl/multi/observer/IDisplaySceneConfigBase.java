package com.autonavi.gbl.multi.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.multi.KldDisplay;
import com.autonavi.gbl.multi.router.DisplaySceneConfigBaseRouter;
@IntfAuto(target = DisplaySceneConfigBaseRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IDisplaySceneConfigBase extends IKldConfigItemBase {
    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    int applyConfig(KldDisplay kldDisplay);

    String getMapConfigName();

    String getRenderConfigName();

    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    int parseConfigString(String str);
}
