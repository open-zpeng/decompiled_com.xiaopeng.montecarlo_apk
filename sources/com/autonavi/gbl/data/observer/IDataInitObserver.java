package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.router.DataInitObserverRouter;
@IntfAuto(target = DataInitObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IDataInitObserver {
    void onInit(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, @OperationErrCode.OperationErrCode1 int i3);
}
