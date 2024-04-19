package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.router.LNDSGlobalFileUpdateObserverRouter;
import java.math.BigInteger;
@IntfAuto(target = LNDSGlobalFileUpdateObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILNDSGlobalFileUpdateObserver {
    void onGlobalFileUpdate(BigInteger bigInteger, @OperationErrCode.OperationErrCode1 int i);

    void onGlobalFileVersion(BigInteger bigInteger, String str);

    void onTileGlobalFileUpdate(BigInteger bigInteger, @OperationErrCode.OperationErrCode1 int i);
}
