package com.autonavi.gbl.data.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.model.MapNum;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.observer.IMapNumObserver;
import com.autonavi.gbl.data.observer.impl.IMapNumObserverImpl;
@IntfAuto(target = IMapNumObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class MapNumObserverRouter extends IMapNumObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(MapNumObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapNumObserverRouter.class);
    private TypeHelper mHelper;
    private IMapNumObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IMapNumObserver iMapNumObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMapNumObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iMapNumObserver;
    }

    protected MapNumObserverRouter(String str, IMapNumObserver iMapNumObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapNumObserver);
    }

    protected MapNumObserverRouter(String str, IMapNumObserver iMapNumObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapNumObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.MapNumObserverRouter.1
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
    @Override // com.autonavi.gbl.data.observer.impl.IMapNumObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.data.router.MapNumObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.data.observer.impl.IMapNumObserverImpl
    public void onRequestMapNum(@OperationErrCode.OperationErrCode1 int i, MapNum mapNum) {
        IMapNumObserver iMapNumObserver = this.mObserver;
        if (iMapNumObserver != null) {
            iMapNumObserver.onRequestMapNum(i, mapNum);
        }
    }
}
