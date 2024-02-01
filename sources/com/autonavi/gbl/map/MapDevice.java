package com.autonavi.gbl.map;

import android.util.Log;
import android.view.Surface;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.IMapDeviceImpl;
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
@IntfAuto(target = IMapDeviceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class MapDevice {
    private static String PACKAGE = ReflexTool.PN(MapDevice.class);
    private IMapDeviceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected MapDevice(long j, boolean z) {
        this(new IMapDeviceImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(MapDevice.class, this, this.mControl);
        }
    }

    public MapDevice(IMapDeviceImpl iMapDeviceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iMapDeviceImpl);
    }

    private void $constructor(IMapDeviceImpl iMapDeviceImpl) {
        if (iMapDeviceImpl != null) {
            this.mControl = iMapDeviceImpl;
            this.mTargetId = String.format("MapDevice_%s_%d", String.valueOf(IMapDeviceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IMapDeviceImpl getControl() {
        return this.mControl;
    }

    public void addDeviceObserver(IDeviceObserver iDeviceObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MapDevice.class.getMethod("addDeviceObserver", IDeviceObserver.class);
            IDeviceObserverImpl iDeviceObserverImpl = null;
            if (iDeviceObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iDeviceObserverImpl = (IDeviceObserverImpl) typeHelper.transfer(method, 0, iDeviceObserver);
            }
            IMapDeviceImpl iMapDeviceImpl = this.mControl;
            if (iMapDeviceImpl != null) {
                iMapDeviceImpl.addDeviceObserver(iDeviceObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeDeviceObserver(IDeviceObserver iDeviceObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MapDevice.class.getMethod("removeDeviceObserver", IDeviceObserver.class);
            IDeviceObserverImpl iDeviceObserverImpl = null;
            if (iDeviceObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iDeviceObserverImpl = (IDeviceObserverImpl) typeHelper.transfer(method, 0, iDeviceObserver);
            }
            IMapDeviceImpl iMapDeviceImpl = this.mControl;
            if (iMapDeviceImpl != null) {
                iMapDeviceImpl.removeDeviceObserver(iDeviceObserverImpl);
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
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            return iMapDeviceImpl.getDeviceId();
        }
        return Integer.MIN_VALUE;
    }

    public void attachSurfaceToDevice(EGLSurfaceAttr eGLSurfaceAttr) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.attachSurfaceToDevice(eGLSurfaceAttr);
        }
    }

    public void detachSurfaceFromDevice() {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.detachSurfaceFromDevice();
        }
    }

    public boolean changeDeviceSize(EGLSurfaceAttr eGLSurfaceAttr) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            return iMapDeviceImpl.changeDeviceSize(eGLSurfaceAttr);
        }
        return false;
    }

    public long getWindowFromSurface(Surface surface) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            return iMapDeviceImpl.getWindowFromSurface(surface);
        }
        return 0L;
    }

    public String getMessageCount() {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            return iMapDeviceImpl.getMessageCount();
        }
        return null;
    }

    public void setRenderFpsByMode(int i) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.setRenderFpsByMode(i);
        }
    }

    public void setRenderFpsByMode(@MapRenderMode.MapRenderMode1 int i, int i2) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.setRenderFpsByMode(i, i2);
        }
    }

    public int getRenderFpsByMode(@MapRenderMode.MapRenderMode1 int i) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            return iMapDeviceImpl.getRenderFpsByMode(i);
        }
        return 0;
    }

    public void setRenderFpsWithTimer(int i, boolean z) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.setRenderFpsWithTimer(i, z);
        }
    }

    public void resetTickCount(int i) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.resetTickCount(i);
        }
    }

    public void renderPause() {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.renderPause();
        }
    }

    public void renderResume() {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.renderResume();
        }
    }

    public void setInnerRenderResume(boolean z) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.setInnerRenderResume(z);
        }
    }

    public boolean isRenderPaused() {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            return iMapDeviceImpl.isRenderPaused();
        }
        return false;
    }

    public void setMaxFps(long j) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.setMaxFps(j);
        }
    }

    public void setMinFps(long j) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.setMinFps(j);
        }
    }

    public void resetRenderState() {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.resetRenderState();
        }
    }

    public void setScreenshotCarType(@ScreenshotCarType.ScreenshotCarType1 int i) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.setScreenshotCarType(i);
        }
    }

    public void setScreenshotMode(@ScreenShotMode.ScreenShotMode1 int i) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.setScreenshotMode(i);
        }
    }

    public void setScreenshotMode(@ScreenShotMode.ScreenShotMode1 int i, IEGLScreenshotObserver iEGLScreenshotObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MapDevice.class.getMethod("setScreenshotMode", Integer.TYPE, IEGLScreenshotObserver.class);
            IEGLScreenshotObserverImpl iEGLScreenshotObserverImpl = null;
            if (iEGLScreenshotObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iEGLScreenshotObserverImpl = (IEGLScreenshotObserverImpl) typeHelper.transfer(method, 1, iEGLScreenshotObserver);
            }
            IMapDeviceImpl iMapDeviceImpl = this.mControl;
            if (iMapDeviceImpl != null) {
                iMapDeviceImpl.setScreenshotMode(i, iEGLScreenshotObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setScreenshotRect(int i, int i2, int i3, int i4) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.setScreenshotRect(i, i2, i3, i4);
        }
    }

    public void setScreenshotCallBackMethod(@ScreenShotCallbackMethod.ScreenShotCallbackMethod1 int i) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.setScreenshotCallBackMethod(i);
        }
    }

    @ScreenShotMode.ScreenShotMode1
    public int getScreenShotMode() {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            return iMapDeviceImpl.getScreenShotMode();
        }
        return Integer.MIN_VALUE;
    }

    public void setScreenshotParameter(@BLGLParameter.BLGLParameter1 int i, ScreenShotParam screenShotParam) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.setScreenshotParameter(i, screenShotParam);
        }
    }

    public void setFilterParam(DeviceFilterParam deviceFilterParam) {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.setFilterParam(deviceFilterParam);
        }
    }

    public void destoryFilterFBO() {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.destoryFilterFBO();
        }
    }

    public void doUnityEvent() {
        IMapDeviceImpl iMapDeviceImpl = this.mControl;
        if (iMapDeviceImpl != null) {
            iMapDeviceImpl.doUnityEvent();
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

    protected void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.observer.IDeviceObserver")).iterator();
            while (it.hasNext()) {
                removeDeviceObserver((IDeviceObserver) it.next());
            }
        }
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
