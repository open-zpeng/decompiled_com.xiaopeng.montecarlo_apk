package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.router.DataDeletionObserverRouter;
@IntfAuto(target = DataDeletionObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IDataDeletionObserver {
    void onAfterDataDeletion(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3);

    void onBeforeDataDeletion(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3);
}
