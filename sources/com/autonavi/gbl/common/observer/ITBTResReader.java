package com.autonavi.gbl.common.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.TBTResReaderType;
import com.autonavi.gbl.common.router.TBTResReaderRouter;
@IntfAuto(target = TBTResReaderRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ITBTResReader {
    byte[] readData(@TBTResReaderType.TBTResReaderType1 int i, int i2);

    void release(byte[] bArr);
}
