package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.router.TextTextureObserverRouter;
@IntfAuto(target = TextTextureObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ITextTextureObserver {
    byte[] getCharBitmap(long j, int i, int i2);

    byte[] getCharsWidths(long j, short[] sArr, int i);
}
