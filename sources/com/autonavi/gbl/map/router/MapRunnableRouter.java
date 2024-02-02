package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.observer.IMapRunnable;
import com.autonavi.gbl.map.observer.impl.IMapRunnableImpl;
@IntfAuto(target = IMapRunnable.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapRunnableRouter extends IMapRunnableImpl {
    private static BindTable BIND_TABLE = new BindTable(MapRunnableRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapRunnableRouter.class);
    private TypeHelper mHelper;
    private IMapRunnable mObserver;
    private TypeHelper mOwnerHelper;
    private String mTargetId;

    private void $constructor(String str, IMapRunnable iMapRunnable) {
        this.mOwnerHelper = new TypeHelper(str);
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMapRunnableImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iMapRunnable;
    }

    protected MapRunnableRouter(String str, IMapRunnable iMapRunnable, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        this.mOwnerHelper = null;
        $constructor(str, iMapRunnable);
    }

    protected MapRunnableRouter(String str, IMapRunnable iMapRunnable) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        this.mOwnerHelper = null;
        $constructor(str, iMapRunnable);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapRunnableRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapRunnableImpl
    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapRunnableRouter.2
        }));
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapRunnableImpl
    public void run() {
        IMapRunnable iMapRunnable = this.mObserver;
        if (iMapRunnable != null) {
            iMapRunnable.run();
            this.mOwnerHelper.unbind("com.autonavi.gbl.map.observer.IMapRunnable", this.mObserver);
        }
    }
}
