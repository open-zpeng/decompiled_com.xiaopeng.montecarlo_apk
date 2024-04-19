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
import com.autonavi.gbl.multi.observer.DisplaySceneConfigBase;
import com.autonavi.gbl.multi.observer.IDisplaySceneConfigBase;
import com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl;
import java.lang.reflect.Method;
@IntfAuto(target = DisplaySceneConfigBase.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class DisplaySceneConfigBaseRouter extends DisplaySceneConfigBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(DisplaySceneConfigBaseRouter.class);
    private static String PACKAGE = ReflexTool.PN(DisplaySceneConfigBaseRouter.class);
    private TypeHelper mHelper;
    private IDisplaySceneConfigBase mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IDisplaySceneConfigBase iDisplaySceneConfigBase) {
        if (iDisplaySceneConfigBase != null) {
            this.mObserver = iDisplaySceneConfigBase;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(DisplaySceneConfigBase.class, iDisplaySceneConfigBase, this);
            }
        }
    }

    private void $constructor(String str, IDisplaySceneConfigBase iDisplaySceneConfigBase) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(DisplaySceneConfigBaseImpl.getCPtr((DisplaySceneConfigBaseImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iDisplaySceneConfigBase);
    }

    public DisplaySceneConfigBaseRouter(String str, IDisplaySceneConfigBase iDisplaySceneConfigBase, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDisplaySceneConfigBase);
    }

    public DisplaySceneConfigBaseRouter(String str, IDisplaySceneConfigBase iDisplaySceneConfigBase) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDisplaySceneConfigBase);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.DisplaySceneConfigBaseRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.DisplaySceneConfigBaseRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int parseConfigString(String str) {
        IDisplaySceneConfigBase iDisplaySceneConfigBase = this.mObserver;
        if (iDisplaySceneConfigBase != null) {
            return iDisplaySceneConfigBase.parseConfigString(str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        try {
            Method method = DisplaySceneConfigBaseRouter.class.getMethod("applyConfig", IKldDisplayImpl.class);
            if (iKldDisplayImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (KldDisplay) typeHelper.transfer(method, 0, iKldDisplayImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.DisplaySceneConfigBaseRouter.3
                    }));
                }
            }
            IDisplaySceneConfigBase iDisplaySceneConfigBase = this.mObserver;
            if (iDisplaySceneConfigBase != null) {
                return iDisplaySceneConfigBase.applyConfig(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl
    public String getRenderConfigName() {
        IDisplaySceneConfigBase iDisplaySceneConfigBase = this.mObserver;
        if (iDisplaySceneConfigBase != null) {
            return iDisplaySceneConfigBase.getRenderConfigName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl
    public String getMapConfigName() {
        IDisplaySceneConfigBase iDisplaySceneConfigBase = this.mObserver;
        if (iDisplaySceneConfigBase != null) {
            return iDisplaySceneConfigBase.getMapConfigName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public String getTypeName() {
        IDisplaySceneConfigBase iDisplaySceneConfigBase = this.mObserver;
        if (iDisplaySceneConfigBase != null) {
            return iDisplaySceneConfigBase.getTypeName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void getTypeName(String[] strArr) {
        IDisplaySceneConfigBase iDisplaySceneConfigBase = this.mObserver;
        if (iDisplaySceneConfigBase != null) {
            iDisplaySceneConfigBase.getTypeName(strArr);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public String getConfigName() {
        IDisplaySceneConfigBase iDisplaySceneConfigBase = this.mObserver;
        if (iDisplaySceneConfigBase != null) {
            return iDisplaySceneConfigBase.getConfigName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void getConfigName(String[] strArr) {
        IDisplaySceneConfigBase iDisplaySceneConfigBase = this.mObserver;
        if (iDisplaySceneConfigBase != null) {
            iDisplaySceneConfigBase.getConfigName(strArr);
        }
    }
}
