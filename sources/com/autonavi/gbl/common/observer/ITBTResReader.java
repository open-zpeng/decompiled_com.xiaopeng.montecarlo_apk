package com.autonavi.gbl.common.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.router.TBTResReaderRouter;
@IntfAuto(target = TBTResReaderRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ITBTResReader {
    byte[] readFile(String str);

    default void release(byte[] bArr) {
    }
}
