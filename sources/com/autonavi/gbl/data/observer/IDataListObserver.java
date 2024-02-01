package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.router.DataListObserverRouter;
@IntfAuto(target = DataListObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IDataListObserver {
    void onRequestDataListCheck(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3);
}
