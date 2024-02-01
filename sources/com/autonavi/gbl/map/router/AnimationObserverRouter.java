package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.AnmCallbackParam;
import com.autonavi.gbl.map.observer.IAnimationObserver;
import com.autonavi.gbl.map.observer.impl.IAnimationObserverImpl;
@IntfAuto(target = IAnimationObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class AnimationObserverRouter extends IAnimationObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(AnimationObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(AnimationObserverRouter.class);
    private TypeHelper mHelper;
    private IAnimationObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IAnimationObserver iAnimationObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IAnimationObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iAnimationObserver;
    }

    protected AnimationObserverRouter(String str, IAnimationObserver iAnimationObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iAnimationObserver);
    }

    protected AnimationObserverRouter(String str, IAnimationObserver iAnimationObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iAnimationObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.observer.impl.IAnimationObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IAnimationObserverImpl
    public void processMapAnimationFinished(long j, AnmCallbackParam anmCallbackParam) {
        IAnimationObserver iAnimationObserver = this.mObserver;
        if (iAnimationObserver != null) {
            iAnimationObserver.processMapAnimationFinished(j, anmCallbackParam);
        }
    }
}
