package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.HotUpdateFileType;
import com.autonavi.gbl.data.router.HotUpdateFileObserverRouter;
@IntfAuto(target = HotUpdateFileObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IHotUpdateFileObserver {
    void onHotUpdateFile(@HotUpdateFileType.HotUpdateFileType1 int i, int i2, String str);
}
