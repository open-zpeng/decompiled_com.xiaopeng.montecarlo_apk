package com.autonavi.gbl.multi.display.model;

import android.util.Log;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.autonavi.gbl.map.observer.IBLMapViewProxy;
import com.autonavi.gbl.map.observer.impl.IBLMapViewProxyImpl;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.display.observer.IMapDisplayObserver;
import com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;
/* loaded from: classes2.dex */
public class DisplayCreateParam implements Serializable {
    private DeviceAttribute deviceAttribute;
    private DisplayAttribute displayAttribute;
    private IMapDisplayObserverImpl displayObserver;
    @DisplayType.DisplayType1
    private int displayType;
    private TypeHelper mTypeHelper;
    private IBLMapViewProxyImpl mapviewProxy;
    private EGLSurfaceAttr surfaceAttribute;

    public void delete() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    private void initTypeHelper() {
        this.mTypeHelper = new TypeHelper("DisplayCreateParam" + hashCode());
    }

    private void recordByIntfAuto() {
        getDisplayObserver();
        getMapviewProxy();
    }

    public void setDisplayType(int i) {
        this.displayType = i;
    }

    public int getDisplayType() {
        return this.displayType;
    }

    public void setDisplayAttribute(DisplayAttribute displayAttribute) {
        this.displayAttribute = displayAttribute;
    }

    public DisplayAttribute getDisplayAttribute() {
        return this.displayAttribute;
    }

    public void setDeviceAttribute(DeviceAttribute deviceAttribute) {
        this.deviceAttribute = deviceAttribute;
    }

    public DeviceAttribute getDeviceAttribute() {
        return this.deviceAttribute;
    }

    public void setSurfaceAttribute(EGLSurfaceAttr eGLSurfaceAttr) {
        this.surfaceAttribute = eGLSurfaceAttr;
    }

    public EGLSurfaceAttr getSurfaceAttribute() {
        return this.surfaceAttribute;
    }

    public void setDisplayObserver(IMapDisplayObserver iMapDisplayObserver) {
        ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.multi.display.model.DisplayCreateParam.1
        });
        try {
            Method method = getClass().getMethod("setDisplayObserver", IMapDisplayObserver.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                Set bindSet = typeHelper.getBindSet(method, 0);
                bindSet.remove(iMapDisplayObserver);
                this.displayObserver = (IMapDisplayObserverImpl) this.mTypeHelper.transfer(method, 0, iMapDisplayObserver);
                this.mTypeHelper.unbindSet(method, 0, bindSet);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public IMapDisplayObserver getDisplayObserver() {
        if (this.mTypeHelper != null && this.displayObserver != null) {
            ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.multi.display.model.DisplayCreateParam.2
            });
            try {
                return (IMapDisplayObserver) this.mTypeHelper.transfer(getClass().getMethod("getDisplayObserver", new Class[0]), -1, (Object) this.displayObserver, true);
            } catch (Exception e) {
                Log.w("INTFAUTO", Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public void setMapviewProxy(IBLMapViewProxy iBLMapViewProxy) {
        ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.multi.display.model.DisplayCreateParam.3
        });
        try {
            Method method = getClass().getMethod("setMapviewProxy", IBLMapViewProxy.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                Set bindSet = typeHelper.getBindSet(method, 0);
                bindSet.remove(iBLMapViewProxy);
                this.mapviewProxy = (IBLMapViewProxyImpl) this.mTypeHelper.transfer(method, 0, iBLMapViewProxy);
                this.mTypeHelper.unbindSet(method, 0, bindSet);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public IBLMapViewProxy getMapviewProxy() {
        if (this.mTypeHelper != null && this.mapviewProxy != null) {
            ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.multi.display.model.DisplayCreateParam.4
            });
            try {
                return (IBLMapViewProxy) this.mTypeHelper.transfer(getClass().getMethod("getMapviewProxy", new Class[0]), -1, (Object) this.mapviewProxy, true);
            } catch (Exception e) {
                Log.w("INTFAUTO", Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public DisplayCreateParam() {
        initTypeHelper();
        this.displayType = -1;
        this.displayAttribute = new DisplayAttribute();
        this.deviceAttribute = new DeviceAttribute();
        this.surfaceAttribute = new EGLSurfaceAttr();
        this.displayObserver = null;
        this.mapviewProxy = null;
        recordByIntfAuto();
    }

    protected DisplayCreateParam(@DisplayType.DisplayType1 int i, DisplayAttribute displayAttribute, DeviceAttribute deviceAttribute, EGLSurfaceAttr eGLSurfaceAttr, IMapDisplayObserverImpl iMapDisplayObserverImpl, IBLMapViewProxyImpl iBLMapViewProxyImpl) {
        initTypeHelper();
        this.displayType = i;
        this.displayAttribute = displayAttribute;
        this.deviceAttribute = deviceAttribute;
        this.surfaceAttribute = eGLSurfaceAttr;
        this.displayObserver = iMapDisplayObserverImpl;
        this.mapviewProxy = iBLMapViewProxyImpl;
        recordByIntfAuto();
    }

    public DisplayCreateParam(@DisplayType.DisplayType1 int i, DisplayAttribute displayAttribute, DeviceAttribute deviceAttribute, EGLSurfaceAttr eGLSurfaceAttr, IMapDisplayObserver iMapDisplayObserver, IBLMapViewProxy iBLMapViewProxy) {
        initTypeHelper();
        Constructor EC = ReflexTool.EC(new Object() { // from class: com.autonavi.gbl.multi.display.model.DisplayCreateParam.5
        });
        this.displayType = i;
        this.displayAttribute = displayAttribute;
        this.deviceAttribute = deviceAttribute;
        this.surfaceAttribute = eGLSurfaceAttr;
        TypeHelper typeHelper = this.mTypeHelper;
        this.displayObserver = typeHelper != null ? (IMapDisplayObserverImpl) typeHelper.transfer(EC, 4, iMapDisplayObserver) : null;
        TypeHelper typeHelper2 = this.mTypeHelper;
        this.mapviewProxy = typeHelper2 != null ? (IBLMapViewProxyImpl) typeHelper2.transfer(EC, 5, iBLMapViewProxy) : null;
        recordByIntfAuto();
    }
}
