package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.MapDevice;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.MapDeviceImpl;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.observer.IMapLifecycleObserverInterface;
import com.autonavi.gbl.map.observer.impl.IMapLifecycleObserver;
import java.lang.reflect.Method;
@IntfAuto(target = IMapLifecycleObserverInterface.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapLifecycleObserverInterfaceRouter extends IMapLifecycleObserver {
    private static BindTable BIND_TABLE = new BindTable(MapLifecycleObserverInterfaceRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapLifecycleObserverInterfaceRouter.class);
    private TypeHelper mHelper;
    private IMapLifecycleObserverInterface mObserver;
    private String mTargetId;

    private void $constructor(String str, IMapLifecycleObserverInterface iMapLifecycleObserverInterface) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMapLifecycleObserver.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iMapLifecycleObserverInterface;
    }

    protected MapLifecycleObserverInterfaceRouter(String str, IMapLifecycleObserverInterface iMapLifecycleObserverInterface, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapLifecycleObserverInterface);
    }

    protected MapLifecycleObserverInterfaceRouter(String str, IMapLifecycleObserverInterface iMapLifecycleObserverInterface) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapLifecycleObserverInterface);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapLifecycleObserverInterfaceRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.observer.impl.IMapLifecycleObserver
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapLifecycleObserverInterfaceRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapLifecycleObserver
    public void beforeEGLDeviceCreate(MapDeviceImpl mapDeviceImpl) {
        try {
            Method method = MapLifecycleObserverInterfaceRouter.class.getMethod("beforeEGLDeviceCreate", MapDeviceImpl.class);
            if (mapDeviceImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (MapDevice) typeHelper.transfer(method, 0, mapDeviceImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $device == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapLifecycleObserverInterfaceRouter.3
                    }));
                }
            }
            IMapLifecycleObserverInterface iMapLifecycleObserverInterface = this.mObserver;
            if (iMapLifecycleObserverInterface != null) {
                iMapLifecycleObserverInterface.beforeEGLDeviceCreate(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapLifecycleObserver
    public void beforeEGLMapViewCreate(MapViewImpl mapViewImpl) {
        try {
            Method method = MapLifecycleObserverInterfaceRouter.class.getMethod("beforeEGLMapViewCreate", MapViewImpl.class);
            if (mapViewImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (MapView) typeHelper.transfer(method, 0, mapViewImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $mapView == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.MapLifecycleObserverInterfaceRouter.4
                    }));
                }
            }
            IMapLifecycleObserverInterface iMapLifecycleObserverInterface = this.mObserver;
            if (iMapLifecycleObserverInterface != null) {
                iMapLifecycleObserverInterface.beforeEGLMapViewCreate(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
