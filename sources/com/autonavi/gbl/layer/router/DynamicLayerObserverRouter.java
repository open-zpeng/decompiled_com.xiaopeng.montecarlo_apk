package com.autonavi.gbl.layer.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.model.DynamicLayerObserverParam;
import com.autonavi.gbl.layer.observer.IDynamicLayerObserver;
import com.autonavi.gbl.layer.observer.impl.IDynamicLayerObserverImpl;
@IntfAuto(target = IDynamicLayerObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class DynamicLayerObserverRouter extends IDynamicLayerObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(DynamicLayerObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(DynamicLayerObserverRouter.class);
    private TypeHelper mHelper;
    private IDynamicLayerObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IDynamicLayerObserver iDynamicLayerObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IDynamicLayerObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iDynamicLayerObserver;
    }

    protected DynamicLayerObserverRouter(String str, IDynamicLayerObserver iDynamicLayerObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDynamicLayerObserver);
    }

    protected DynamicLayerObserverRouter(String str, IDynamicLayerObserver iDynamicLayerObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDynamicLayerObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.observer.impl.IDynamicLayerObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IDynamicLayerObserverImpl
    public float getPointMarkerScaleFactor() {
        IDynamicLayerObserver iDynamicLayerObserver = this.mObserver;
        if (iDynamicLayerObserver != null) {
            return iDynamicLayerObserver.getPointMarkerScaleFactor();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IDynamicLayerObserverImpl
    public boolean isNightMode() {
        IDynamicLayerObserver iDynamicLayerObserver = this.mObserver;
        if (iDynamicLayerObserver != null) {
            return iDynamicLayerObserver.isNightMode();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IDynamicLayerObserverImpl
    public void onNotifyClick(DynamicLayerObserverParam dynamicLayerObserverParam) {
        IDynamicLayerObserver iDynamicLayerObserver = this.mObserver;
        if (iDynamicLayerObserver != null) {
            iDynamicLayerObserver.onNotifyClick(dynamicLayerObserverParam);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.impl.IDynamicLayerObserverImpl
    public void onFocusChange(DynamicLayerObserverParam dynamicLayerObserverParam, boolean z) {
        IDynamicLayerObserver iDynamicLayerObserver = this.mObserver;
        if (iDynamicLayerObserver != null) {
            iDynamicLayerObserver.onFocusChange(dynamicLayerObserverParam, z);
        }
    }
}
