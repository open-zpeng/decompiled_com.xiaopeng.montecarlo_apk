package com.autonavi.gbl.multi.observer;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.KldDisplay;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.model.RectSizeType;
import com.autonavi.gbl.multi.observer.impl.SurfaceConfigBaseImpl;
import com.autonavi.gbl.multi.router.SurfaceConfigBaseRouter;
import java.lang.reflect.Method;
@IntfAuto(target = SurfaceConfigBaseRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class SurfaceConfigBase extends KldConfigItemBase implements ISurfaceConfigBase {
    private static String PACKAGE = ReflexTool.PN(SurfaceConfigBase.class);
    private boolean mHasDestroy;
    private SurfaceConfigBaseImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SurfaceConfigBase(long j, boolean z) {
        this(new SurfaceConfigBaseRouter("SurfaceConfigBase", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISurfaceConfigBase.class}, new Object[]{this});
    }

    public SurfaceConfigBase() {
        this(new SurfaceConfigBaseRouter("SurfaceConfigBase", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ISurfaceConfigBase.class}, new Object[]{this});
    }

    public SurfaceConfigBase(SurfaceConfigBaseImpl surfaceConfigBaseImpl) {
        super(surfaceConfigBaseImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(surfaceConfigBaseImpl);
    }

    private void $constructor(SurfaceConfigBaseImpl surfaceConfigBaseImpl) {
        if (surfaceConfigBaseImpl != null) {
            this.mService = surfaceConfigBaseImpl;
            this.mTargetId = String.format("SurfaceConfigBase_%s_%d", String.valueOf(SurfaceConfigBaseImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public SurfaceConfigBaseImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.SurfaceConfigBase.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.SurfaceConfigBase.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.SurfaceConfigBase.3
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

    public void setSurfaceSize(RectSizeType rectSizeType) {
        SurfaceConfigBaseImpl surfaceConfigBaseImpl = this.mService;
        if (surfaceConfigBaseImpl != null) {
            surfaceConfigBaseImpl.$explicit_setSurfaceSize(rectSizeType);
        }
    }

    public void setIsSurfaceVisiable(boolean z) {
        SurfaceConfigBaseImpl surfaceConfigBaseImpl = this.mService;
        if (surfaceConfigBaseImpl != null) {
            surfaceConfigBaseImpl.$explicit_setIsSurfaceVisiable(z);
        }
    }

    public void setIsSeparateRender(boolean z) {
        SurfaceConfigBaseImpl surfaceConfigBaseImpl = this.mService;
        if (surfaceConfigBaseImpl != null) {
            surfaceConfigBaseImpl.$explicit_setIsSeparateRender(z);
        }
    }

    public void setWindowId(int i) {
        SurfaceConfigBaseImpl surfaceConfigBaseImpl = this.mService;
        if (surfaceConfigBaseImpl != null) {
            surfaceConfigBaseImpl.$explicit_setWindowId(i);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase, com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int parseConfigString(String str) {
        SurfaceConfigBaseImpl surfaceConfigBaseImpl = this.mService;
        if (surfaceConfigBaseImpl != null) {
            return surfaceConfigBaseImpl.$explicit_parseConfigString(str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase, com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int applyConfig(KldDisplay kldDisplay) {
        try {
            Method method = SurfaceConfigBase.class.getMethod("applyConfig", KldDisplay.class);
            if (kldDisplay != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IKldDisplayImpl) typeHelper.transfer(method, 0, kldDisplay) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.SurfaceConfigBase.4
                    }));
                }
            }
            SurfaceConfigBaseImpl surfaceConfigBaseImpl = this.mService;
            if (surfaceConfigBaseImpl != null) {
                return surfaceConfigBaseImpl.$explicit_applyConfig(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.multi.observer.ISurfaceConfigBase
    public RectSizeType getSurfaceSize() {
        SurfaceConfigBaseImpl surfaceConfigBaseImpl = this.mService;
        if (surfaceConfigBaseImpl != null) {
            return surfaceConfigBaseImpl.$explicit_getSurfaceSize();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.ISurfaceConfigBase
    public boolean getIsSurfaceVisiable() {
        SurfaceConfigBaseImpl surfaceConfigBaseImpl = this.mService;
        if (surfaceConfigBaseImpl != null) {
            return surfaceConfigBaseImpl.$explicit_getIsSurfaceVisiable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.ISurfaceConfigBase
    public boolean getIsSeparateRender() {
        SurfaceConfigBaseImpl surfaceConfigBaseImpl = this.mService;
        if (surfaceConfigBaseImpl != null) {
            return surfaceConfigBaseImpl.$explicit_getIsSeparateRender();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.ISurfaceConfigBase
    public int getWindowId() {
        SurfaceConfigBaseImpl surfaceConfigBaseImpl = this.mService;
        if (surfaceConfigBaseImpl != null) {
            return surfaceConfigBaseImpl.$explicit_getWindowId();
        }
        return 0;
    }
}
