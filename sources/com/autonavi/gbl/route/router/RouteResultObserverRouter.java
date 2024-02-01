package com.autonavi.gbl.route.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.route.model.PathResultData;
import com.autonavi.gbl.route.observer.IRouteResultObserver;
import com.autonavi.gbl.route.observer.impl.IRouteResultObserverImpl;
import java.util.ArrayList;
@IntfAuto(target = IRouteResultObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteResultObserverRouter extends IRouteResultObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteResultObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteResultObserverRouter.class);
    private TypeHelper mHelper;
    private IRouteResultObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IRouteResultObserver iRouteResultObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IRouteResultObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iRouteResultObserver;
    }

    protected RouteResultObserverRouter(String str, IRouteResultObserver iRouteResultObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteResultObserver);
    }

    protected RouteResultObserverRouter(String str, IRouteResultObserver iRouteResultObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteResultObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.route.observer.impl.IRouteResultObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteResultObserverImpl
    public void onNewRoute(PathResultData pathResultData, ArrayList<PathInfo> arrayList, RouteLimitInfo routeLimitInfo) {
        IRouteResultObserver iRouteResultObserver = this.mObserver;
        if (iRouteResultObserver != null) {
            iRouteResultObserver.onNewRoute(pathResultData, arrayList, routeLimitInfo);
        }
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteResultObserverImpl
    public void onNewRouteError(PathResultData pathResultData, RouteLimitInfo routeLimitInfo) {
        IRouteResultObserver iRouteResultObserver = this.mObserver;
        if (iRouteResultObserver != null) {
            iRouteResultObserver.onNewRouteError(pathResultData, routeLimitInfo);
        }
    }
}
