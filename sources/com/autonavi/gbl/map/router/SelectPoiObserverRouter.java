package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.SelectOutInfo;
import com.autonavi.gbl.map.observer.ISelectPoiObserver;
import com.autonavi.gbl.map.observer.impl.ISelectPoiObserverImpl;
@IntfAuto(target = ISelectPoiObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class SelectPoiObserverRouter extends ISelectPoiObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(SelectPoiObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(SelectPoiObserverRouter.class);
    private TypeHelper mHelper;
    private ISelectPoiObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ISelectPoiObserver iSelectPoiObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ISelectPoiObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iSelectPoiObserver;
    }

    protected SelectPoiObserverRouter(String str, ISelectPoiObserver iSelectPoiObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSelectPoiObserver);
    }

    protected SelectPoiObserverRouter(String str, ISelectPoiObserver iSelectPoiObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSelectPoiObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.SelectPoiObserverRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.observer.impl.ISelectPoiObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.SelectPoiObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.ISelectPoiObserverImpl
    public void onSelectPoiOut(long j, SelectOutInfo selectOutInfo) {
        ISelectPoiObserver iSelectPoiObserver = this.mObserver;
        if (iSelectPoiObserver != null) {
            iSelectPoiObserver.onSelectPoiOut(j, selectOutInfo);
        }
    }
}
