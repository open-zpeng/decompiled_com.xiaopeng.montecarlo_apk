package com.autonavi.gbl.route.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RouteErrorcode;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
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
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.router.RouteConsisAdditionObserverRouter.1
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
    @Override // com.autonavi.gbl.route.observer.impl.IRouteConsisAdditionObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.router.RouteConsisAdditionObserverRouter.2
        }));
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
    public void onSyncRouteError(long j, @RouteErrorcode.RouteErrorcode1 int i) {
        IRouteConsisAdditionObserver iRouteConsisAdditionObserver = this.mObserver;
        if (iRouteConsisAdditionObserver != null) {
            iRouteConsisAdditionObserver.onSyncRouteError(j, i);
        }
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteConsisAdditionObserverImpl
    public void onSyncRouteResult(long j, String str, ArrayList<PathInfoImpl> arrayList, BinaryStream binaryStream, @RouteErrorcode.RouteErrorcode1 int i) {
        try {
            Method method = RouteConsisAdditionObserverRouter.class.getMethod("onSyncRouteResult", Long.TYPE, String.class, ArrayList.class, BinaryStream.class, Integer.TYPE);
            if (arrayList != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, 2, (ArrayList) arrayList) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pathInfoList == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.router.RouteConsisAdditionObserverRouter.3
                    }));
                }
            }
            ArrayList<PathInfo> arrayList2 = r1;
            IRouteConsisAdditionObserver iRouteConsisAdditionObserver = this.mObserver;
            if (iRouteConsisAdditionObserver != null) {
                iRouteConsisAdditionObserver.onSyncRouteResult(j, str, arrayList2, binaryStream, i);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteConsisAdditionObserverImpl
    public void onSyncRouteOption(IRouteOptionImpl iRouteOptionImpl) {
        try {
            Method method = RouteConsisAdditionObserverRouter.class.getMethod("onSyncRouteOption", IRouteOptionImpl.class);
            if (iRouteOptionImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (RouteOption) typeHelper.transfer(method, 0, iRouteOptionImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $option == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.router.RouteConsisAdditionObserverRouter.4
                    }));
                }
            }
            IRouteConsisAdditionObserver iRouteConsisAdditionObserver = this.mObserver;
            if (iRouteConsisAdditionObserver != null) {
                iRouteConsisAdditionObserver.onSyncRouteOption(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.route.observer.impl.IRouteConsisAdditionObserverImpl
    public void onGetNaviPath(ArrayList<ConsisPathIdentity> arrayList, ArrayList<PathInfoImpl> arrayList2) {
        try {
            Method method = RouteConsisAdditionObserverRouter.class.getMethod("onGetNaviPath", ArrayList.class, ArrayList.class);
            if (arrayList2 != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, 1, (ArrayList) arrayList2) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $paths == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.router.RouteConsisAdditionObserverRouter.5
                    }));
                }
            }
            IRouteConsisAdditionObserver iRouteConsisAdditionObserver = this.mObserver;
            if (iRouteConsisAdditionObserver != null) {
                iRouteConsisAdditionObserver.onGetNaviPath(arrayList, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
