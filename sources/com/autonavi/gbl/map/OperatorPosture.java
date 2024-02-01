package com.autonavi.gbl.map;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.SizeFloat;
import com.autonavi.gbl.map.impl.IOperatorPostureImpl;
import com.autonavi.gbl.map.model.CalMapZoomerLonLatParam;
import com.autonavi.gbl.map.model.CalMapZoomerParam;
import com.autonavi.gbl.map.model.Matrix4x4F;
import com.autonavi.gbl.map.model.PointD;
import com.autonavi.gbl.map.model.PointF;
import java.lang.reflect.Method;
@IntfAuto(target = IOperatorPostureImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class OperatorPosture {
    private static String PACKAGE = ReflexTool.PN(OperatorPosture.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IOperatorPostureImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected OperatorPosture(long j, boolean z) {
        this(new IOperatorPostureImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorPosture.class, this, this.mControl);
        }
    }

    public OperatorPosture(IOperatorPostureImpl iOperatorPostureImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iOperatorPostureImpl);
    }

    private void $constructor(IOperatorPostureImpl iOperatorPostureImpl) {
        if (iOperatorPostureImpl != null) {
            this.mControl = iOperatorPostureImpl;
            this.mTargetId = String.format("OperatorPosture_%s_%d", String.valueOf(IOperatorPostureImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IOperatorPostureImpl getControl() {
        return this.mControl;
    }

    public static double getMaxPitchAngle() {
        return IOperatorPostureImpl.getMaxPitchAngle();
    }

    public static double getMinPitchAngle() {
        return IOperatorPostureImpl.getMinPitchAngle();
    }

    public static float calcMapZoomScaleFactor(int i, int i2, float f) {
        return IOperatorPostureImpl.calcMapZoomScaleFactor(i, i2, f);
    }

    public static int meterToP20(double d, double d2, float f) {
        return IOperatorPostureImpl.meterToP20(d, d2, f);
    }

    public SizeFloat getViewSize() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getViewSize();
        }
        return null;
    }

    public SizeFloat getScreenSize() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getScreenSize();
        }
        return null;
    }

    public RectDouble getMapBound() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getMapBound();
        }
        return null;
    }

    public Coord3DDouble getMapCenter() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getMapCenter();
        }
        return null;
    }

    public PointF getProjectionCenter() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getProjectionCenter();
        }
        return null;
    }

    public float getMaxScale() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getMaxScale();
        }
        return 0.0f;
    }

    public float getMinScale() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getMinScale();
        }
        return 0.0f;
    }

    public float getZoomLevel() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getZoomLevel();
        }
        return 0.0f;
    }

    public float getScaleFactor() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getScaleFactor();
        }
        return 0.0f;
    }

    public float getPitchAngle() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getPitchAngle();
        }
        return 0.0f;
    }

    public float getRollAngle() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getRollAngle();
        }
        return 0.0f;
    }

    public float getRawAngle() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getRawAngle();
        }
        return 0.0f;
    }

    public float getWinSkyHeight() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getWinSkyHeight();
        }
        return 0.0f;
    }

    @Deprecated
    public boolean setWinSkyHeight(float f) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.setWinSkyHeight(f);
        }
        return false;
    }

    public float getScreenDpi() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getScreenDpi();
        }
        return 0.0f;
    }

    public float getNearScaleRate() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getNearScaleRate();
        }
        return 0.0f;
    }

    public float getCameraToCenterOriDis() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getCameraToCenterOriDis();
        }
        return 0.0f;
    }

    public float getPixelToWorldScale() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getPixelToWorldScale();
        }
        return 0.0f;
    }

    public void setMapCenter(Coord3DDouble coord3DDouble) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setMapCenter(coord3DDouble);
        }
    }

    public void setMapCenter(double d, double d2, double d3, boolean z, boolean z2) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setMapCenter(d, d2, d3, z, z2);
        }
    }

    public void setProjectionCenter(float f, float f2) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setProjectionCenter(f, f2);
        }
    }

    public void setZoomLevel(float f) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setZoomLevel(f);
        }
    }

    public void setMaxZoomLevel(float f) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setMaxZoomLevel(f);
        }
    }

    public void setMinZoomLevel(float f) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setMinZoomLevel(f);
        }
    }

    public void setZoomLevel(float f, boolean z, boolean z2) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setZoomLevel(f, z, z2);
        }
    }

    public void setRollAngle(float f) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setRollAngle(f);
        }
    }

    public void setRollAngle(float f, boolean z, boolean z2) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setRollAngle(f, z, z2);
        }
    }

    public void setRawAngle(float f) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setRawAngle(f);
        }
    }

    public void setPitchAngle(float f) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setPitchAngle(f);
        }
    }

    public void setPitchAngle(float f, boolean z, boolean z2) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setPitchAngle(f, z, z2);
        }
    }

    public void setNearDefaultValue(float f, float f2) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setNearDefaultValue(f, f2);
        }
    }

    public void recalculate() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.recalculate();
        }
    }

    public PointD screenToMap(double d, double d2) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.screenToMap(d, d2);
        }
        return null;
    }

    public Coord2DDouble screenToLonLat(double d, double d2) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.screenToLonLat(d, d2);
        }
        return null;
    }

    public PointD mapToScreen(double d, double d2, double d3) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.mapToScreen(d, d2, d3);
        }
        return null;
    }

    public static Coord2DDouble mapToLonLat(double d, double d2) {
        return IOperatorPostureImpl.mapToLonLat(d, d2);
    }

    public static PointD lonLatToMap(double d, double d2) {
        return IOperatorPostureImpl.lonLatToMap(d, d2);
    }

    public PointD lonLatToScreen(double d, double d2, double d3) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.lonLatToScreen(d, d2, d3);
        }
        return null;
    }

    public double getMapLenWithScreen(double d) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getMapLenWithScreen(d);
        }
        return 0.0d;
    }

    public double getMapLenWithScreenByY(double d, double d2) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getMapLenWithScreenByY(d, d2);
        }
        return 0.0d;
    }

    public float calculateMapZoomer(CalMapZoomerParam calMapZoomerParam) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.calculateMapZoomer(calMapZoomerParam);
        }
        return 0.0f;
    }

    public float calculateMapZoomerLonLat(CalMapZoomerLonLatParam calMapZoomerLonLatParam) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.calculateMapZoomerLonLat(calMapZoomerLonLatParam);
        }
        return 0.0f;
    }

    public Matrix4x4F getViewMatrix() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getViewMatrix();
        }
        return null;
    }

    public Matrix4x4F getProjectionMatrix() {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            return iOperatorPostureImpl.getProjectionMatrix();
        }
        return null;
    }

    public OperatorPosture cloneMapPosture() {
        IOperatorPostureImpl cloneMapPosture;
        TypeHelper typeHelper;
        try {
            Method method = OperatorPosture.class.getMethod("cloneMapPosture", new Class[0]);
            IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
            if (iOperatorPostureImpl == null || (cloneMapPosture = iOperatorPostureImpl.cloneMapPosture()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (OperatorPosture) typeHelper.transfer(method, -1, (Object) cloneMapPosture, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void updateMapPosture(OperatorPosture operatorPosture) {
        TypeHelper typeHelper;
        try {
            Method method = OperatorPosture.class.getMethod("updateMapPosture", OperatorPosture.class);
            IOperatorPostureImpl iOperatorPostureImpl = null;
            if (operatorPosture != null && (typeHelper = this.mTypeHelper) != null) {
                iOperatorPostureImpl = (IOperatorPostureImpl) typeHelper.transfer(method, 0, operatorPosture);
            }
            IOperatorPostureImpl iOperatorPostureImpl2 = this.mControl;
            if (iOperatorPostureImpl2 != null) {
                iOperatorPostureImpl2.updateMapPosture(iOperatorPostureImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public static void destroyClonedMapPosture(OperatorPosture operatorPosture) {
        TypeHelper typeHelper;
        try {
            IOperatorPostureImpl iOperatorPostureImpl = (operatorPosture == null || (typeHelper = gTypeHelper) == null) ? null : (IOperatorPostureImpl) typeHelper.transfer(OperatorPosture.class.getMethod("destroyClonedMapPosture", OperatorPosture.class), 0, operatorPosture);
            if (operatorPosture != null) {
                ReflexTool.invokeDeclMethodSafe(operatorPosture, "onDestroy", null, null);
            }
            IOperatorPostureImpl.destroyClonedMapPosture(iOperatorPostureImpl);
            if (operatorPosture != null) {
                ReflexTool.invokeDeclMethodSafe(operatorPosture, RequestParameters.SUBRESOURCE_DELETE, null, null);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public OperatorPosture cloneDicePosture() {
        IOperatorPostureImpl cloneDicePosture;
        TypeHelper typeHelper;
        try {
            Method method = OperatorPosture.class.getMethod("cloneDicePosture", new Class[0]);
            IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
            if (iOperatorPostureImpl == null || (cloneDicePosture = iOperatorPostureImpl.cloneDicePosture()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (OperatorPosture) typeHelper.transfer(method, -1, (Object) cloneDicePosture, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void updateDicePosture(OperatorPosture operatorPosture) {
        TypeHelper typeHelper;
        try {
            Method method = OperatorPosture.class.getMethod("updateDicePosture", OperatorPosture.class);
            IOperatorPostureImpl iOperatorPostureImpl = null;
            if (operatorPosture != null && (typeHelper = this.mTypeHelper) != null) {
                iOperatorPostureImpl = (IOperatorPostureImpl) typeHelper.transfer(method, 0, operatorPosture);
            }
            IOperatorPostureImpl iOperatorPostureImpl2 = this.mControl;
            if (iOperatorPostureImpl2 != null) {
                iOperatorPostureImpl2.updateDicePosture(iOperatorPostureImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public static void destroyClonedDicePosture(OperatorPosture operatorPosture) {
        TypeHelper typeHelper;
        try {
            IOperatorPostureImpl iOperatorPostureImpl = (operatorPosture == null || (typeHelper = gTypeHelper) == null) ? null : (IOperatorPostureImpl) typeHelper.transfer(OperatorPosture.class.getMethod("destroyClonedDicePosture", OperatorPosture.class), 0, operatorPosture);
            if (operatorPosture != null) {
                ReflexTool.invokeDeclMethodSafe(operatorPosture, "onDestroy", null, null);
            }
            IOperatorPostureImpl.destroyClonedDicePosture(iOperatorPostureImpl);
            if (operatorPosture != null) {
                ReflexTool.invokeDeclMethodSafe(operatorPosture, RequestParameters.SUBRESOURCE_DELETE, null, null);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public static double meterToMapPixel(double d, double d2, double d3) {
        return IOperatorPostureImpl.meterToMapPixel(d, d2, d3);
    }

    public static boolean isSameCoordByLonLat(Coord3DDouble coord3DDouble, Coord3DDouble coord3DDouble2) {
        return IOperatorPostureImpl.isSameCoordByLonLat(coord3DDouble, coord3DDouble2);
    }

    public void setNakeEyeProjectionCenterPercent(float f, float f2, float f3, float f4) {
        IOperatorPostureImpl iOperatorPostureImpl = this.mControl;
        if (iOperatorPostureImpl != null) {
            iOperatorPostureImpl.setNakeEyeProjectionCenterPercent(f, f2, f3, f4);
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

    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
