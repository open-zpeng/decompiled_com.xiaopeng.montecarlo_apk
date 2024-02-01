package com.autonavi.gbl.map.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.MapDevice;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.IMapDeviceImpl;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.observer.IMapLifecycleObserver;
import com.autonavi.gbl.map.observer.impl.IMapLifecycleObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IMapLifecycleObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapLifecycleObserverRouter extends IMapLifecycleObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(MapLifecycleObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapLifecycleObserverRouter.class);
    private TypeHelper mHelper;
    private IMapLifecycleObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IMapLifecycleObserver iMapLifecycleObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMapLifecycleObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iMapLifecycleObserver;
    }

    protected MapLifecycleObserverRouter(String str, IMapLifecycleObserver iMapLifecycleObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapLifecycleObserver);
    }

    protected MapLifecycleObserverRouter(String str, IMapLifecycleObserver iMapLifecycleObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapLifecycleObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.observer.impl.IMapLifecycleObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapLifecycleObserverImpl
    public void beforeEGLDeviceCreate(IMapDeviceImpl iMapDeviceImpl) {
        TypeHelper typeHelper;
        try {
            Method method = MapLifecycleObserverRouter.class.getMethod("beforeEGLDeviceCreate", IMapDeviceImpl.class);
            MapDevice mapDevice = null;
            if (iMapDeviceImpl != null && (typeHelper = this.mHelper) != null) {
                mapDevice = (MapDevice) typeHelper.transfer(method, 0, iMapDeviceImpl);
            }
            IMapLifecycleObserver iMapLifecycleObserver = this.mObserver;
            if (iMapLifecycleObserver != null) {
                iMapLifecycleObserver.beforeEGLDeviceCreate(mapDevice);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IMapLifecycleObserverImpl
    public void beforeEGLMapViewCreate(IMapViewImpl iMapViewImpl) {
        TypeHelper typeHelper;
        try {
            Method method = MapLifecycleObserverRouter.class.getMethod("beforeEGLMapViewCreate", IMapViewImpl.class);
            MapView mapView = null;
            if (iMapViewImpl != null && (typeHelper = this.mHelper) != null) {
                mapView = (MapView) typeHelper.transfer(method, 0, iMapViewImpl);
            }
            IMapLifecycleObserver iMapLifecycleObserver = this.mObserver;
            if (iMapLifecycleObserver != null) {
                iMapLifecycleObserver.beforeEGLMapViewCreate(mapView);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
