package com.autonavi.gbl.common.path.option;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.POIInfo;
import com.autonavi.gbl.common.path.model.PointType;
import com.autonavi.gbl.common.path.option.impl.IPOIForRequestImpl;
import java.lang.reflect.Method;
import java.math.BigInteger;
@IntfAuto(target = IPOIForRequestImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class POIForRequest {
    private static String PACKAGE = ReflexTool.PN(POIForRequest.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IPOIForRequestImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected POIForRequest(long j, boolean z) {
        this(new IPOIForRequestImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(POIForRequest.class, this, this.mControl);
        }
    }

    public POIForRequest(IPOIForRequestImpl iPOIForRequestImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iPOIForRequestImpl);
    }

    private void $constructor(IPOIForRequestImpl iPOIForRequestImpl) {
        if (iPOIForRequestImpl != null) {
            this.mControl = iPOIForRequestImpl;
            this.mTargetId = String.format("POIForRequest_%s_%d", String.valueOf(IPOIForRequestImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IPOIForRequestImpl getControl() {
        return this.mControl;
    }

    public POIInfo getPoint(@PointType.PointType1 int i, long j) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.getPoint(i, j);
        }
        return null;
    }

    public static POIForRequest create() {
        try {
            Method method = POIForRequest.class.getMethod("create", new Class[0]);
            IPOIForRequestImpl create = IPOIForRequestImpl.create();
            if (create != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (POIForRequest) typeHelper.transfer(method, -1, (Object) create, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.POIForRequest.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public static void destroy(POIForRequest pOIForRequest) {
        try {
            Method method = POIForRequest.class.getMethod("destroy", POIForRequest.class);
            if (pOIForRequest != null) {
                TypeHelper typeHelper = gTypeHelper;
                r1 = typeHelper != null ? (IPOIForRequestImpl) typeHelper.transfer(method, 0, pOIForRequest) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pPOIForRequest == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.POIForRequest.2
                    }));
                }
            }
            if (r1 != null) {
                IPOIForRequestImpl.destroy(r1);
                pOIForRequest.delete();
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setDirection(float f) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setDirection(f);
        }
    }

    public float getDirection() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.getDirection();
        }
        return 0.0f;
    }

    public void setReliability(float f) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setReliability(f);
        }
    }

    public float getReliability() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.getReliability();
        }
        return 0.0f;
    }

    public void setAngleType(int i) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setAngleType(i);
        }
    }

    public int getAngleType() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.getAngleType();
        }
        return 0;
    }

    public void setSourceInfo(String str) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setSourceInfo(str);
        }
    }

    public String getSourceInfo() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.getSourceInfo();
        }
        return null;
    }

    public void setAngleGps(float f) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setAngleGps(f);
        }
    }

    public float getAngleGps() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.getAngleGps();
        }
        return 0.0f;
    }

    public void setAngleComp(float f) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setAngleComp(f);
        }
    }

    public float getAngleComp() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.getAngleComp();
        }
        return 0.0f;
    }

    public void setMatchingDir(float f) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setMatchingDir(f);
        }
    }

    public float matchingDir() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.matchingDir();
        }
        return 0.0f;
    }

    public void setFittingDir(float f) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setFittingDir(f);
        }
    }

    public float fittingDir() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.fittingDir();
        }
        return 0.0f;
    }

    public void setRadius(float f) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setRadius(f);
        }
    }

    public float radius() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.radius();
        }
        return 0.0f;
    }

    public void setSigType(int i) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setSigType(i);
        }
    }

    public int sigType() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.sigType();
        }
        return 0;
    }

    public void setGpsCredit(float f) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setGpsCredit(f);
        }
    }

    public float gpsCredit() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.gpsCredit();
        }
        return 0.0f;
    }

    public void setFittingCredit(float f) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setFittingCredit(f);
        }
    }

    public float fittingCredit() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.fittingCredit();
        }
        return 0.0f;
    }

    public void setPrecision(float f) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setPrecision(f);
        }
    }

    public float precision() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.precision();
        }
        return 0.0f;
    }

    public void setSpeed(float f) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setSpeed(f);
        }
    }

    public float getSpeed() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.getSpeed();
        }
        return 0.0f;
    }

    public void setFormWay(int i) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setFormWay(i);
        }
    }

    public int getFormWay() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.getFormWay();
        }
        return 0;
    }

    public void setLinkType(int i) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setLinkType(i);
        }
    }

    public int getLinkType() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.getLinkType();
        }
        return 0;
    }

    public void addPoint(@PointType.PointType1 int i, POIInfo pOIInfo) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.addPoint(i, pOIInfo);
        }
    }

    public void clearPoint(@PointType.PointType1 int i) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.clearPoint(i);
        }
    }

    public long getPointSize(@PointType.PointType1 int i) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.getPointSize(i);
        }
        return 0L;
    }

    public boolean setPointRoadID(@PointType.PointType1 int i, long j, BigInteger bigInteger) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.setPointRoadID(i, j, bigInteger);
        }
        return false;
    }

    public void reset() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.reset();
        }
    }

    public long getNativeTypeHandle() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.getNativeTypeHandle();
        }
        return 0L;
    }

    public void copy(POIForRequest pOIForRequest) {
        try {
            Method method = POIForRequest.class.getMethod("copy", POIForRequest.class);
            if (pOIForRequest != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IPOIForRequestImpl) typeHelper.transfer(method, 0, pOIForRequest) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $src == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.POIForRequest.3
                    }));
                }
            }
            IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
            if (iPOIForRequestImpl != null) {
                iPOIForRequestImpl.copy(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setParkingBuildingID(long j) {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            iPOIForRequestImpl.setParkingBuildingID(j);
        }
    }

    public long getParkingBuildingID() {
        IPOIForRequestImpl iPOIForRequestImpl = this.mControl;
        if (iPOIForRequestImpl != null) {
            return iPOIForRequestImpl.getParkingBuildingID();
        }
        return 0L;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.POIForRequest.4
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.POIForRequest.5
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.POIForRequest.6
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
