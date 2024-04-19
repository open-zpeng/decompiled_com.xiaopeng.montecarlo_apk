package com.autonavi.gbl.multi.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.multi.KldDisplay;
import com.autonavi.gbl.multi.router.KldConfigItemBaseRouter;
@IntfAuto(target = KldConfigItemBaseRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IKldConfigItemBase {
    int applyConfig(KldDisplay kldDisplay);

    String getConfigName();

    void getConfigName(String[] strArr);

    String getTypeName();

    void getTypeName(String[] strArr);

    int parseConfigString(String str);
}
