package com.autonavi.gbl.route.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.route.model.BLRerouteRequestInfo;
import com.autonavi.gbl.route.observer.INaviRerouteObserver;
import com.autonavi.gbl.route.observer.impl.INaviRerouteObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = INaviRerouteObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class NaviRerouteObserverRouter extends INaviRerouteObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(NaviRerouteObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(NaviRerouteObserverRouter.class);
    private TypeHelper mHelper;
    private INaviRerouteObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, INaviRerouteObserver iNaviRerouteObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(INaviRerouteObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iNaviRerouteObserver;
    }

    protected NaviRerouteObserverRouter(String str, INaviRerouteObserver iNaviRerouteObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iNaviRerouteObserver);
    }

    protected NaviRerouteObserverRouter(String str, INaviRerouteObserver iNaviRerouteObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iNaviRerouteObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.route.observer.impl.INaviRerouteObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.route.observer.impl.INaviRerouteObserverImpl
    public void onModifyRerouteOption(IRouteOptionImpl iRouteOptionImpl) {
        TypeHelper typeHelper;
        try {
            Method method = NaviRerouteObserverRouter.class.getMethod("onModifyRerouteOption", IRouteOptionImpl.class);
            RouteOption routeOption = null;
            if (iRouteOptionImpl != null && (typeHelper = this.mHelper) != null) {
                routeOption = (RouteOption) typeHelper.transfer(method, 0, iRouteOptionImpl);
            }
            INaviRerouteObserver iNaviRerouteObserver = this.mObserver;
            if (iNaviRerouteObserver != null) {
                iNaviRerouteObserver.onModifyRerouteOption(routeOption);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.route.observer.impl.INaviRerouteObserverImpl
    public void onRerouteInfo(BLRerouteRequestInfo bLRerouteRequestInfo) {
        INaviRerouteObserver iNaviRerouteObserver = this.mObserver;
        if (iNaviRerouteObserver != null) {
            iNaviRerouteObserver.onRerouteInfo(bLRerouteRequestInfo);
        }
    }

    @Override // com.autonavi.gbl.route.observer.impl.INaviRerouteObserverImpl
    public void onSwitchParallelRoadRerouteInfo(BLRerouteRequestInfo bLRerouteRequestInfo) {
        INaviRerouteObserver iNaviRerouteObserver = this.mObserver;
        if (iNaviRerouteObserver != null) {
            iNaviRerouteObserver.onSwitchParallelRoadRerouteInfo(bLRerouteRequestInfo);
        }
    }
}
