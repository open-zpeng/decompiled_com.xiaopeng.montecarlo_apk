package com.autonavi.gbl.route.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.route.model.RouteAlongServiceAreaInfo;
import com.autonavi.gbl.route.model.RouteServiceArea;
import com.autonavi.gbl.route.observer.IRouteServiceAreaObserver;
import com.autonavi.gbl.route.observer.impl.IRouteServiceAreaObserverImpl;
import java.util.ArrayList;
@IntfAuto(target = IRouteServiceAreaObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteServiceAreaObserverRouter extends IRouteServiceAreaObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteServiceAreaObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteServiceAreaObserverRouter.class);
    private TypeHelper mHelper;
    private IRouteServiceAreaObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IRouteServiceAreaObserver iRouteServiceAreaObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IRouteServiceAreaObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iRouteServiceAreaObserver;
    }

    protected RouteServiceAreaObserverRouter(String str, IRouteServiceAreaObserver iRouteServiceAreaObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteServiceAreaObserver);
    }

    protected RouteServiceAreaObserverRouter(String str, IRouteServiceAreaObserver iRouteServiceAreaObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteServiceAreaObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.route.observer.impl.IRouteServiceAreaObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteServiceAreaObserverImpl
    public void onServiceAreaUpdated(ArrayList<RouteServiceArea> arrayList) {
        IRouteServiceAreaObserver iRouteServiceAreaObserver = this.mObserver;
        if (iRouteServiceAreaObserver != null) {
            iRouteServiceAreaObserver.onServiceAreaUpdated(arrayList);
        }
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteServiceAreaObserverImpl
    public void onUpdateAlongServiceArea(ArrayList<RouteAlongServiceAreaInfo> arrayList) {
        IRouteServiceAreaObserver iRouteServiceAreaObserver = this.mObserver;
        if (iRouteServiceAreaObserver != null) {
            iRouteServiceAreaObserver.onUpdateAlongServiceArea(arrayList);
        }
    }
}
