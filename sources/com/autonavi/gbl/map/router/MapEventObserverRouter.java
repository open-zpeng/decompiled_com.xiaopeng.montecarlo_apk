package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.observer.IMapEventObserver;
import com.autonavi.gbl.map.observer.impl.IMapEventObserverImpl;
@IntfAuto(target = IMapEventObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapEventObserverRouter extends IMapEventObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(MapEventObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapEventObserverRouter.class);
    private TypeHelper mHelper;
    private IMapEventObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IMapEventObserver iMapEventObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMapEventObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iMapEventObserver;
    }

    protected MapEventObserverRouter(String str, IMapEventObserver iMapEventObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapEventObserver);
    }

    protected MapEventObserverRouter(String str, IMapEventObserver iMapEventObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapEventObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapEventObserverRouter.1
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
    @Override // com.autonavi.gbl.map.observer.impl.IMapEventObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapEventObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapEventObserverImpl
    public boolean onMapMoveStart() {
        IMapEventObserver iMapEventObserver = this.mObserver;
        if (iMapEventObserver != null) {
            return iMapEventObserver.onMapMoveStart();
        }
        return false;
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapEventObserverImpl
    public boolean onMapMoveEnd() {
        IMapEventObserver iMapEventObserver = this.mObserver;
        if (iMapEventObserver != null) {
            return iMapEventObserver.onMapMoveEnd();
        }
        return false;
    }
}
