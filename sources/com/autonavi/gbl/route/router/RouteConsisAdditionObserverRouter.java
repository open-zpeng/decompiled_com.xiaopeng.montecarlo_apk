package com.autonavi.gbl.route.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.route.model.ConsisPathIdentity;
import com.autonavi.gbl.route.observer.IRouteConsisAdditionObserver;
import com.autonavi.gbl.route.observer.impl.IRouteConsisAdditionObserverImpl;
import com.autonavi.gbl.util.model.BinaryStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IRouteConsisAdditionObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RouteConsisAdditionObserverRouter extends IRouteConsisAdditionObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteConsisAdditionObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(RouteConsisAdditionObserverRouter.class);
    private TypeHelper mHelper;
    private IRouteConsisAdditionObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IRouteConsisAdditionObserver iRouteConsisAdditionObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IRouteConsisAdditionObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iRouteConsisAdditionObserver;
    }

    protected RouteConsisAdditionObserverRouter(String str, IRouteConsisAdditionObserver iRouteConsisAdditionObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteConsisAdditionObserver);
    }

    protected RouteConsisAdditionObserverRouter(String str, IRouteConsisAdditionObserver iRouteConsisAdditionObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRouteConsisAdditionObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.route.observer.impl.IRouteConsisAdditionObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteConsisAdditionObserverImpl
    public void onSyncRouteSuccess(long j, ArrayList<ConsisPathIdentity> arrayList) {
        IRouteConsisAdditionObserver iRouteConsisAdditionObserver = this.mObserver;
        if (iRouteConsisAdditionObserver != null) {
            iRouteConsisAdditionObserver.onSyncRouteSuccess(j, arrayList);
        }
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteConsisAdditionObserverImpl
    public void onSyncRouteError(long j, int i) {
        IRouteConsisAdditionObserver iRouteConsisAdditionObserver = this.mObserver;
        if (iRouteConsisAdditionObserver != null) {
            iRouteConsisAdditionObserver.onSyncRouteError(j, i);
        }
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteConsisAdditionObserverImpl
    public void onSyncRouteResult(long j, String str, ArrayList<PathInfo> arrayList, BinaryStream binaryStream, int i) {
        IRouteConsisAdditionObserver iRouteConsisAdditionObserver = this.mObserver;
        if (iRouteConsisAdditionObserver != null) {
            iRouteConsisAdditionObserver.onSyncRouteResult(j, str, arrayList, binaryStream, i);
        }
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteConsisAdditionObserverImpl
    public void onSyncRouteOption(IRouteOptionImpl iRouteOptionImpl) {
        TypeHelper typeHelper;
        try {
            Method method = RouteConsisAdditionObserverRouter.class.getMethod("onSyncRouteOption", IRouteOptionImpl.class);
            RouteOption routeOption = null;
            if (iRouteOptionImpl != null && (typeHelper = this.mHelper) != null) {
                routeOption = (RouteOption) typeHelper.transfer(method, 0, iRouteOptionImpl);
            }
            IRouteConsisAdditionObserver iRouteConsisAdditionObserver = this.mObserver;
            if (iRouteConsisAdditionObserver != null) {
                iRouteConsisAdditionObserver.onSyncRouteOption(routeOption);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteConsisAdditionObserverImpl
    public void onGetNaviPath(ArrayList<ConsisPathIdentity> arrayList, ArrayList<PathInfo> arrayList2) {
        IRouteConsisAdditionObserver iRouteConsisAdditionObserver = this.mObserver;
        if (iRouteConsisAdditionObserver != null) {
            iRouteConsisAdditionObserver.onGetNaviPath(arrayList, arrayList2);
        }
    }
}
