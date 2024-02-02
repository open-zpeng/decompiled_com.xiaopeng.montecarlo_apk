package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.observer.IMapFpsObserver;
import com.autonavi.gbl.map.observer.impl.IMapFpsObserverImpl;
@IntfAuto(target = IMapFpsObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapFpsObserverRouter extends IMapFpsObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(MapFpsObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapFpsObserverRouter.class);
    private TypeHelper mHelper;
    private IMapFpsObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IMapFpsObserver iMapFpsObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMapFpsObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iMapFpsObserver;
    }

    protected MapFpsObserverRouter(String str, IMapFpsObserver iMapFpsObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapFpsObserver);
    }

    protected MapFpsObserverRouter(String str, IMapFpsObserver iMapFpsObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapFpsObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapFpsObserverRouter.1
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
    @Override // com.autonavi.gbl.map.observer.impl.IMapFpsObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapFpsObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapFpsObserverImpl
    public void onMapRenderTimeOut(int i, int i2, int i3) {
        IMapFpsObserver iMapFpsObserver = this.mObserver;
        if (iMapFpsObserver != null) {
            iMapFpsObserver.onMapRenderTimeOut(i, i2, i3);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapFpsObserverImpl
    public void onMapRenderRealFps(int i, int i2, int i3) {
        IMapFpsObserver iMapFpsObserver = this.mObserver;
        if (iMapFpsObserver != null) {
            iMapFpsObserver.onMapRenderRealFps(i, i2, i3);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapFpsObserverImpl
    public void onMapRenderConfigFps(int i, int i2) {
        IMapFpsObserver iMapFpsObserver = this.mObserver;
        if (iMapFpsObserver != null) {
            iMapFpsObserver.onMapRenderConfigFps(i, i2);
        }
    }
}
