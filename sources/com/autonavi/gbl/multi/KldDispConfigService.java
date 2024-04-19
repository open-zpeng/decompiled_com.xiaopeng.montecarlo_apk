package com.autonavi.gbl.multi;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.adapter.MultiObjectManager;
import com.autonavi.gbl.multi.impl.IKldDispConfigServiceImpl;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.observer.DisplayConfigBase;
import com.autonavi.gbl.multi.observer.KldConfigItemBase;
import com.autonavi.gbl.multi.observer.MapConfigBase;
import com.autonavi.gbl.multi.observer.RenderConfigBase;
import com.autonavi.gbl.multi.observer.SurfaceConfigBase;
import com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl;
import com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl;
import com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl;
import com.autonavi.gbl.multi.observer.impl.MapConfigBaseImpl;
import com.autonavi.gbl.multi.observer.impl.RenderConfigBaseImpl;
import com.autonavi.gbl.multi.observer.impl.SurfaceConfigBaseImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IKldDispConfigServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class KldDispConfigService implements IService {
    private static String PACKAGE = ReflexTool.PN(KldDispConfigService.class);
    private IKldDispConfigServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected KldDispConfigService(long j, boolean z) {
        this((IKldDispConfigServiceImpl) ReflexTool.invokeDeclConstructorSafe(IKldDispConfigServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(KldDispConfigService.class, this, this.mControl);
        }
    }

    public KldDispConfigService(IKldDispConfigServiceImpl iKldDispConfigServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iKldDispConfigServiceImpl);
    }

    private void $constructor(IKldDispConfigServiceImpl iKldDispConfigServiceImpl) {
        if (iKldDispConfigServiceImpl != null) {
            this.mControl = iKldDispConfigServiceImpl;
            this.mTargetId = String.format("KldDispConfigService_%s_%d", String.valueOf(IKldDispConfigServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IKldDispConfigServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
        if (iKldDispConfigServiceImpl != null) {
            return iKldDispConfigServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
        if (iKldDispConfigServiceImpl != null) {
            return iKldDispConfigServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
        if (iKldDispConfigServiceImpl != null) {
            iKldDispConfigServiceImpl.onCreate();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
        if (iKldDispConfigServiceImpl != null) {
            return iKldDispConfigServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public int parseJsonConfig(String str) {
        IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
        if (iKldDispConfigServiceImpl != null) {
            return iKldDispConfigServiceImpl.parseJsonConfig(str);
        }
        return 0;
    }

    public int registerSurfaceConfigBase(Class cls, String str) {
        IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
        if (iKldDispConfigServiceImpl != null) {
            return iKldDispConfigServiceImpl.registerSurfaceConfigBase(cls.getCanonicalName(), str);
        }
        return 0;
    }

    public int registerDisplaySceneConfigBase(Class cls, String str) {
        IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
        if (iKldDispConfigServiceImpl != null) {
            return iKldDispConfigServiceImpl.registerDisplaySceneConfigBase(cls.getCanonicalName(), str);
        }
        return 0;
    }

    public int registerDisplayConfigBase(Class cls, String str) {
        IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
        if (iKldDispConfigServiceImpl != null) {
            return iKldDispConfigServiceImpl.registerDisplayConfigBase(cls.getCanonicalName(), str);
        }
        return 0;
    }

    public int registerRenderConfigBase(Class cls, String str) {
        IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
        if (iKldDispConfigServiceImpl != null) {
            return iKldDispConfigServiceImpl.registerRenderConfigBase(cls.getCanonicalName(), str);
        }
        return 0;
    }

    public int registerMapConfigBase(Class cls, String str) {
        IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
        if (iKldDispConfigServiceImpl != null) {
            return iKldDispConfigServiceImpl.registerMapConfigBase(cls.getCanonicalName(), str);
        }
        return 0;
    }

    public int init(String str) {
        IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
        if (iKldDispConfigServiceImpl != null) {
            return iKldDispConfigServiceImpl.init(str);
        }
        return 0;
    }

    public KldConfigItemBase getConfigItem(String str, String str2) {
        IKldConfigItemBaseImpl configItem;
        try {
            Method method = KldDispConfigService.class.getMethod("getConfigItem", String.class, String.class);
            IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
            if (iKldDispConfigServiceImpl != null && (configItem = iKldDispConfigServiceImpl.getConfigItem(str, str2)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (KldConfigItemBase) typeHelper.transfer(method, -1, (Object) configItem, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDispConfigService.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public KldConfigItemBase getConfigItem1(String str, String str2) {
        IKldConfigItemBaseImpl configItem1;
        try {
            Method method = KldDispConfigService.class.getMethod("getConfigItem1", String.class, String.class);
            IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
            if (iKldDispConfigServiceImpl != null && (configItem1 = iKldDispConfigServiceImpl.getConfigItem1(str, str2)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (KldConfigItemBase) typeHelper.transfer(method, -1, (Object) configItem1, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDispConfigService.2
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public ArrayList<DisplayConfigBase> getDispList() {
        ArrayList<DisplayConfigBaseImpl> dispList;
        try {
            Method method = KldDispConfigService.class.getMethod("getDispList", new Class[0]);
            IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
            if (iKldDispConfigServiceImpl != null && (dispList = iKldDispConfigServiceImpl.getDispList()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, -1, (ArrayList) dispList, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDispConfigService.3
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public DisplayConfigBase getDispConfigItemByType(@DisplayType.DisplayType1 int i) {
        DisplayConfigBaseImpl dispConfigItemByType;
        try {
            Method method = KldDispConfigService.class.getMethod("getDispConfigItemByType", Integer.TYPE);
            IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
            if (iKldDispConfigServiceImpl != null && (dispConfigItemByType = iKldDispConfigServiceImpl.getDispConfigItemByType(i)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (DisplayConfigBase) typeHelper.transfer(method, -1, (Object) dispConfigItemByType, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDispConfigService.4
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public DisplayConfigBase getDispConfigItemByName(String str) {
        DisplayConfigBaseImpl dispConfigItemByName;
        try {
            Method method = KldDispConfigService.class.getMethod("getDispConfigItemByName", String.class);
            IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
            if (iKldDispConfigServiceImpl != null && (dispConfigItemByName = iKldDispConfigServiceImpl.getDispConfigItemByName(str)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (DisplayConfigBase) typeHelper.transfer(method, -1, (Object) dispConfigItemByName, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDispConfigService.5
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public MapConfigBase getMapConfigItem(String str) {
        MapConfigBaseImpl mapConfigItem;
        try {
            Method method = KldDispConfigService.class.getMethod("getMapConfigItem", String.class);
            IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
            if (iKldDispConfigServiceImpl != null && (mapConfigItem = iKldDispConfigServiceImpl.getMapConfigItem(str)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (MapConfigBase) typeHelper.transfer(method, -1, (Object) mapConfigItem, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDispConfigService.6
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public RenderConfigBase getRenderConfigItem(String str) {
        RenderConfigBaseImpl renderConfigItem;
        try {
            Method method = KldDispConfigService.class.getMethod("getRenderConfigItem", String.class);
            IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
            if (iKldDispConfigServiceImpl != null && (renderConfigItem = iKldDispConfigServiceImpl.getRenderConfigItem(str)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (RenderConfigBase) typeHelper.transfer(method, -1, (Object) renderConfigItem, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDispConfigService.7
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public SurfaceConfigBaseImpl getSurfaceConfigItemImpl(String str) {
        return (SurfaceConfigBaseImpl) MultiObjectManager.getInstance().getConfigObject(str);
    }

    public DisplaySceneConfigBaseImpl getDisplaySceneConfigItemImpl(String str) {
        return (DisplaySceneConfigBaseImpl) MultiObjectManager.getInstance().getConfigObject(str);
    }

    public DisplayConfigBaseImpl getDisplayConfigItemImpl(String str) {
        return (DisplayConfigBaseImpl) MultiObjectManager.getInstance().getConfigObject(str);
    }

    public RenderConfigBaseImpl getRenderConfigItemImpl(String str) {
        return (RenderConfigBaseImpl) MultiObjectManager.getInstance().getConfigObject(str);
    }

    public MapConfigBaseImpl getMapConfigItemImpl(String str) {
        return (MapConfigBaseImpl) MultiObjectManager.getInstance().getConfigObject(str);
    }

    public SurfaceConfigBase getSurfaceConfigItem(String str) {
        SurfaceConfigBaseImpl surfaceConfigItem;
        try {
            Method method = KldDispConfigService.class.getMethod("getSurfaceConfigItem", String.class);
            IKldDispConfigServiceImpl iKldDispConfigServiceImpl = this.mControl;
            if (iKldDispConfigServiceImpl != null && (surfaceConfigItem = iKldDispConfigServiceImpl.getSurfaceConfigItem(str)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (SurfaceConfigBase) typeHelper.transfer(method, -1, (Object) surfaceConfigItem, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDispConfigService.8
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDispConfigService.9
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDispConfigService.10
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.KldDispConfigService.11
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
