package com.autonavi.gbl.search.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.search.model.SceneSearchResult;
import com.autonavi.gbl.search.observer.ISceneSearchObserver;
import com.autonavi.gbl.search.observer.impl.ISceneSearchObserverImpl;
@IntfAuto(target = ISceneSearchObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class SceneSearchObserverRouter extends ISceneSearchObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(SceneSearchObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(SceneSearchObserverRouter.class);
    private TypeHelper mHelper;
    private ISceneSearchObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ISceneSearchObserver iSceneSearchObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ISceneSearchObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iSceneSearchObserver;
    }

    protected SceneSearchObserverRouter(String str, ISceneSearchObserver iSceneSearchObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSceneSearchObserver);
    }

    protected SceneSearchObserverRouter(String str, ISceneSearchObserver iSceneSearchObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSceneSearchObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.search.observer.impl.ISceneSearchObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.search.observer.impl.ISceneSearchObserverImpl
    public void onGetSceneResult(int i, int i2, SceneSearchResult sceneSearchResult) {
        ISceneSearchObserver iSceneSearchObserver = this.mObserver;
        if (iSceneSearchObserver != null) {
            iSceneSearchObserver.onGetSceneResult(i, i2, sceneSearchResult);
        }
    }
}
