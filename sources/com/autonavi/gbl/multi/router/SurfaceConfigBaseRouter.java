package com.autonavi.gbl.multi.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.KldDisplay;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.model.RectSizeType;
import com.autonavi.gbl.multi.observer.ISurfaceConfigBase;
import com.autonavi.gbl.multi.observer.SurfaceConfigBase;
import com.autonavi.gbl.multi.observer.impl.SurfaceConfigBaseImpl;
import java.lang.reflect.Method;
@IntfAuto(target = SurfaceConfigBase.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class SurfaceConfigBaseRouter extends SurfaceConfigBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(SurfaceConfigBaseRouter.class);
    private static String PACKAGE = ReflexTool.PN(SurfaceConfigBaseRouter.class);
    private TypeHelper mHelper;
    private ISurfaceConfigBase mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(ISurfaceConfigBase iSurfaceConfigBase) {
        if (iSurfaceConfigBase != null) {
            this.mObserver = iSurfaceConfigBase;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(SurfaceConfigBase.class, iSurfaceConfigBase, this);
            }
        }
    }

    private void $constructor(String str, ISurfaceConfigBase iSurfaceConfigBase) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(SurfaceConfigBaseImpl.getCPtr((SurfaceConfigBaseImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iSurfaceConfigBase);
    }

    public SurfaceConfigBaseRouter(String str, ISurfaceConfigBase iSurfaceConfigBase, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSurfaceConfigBase);
    }

    public SurfaceConfigBaseRouter(String str, ISurfaceConfigBase iSurfaceConfigBase) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSurfaceConfigBase);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.SurfaceConfigBaseRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.SurfaceConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.SurfaceConfigBaseRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.SurfaceConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int parseConfigString(String str) {
        ISurfaceConfigBase iSurfaceConfigBase = this.mObserver;
        if (iSurfaceConfigBase != null) {
            return iSurfaceConfigBase.parseConfigString(str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.SurfaceConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        try {
            Method method = SurfaceConfigBaseRouter.class.getMethod("applyConfig", IKldDisplayImpl.class);
            if (iKldDisplayImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (KldDisplay) typeHelper.transfer(method, 0, iKldDisplayImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.SurfaceConfigBaseRouter.3
                    }));
                }
            }
            ISurfaceConfigBase iSurfaceConfigBase = this.mObserver;
            if (iSurfaceConfigBase != null) {
                return iSurfaceConfigBase.applyConfig(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.SurfaceConfigBaseImpl
    public RectSizeType getSurfaceSize() {
        ISurfaceConfigBase iSurfaceConfigBase = this.mObserver;
        if (iSurfaceConfigBase != null) {
            return iSurfaceConfigBase.getSurfaceSize();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.SurfaceConfigBaseImpl
    public boolean getIsSurfaceVisiable() {
        ISurfaceConfigBase iSurfaceConfigBase = this.mObserver;
        if (iSurfaceConfigBase != null) {
            return iSurfaceConfigBase.getIsSurfaceVisiable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.SurfaceConfigBaseImpl
    public boolean getIsSeparateRender() {
        ISurfaceConfigBase iSurfaceConfigBase = this.mObserver;
        if (iSurfaceConfigBase != null) {
            return iSurfaceConfigBase.getIsSeparateRender();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.SurfaceConfigBaseImpl
    public int getWindowId() {
        ISurfaceConfigBase iSurfaceConfigBase = this.mObserver;
        if (iSurfaceConfigBase != null) {
            return iSurfaceConfigBase.getWindowId();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public String getTypeName() {
        ISurfaceConfigBase iSurfaceConfigBase = this.mObserver;
        if (iSurfaceConfigBase != null) {
            return iSurfaceConfigBase.getTypeName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void getTypeName(String[] strArr) {
        ISurfaceConfigBase iSurfaceConfigBase = this.mObserver;
        if (iSurfaceConfigBase != null) {
            iSurfaceConfigBase.getTypeName(strArr);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public String getConfigName() {
        ISurfaceConfigBase iSurfaceConfigBase = this.mObserver;
        if (iSurfaceConfigBase != null) {
            return iSurfaceConfigBase.getConfigName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void getConfigName(String[] strArr) {
        ISurfaceConfigBase iSurfaceConfigBase = this.mObserver;
        if (iSurfaceConfigBase != null) {
            iSurfaceConfigBase.getConfigName(strArr);
        }
    }
}
