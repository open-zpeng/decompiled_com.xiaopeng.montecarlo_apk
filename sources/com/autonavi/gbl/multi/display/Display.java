package com.autonavi.gbl.multi.display;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.MapDevice;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.IMapDeviceImpl;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.multi.display.impl.IDisplayCropImpl;
import com.autonavi.gbl.multi.display.impl.IDisplayImpl;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.display.observer.IMapDisplayObserver;
import com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IDisplayImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class Display {
    private static String PACKAGE = ReflexTool.PN(Display.class);
    private IDisplayImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected Display(long j, boolean z) {
        this(new IDisplayImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(Display.class, this, this.mControl);
        }
    }

    public Display(IDisplayImpl iDisplayImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iDisplayImpl);
    }

    private void $constructor(IDisplayImpl iDisplayImpl) {
        if (iDisplayImpl != null) {
            this.mControl = iDisplayImpl;
            this.mTargetId = String.format("Display_%s_%d", String.valueOf(IDisplayImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IDisplayImpl getControl() {
        return this.mControl;
    }

    public int getId() {
        IDisplayImpl iDisplayImpl = this.mControl;
        if (iDisplayImpl != null) {
            return iDisplayImpl.getId();
        }
        return 0;
    }

    @DisplayType.DisplayType1
    public int getType() {
        IDisplayImpl iDisplayImpl = this.mControl;
        if (iDisplayImpl != null) {
            return iDisplayImpl.getType();
        }
        return Integer.MIN_VALUE;
    }

    public boolean isRemote() {
        IDisplayImpl iDisplayImpl = this.mControl;
        if (iDisplayImpl != null) {
            return iDisplayImpl.isRemote();
        }
        return false;
    }

    public MapView getMapView() {
        IMapViewImpl mapView;
        TypeHelper typeHelper;
        try {
            Method method = Display.class.getMethod("getMapView", new Class[0]);
            IDisplayImpl iDisplayImpl = this.mControl;
            if (iDisplayImpl == null || (mapView = iDisplayImpl.getMapView()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (MapView) typeHelper.transfer(method, -1, (Object) mapView, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public MapDevice getMapDevice() {
        IMapDeviceImpl mapDevice;
        TypeHelper typeHelper;
        try {
            Method method = Display.class.getMethod("getMapDevice", new Class[0]);
            IDisplayImpl iDisplayImpl = this.mControl;
            if (iDisplayImpl == null || (mapDevice = iDisplayImpl.getMapDevice()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (MapDevice) typeHelper.transfer(method, -1, (Object) mapDevice, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public DisplayCrop getCrop() {
        IDisplayCropImpl crop;
        TypeHelper typeHelper;
        try {
            Method method = Display.class.getMethod("getCrop", new Class[0]);
            IDisplayImpl iDisplayImpl = this.mControl;
            if (iDisplayImpl == null || (crop = iDisplayImpl.getCrop()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (DisplayCrop) typeHelper.transfer(method, -1, (Object) crop, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void addObserver(IMapDisplayObserver iMapDisplayObserver) {
        TypeHelper typeHelper;
        try {
            Method method = Display.class.getMethod("addObserver", IMapDisplayObserver.class);
            IMapDisplayObserverImpl iMapDisplayObserverImpl = null;
            if (iMapDisplayObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMapDisplayObserverImpl = (IMapDisplayObserverImpl) typeHelper.transfer(method, 0, iMapDisplayObserver);
            }
            IDisplayImpl iDisplayImpl = this.mControl;
            if (iDisplayImpl != null) {
                iDisplayImpl.addObserver(iMapDisplayObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeObserver(IMapDisplayObserver iMapDisplayObserver) {
        TypeHelper typeHelper;
        try {
            Method method = Display.class.getMethod("removeObserver", IMapDisplayObserver.class);
            IMapDisplayObserverImpl iMapDisplayObserverImpl = null;
            if (iMapDisplayObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMapDisplayObserverImpl = (IMapDisplayObserverImpl) typeHelper.transfer(method, 0, iMapDisplayObserver);
            }
            IDisplayImpl iDisplayImpl = this.mControl;
            if (iDisplayImpl != null) {
                iDisplayImpl.removeObserver(iMapDisplayObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iMapDisplayObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
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
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.multi.display.observer.IMapDisplayObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((IMapDisplayObserver) it.next());
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
