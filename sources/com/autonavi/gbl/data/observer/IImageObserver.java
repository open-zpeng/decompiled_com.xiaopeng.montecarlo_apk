package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.router.ImageObserverRouter;
@IntfAuto(target = ImageObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IImageObserver {
    void onDownloadImage(int i, @OperationErrCode.OperationErrCode1 int i2, String str, @DataType.DataType1 int i3);
}
