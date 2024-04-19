package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.observer.IReculateOverlay;
import com.autonavi.gbl.map.observer.impl.IReculateOverlayImpl;
@IntfAuto(target = IReculateOverlay.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class ReculateOverlayRouter extends IReculateOverlayImpl {
    private static BindTable BIND_TABLE = new BindTable(ReculateOverlayRouter.class);
    private static String PACKAGE = ReflexTool.PN(ReculateOverlayRouter.class);
    private TypeHelper mHelper;
    private IReculateOverlay mObserver;
    private String mTargetId;

    private void $constructor(String str, IReculateOverlay iReculateOverlay) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IReculateOverlayImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iReculateOverlay;
    }

    protected ReculateOverlayRouter(String str, IReculateOverlay iReculateOverlay, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iReculateOverlay);
    }

    protected ReculateOverlayRouter(String str, IReculateOverlay iReculateOverlay) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iReculateOverlay);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.ReculateOverlayRouter.1
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
    @Override // com.autonavi.gbl.map.observer.impl.IReculateOverlayImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.ReculateOverlayRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IReculateOverlayImpl
    public void recalculateOverlay() {
        IReculateOverlay iReculateOverlay = this.mObserver;
        if (iReculateOverlay != null) {
            iReculateOverlay.recalculateOverlay();
        }
    }
}
