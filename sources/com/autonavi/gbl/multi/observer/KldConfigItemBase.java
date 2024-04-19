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
import com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl;
import com.autonavi.gbl.multi.router.KldConfigItemBaseRouter;
import java.lang.reflect.Method;
@IntfAuto(target = KldConfigItemBaseRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class KldConfigItemBase implements IKldConfigItemBase {
    private static String PACKAGE = ReflexTool.PN(KldConfigItemBase.class);
    private boolean mHasDestroy;
    private IKldConfigItemBaseImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected KldConfigItemBase(long j, boolean z) {
        this(new KldConfigItemBaseRouter("KldConfigItemBase", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IKldConfigItemBase.class}, new Object[]{this});
    }

    public KldConfigItemBase() {
        this(new KldConfigItemBaseRouter("KldConfigItemBase", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IKldConfigItemBase.class}, new Object[]{this});
    }

    public KldConfigItemBase(KldConfigItemBase kldConfigItemBase) {
        this(new KldConfigItemBaseRouter("KldConfigItemBase", null, (IKldConfigItemBaseImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.multi.observer.KldConfigItemBase", kldConfigItemBase)));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IKldConfigItemBase.class}, new Object[]{this});
    }

    public KldConfigItemBase(IKldConfigItemBaseImpl iKldConfigItemBaseImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(iKldConfigItemBaseImpl);
    }

    private void $constructor(IKldConfigItemBaseImpl iKldConfigItemBaseImpl) {
        if (iKldConfigItemBaseImpl != null) {
            this.mService = iKldConfigItemBaseImpl;
            this.mTargetId = String.format("KldConfigItemBase_%s_%d", String.valueOf(IKldConfigItemBaseImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    public IKldConfigItemBaseImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.KldConfigItemBase.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.KldConfigItemBase.2
        }));
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.KldConfigItemBase.3
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

    public void setTypeName(String str) {
        IKldConfigItemBaseImpl iKldConfigItemBaseImpl = this.mService;
        if (iKldConfigItemBaseImpl != null) {
            iKldConfigItemBaseImpl.$explicit_setTypeName(str);
        }
    }

    public void setConfigName(String str) {
        IKldConfigItemBaseImpl iKldConfigItemBaseImpl = this.mService;
        if (iKldConfigItemBaseImpl != null) {
            iKldConfigItemBaseImpl.$explicit_setConfigName(str);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase
    public String getTypeName() {
        IKldConfigItemBaseImpl iKldConfigItemBaseImpl = this.mService;
        if (iKldConfigItemBaseImpl != null) {
            return iKldConfigItemBaseImpl.$explicit_getTypeName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase
    public void getTypeName(String[] strArr) {
        IKldConfigItemBaseImpl iKldConfigItemBaseImpl = this.mService;
        if (iKldConfigItemBaseImpl != null) {
            iKldConfigItemBaseImpl.$explicit_getTypeName(strArr);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase
    public String getConfigName() {
        IKldConfigItemBaseImpl iKldConfigItemBaseImpl = this.mService;
        if (iKldConfigItemBaseImpl != null) {
            return iKldConfigItemBaseImpl.$explicit_getConfigName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase
    public void getConfigName(String[] strArr) {
        IKldConfigItemBaseImpl iKldConfigItemBaseImpl = this.mService;
        if (iKldConfigItemBaseImpl != null) {
            iKldConfigItemBaseImpl.$explicit_getConfigName(strArr);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int parseConfigString(String str) {
        IKldConfigItemBaseImpl iKldConfigItemBaseImpl = this.mService;
        if (iKldConfigItemBaseImpl != null) {
            return iKldConfigItemBaseImpl.$explicit_parseConfigString(str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int applyConfig(KldDisplay kldDisplay) {
        try {
            Method method = KldConfigItemBase.class.getMethod("applyConfig", KldDisplay.class);
            if (kldDisplay != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IKldDisplayImpl) typeHelper.transfer(method, 0, kldDisplay) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.KldConfigItemBase.4
                    }));
                }
            }
            IKldConfigItemBaseImpl iKldConfigItemBaseImpl = this.mService;
            if (iKldConfigItemBaseImpl != null) {
                return iKldConfigItemBaseImpl.$explicit_applyConfig(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }
}
