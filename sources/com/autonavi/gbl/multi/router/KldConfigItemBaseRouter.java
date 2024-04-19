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
import com.autonavi.gbl.multi.observer.IKldConfigItemBase;
import com.autonavi.gbl.multi.observer.KldConfigItemBase;
import com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl;
import java.lang.reflect.Method;
@IntfAuto(target = KldConfigItemBase.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class KldConfigItemBaseRouter extends IKldConfigItemBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(KldConfigItemBaseRouter.class);
    private static String PACKAGE = ReflexTool.PN(KldConfigItemBaseRouter.class);
    private TypeHelper mHelper;
    private IKldConfigItemBase mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IKldConfigItemBase iKldConfigItemBase) {
        if (iKldConfigItemBase != null) {
            this.mObserver = iKldConfigItemBase;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(KldConfigItemBase.class, iKldConfigItemBase, this);
            }
        }
    }

    private void $constructor(String str, IKldConfigItemBase iKldConfigItemBase) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IKldConfigItemBaseImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iKldConfigItemBase);
    }

    public KldConfigItemBaseRouter(String str, IKldConfigItemBase iKldConfigItemBase, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKldConfigItemBase);
    }

    public KldConfigItemBaseRouter(String str, IKldConfigItemBase iKldConfigItemBase) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKldConfigItemBase);
    }

    public KldConfigItemBaseRouter(String str, IKldConfigItemBase iKldConfigItemBase, IKldConfigItemBaseImpl iKldConfigItemBaseImpl) {
        super(iKldConfigItemBaseImpl);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKldConfigItemBase);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldConfigItemBaseRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldConfigItemBaseRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public String getTypeName() {
        IKldConfigItemBase iKldConfigItemBase = this.mObserver;
        if (iKldConfigItemBase != null) {
            return iKldConfigItemBase.getTypeName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void getTypeName(String[] strArr) {
        IKldConfigItemBase iKldConfigItemBase = this.mObserver;
        if (iKldConfigItemBase != null) {
            iKldConfigItemBase.getTypeName(strArr);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public String getConfigName() {
        IKldConfigItemBase iKldConfigItemBase = this.mObserver;
        if (iKldConfigItemBase != null) {
            return iKldConfigItemBase.getConfigName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void getConfigName(String[] strArr) {
        IKldConfigItemBase iKldConfigItemBase = this.mObserver;
        if (iKldConfigItemBase != null) {
            iKldConfigItemBase.getConfigName(strArr);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int parseConfigString(String str) {
        IKldConfigItemBase iKldConfigItemBase = this.mObserver;
        if (iKldConfigItemBase != null) {
            return iKldConfigItemBase.parseConfigString(str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        try {
            Method method = KldConfigItemBaseRouter.class.getMethod("applyConfig", IKldDisplayImpl.class);
            if (iKldDisplayImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (KldDisplay) typeHelper.transfer(method, 0, iKldDisplayImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldConfigItemBaseRouter.3
                    }));
                }
            }
            IKldConfigItemBase iKldConfigItemBase = this.mObserver;
            if (iKldConfigItemBase != null) {
                return iKldConfigItemBase.applyConfig(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }
}
