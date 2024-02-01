package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.ScreenShotCallbackMethod;
import com.autonavi.gbl.map.model.ScreenShotDataInfo;
import com.autonavi.gbl.map.observer.IEGLScreenshotObserver;
import com.autonavi.gbl.map.observer.impl.IEGLScreenshotObserverImpl;
@IntfAuto(target = IEGLScreenshotObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class EGLScreenshotObserverRouter extends IEGLScreenshotObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(EGLScreenshotObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(EGLScreenshotObserverRouter.class);
    private TypeHelper mHelper;
    private IEGLScreenshotObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IEGLScreenshotObserver iEGLScreenshotObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IEGLScreenshotObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iEGLScreenshotObserver;
    }

    protected EGLScreenshotObserverRouter(String str, IEGLScreenshotObserver iEGLScreenshotObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEGLScreenshotObserver);
    }

    protected EGLScreenshotObserverRouter(String str, IEGLScreenshotObserver iEGLScreenshotObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iEGLScreenshotObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.observer.impl.IEGLScreenshotObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IEGLScreenshotObserverImpl
    public void onEGLScreenshot(int i, byte[] bArr, ScreenShotDataInfo screenShotDataInfo, @ScreenShotCallbackMethod.ScreenShotCallbackMethod1 int i2, long j) {
        IEGLScreenshotObserver iEGLScreenshotObserver = this.mObserver;
        if (iEGLScreenshotObserver != null) {
            iEGLScreenshotObserver.onEGLScreenshot(i, bArr, screenShotDataInfo, i2, j);
        }
    }
}
