package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.observer.IMapStyleSwitchObserver;
import com.autonavi.gbl.map.observer.impl.IMapStyleSwitchObserverImpl;
@IntfAuto(target = IMapStyleSwitchObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapStyleSwitchObserverRouter extends IMapStyleSwitchObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(MapStyleSwitchObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapStyleSwitchObserverRouter.class);
    private TypeHelper mHelper;
    private IMapStyleSwitchObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IMapStyleSwitchObserver iMapStyleSwitchObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMapStyleSwitchObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iMapStyleSwitchObserver;
    }

    protected MapStyleSwitchObserverRouter(String str, IMapStyleSwitchObserver iMapStyleSwitchObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapStyleSwitchObserver);
    }

    protected MapStyleSwitchObserverRouter(String str, IMapStyleSwitchObserver iMapStyleSwitchObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapStyleSwitchObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.observer.impl.IMapStyleSwitchObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapStyleSwitchObserverImpl
    public void onMapStyleSwitchComplete(int i) {
        IMapStyleSwitchObserver iMapStyleSwitchObserver = this.mObserver;
        if (iMapStyleSwitchObserver != null) {
            iMapStyleSwitchObserver.onMapStyleSwitchComplete(i);
        }
    }
}
