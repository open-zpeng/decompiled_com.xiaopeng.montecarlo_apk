package com.autonavi.gbl.route;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.GDataTime;
import com.autonavi.gbl.route.impl.IRouteConsisAdditionServiceImpl;
import com.autonavi.gbl.route.model.ConsisPathBinaryData;
import com.autonavi.gbl.route.observer.IRouteConsisAdditionObserver;
import com.autonavi.gbl.route.observer.impl.IRouteConsisAdditionObserverImpl;
import com.autonavi.gbl.util.model.BinaryStream;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IRouteConsisAdditionServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class RouteConsisAdditionService {
    private static String PACKAGE = ReflexTool.PN(RouteConsisAdditionService.class);
    private IRouteConsisAdditionServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteConsisAdditionService(long j, boolean z) {
        this(new IRouteConsisAdditionServiceImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(RouteConsisAdditionService.class, this, this.mControl);
        }
    }

    public RouteConsisAdditionService(IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iRouteConsisAdditionServiceImpl);
    }

    private void $constructor(IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl) {
        if (iRouteConsisAdditionServiceImpl != null) {
            this.mControl = iRouteConsisAdditionServiceImpl;
            this.mTargetId = String.format("RouteConsisAdditionService_%s_%d", String.valueOf(IRouteConsisAdditionServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IRouteConsisAdditionServiceImpl getControl() {
        return this.mControl;
    }

    public void addRouteConsisAdditionObserver(IRouteConsisAdditionObserver iRouteConsisAdditionObserver) {
        try {
            Method method = RouteConsisAdditionService.class.getMethod("addRouteConsisAdditionObserver", IRouteConsisAdditionObserver.class);
            if (iRouteConsisAdditionObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IRouteConsisAdditionObserverImpl) typeHelper.transfer(method, 0, iRouteConsisAdditionObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteConsisAdditionService.1
                    }));
                }
            }
            IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl = this.mControl;
            if (iRouteConsisAdditionServiceImpl != null) {
                iRouteConsisAdditionServiceImpl.addRouteConsisAdditionObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeRouteConsisAdditionObserver(IRouteConsisAdditionObserver iRouteConsisAdditionObserver) {
        try {
            Method method = RouteConsisAdditionService.class.getMethod("removeRouteConsisAdditionObserver", IRouteConsisAdditionObserver.class);
            if (iRouteConsisAdditionObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IRouteConsisAdditionObserverImpl) typeHelper.transfer(method, 0, iRouteConsisAdditionObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteConsisAdditionService.2
                    }));
                }
            }
            IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl = this.mControl;
            if (iRouteConsisAdditionServiceImpl != null) {
                iRouteConsisAdditionServiceImpl.removeRouteConsisAdditionObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iRouteConsisAdditionObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setRoutePlanTime(GDataTime gDataTime) {
        IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl = this.mControl;
        if (iRouteConsisAdditionServiceImpl != null) {
            iRouteConsisAdditionServiceImpl.setRoutePlanTime(gDataTime);
        }
    }

    public long syncOnlinePathToMultiSource(ConsisPathBinaryData consisPathBinaryData, BinaryStream binaryStream, long j) {
        IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl = this.mControl;
        if (iRouteConsisAdditionServiceImpl != null) {
            return iRouteConsisAdditionServiceImpl.syncOnlinePathToMultiSource(consisPathBinaryData, binaryStream, j);
        }
        return 0L;
    }

    public long syncOnlinePathToMultiSource(ConsisPathBinaryData consisPathBinaryData, BinaryStream binaryStream) {
        IRouteConsisAdditionServiceImpl iRouteConsisAdditionServiceImpl = this.mControl;
        if (iRouteConsisAdditionServiceImpl != null) {
            return iRouteConsisAdditionServiceImpl.syncOnlinePathToMultiSource(consisPathBinaryData, binaryStream);
        }
        return 0L;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteConsisAdditionService.3
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteConsisAdditionService.4
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.route.observer.IRouteConsisAdditionObserver")).iterator();
            while (it.hasNext()) {
                removeRouteConsisAdditionObserver((IRouteConsisAdditionObserver) it.next());
            }
        }
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.RouteConsisAdditionService.5
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
