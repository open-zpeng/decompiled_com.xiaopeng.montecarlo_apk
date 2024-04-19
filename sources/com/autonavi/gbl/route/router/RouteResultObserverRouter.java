package com.autonavi.gbl.route.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.route.model.PathResultData;
import com.autonavi.gbl.route.observer.IRouteResultObserver;
import com.autonavi.gbl.route.observer.impl.IRouteResultObserverImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
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
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.router.RouteResultObserverRouter.1
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
    @Override // com.autonavi.gbl.route.observer.impl.IRouteResultObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.router.RouteResultObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteResultObserverImpl
    public void onNewRoute(PathResultData pathResultData, ArrayList<PathInfoImpl> arrayList, RouteLimitInfo routeLimitInfo) {
        try {
            Method method = RouteResultObserverRouter.class.getMethod("onNewRoute", PathResultData.class, ArrayList.class, RouteLimitInfo.class);
            if (arrayList != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, 1, (ArrayList) arrayList) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pathInfoList == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.router.RouteResultObserverRouter.3
                    }));
                }
            }
            IRouteResultObserver iRouteResultObserver = this.mObserver;
            if (iRouteResultObserver != null) {
                iRouteResultObserver.onNewRoute(pathResultData, r1, routeLimitInfo);
                if (r1 != null) {
                    Iterator<PathInfo> it = r1.iterator();
                    while (it.hasNext()) {
                        it.next().delete();
                    }
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
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
