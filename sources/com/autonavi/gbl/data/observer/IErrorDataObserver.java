package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.DataErrorType;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.router.ErrorDataObserverRouter;
@IntfAuto(target = ErrorDataObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IErrorDataObserver {
    void onDeleteErrorData(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @OperationErrCode.OperationErrCode1 int i4);

    void onErrorNotify(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @DataErrorType.DataErrorType1 int i4, String str);

    void onErrorNotifyH(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @DataErrorType.DataErrorType1 int i4, String str);
}
