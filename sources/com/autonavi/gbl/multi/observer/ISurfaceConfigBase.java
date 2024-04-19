package com.autonavi.gbl.multi.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.multi.KldDisplay;
import com.autonavi.gbl.multi.model.RectSizeType;
import com.autonavi.gbl.multi.router.SurfaceConfigBaseRouter;
@IntfAuto(target = SurfaceConfigBaseRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ISurfaceConfigBase extends IKldConfigItemBase {
    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    int applyConfig(KldDisplay kldDisplay);

    boolean getIsSeparateRender();

    boolean getIsSurfaceVisiable();

    RectSizeType getSurfaceSize();

    int getWindowId();

    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    int parseConfigString(String str);
}
