package com.autonavi.gbl.multi;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.ChannelMsgSyncController;
import com.autonavi.gbl.consis.ChannelParcel;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.impl.IChannelMsgSyncControllerImpl;
import com.autonavi.gbl.consis.observer.ChannelTransProxy;
import com.autonavi.gbl.consis.observer.IChannelConnectObserver;
import com.autonavi.gbl.consis.observer.IChannelMsgObserver;
import com.autonavi.gbl.consis.observer.IChannelMsgTransfer;
import com.autonavi.gbl.consis.observer.impl.IChannelConnectObserverImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelMsgObserverImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelMsgTransferImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelTransProxyImpl;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.autonavi.gbl.map.observer.IBLMapViewProxy;
import com.autonavi.gbl.map.observer.impl.IBLMapViewProxyImpl;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.impl.IKldDisplayServiceImpl;
import com.autonavi.gbl.multi.model.DisplayAttr;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.observer.IKldDisplayDataProvider;
import com.autonavi.gbl.multi.observer.IKldDisplayObserver;
import com.autonavi.gbl.multi.observer.IKldRemoteDispObserver;
import com.autonavi.gbl.multi.observer.IKldSceneObserver;
import com.autonavi.gbl.multi.observer.impl.IKldDisplayDataProviderImpl;
import com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl;
import com.autonavi.gbl.multi.observer.impl.IKldRemoteDispObserverImpl;
import com.autonavi.gbl.multi.observer.impl.IKldSceneObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
@IntfAuto(target = IKldDisplayServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class KldDisplayService implements IService {
    private static String PACKAGE = ReflexTool.PN(KldDisplayService.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IKldDisplayServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected KldDisplayService(long j, boolean z) {
        this((IKldDisplayServiceImpl) ReflexTool.invokeDeclConstructorSafe(IKldDisplayServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(KldDisplayService.class, this, this.mControl);
        }
    }

    public KldDisplayService(IKldDisplayServiceImpl iKldDisplayServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iKldDisplayServiceImpl);
    }

    private void $constructor(IKldDisplayServiceImpl iKldDisplayServiceImpl) {
        if (iKldDisplayServiceImpl != null) {
            this.mControl = iKldDisplayServiceImpl;
            this.mTargetId = String.format("KldDisplayService_%s_%d", String.valueOf(IKldDisplayServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IKldDisplayServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
        if (iKldDisplayServiceImpl != null) {
            return iKldDisplayServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
        if (iKldDisplayServiceImpl != null) {
            return iKldDisplayServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
        if (iKldDisplayServiceImpl != null) {
            iKldDisplayServiceImpl.onCreate();
        }
    }

    public static String getDisplayNameByType(@DisplayType.DisplayType1 int i) {
        return IKldDisplayServiceImpl.getDisplayNameByType(i);
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
        if (iKldDisplayServiceImpl != null) {
            return iKldDisplayServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public KldDisplay createMainDisplay(DisplayAttr displayAttr, DeviceAttribute deviceAttribute, EGLSurfaceAttr eGLSurfaceAttr, IKldDisplayObserver iKldDisplayObserver, IKldSceneObserver iKldSceneObserver, IBLMapViewProxy iBLMapViewProxy) {
        IKldDisplayObserverImpl iKldDisplayObserverImpl;
        IKldSceneObserverImpl iKldSceneObserverImpl;
        IBLMapViewProxyImpl iBLMapViewProxyImpl;
        IKldDisplayImpl createMainDisplay;
        try {
            Method method = KldDisplayService.class.getMethod("createMainDisplay", DisplayAttr.class, DeviceAttribute.class, EGLSurfaceAttr.class, IKldDisplayObserver.class, IKldSceneObserver.class, IBLMapViewProxy.class);
            if (iKldDisplayObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                IKldDisplayObserverImpl iKldDisplayObserverImpl2 = typeHelper != null ? (IKldDisplayObserverImpl) typeHelper.transfer(method, 3, iKldDisplayObserver) : null;
                if (iKldDisplayObserverImpl2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.1
                    }));
                    return null;
                }
                iKldDisplayObserverImpl = iKldDisplayObserverImpl2;
            } else {
                iKldDisplayObserverImpl = null;
            }
            if (iKldSceneObserver != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                IKldSceneObserverImpl iKldSceneObserverImpl2 = typeHelper2 != null ? (IKldSceneObserverImpl) typeHelper2.transfer(method, 4, iKldSceneObserver) : null;
                if (iKldSceneObserverImpl2 == null) {
                    DebugTool.e("%s: $sceneObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.2
                    }));
                    return null;
                }
                iKldSceneObserverImpl = iKldSceneObserverImpl2;
            } else {
                iKldSceneObserverImpl = null;
            }
            if (iBLMapViewProxy != null) {
                TypeHelper typeHelper3 = this.mTypeHelper;
                IBLMapViewProxyImpl iBLMapViewProxyImpl2 = typeHelper3 != null ? (IBLMapViewProxyImpl) typeHelper3.transfer(method, 5, iBLMapViewProxy) : null;
                if (iBLMapViewProxyImpl2 == null) {
                    DebugTool.e("%s: $mapviewProxy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.3
                    }));
                    return null;
                }
                iBLMapViewProxyImpl = iBLMapViewProxyImpl2;
            } else {
                iBLMapViewProxyImpl = null;
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null && (createMainDisplay = iKldDisplayServiceImpl.createMainDisplay(displayAttr, deviceAttribute, eGLSurfaceAttr, iKldDisplayObserverImpl, iKldSceneObserverImpl, iBLMapViewProxyImpl)) != null) {
                TypeHelper typeHelper4 = this.mTypeHelper;
                r4 = typeHelper4 != null ? (KldDisplay) typeHelper4.transfer(method, -1, (Object) createMainDisplay, true) : null;
                if (r4 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.4
                    }));
                }
            }
            return r4;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public KldDisplay createMainDisplay(DisplayAttr displayAttr, DeviceAttribute deviceAttribute, EGLSurfaceAttr eGLSurfaceAttr, IKldDisplayObserver iKldDisplayObserver, IKldSceneObserver iKldSceneObserver) {
        IKldDisplayObserverImpl iKldDisplayObserverImpl;
        IKldSceneObserverImpl iKldSceneObserverImpl;
        IKldDisplayImpl createMainDisplay;
        try {
            Method method = KldDisplayService.class.getMethod("createMainDisplay", DisplayAttr.class, DeviceAttribute.class, EGLSurfaceAttr.class, IKldDisplayObserver.class, IKldSceneObserver.class);
            if (iKldDisplayObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                IKldDisplayObserverImpl iKldDisplayObserverImpl2 = typeHelper != null ? (IKldDisplayObserverImpl) typeHelper.transfer(method, 3, iKldDisplayObserver) : null;
                if (iKldDisplayObserverImpl2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.5
                    }));
                    return null;
                }
                iKldDisplayObserverImpl = iKldDisplayObserverImpl2;
            } else {
                iKldDisplayObserverImpl = null;
            }
            if (iKldSceneObserver != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                IKldSceneObserverImpl iKldSceneObserverImpl2 = typeHelper2 != null ? (IKldSceneObserverImpl) typeHelper2.transfer(method, 4, iKldSceneObserver) : null;
                if (iKldSceneObserverImpl2 == null) {
                    DebugTool.e("%s: $sceneObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.6
                    }));
                    return null;
                }
                iKldSceneObserverImpl = iKldSceneObserverImpl2;
            } else {
                iKldSceneObserverImpl = null;
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null && (createMainDisplay = iKldDisplayServiceImpl.createMainDisplay(displayAttr, deviceAttribute, eGLSurfaceAttr, iKldDisplayObserverImpl, iKldSceneObserverImpl)) != null) {
                TypeHelper typeHelper3 = this.mTypeHelper;
                r3 = typeHelper3 != null ? (KldDisplay) typeHelper3.transfer(method, -1, (Object) createMainDisplay, true) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.7
                    }));
                }
            }
            return r3;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public KldDisplay createMainDisplay(DisplayAttr displayAttr, IKldDisplayDataProvider iKldDisplayDataProvider, IKldDisplayObserver iKldDisplayObserver) {
        IKldDisplayDataProviderImpl iKldDisplayDataProviderImpl;
        IKldDisplayObserverImpl iKldDisplayObserverImpl;
        IKldDisplayImpl createMainDisplay;
        try {
            Method method = KldDisplayService.class.getMethod("createMainDisplay", DisplayAttr.class, IKldDisplayDataProvider.class, IKldDisplayObserver.class);
            if (iKldDisplayDataProvider != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                iKldDisplayDataProviderImpl = typeHelper != null ? (IKldDisplayDataProviderImpl) typeHelper.transfer(method, 1, iKldDisplayDataProvider) : null;
                if (iKldDisplayDataProviderImpl == null) {
                    DebugTool.e("%s: $dataProvider == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.8
                    }));
                    return null;
                }
            } else {
                iKldDisplayDataProviderImpl = null;
            }
            if (iKldDisplayObserver != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                iKldDisplayObserverImpl = typeHelper2 != null ? (IKldDisplayObserverImpl) typeHelper2.transfer(method, 2, iKldDisplayObserver) : null;
                if (iKldDisplayObserverImpl == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.9
                    }));
                    return null;
                }
            } else {
                iKldDisplayObserverImpl = null;
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null && (createMainDisplay = iKldDisplayServiceImpl.createMainDisplay(displayAttr, iKldDisplayDataProviderImpl, iKldDisplayObserverImpl)) != null) {
                TypeHelper typeHelper3 = this.mTypeHelper;
                r0 = typeHelper3 != null ? (KldDisplay) typeHelper3.transfer(method, -1, (Object) createMainDisplay, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.10
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public KldDisplay createDisplay(@DisplayType.DisplayType1 int i, DisplayAttr displayAttr, IKldDisplayDataProvider iKldDisplayDataProvider, IKldDisplayObserver iKldDisplayObserver) {
        IKldDisplayDataProviderImpl iKldDisplayDataProviderImpl;
        IKldDisplayObserverImpl iKldDisplayObserverImpl;
        IKldDisplayImpl createDisplay;
        try {
            Method method = KldDisplayService.class.getMethod("createDisplay", Integer.TYPE, DisplayAttr.class, IKldDisplayDataProvider.class, IKldDisplayObserver.class);
            if (iKldDisplayDataProvider != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                iKldDisplayDataProviderImpl = typeHelper != null ? (IKldDisplayDataProviderImpl) typeHelper.transfer(method, 2, iKldDisplayDataProvider) : null;
                if (iKldDisplayDataProviderImpl == null) {
                    DebugTool.e("%s: $dataProvider == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.11
                    }));
                    return null;
                }
            } else {
                iKldDisplayDataProviderImpl = null;
            }
            if (iKldDisplayObserver != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                iKldDisplayObserverImpl = typeHelper2 != null ? (IKldDisplayObserverImpl) typeHelper2.transfer(method, 3, iKldDisplayObserver) : null;
                if (iKldDisplayObserverImpl == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.12
                    }));
                    return null;
                }
            } else {
                iKldDisplayObserverImpl = null;
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null && (createDisplay = iKldDisplayServiceImpl.createDisplay(i, displayAttr, iKldDisplayDataProviderImpl, iKldDisplayObserverImpl)) != null) {
                TypeHelper typeHelper3 = this.mTypeHelper;
                r0 = typeHelper3 != null ? (KldDisplay) typeHelper3.transfer(method, -1, (Object) createDisplay, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.13
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public KldDisplay createDisplay(@DisplayType.DisplayType1 int i, DisplayAttr displayAttr, DeviceAttribute deviceAttribute, EGLSurfaceAttr eGLSurfaceAttr, IKldDisplayObserver iKldDisplayObserver, IBLMapViewProxy iBLMapViewProxy) {
        IKldDisplayObserverImpl iKldDisplayObserverImpl;
        IBLMapViewProxyImpl iBLMapViewProxyImpl;
        IKldDisplayImpl createDisplay;
        try {
            Method method = KldDisplayService.class.getMethod("createDisplay", Integer.TYPE, DisplayAttr.class, DeviceAttribute.class, EGLSurfaceAttr.class, IKldDisplayObserver.class, IBLMapViewProxy.class);
            if (iKldDisplayObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                IKldDisplayObserverImpl iKldDisplayObserverImpl2 = typeHelper != null ? (IKldDisplayObserverImpl) typeHelper.transfer(method, 4, iKldDisplayObserver) : null;
                if (iKldDisplayObserverImpl2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.14
                    }));
                    return null;
                }
                iKldDisplayObserverImpl = iKldDisplayObserverImpl2;
            } else {
                iKldDisplayObserverImpl = null;
            }
            if (iBLMapViewProxy != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                IBLMapViewProxyImpl iBLMapViewProxyImpl2 = typeHelper2 != null ? (IBLMapViewProxyImpl) typeHelper2.transfer(method, 5, iBLMapViewProxy) : null;
                if (iBLMapViewProxyImpl2 == null) {
                    DebugTool.e("%s: $mapviewProxy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.15
                    }));
                    return null;
                }
                iBLMapViewProxyImpl = iBLMapViewProxyImpl2;
            } else {
                iBLMapViewProxyImpl = null;
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null && (createDisplay = iKldDisplayServiceImpl.createDisplay(i, displayAttr, deviceAttribute, eGLSurfaceAttr, iKldDisplayObserverImpl, iBLMapViewProxyImpl)) != null) {
                TypeHelper typeHelper3 = this.mTypeHelper;
                r3 = typeHelper3 != null ? (KldDisplay) typeHelper3.transfer(method, -1, (Object) createDisplay, true) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.16
                    }));
                }
            }
            return r3;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public KldDisplay createDisplay(@DisplayType.DisplayType1 int i, DisplayAttr displayAttr, DeviceAttribute deviceAttribute, EGLSurfaceAttr eGLSurfaceAttr, IKldDisplayObserver iKldDisplayObserver) {
        IKldDisplayObserverImpl iKldDisplayObserverImpl;
        IKldDisplayImpl createDisplay;
        try {
            Method method = KldDisplayService.class.getMethod("createDisplay", Integer.TYPE, DisplayAttr.class, DeviceAttribute.class, EGLSurfaceAttr.class, IKldDisplayObserver.class);
            if (iKldDisplayObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                IKldDisplayObserverImpl iKldDisplayObserverImpl2 = typeHelper != null ? (IKldDisplayObserverImpl) typeHelper.transfer(method, 4, iKldDisplayObserver) : null;
                if (iKldDisplayObserverImpl2 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.17
                    }));
                    return null;
                }
                iKldDisplayObserverImpl = iKldDisplayObserverImpl2;
            } else {
                iKldDisplayObserverImpl = null;
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null && (createDisplay = iKldDisplayServiceImpl.createDisplay(i, displayAttr, deviceAttribute, eGLSurfaceAttr, iKldDisplayObserverImpl)) != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (KldDisplay) typeHelper2.transfer(method, -1, (Object) createDisplay, true) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.18
                    }));
                }
            }
            return r2;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void destroyDisplay(KldDisplay kldDisplay) {
        try {
            Method method = KldDisplayService.class.getMethod("destroyDisplay", KldDisplay.class);
            if (kldDisplay != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IKldDisplayImpl) typeHelper.transfer(method, 0, kldDisplay) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $disp == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.19
                    }));
                }
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null) {
                iKldDisplayServiceImpl.destroyDisplay(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void destroyAllDisplays() {
        IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
        if (iKldDisplayServiceImpl != null) {
            iKldDisplayServiceImpl.destroyAllDisplays();
        }
    }

    public void setRemoteDisplayObserver(IKldRemoteDispObserver iKldRemoteDispObserver) {
        try {
            Method method = KldDisplayService.class.getMethod("setRemoteDisplayObserver", IKldRemoteDispObserver.class);
            if (iKldRemoteDispObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IKldRemoteDispObserverImpl) typeHelper.transfer(method, 0, iKldRemoteDispObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.20
                    }));
                }
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null) {
                iKldDisplayServiceImpl.setRemoteDisplayObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public int init(boolean z, boolean z2) {
        IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
        if (iKldDisplayServiceImpl != null) {
            return iKldDisplayServiceImpl.init(z, z2);
        }
        return 0;
    }

    public int init(boolean z, String str, int i) {
        IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
        if (iKldDisplayServiceImpl != null) {
            return iKldDisplayServiceImpl.init(z, str, i);
        }
        return 0;
    }

    public KldDisplay getDisplayByType(@DisplayType.DisplayType1 int i) {
        IKldDisplayImpl displayByType;
        try {
            Method method = KldDisplayService.class.getMethod("getDisplayByType", Integer.TYPE);
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null && (displayByType = iKldDisplayServiceImpl.getDisplayByType(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (KldDisplay) typeHelper.transfer(method, -1, (Object) displayByType, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.21
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public KldDisplay getDisplayById(long j) {
        IKldDisplayImpl displayById;
        try {
            Method method = KldDisplayService.class.getMethod("getDisplayById", Long.TYPE);
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null && (displayById = iKldDisplayServiceImpl.getDisplayById(j)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (KldDisplay) typeHelper.transfer(method, -1, (Object) displayById, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.22
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public KldDisplay getDisplayByName(String str) {
        IKldDisplayImpl displayByName;
        try {
            Method method = KldDisplayService.class.getMethod("getDisplayByName", String.class);
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null && (displayByName = iKldDisplayServiceImpl.getDisplayByName(str)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (KldDisplay) typeHelper.transfer(method, -1, (Object) displayByName, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.23
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    @DisplayType.DisplayType1
    public static int getDisplayTypeByName(String str) {
        return IKldDisplayServiceImpl.getDisplayTypeByName(str);
    }

    public int appendChannelTransProxy(ChannelTransProxy channelTransProxy) {
        try {
            Method method = KldDisplayService.class.getMethod("appendChannelTransProxy", ChannelTransProxy.class);
            if (channelTransProxy != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IChannelTransProxyImpl) typeHelper.transfer(method, 0, channelTransProxy) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $proxy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.24
                    }));
                    return 0;
                }
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null) {
                return iKldDisplayServiceImpl.appendChannelTransProxy(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public int removeChannelProxy(ChannelTransProxy channelTransProxy) {
        try {
            Method method = KldDisplayService.class.getMethod("removeChannelProxy", ChannelTransProxy.class);
            if (channelTransProxy != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IChannelTransProxyImpl) typeHelper.transfer(method, 0, channelTransProxy) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $proxy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.25
                    }));
                    return 0;
                }
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null) {
                return iKldDisplayServiceImpl.removeChannelProxy(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public boolean setExtraDataSender(IChannelMsgObserver iChannelMsgObserver) {
        try {
            Method method = KldDisplayService.class.getMethod("setExtraDataSender", IChannelMsgObserver.class);
            if (iChannelMsgObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IChannelMsgObserverImpl) typeHelper.transfer(method, 0, iChannelMsgObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $extraDataSender == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.26
                    }));
                    return false;
                }
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null) {
                return iKldDisplayServiceImpl.setExtraDataSender(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean setExtraDataReceiver(IChannelMsgObserver iChannelMsgObserver) {
        try {
            Method method = KldDisplayService.class.getMethod("setExtraDataReceiver", IChannelMsgObserver.class);
            if (iChannelMsgObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IChannelMsgObserverImpl) typeHelper.transfer(method, 0, iChannelMsgObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $extraDataReceiver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.27
                    }));
                    return false;
                }
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null) {
                return iKldDisplayServiceImpl.setExtraDataReceiver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public ChannelMsgSyncController setDataTransfer(IChannelMsgTransfer iChannelMsgTransfer) {
        IChannelMsgTransferImpl iChannelMsgTransferImpl;
        IChannelMsgSyncControllerImpl dataTransfer;
        try {
            Method method = KldDisplayService.class.getMethod("setDataTransfer", IChannelMsgTransfer.class);
            if (iChannelMsgTransfer != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                iChannelMsgTransferImpl = typeHelper != null ? (IChannelMsgTransferImpl) typeHelper.transfer(method, 0, iChannelMsgTransfer) : null;
                if (iChannelMsgTransferImpl == null) {
                    DebugTool.e("%s: $callback == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.28
                    }));
                    return null;
                }
            } else {
                iChannelMsgTransferImpl = null;
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null && (dataTransfer = iKldDisplayServiceImpl.setDataTransfer(iChannelMsgTransferImpl)) != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r0 = typeHelper2 != null ? (ChannelMsgSyncController) typeHelper2.transfer(method, -1, (Object) dataTransfer, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.29
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void setChannelConnectObserver(IChannelConnectObserver iChannelConnectObserver) {
        try {
            Method method = KldDisplayService.class.getMethod("setChannelConnectObserver", IChannelConnectObserver.class);
            if (iChannelConnectObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IChannelConnectObserverImpl) typeHelper.transfer(method, 0, iChannelConnectObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pObserver == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.30
                    }));
                }
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null) {
                iKldDisplayServiceImpl.setChannelConnectObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public boolean sendCustomData(ChannelParcel channelParcel, ChannelTransProxy channelTransProxy) {
        ChannelParcelImpl channelParcelImpl;
        try {
            Method method = KldDisplayService.class.getMethod("sendCustomData", ChannelParcel.class, ChannelTransProxy.class);
            if (channelParcel != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                channelParcelImpl = typeHelper != null ? (ChannelParcelImpl) typeHelper.transfer(method, 0, channelParcel) : null;
                if (channelParcelImpl == null) {
                    DebugTool.e("%s: $data == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.31
                    }));
                    return false;
                }
            } else {
                channelParcelImpl = null;
            }
            if (channelTransProxy != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r2 = typeHelper2 != null ? (IChannelTransProxyImpl) typeHelper2.transfer(method, 1, channelTransProxy) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $proxy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.32
                    }));
                    return false;
                }
            }
            IKldDisplayServiceImpl iKldDisplayServiceImpl = this.mControl;
            if (iKldDisplayServiceImpl != null) {
                return iKldDisplayServiceImpl.sendCustomData(channelParcelImpl, r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.33
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.34
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplayService.35
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
