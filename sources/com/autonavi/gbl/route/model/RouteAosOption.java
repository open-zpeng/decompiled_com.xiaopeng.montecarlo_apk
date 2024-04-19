package com.autonavi.gbl.route.model;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.route.model.ExtraRequestParam;
import com.autonavi.gbl.route.model.impl.IRouteAosOptionImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IRouteAosOptionImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class RouteAosOption {
    private static String PACKAGE = ReflexTool.PN(RouteAosOption.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IRouteAosOptionImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RouteAosOption(long j, boolean z) {
        this(new IRouteAosOptionImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(RouteAosOption.class, this, this.mControl);
        }
    }

    public RouteAosOption(IRouteAosOptionImpl iRouteAosOptionImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iRouteAosOptionImpl);
    }

    private void $constructor(IRouteAosOptionImpl iRouteAosOptionImpl) {
        if (iRouteAosOptionImpl != null) {
            this.mControl = iRouteAosOptionImpl;
            this.mTargetId = String.format("RouteAosOption_%s_%d", String.valueOf(IRouteAosOptionImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IRouteAosOptionImpl getControl() {
        return this.mControl;
    }

    public static RouteAosOption create() {
        try {
            Method method = RouteAosOption.class.getMethod("create", new Class[0]);
            IRouteAosOptionImpl create = IRouteAosOptionImpl.create();
            if (create != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (RouteAosOption) typeHelper.transfer(method, -1, (Object) create, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.model.RouteAosOption.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static void destroy(RouteAosOption routeAosOption) {
        try {
            Method method = RouteAosOption.class.getMethod("destroy", RouteAosOption.class);
            if (routeAosOption != null) {
                TypeHelper typeHelper = gTypeHelper;
                r1 = typeHelper != null ? (IRouteAosOptionImpl) typeHelper.transfer(method, 0, routeAosOption) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $routeOption == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.model.RouteAosOption.2
                    }));
                }
            }
            if (r1 != null) {
                IRouteAosOptionImpl.destroy(r1);
                routeAosOption.delete();
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setFromX(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setFromX(str);
        }
    }

    public void setFromY(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setFromY(str);
        }
    }

    public void setStartPoiType(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setStartPoiType(str);
        }
    }

    public void setToX(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setToX(str);
        }
    }

    public void setToY(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setToY(str);
        }
    }

    public void setEndPoiType(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setEndPoiType(str);
        }
    }

    public void setStartPoiId(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setStartPoiId(str);
        }
    }

    public void setEndPoiId(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setEndPoiId(str);
        }
    }

    public void setViaPoints(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setViaPoints(str);
        }
    }

    public void setViaPointIds(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setViaPointIds(str);
        }
    }

    public void setViaPoiType(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setViaPoiType(str);
        }
    }

    public void setPolicy2(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setPolicy2(str);
        }
    }

    public void setRequestTimeOut(long j) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setRequestTimeOut(j);
        }
    }

    public void setFlag(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setFlag(i);
        }
    }

    public void setSdkVer(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setSdkVer(str);
        }
    }

    public void setRouteVer(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setRouteVer(str);
        }
    }

    public void setCarType(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setCarType(i);
        }
    }

    public void setVehicleCharge(float f) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setVehicleCharge(f);
        }
    }

    public void setCarHeight(float f) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setCarHeight(f);
        }
    }

    public void setCarLoad(float f) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setCarLoad(f);
        }
    }

    public void setCarWeight(float f) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setCarWeight(f);
        }
    }

    public void setCarWidth(float f) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setCarWidth(f);
        }
    }

    public void setCarLength(float f) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setCarLength(f);
        }
    }

    public void setCarSize(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setCarSize(i);
        }
    }

    public void setRefresh(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setRefresh(i);
        }
    }

    public void setContentOption(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setContentOption(i);
        }
    }

    public void setCarPlate(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setCarPlate(str);
        }
    }

    public void setUsePoiQuery(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setUsePoiQuery(str);
        }
    }

    public void setReturnFormat(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setReturnFormat(i);
        }
    }

    public void setPlayStyle(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setPlayStyle(i);
        }
    }

    public void setSoundType(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setSoundType(i);
        }
    }

    public void setGpsHelter(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setGpsHelter(str);
        }
    }

    public void setThreeD(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setThreeD(i);
        }
    }

    public void setStartLocatePrecision(float f) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setStartLocatePrecision(f);
        }
    }

    public void setStartLocateSpeed(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setStartLocateSpeed(i);
        }
    }

    public void setStartAngleCredibility(float f) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setStartAngleCredibility(f);
        }
    }

    public void setStartAngleAngle(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setStartAngleAngle(i);
        }
    }

    public void setStartDirType(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setStartDirType(i);
        }
    }

    public void setCompassDir(float f) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setCompassDir(f);
        }
    }

    public void setGpsDir(float f) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setGpsDir(f);
        }
    }

    public void setMatchingDir(float f) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setMatchingDir(f);
        }
    }

    public void setSigType(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setSigType(i);
        }
    }

    public void setGpsCredibility(float f) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setGpsCredibility(f);
        }
    }

    public void setRouteMode(int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setRouteMode(i);
        }
    }

    public void setAngleRadius(float f) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setAngleRadius(f);
        }
    }

    public void setInvoker(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setInvoker(str);
        }
    }

    public void setStartTypeCode(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setStartTypeCode(str);
        }
    }

    public void setViaTypeCode(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setViaTypeCode(str);
        }
    }

    public void setEndTypeCode(String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.setEndTypeCode(str);
        }
    }

    public void addExtraParam(@ExtraRequestParam.ExtraRequestParam1 int i, String str) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            iRouteAosOptionImpl.addExtraParam(i, str);
        }
    }

    public String getExtraParamByFild(@ExtraRequestParam.ExtraRequestParam1 int i) {
        IRouteAosOptionImpl iRouteAosOptionImpl = this.mControl;
        if (iRouteAosOptionImpl != null) {
            return iRouteAosOptionImpl.getExtraParamByFild(i);
        }
        return null;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.model.RouteAosOption.3
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.model.RouteAosOption.4
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.route.model.RouteAosOption.5
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
