package com.autonavi.gbl.recorder.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.recorder.model.PlayProgress;
import com.autonavi.gbl.recorder.observer.IPlayerObserver;
import com.autonavi.gbl.recorder.observer.impl.IPlayerObserverImpl;
@IntfAuto(target = IPlayerObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PlayerObserverRouter extends IPlayerObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PlayerObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PlayerObserverRouter.class);
    private TypeHelper mHelper;
    private IPlayerObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPlayerObserver iPlayerObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPlayerObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPlayerObserver;
    }

    protected PlayerObserverRouter(String str, IPlayerObserver iPlayerObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPlayerObserver);
    }

    protected PlayerObserverRouter(String str, IPlayerObserver iPlayerObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPlayerObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.recorder.observer.impl.IPlayerObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.recorder.observer.impl.IPlayerObserverImpl
    public void onPlayProgress(PlayProgress playProgress) {
        IPlayerObserver iPlayerObserver = this.mObserver;
        if (iPlayerObserver != null) {
            iPlayerObserver.onPlayProgress(playProgress);
        }
    }
}
