package com.autonavi.gbl.route.model;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.RouteDisplayPoints;
import com.autonavi.gbl.aosclient.model.RoutePathProjectPoints;
import com.autonavi.gbl.aosclient.model.RoutepathrestorationPathsInfo;
import com.autonavi.gbl.aosclient.model.RoutepathrestorationPointInfo;
import com.autonavi.gbl.route.model.impl.IRouteRestorationOptionImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IRouteRestorationOptionImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class RouteRestorationOption {
    private static String PACKAGE = ReflexTool.PN(RouteRestorationOption.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IRouteRestorationOptionImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteRestorationOption(long j, boolean z) {
        this(new IRouteRestorationOptionImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(RouteRestorationOption.class, this, this.mControl);
        }
    }

    public RouteRestorationOption(IRouteRestorationOptionImpl iRouteRestorationOptionImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iRouteRestorationOptionImpl);
    }

    private void $constructor(IRouteRestorationOptionImpl iRouteRestorationOptionImpl) {
        if (iRouteRestorationOptionImpl != null) {
            this.mControl = iRouteRestorationOptionImpl;
            this.mTargetId = String.format("RouteRestorationOption_%s_%d", String.valueOf(IRouteRestorationOptionImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IRouteRestorationOptionImpl getControl() {
        return this.mControl;
    }

    public static RouteRestorationOption create() {
        try {
            Method method = RouteRestorationOption.class.getMethod("create", new Class[0]);
            IRouteRestorationOptionImpl create = IRouteRestorationOptionImpl.create();
            if (create != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (RouteRestorationOption) typeHelper.transfer(method, -1, (Object) create, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.model.RouteRestorationOption.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static void destroy(RouteRestorationOption routeRestorationOption) {
        try {
            Method method = RouteRestorationOption.class.getMethod("destroy", RouteRestorationOption.class);
            if (routeRestorationOption != null) {
                TypeHelper typeHelper = gTypeHelper;
                r1 = typeHelper != null ? (IRouteRestorationOptionImpl) typeHelper.transfer(method, 0, routeRestorationOption) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $routeOption == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.model.RouteRestorationOption.2
                    }));
                }
            }
            if (r1 != null) {
                IRouteRestorationOptionImpl.destroy(r1);
                routeRestorationOption.delete();
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setPaths(ArrayList<RoutepathrestorationPathsInfo> arrayList) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setPaths(arrayList);
        }
    }

    public void setStartPoints(ArrayList<RoutepathrestorationPointInfo> arrayList) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setStartPoints(arrayList);
        }
    }

    public void setViaPoints(ArrayList<RouteDisplayPoints> arrayList, ArrayList<RoutePathProjectPoints> arrayList2) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setViaPoints(arrayList, arrayList2);
        }
    }

    public void setEndPoints(ArrayList<RoutepathrestorationPointInfo> arrayList) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setEndPoints(arrayList);
        }
    }

    public void setEndName(String str) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setEndName(str);
        }
    }

    public void setContentOption(String str) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setContentOption(str);
        }
    }

    public void setRouteVer(String str) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setRouteVer(str);
        }
    }

    public void setSdkVer(String str) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setSdkVer(str);
        }
    }

    public void setCarType(int i) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setCarType(i);
        }
    }

    public void setCarSize(int i) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setCarSize(i);
        }
    }

    public void setCarHeight(double d) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setCarHeight(d);
        }
    }

    public void setCarWidth(double d) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setCarWidth(d);
        }
    }

    public void setCarLoad(double d) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setCarLoad(d);
        }
    }

    public void setCarWeight(double d) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setCarWeight(d);
        }
    }

    public void setCarAxis(int i) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setCarAxis(i);
        }
    }

    public void setCarPlate(String str) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setCarPlate(str);
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.model.RouteRestorationOption.3
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.model.RouteRestorationOption.4
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.model.RouteRestorationOption.5
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
