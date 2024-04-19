package com.autonavi.gbl.multi;

import android.util.Log;
import android.view.Surface;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.BizAGroupControl;
import com.autonavi.gbl.layer.BizAreaControl;
import com.autonavi.gbl.layer.BizCarControl;
import com.autonavi.gbl.layer.BizCustomControl;
import com.autonavi.gbl.layer.BizFlyLineControl;
import com.autonavi.gbl.layer.BizGuideEagleEyeControl;
import com.autonavi.gbl.layer.BizGuideRouteControl;
import com.autonavi.gbl.layer.BizLabelControl;
import com.autonavi.gbl.layer.BizRoadCrossControl;
import com.autonavi.gbl.layer.BizRoadFacilityControl;
import com.autonavi.gbl.layer.BizSearchControl;
import com.autonavi.gbl.layer.BizUserControl;
import com.autonavi.gbl.layer.impl.IBizAGroupControl;
import com.autonavi.gbl.layer.impl.IBizAreaControl;
import com.autonavi.gbl.layer.impl.IBizCarControl;
import com.autonavi.gbl.layer.impl.IBizCustomControl;
import com.autonavi.gbl.layer.impl.IBizFlyLineControlImpl;
import com.autonavi.gbl.layer.impl.IBizGuideEagleEyeControl;
import com.autonavi.gbl.layer.impl.IBizGuideRouteControl;
import com.autonavi.gbl.layer.impl.IBizLabelControl;
import com.autonavi.gbl.layer.impl.IBizRoadCrossControl;
import com.autonavi.gbl.layer.impl.IBizRoadFacilityControl;
import com.autonavi.gbl.layer.impl.IBizSearchControl;
import com.autonavi.gbl.layer.impl.IBizUserControl;
import com.autonavi.gbl.map.MapDevice;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.impl.MapDeviceImpl;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.impl.CKldSceneContextImpl;
import com.autonavi.gbl.multi.impl.IKldDisplayCrop;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.observer.IKldDisplayDataProvider;
import com.autonavi.gbl.multi.observer.IKldDisplayObserver;
import com.autonavi.gbl.multi.observer.IKldSceneObserver;
import com.autonavi.gbl.multi.observer.impl.IKldDisplayDataProviderImpl;
import com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl;
import com.autonavi.gbl.multi.observer.impl.IKldSceneObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IKldDisplayImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class KldDisplay {
    private static String PACKAGE = ReflexTool.PN(KldDisplay.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IKldDisplayImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected KldDisplay(long j, boolean z) {
        this(new IKldDisplayImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(KldDisplay.class, this, this.mControl);
        }
    }

    public KldDisplay(IKldDisplayImpl iKldDisplayImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iKldDisplayImpl);
    }

    private void $constructor(IKldDisplayImpl iKldDisplayImpl) {
        if (iKldDisplayImpl != null) {
            this.mControl = iKldDisplayImpl;
            this.mTargetId = String.format("KldDisplay_%s_%d", String.valueOf(IKldDisplayImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IKldDisplayImpl getControl() {
        return this.mControl;
    }

    public String getDisplayName() {
        IKldDisplayImpl iKldDisplayImpl = this.mControl;
        if (iKldDisplayImpl != null) {
            return iKldDisplayImpl.getDisplayName();
        }
        return null;
    }

    public int getDisplayId() {
        IKldDisplayImpl iKldDisplayImpl = this.mControl;
        if (iKldDisplayImpl != null) {
            return iKldDisplayImpl.getDisplayId();
        }
        return 0;
    }

    @DisplayType.DisplayType1
    public int getDisplayType() {
        IKldDisplayImpl iKldDisplayImpl = this.mControl;
        if (iKldDisplayImpl != null) {
            return iKldDisplayImpl.getDisplayType();
        }
        return Integer.MIN_VALUE;
    }

    public boolean isRemoteDisplay() {
        IKldDisplayImpl iKldDisplayImpl = this.mControl;
        if (iKldDisplayImpl != null) {
            return iKldDisplayImpl.isRemoteDisplay();
        }
        return false;
    }

    public MapView getRelatedMapView() {
        MapViewImpl relatedMapView;
        try {
            Method method = KldDisplay.class.getMethod("getRelatedMapView", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (relatedMapView = iKldDisplayImpl.getRelatedMapView()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (MapView) typeHelper.transfer(method, -1, (Object) relatedMapView, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public MapDevice getRelatedMapDevice() {
        MapDeviceImpl relatedMapDevice;
        try {
            Method method = KldDisplay.class.getMethod("getRelatedMapDevice", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (relatedMapDevice = iKldDisplayImpl.getRelatedMapDevice()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (MapDevice) typeHelper.transfer(method, -1, (Object) relatedMapDevice, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.2
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public IKldDisplayCrop getDisplayCrop() {
        IKldDisplayImpl iKldDisplayImpl = this.mControl;
        if (iKldDisplayImpl != null) {
            return iKldDisplayImpl.getDisplayCrop();
        }
        return null;
    }

    public void appendSyncProperty(int i, boolean z) {
        IKldDisplayImpl iKldDisplayImpl = this.mControl;
        if (iKldDisplayImpl != null) {
            iKldDisplayImpl.appendSyncProperty(i, z);
        }
    }

    public void removeSyncProperty(int i) {
        IKldDisplayImpl iKldDisplayImpl = this.mControl;
        if (iKldDisplayImpl != null) {
            iKldDisplayImpl.removeSyncProperty(i);
        }
    }

    public CKldSceneContextImpl getSceneContext() {
        IKldDisplayImpl iKldDisplayImpl = this.mControl;
        if (iKldDisplayImpl != null) {
            return iKldDisplayImpl.getSceneContext();
        }
        return null;
    }

    public int pauseScene() {
        IKldDisplayImpl iKldDisplayImpl = this.mControl;
        if (iKldDisplayImpl != null) {
            return iKldDisplayImpl.pauseScene();
        }
        return 0;
    }

    public int resumeScene() {
        IKldDisplayImpl iKldDisplayImpl = this.mControl;
        if (iKldDisplayImpl != null) {
            return iKldDisplayImpl.resumeScene();
        }
        return 0;
    }

    public int startScene(String str, CKldIntent cKldIntent, boolean z) {
        IKldDisplayImpl iKldDisplayImpl = this.mControl;
        if (iKldDisplayImpl != null) {
            return iKldDisplayImpl.startScene(str, cKldIntent, z);
        }
        return 0;
    }

    public int popScene(boolean z) {
        IKldDisplayImpl iKldDisplayImpl = this.mControl;
        if (iKldDisplayImpl != null) {
            return iKldDisplayImpl.popScene(z);
        }
        return 0;
    }

    public int popScene(String str, boolean z) {
        IKldDisplayImpl iKldDisplayImpl = this.mControl;
        if (iKldDisplayImpl != null) {
            return iKldDisplayImpl.popScene(str, z);
        }
        return 0;
    }

    public void setDataProvider(IKldDisplayDataProvider iKldDisplayDataProvider) {
        try {
            Method method = KldDisplay.class.getMethod("setDataProvider", IKldDisplayDataProvider.class);
            if (iKldDisplayDataProvider != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IKldDisplayDataProviderImpl) typeHelper.transfer(method, 0, iKldDisplayDataProvider) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $dataProvider == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.3
                    }));
                }
            }
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null) {
                iKldDisplayImpl.setDataProvider(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setDisplayObserver(IKldDisplayObserver iKldDisplayObserver) {
        try {
            Method method = KldDisplay.class.getMethod("setDisplayObserver", IKldDisplayObserver.class);
            if (iKldDisplayObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IKldDisplayObserverImpl) typeHelper.transfer(method, 0, iKldDisplayObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.4
                    }));
                }
            }
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null) {
                iKldDisplayImpl.setDisplayObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void setSceneObserver(IKldSceneObserver iKldSceneObserver) {
        try {
            Method method = KldDisplay.class.getMethod("setSceneObserver", IKldSceneObserver.class);
            if (iKldSceneObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IKldSceneObserverImpl) typeHelper.transfer(method, 0, iKldSceneObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.5
                    }));
                }
            }
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null) {
                iKldDisplayImpl.setSceneObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public static long getWindowFromSurface(Surface surface) {
        return IKldDisplayImpl.getWindowFromSurface(surface);
    }

    public BizRoadFacilityControl getBizRoadFacilityControl() {
        IBizRoadFacilityControl bizRoadFacilityControl;
        try {
            Method method = KldDisplay.class.getMethod("getBizRoadFacilityControl", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (bizRoadFacilityControl = iKldDisplayImpl.getBizRoadFacilityControl()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizRoadFacilityControl) typeHelper.transfer(method, -1, (Object) bizRoadFacilityControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.6
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizLabelControl getBizLabelControl() {
        IBizLabelControl bizLabelControl;
        try {
            Method method = KldDisplay.class.getMethod("getBizLabelControl", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (bizLabelControl = iKldDisplayImpl.getBizLabelControl()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizLabelControl) typeHelper.transfer(method, -1, (Object) bizLabelControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.7
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizRoadCrossControl getBizRoadCrossControl() {
        IBizRoadCrossControl bizRoadCrossControl;
        try {
            Method method = KldDisplay.class.getMethod("getBizRoadCrossControl", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (bizRoadCrossControl = iKldDisplayImpl.getBizRoadCrossControl()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizRoadCrossControl) typeHelper.transfer(method, -1, (Object) bizRoadCrossControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.8
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizUserControl getBizUserControl() {
        IBizUserControl bizUserControl;
        try {
            Method method = KldDisplay.class.getMethod("getBizUserControl", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (bizUserControl = iKldDisplayImpl.getBizUserControl()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizUserControl) typeHelper.transfer(method, -1, (Object) bizUserControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.9
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizGuideRouteControl getBizGuideRouteControl() {
        IBizGuideRouteControl bizGuideRouteControl;
        try {
            Method method = KldDisplay.class.getMethod("getBizGuideRouteControl", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (bizGuideRouteControl = iKldDisplayImpl.getBizGuideRouteControl()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizGuideRouteControl) typeHelper.transfer(method, -1, (Object) bizGuideRouteControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.10
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizCarControl getBizCarControl() {
        IBizCarControl bizCarControl;
        try {
            Method method = KldDisplay.class.getMethod("getBizCarControl", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (bizCarControl = iKldDisplayImpl.getBizCarControl()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizCarControl) typeHelper.transfer(method, -1, (Object) bizCarControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.11
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizFlyLineControl getBizFlyLineControl() {
        IBizFlyLineControlImpl bizFlyLineControl;
        try {
            Method method = KldDisplay.class.getMethod("getBizFlyLineControl", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (bizFlyLineControl = iKldDisplayImpl.getBizFlyLineControl()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizFlyLineControl) typeHelper.transfer(method, -1, (Object) bizFlyLineControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.12
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizAGroupControl getBizAGroupControl() {
        IBizAGroupControl bizAGroupControl;
        try {
            Method method = KldDisplay.class.getMethod("getBizAGroupControl", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (bizAGroupControl = iKldDisplayImpl.getBizAGroupControl()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizAGroupControl) typeHelper.transfer(method, -1, (Object) bizAGroupControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.13
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizAreaControl getBizAreaControl() {
        IBizAreaControl bizAreaControl;
        try {
            Method method = KldDisplay.class.getMethod("getBizAreaControl", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (bizAreaControl = iKldDisplayImpl.getBizAreaControl()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizAreaControl) typeHelper.transfer(method, -1, (Object) bizAreaControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.14
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizSearchControl getBizSearchControl() {
        IBizSearchControl bizSearchControl;
        try {
            Method method = KldDisplay.class.getMethod("getBizSearchControl", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (bizSearchControl = iKldDisplayImpl.getBizSearchControl()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizSearchControl) typeHelper.transfer(method, -1, (Object) bizSearchControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.15
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizGuideEagleEyeControl getBizGuideEagleEyeControl() {
        IBizGuideEagleEyeControl bizGuideEagleEyeControl;
        try {
            Method method = KldDisplay.class.getMethod("getBizGuideEagleEyeControl", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (bizGuideEagleEyeControl = iKldDisplayImpl.getBizGuideEagleEyeControl()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizGuideEagleEyeControl) typeHelper.transfer(method, -1, (Object) bizGuideEagleEyeControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.16
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public BizCustomControl getBizCustomControl() {
        IBizCustomControl bizCustomControl;
        try {
            Method method = KldDisplay.class.getMethod("getBizCustomControl", new Class[0]);
            IKldDisplayImpl iKldDisplayImpl = this.mControl;
            if (iKldDisplayImpl != null && (bizCustomControl = iKldDisplayImpl.getBizCustomControl()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (BizCustomControl) typeHelper.transfer(method, -1, (Object) bizCustomControl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.17
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.18
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.19
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDisplay.20
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
