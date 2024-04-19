package com.autonavi.gbl.map;

import android.util.Log;
import android.view.Surface;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.MapDeviceImpl;
import com.autonavi.gbl.map.model.BLGLParameter;
import com.autonavi.gbl.map.model.DeviceFilterParam;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.autonavi.gbl.map.model.MapRenderMode;
import com.autonavi.gbl.map.model.ScreenShotCallbackMethod;
import com.autonavi.gbl.map.model.ScreenShotMode;
import com.autonavi.gbl.map.model.ScreenShotParam;
import com.autonavi.gbl.map.model.ScreenshotCarType;
import com.autonavi.gbl.map.observer.IDeviceObserver;
import com.autonavi.gbl.map.observer.IEGLScreenshotObserver;
import com.autonavi.gbl.map.observer.impl.IDeviceObserverImpl;
import com.autonavi.gbl.map.observer.impl.IEGLScreenshotObserverImpl;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = MapDeviceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class MapDevice {
    private static String PACKAGE = ReflexTool.PN(MapDevice.class);
    private MapDeviceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected MapDevice(long j, boolean z) {
        this(new MapDeviceImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(MapDevice.class, this, this.mControl);
        }
    }

    public MapDevice(MapDeviceImpl mapDeviceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(mapDeviceImpl);
    }

    private void $constructor(MapDeviceImpl mapDeviceImpl) {
        if (mapDeviceImpl != null) {
            this.mControl = mapDeviceImpl;
            this.mTargetId = String.format("MapDevice_%s_%d", String.valueOf(MapDeviceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected MapDeviceImpl getControl() {
        return this.mControl;
    }

    public void addDeviceObserver(IDeviceObserver iDeviceObserver) {
        try {
            Method method = MapDevice.class.getMethod("addDeviceObserver", IDeviceObserver.class);
            if (iDeviceObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IDeviceObserverImpl) typeHelper.transfer(method, 0, iDeviceObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pIDeviceObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapDevice.1
                    }));
                }
            }
            MapDeviceImpl mapDeviceImpl = this.mControl;
            if (mapDeviceImpl != null) {
                mapDeviceImpl.addDeviceObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeDeviceObserver(IDeviceObserver iDeviceObserver) {
        try {
            Method method = MapDevice.class.getMethod("removeDeviceObserver", IDeviceObserver.class);
            if (iDeviceObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IDeviceObserverImpl) typeHelper.transfer(method, 0, iDeviceObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pIDeviceObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapDevice.2
                    }));
                }
            }
            MapDeviceImpl mapDeviceImpl = this.mControl;
            if (mapDeviceImpl != null) {
                mapDeviceImpl.removeDeviceObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iDeviceObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @EGLDeviceID.EGLDeviceID1
    public int getDeviceId() {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            return mapDeviceImpl.getDeviceId();
        }
        return Integer.MIN_VALUE;
    }

    public void attachSurfaceToDevice(EGLSurfaceAttr eGLSurfaceAttr) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.attachSurfaceToDevice(eGLSurfaceAttr);
        }
    }

    public void detachSurfaceFromDevice() {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.detachSurfaceFromDevice();
        }
    }

    public boolean changeDeviceSize(EGLSurfaceAttr eGLSurfaceAttr) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            return mapDeviceImpl.changeDeviceSize(eGLSurfaceAttr);
        }
        return false;
    }

    public long getWindowFromSurface(Surface surface) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            return mapDeviceImpl.getWindowFromSurface(surface);
        }
        return 0L;
    }

    public void setRenderFpsByMode(int i) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.setRenderFpsByMode(i);
        }
    }

    public void setRenderFpsByMode(@MapRenderMode.MapRenderMode1 int i, int i2) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.setRenderFpsByMode(i, i2);
        }
    }

    public int getRenderFpsByMode(@MapRenderMode.MapRenderMode1 int i) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            return mapDeviceImpl.getRenderFpsByMode(i);
        }
        return 0;
    }

    public void setRenderFpsWithTimer(int i, boolean z) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.setRenderFpsWithTimer(i, z);
        }
    }

    public void resetTickCount(int i) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.resetTickCount(i);
        }
    }

    public void renderPause() {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.renderPause();
        }
    }

    public void renderResume() {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.renderResume();
        }
    }

    public void setInnerRenderResume(boolean z) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.setInnerRenderResume(z);
        }
    }

    public boolean isRenderPaused() {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            return mapDeviceImpl.isRenderPaused();
        }
        return false;
    }

    public void setMaxFps(long j) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.setMaxFps(j);
        }
    }

    public void setMinFps(long j) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.setMinFps(j);
        }
    }

    public void resetRenderState() {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.resetRenderState();
        }
    }

    public void setScreenshotCarType(@ScreenshotCarType.ScreenshotCarType1 int i) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.setScreenshotCarType(i);
        }
    }

    public void setScreenshotMode(@ScreenShotMode.ScreenShotMode1 int i) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.setScreenshotMode(i);
        }
    }

    public void setScreenshotMode(@ScreenShotMode.ScreenShotMode1 int i, IEGLScreenshotObserver iEGLScreenshotObserver) {
        try {
            Method method = MapDevice.class.getMethod("setScreenshotMode", Integer.TYPE, IEGLScreenshotObserver.class);
            if (iEGLScreenshotObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IEGLScreenshotObserverImpl) typeHelper.transfer(method, 1, iEGLScreenshotObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $Observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapDevice.3
                    }));
                }
            }
            MapDeviceImpl mapDeviceImpl = this.mControl;
            if (mapDeviceImpl != null) {
                mapDeviceImpl.setScreenshotMode(i, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setScreenshotRect(int i, int i2, int i3, int i4) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.setScreenshotRect(i, i2, i3, i4);
        }
    }

    public void setScreenshotCallBackMethod(@ScreenShotCallbackMethod.ScreenShotCallbackMethod1 int i) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.setScreenshotCallBackMethod(i);
        }
    }

    @ScreenShotMode.ScreenShotMode1
    public int getScreenShotMode() {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            return mapDeviceImpl.getScreenShotMode();
        }
        return Integer.MIN_VALUE;
    }

    public void setScreenshotParameter(@BLGLParameter.BLGLParameter1 int i, ScreenShotParam screenShotParam) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.setScreenshotParameter(i, screenShotParam);
        }
    }

    public void setFilterParam(DeviceFilterParam deviceFilterParam) {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.setFilterParam(deviceFilterParam);
        }
    }

    public void destoryFilterFBO() {
        MapDeviceImpl mapDeviceImpl = this.mControl;
        if (mapDeviceImpl != null) {
            mapDeviceImpl.destoryFilterFBO();
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapDevice.4
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapDevice.5
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.observer.IDeviceObserver")).iterator();
            while (it.hasNext()) {
                removeDeviceObserver((IDeviceObserver) it.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.MapDevice.6
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
