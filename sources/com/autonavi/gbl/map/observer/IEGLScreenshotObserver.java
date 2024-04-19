package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.ScreenShotCallbackMethod;
import com.autonavi.gbl.map.model.ScreenShotDataInfo;
import com.autonavi.gbl.map.router.EGLScreenshotObserverRouter;
@IntfAuto(target = EGLScreenshotObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IEGLScreenshotObserver {
    void onEGLScreenshot(int i, byte[] bArr, ScreenShotDataInfo screenShotDataInfo, @ScreenShotCallbackMethod.ScreenShotCallbackMethod1 int i2, long j);
}
