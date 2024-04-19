package com.autonavi.gbl.multi.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
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
import com.autonavi.gbl.multi.observer.IRenderConfigBase;
import com.autonavi.gbl.multi.observer.RenderConfigBase;
import com.autonavi.gbl.multi.observer.impl.RenderConfigBaseImpl;
import java.lang.reflect.Method;
@IntfAuto(target = RenderConfigBase.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RenderConfigBaseRouter extends RenderConfigBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(RenderConfigBaseRouter.class);
    private static String PACKAGE = ReflexTool.PN(RenderConfigBaseRouter.class);
    private TypeHelper mHelper;
    private IRenderConfigBase mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRenderConfigBase iRenderConfigBase) {
        if (iRenderConfigBase != null) {
            this.mObserver = iRenderConfigBase;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RenderConfigBase.class, iRenderConfigBase, this);
            }
        }
    }

    private void $constructor(String str, IRenderConfigBase iRenderConfigBase) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RenderConfigBaseImpl.getCPtr((RenderConfigBaseImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRenderConfigBase);
    }

    public RenderConfigBaseRouter(String str, IRenderConfigBase iRenderConfigBase, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRenderConfigBase);
    }

    public RenderConfigBaseRouter(String str, IRenderConfigBase iRenderConfigBase) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRenderConfigBase);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.RenderConfigBaseRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.RenderConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.RenderConfigBaseRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.RenderConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int parseConfigString(String str) {
        IRenderConfigBase iRenderConfigBase = this.mObserver;
        if (iRenderConfigBase != null) {
            return iRenderConfigBase.parseConfigString(str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.RenderConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        try {
            Method method = RenderConfigBaseRouter.class.getMethod("applyConfig", IKldDisplayImpl.class);
            if (iKldDisplayImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (KldDisplay) typeHelper.transfer(method, 0, iKldDisplayImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.RenderConfigBaseRouter.3
                    }));
                }
            }
            IRenderConfigBase iRenderConfigBase = this.mObserver;
            if (iRenderConfigBase != null) {
                return iRenderConfigBase.applyConfig(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.RenderConfigBaseImpl
    public boolean getIsMapVisiable() {
        IRenderConfigBase iRenderConfigBase = this.mObserver;
        if (iRenderConfigBase != null) {
            return iRenderConfigBase.getIsMapVisiable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.RenderConfigBaseImpl
    public ZoomScale getZoomScale() {
        IRenderConfigBase iRenderConfigBase = this.mObserver;
        if (iRenderConfigBase != null) {
            return iRenderConfigBase.getZoomScale();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.RenderConfigBaseImpl
    public float getMapTextScale() {
        IRenderConfigBase iRenderConfigBase = this.mObserver;
        if (iRenderConfigBase != null) {
            return iRenderConfigBase.getMapTextScale();
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.RenderConfigBaseImpl
    public int getFps() {
        IRenderConfigBase iRenderConfigBase = this.mObserver;
        if (iRenderConfigBase != null) {
            return iRenderConfigBase.getFps();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.RenderConfigBaseImpl
    public LeftTop getProjectCenter() {
        IRenderConfigBase iRenderConfigBase = this.mObserver;
        if (iRenderConfigBase != null) {
            return iRenderConfigBase.getProjectCenter();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.RenderConfigBaseImpl
    public MapViewPortParam getMapViewPort() {
        IRenderConfigBase iRenderConfigBase = this.mObserver;
        if (iRenderConfigBase != null) {
            return iRenderConfigBase.getMapViewPort();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public String getTypeName() {
        IRenderConfigBase iRenderConfigBase = this.mObserver;
        if (iRenderConfigBase != null) {
            return iRenderConfigBase.getTypeName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void getTypeName(String[] strArr) {
        IRenderConfigBase iRenderConfigBase = this.mObserver;
        if (iRenderConfigBase != null) {
            iRenderConfigBase.getTypeName(strArr);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public String getConfigName() {
        IRenderConfigBase iRenderConfigBase = this.mObserver;
        if (iRenderConfigBase != null) {
            return iRenderConfigBase.getConfigName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void getConfigName(String[] strArr) {
        IRenderConfigBase iRenderConfigBase = this.mObserver;
        if (iRenderConfigBase != null) {
            iRenderConfigBase.getConfigName(strArr);
        }
    }
}
