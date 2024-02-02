package com.autonavi.gbl.map;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.SizeFloat;
import com.autonavi.gbl.map.impl.OperatorPostureImpl;
import com.autonavi.gbl.map.model.CalMapZoomerLonLatParam;
import com.autonavi.gbl.map.model.CalMapZoomerParam;
import com.autonavi.gbl.map.model.MapBound;
import com.autonavi.gbl.map.model.Matrix4x4F;
import com.autonavi.gbl.map.model.PointD;
import java.lang.reflect.Method;
@IntfAuto(target = OperatorPostureImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class OperatorPosture {
    private static String PACKAGE = ReflexTool.PN(OperatorPosture.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private OperatorPostureImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected OperatorPosture(long j, boolean z) {
        this(new OperatorPostureImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorPosture.class, this, this.mControl);
        }
    }

    public OperatorPosture(OperatorPostureImpl operatorPostureImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(operatorPostureImpl);
    }

    private void $constructor(OperatorPostureImpl operatorPostureImpl) {
        if (operatorPostureImpl != null) {
            this.mControl = operatorPostureImpl;
            this.mTargetId = String.format("OperatorPosture_%s_%d", String.valueOf(OperatorPostureImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected OperatorPostureImpl getControl() {
        return this.mControl;
    }

    public static double getMaxPitchAngle() {
        return OperatorPostureImpl.getMaxPitchAngle();
    }

    public static double getMinPitchAngle() {
        return OperatorPostureImpl.getMinPitchAngle();
    }

    public static float calcMapZoomScaleFactor(int i, int i2, float f) {
        return OperatorPostureImpl.calcMapZoomScaleFactor(i, i2, f);
    }

    public static int meterToP20(double d, double d2, float f) {
        return OperatorPostureImpl.meterToP20(d, d2, f);
    }

    public SizeFloat getViewSize() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getViewSize();
        }
        return null;
    }

    public SizeFloat getScreenSize() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getScreenSize();
        }
        return null;
    }

    public MapBound getMapBound() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getMapBound();
        }
        return null;
    }

    public Coord3DDouble getMapCenter() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getMapCenter();
        }
        return null;
    }

    public SizeFloat getProjectionCenter() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getProjectionCenter();
        }
        return null;
    }

    public float getMaxScale() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getMaxScale();
        }
        return 0.0f;
    }

    public float getMinScale() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getMinScale();
        }
        return 0.0f;
    }

    public float getZoomLevel() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getZoomLevel();
        }
        return 0.0f;
    }

    public float getScaleFactor() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getScaleFactor();
        }
        return 0.0f;
    }

    public float getPitchAngle() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getPitchAngle();
        }
        return 0.0f;
    }

    public float getRollAngle() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getRollAngle();
        }
        return 0.0f;
    }

    public float getRawAngle() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getRawAngle();
        }
        return 0.0f;
    }

    public float getWinSkyHeight() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getWinSkyHeight();
        }
        return 0.0f;
    }

    public float getScreenDpi() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getScreenDpi();
        }
        return 0.0f;
    }

    public float getNearScaleRate() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getNearScaleRate();
        }
        return 0.0f;
    }

    public float getCameraToCenterOriDis() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getCameraToCenterOriDis();
        }
        return 0.0f;
    }

    public float getPixelToWorldScale() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getPixelToWorldScale();
        }
        return 0.0f;
    }

    public void setMapCenter(Coord3DDouble coord3DDouble) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.setMapCenter(coord3DDouble);
        }
    }

    public void setMapCenter(double d, double d2, double d3, boolean z, boolean z2) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.setMapCenter(d, d2, d3, z, z2);
        }
    }

    public void setProjectionCenter(float f, float f2) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.setProjectionCenter(f, f2);
        }
    }

    public void setZoomLevel(float f) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.setZoomLevel(f);
        }
    }

    public void setMaxZoomLevel(float f) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.setMaxZoomLevel(f);
        }
    }

    public void setMinZoomLevel(float f) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.setMinZoomLevel(f);
        }
    }

    public void setZoomLevel(float f, boolean z, boolean z2) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.setZoomLevel(f, z, z2);
        }
    }

    public void setRollAngle(float f) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.setRollAngle(f);
        }
    }

    public void setRollAngle(float f, boolean z, boolean z2) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.setRollAngle(f, z, z2);
        }
    }

    public void setRawAngle(float f) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.setRawAngle(f);
        }
    }

    public void setPitchAngle(float f) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.setPitchAngle(f);
        }
    }

    public void setPitchAngle(float f, boolean z, boolean z2) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.setPitchAngle(f, z, z2);
        }
    }

    public void setNearDefaultValue(float f, float f2) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.setNearDefaultValue(f, f2);
        }
    }

    public void recalculate() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            operatorPostureImpl.recalculate();
        }
    }

    public Coord2DDouble screenToMap(double d, double d2) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.screenToMap(d, d2);
        }
        return null;
    }

    public Coord2DDouble screenToLonLat(double d, double d2) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.screenToLonLat(d, d2);
        }
        return null;
    }

    public PointD mapToScreen(double d, double d2, double d3) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.mapToScreen(d, d2, d3);
        }
        return null;
    }

    public static Coord2DDouble mapToLonLat(double d, double d2) {
        return OperatorPostureImpl.mapToLonLat(d, d2);
    }

    public static Coord2DDouble lonLatToMap(double d, double d2) {
        return OperatorPostureImpl.lonLatToMap(d, d2);
    }

    public PointD lonLatToScreen(double d, double d2, double d3) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.lonLatToScreen(d, d2, d3);
        }
        return null;
    }

    public double getMapLenWithScreen(double d) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getMapLenWithScreen(d);
        }
        return 0.0d;
    }

    public double getMapLenWithScreenByY(double d, double d2) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getMapLenWithScreenByY(d, d2);
        }
        return 0.0d;
    }

    public float calculateMapZoomer(CalMapZoomerParam calMapZoomerParam) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.calculateMapZoomer(calMapZoomerParam);
        }
        return 0.0f;
    }

    public float calculateMapZoomerLonLat(CalMapZoomerLonLatParam calMapZoomerLonLatParam) {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.calculateMapZoomerLonLat(calMapZoomerLonLatParam);
        }
        return 0.0f;
    }

    public Matrix4x4F getViewMatrix() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getViewMatrix();
        }
        return null;
    }

    public Matrix4x4F getProjectionMatrix() {
        OperatorPostureImpl operatorPostureImpl = this.mControl;
        if (operatorPostureImpl != null) {
            return operatorPostureImpl.getProjectionMatrix();
        }
        return null;
    }

    public OperatorPosture cloneMapPosture() {
        OperatorPostureImpl cloneMapPosture;
        try {
            Method method = OperatorPosture.class.getMethod("cloneMapPosture", new Class[0]);
            OperatorPostureImpl operatorPostureImpl = this.mControl;
            if (operatorPostureImpl != null && (cloneMapPosture = operatorPostureImpl.cloneMapPosture()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (OperatorPosture) typeHelper.transfer(method, -1, (Object) cloneMapPosture, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorPosture.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void updateMapPosture(OperatorPosture operatorPosture) {
        try {
            Method method = OperatorPosture.class.getMethod("updateMapPosture", OperatorPosture.class);
            if (operatorPosture != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (OperatorPostureImpl) typeHelper.transfer(method, 0, operatorPosture) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $copy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorPosture.2
                    }));
                }
            }
            OperatorPostureImpl operatorPostureImpl = this.mControl;
            if (operatorPostureImpl != null) {
                operatorPostureImpl.updateMapPosture(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public static void destroyClonedMapPosture(OperatorPosture operatorPosture) {
        OperatorPostureImpl operatorPostureImpl;
        try {
            Method method = OperatorPosture.class.getMethod("destroyClonedMapPosture", OperatorPosture.class);
            if (operatorPosture != null) {
                TypeHelper typeHelper = gTypeHelper;
                operatorPostureImpl = typeHelper != null ? (OperatorPostureImpl) typeHelper.transfer(method, 0, operatorPosture) : null;
                if (operatorPostureImpl == null) {
                    DebugTool.e("%s: $pMapPosture == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorPosture.3
                    }));
                }
            } else {
                operatorPostureImpl = null;
            }
            if (operatorPosture != null) {
                ReflexTool.invokeDeclMethodSafe(operatorPosture, "onDestroy", null, null);
            }
            OperatorPostureImpl.destroyClonedMapPosture(operatorPostureImpl);
            if (operatorPosture != null) {
                ReflexTool.invokeDeclMethodSafe(operatorPosture, RequestParameters.SUBRESOURCE_DELETE, null, null);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public OperatorPosture cloneDicePosture() {
        OperatorPostureImpl cloneDicePosture;
        try {
            Method method = OperatorPosture.class.getMethod("cloneDicePosture", new Class[0]);
            OperatorPostureImpl operatorPostureImpl = this.mControl;
            if (operatorPostureImpl != null && (cloneDicePosture = operatorPostureImpl.cloneDicePosture()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (OperatorPosture) typeHelper.transfer(method, -1, (Object) cloneDicePosture, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorPosture.4
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void updateDicePosture(OperatorPosture operatorPosture) {
        try {
            Method method = OperatorPosture.class.getMethod("updateDicePosture", OperatorPosture.class);
            if (operatorPosture != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (OperatorPostureImpl) typeHelper.transfer(method, 0, operatorPosture) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $copy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorPosture.5
                    }));
                }
            }
            OperatorPostureImpl operatorPostureImpl = this.mControl;
            if (operatorPostureImpl != null) {
                operatorPostureImpl.updateDicePosture(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public static void destroyClonedDicePosture(OperatorPosture operatorPosture) {
        OperatorPostureImpl operatorPostureImpl;
        try {
            Method method = OperatorPosture.class.getMethod("destroyClonedDicePosture", OperatorPosture.class);
            if (operatorPosture != null) {
                TypeHelper typeHelper = gTypeHelper;
                operatorPostureImpl = typeHelper != null ? (OperatorPostureImpl) typeHelper.transfer(method, 0, operatorPosture) : null;
                if (operatorPostureImpl == null) {
                    DebugTool.e("%s: $pMapPosture == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorPosture.6
                    }));
                }
            } else {
                operatorPostureImpl = null;
            }
            if (operatorPosture != null) {
                ReflexTool.invokeDeclMethodSafe(operatorPosture, "onDestroy", null, null);
            }
            OperatorPostureImpl.destroyClonedDicePosture(operatorPostureImpl);
            if (operatorPosture != null) {
                ReflexTool.invokeDeclMethodSafe(operatorPosture, RequestParameters.SUBRESOURCE_DELETE, null, null);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public static double meterToMapPixel(double d, double d2, double d3) {
        return OperatorPostureImpl.meterToMapPixel(d, d2, d3);
    }

    public static boolean isSameCoordByLonLat(Coord3DDouble coord3DDouble, Coord3DDouble coord3DDouble2) {
        return OperatorPostureImpl.isSameCoordByLonLat(coord3DDouble, coord3DDouble2);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorPosture.7
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorPosture.8
        }));
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorPosture.9
        }));
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
