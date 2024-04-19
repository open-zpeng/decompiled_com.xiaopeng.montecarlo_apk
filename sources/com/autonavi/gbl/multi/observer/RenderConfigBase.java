package com.autonavi.gbl.multi.observer;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.MapViewPortParam;
import com.autonavi.gbl.multi.KldDisplay;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.model.LeftTop;
import com.autonavi.gbl.multi.model.ZoomScale;
import com.autonavi.gbl.multi.observer.impl.RenderConfigBaseImpl;
import com.autonavi.gbl.multi.router.RenderConfigBaseRouter;
import java.lang.reflect.Method;
@IntfAuto(target = RenderConfigBaseRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class RenderConfigBase extends KldConfigItemBase implements IRenderConfigBase {
    private static String PACKAGE = ReflexTool.PN(RenderConfigBase.class);
    private boolean mHasDestroy;
    private RenderConfigBaseImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected RenderConfigBase(long j, boolean z) {
        this(new RenderConfigBaseRouter("RenderConfigBase", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRenderConfigBase.class}, new Object[]{this});
    }

    public RenderConfigBase() {
        this(new RenderConfigBaseRouter("RenderConfigBase", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRenderConfigBase.class}, new Object[]{this});
    }

    public RenderConfigBase(RenderConfigBaseImpl renderConfigBaseImpl) {
        super(renderConfigBaseImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(renderConfigBaseImpl);
    }

    private void $constructor(RenderConfigBaseImpl renderConfigBaseImpl) {
        if (renderConfigBaseImpl != null) {
            this.mService = renderConfigBaseImpl;
            this.mTargetId = String.format("RenderConfigBase_%s_%d", String.valueOf(RenderConfigBaseImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public RenderConfigBaseImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.RenderConfigBase.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.RenderConfigBase.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.RenderConfigBase.3
        });
        objArr[1] = String.valueOf(this.mService != null);
        DebugTool.d("%s: mService=%s", objArr);
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            ReflexTool.invokeDeclMethodSafe(this.mService, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mService = null;
        }
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public void setConfigName(String str) {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            renderConfigBaseImpl.$explicit_setConfigName(str);
        }
    }

    public int activateConfigItem(String str, KldDisplay kldDisplay) {
        try {
            Method method = RenderConfigBase.class.getMethod("activateConfigItem", String.class, KldDisplay.class);
            if (kldDisplay != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IKldDisplayImpl) typeHelper.transfer(method, 1, kldDisplay) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.RenderConfigBase.4
                    }));
                }
            }
            RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
            if (renderConfigBaseImpl != null) {
                return renderConfigBaseImpl.$explicit_activateConfigItem(str, r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    public void setIsMapVisiable(boolean z) {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            renderConfigBaseImpl.$explicit_setIsMapVisiable(z);
        }
    }

    public void setZoomScale(ZoomScale zoomScale) {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            renderConfigBaseImpl.$explicit_setZoomScale(zoomScale);
        }
    }

    public void setMapTextScale(float f) {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            renderConfigBaseImpl.$explicit_setMapTextScale(f);
        }
    }

    public void setFps(int i) {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            renderConfigBaseImpl.$explicit_setFps(i);
        }
    }

    public void setProjectCenter(LeftTop leftTop) {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            renderConfigBaseImpl.$explicit_setProjectCenter(leftTop);
        }
    }

    public void setMapViewPort(MapViewPortParam mapViewPortParam) {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            renderConfigBaseImpl.$explicit_setMapViewPort(mapViewPortParam);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase, com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int parseConfigString(String str) {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            return renderConfigBaseImpl.$explicit_parseConfigString(str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase, com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int applyConfig(KldDisplay kldDisplay) {
        try {
            Method method = RenderConfigBase.class.getMethod("applyConfig", KldDisplay.class);
            if (kldDisplay != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IKldDisplayImpl) typeHelper.transfer(method, 0, kldDisplay) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.RenderConfigBase.5
                    }));
                }
            }
            RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
            if (renderConfigBaseImpl != null) {
                return renderConfigBaseImpl.$explicit_applyConfig(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.multi.observer.IRenderConfigBase
    public boolean getIsMapVisiable() {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            return renderConfigBaseImpl.$explicit_getIsMapVisiable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.IRenderConfigBase
    public ZoomScale getZoomScale() {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            return renderConfigBaseImpl.$explicit_getZoomScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IRenderConfigBase
    public float getMapTextScale() {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            return renderConfigBaseImpl.$explicit_getMapTextScale();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.multi.observer.IRenderConfigBase
    public int getFps() {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            return renderConfigBaseImpl.$explicit_getFps();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IRenderConfigBase
    public LeftTop getProjectCenter() {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            return renderConfigBaseImpl.$explicit_getProjectCenter();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IRenderConfigBase
    public MapViewPortParam getMapViewPort() {
        RenderConfigBaseImpl renderConfigBaseImpl = this.mService;
        if (renderConfigBaseImpl != null) {
            return renderConfigBaseImpl.$explicit_getMapViewPort();
        }
        return null;
    }
}
