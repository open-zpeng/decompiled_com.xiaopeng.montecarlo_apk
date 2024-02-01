package com.autonavi.gbl.route.model;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.RouteDisplayPoints;
import com.autonavi.gbl.aosclient.model.RoutePathProjectPoints;
import com.autonavi.gbl.aosclient.model.RoutepathrestorationPathsInfo;
import com.autonavi.gbl.aosclient.model.RoutepathrestorationPointInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
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

    protected void clean() {
    }

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
        TypeHelper typeHelper;
        try {
            Method method = RouteRestorationOption.class.getMethod("create", new Class[0]);
            IRouteRestorationOptionImpl create = IRouteRestorationOptionImpl.create();
            if (create == null || (typeHelper = gTypeHelper) == null) {
                return null;
            }
            return (RouteRestorationOption) typeHelper.transfer(method, -1, (Object) create, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static void destroy(RouteRestorationOption routeRestorationOption) {
        TypeHelper typeHelper;
        try {
            Method method = RouteRestorationOption.class.getMethod("destroy", RouteRestorationOption.class);
            IRouteRestorationOptionImpl iRouteRestorationOptionImpl = null;
            if (routeRestorationOption != null && (typeHelper = gTypeHelper) != null) {
                iRouteRestorationOptionImpl = (IRouteRestorationOptionImpl) typeHelper.transfer(method, 0, routeRestorationOption);
            }
            if (iRouteRestorationOptionImpl != null) {
                IRouteRestorationOptionImpl.destroy(iRouteRestorationOptionImpl);
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

    public void setType(String str) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setType(str);
        }
    }

    public void setFlag(String str) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setFlag(str);
        }
    }

    public void setPriorityType(long j) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setPriorityType(j);
        }
    }

    public void setOfflineRouteOption(RouteOption routeOption) {
        TypeHelper typeHelper;
        try {
            Method method = RouteRestorationOption.class.getMethod("setOfflineRouteOption", RouteOption.class);
            IRouteOptionImpl iRouteOptionImpl = null;
            if (routeOption != null && (typeHelper = this.mTypeHelper) != null) {
                iRouteOptionImpl = (IRouteOptionImpl) typeHelper.transfer(method, 0, routeOption);
            }
            IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
            if (iRouteRestorationOptionImpl != null) {
                iRouteRestorationOptionImpl.setOfflineRouteOption(iRouteOptionImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setNeedSwitchToLocal(boolean z) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setNeedSwitchToLocal(z);
        }
    }

    public void setNaviId(String str) {
        IRouteRestorationOptionImpl iRouteRestorationOptionImpl = this.mControl;
        if (iRouteRestorationOptionImpl != null) {
            iRouteRestorationOptionImpl.setNaviId(str);
        }
    }

    protected void unbind() {
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

    public synchronized void delete() {
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
