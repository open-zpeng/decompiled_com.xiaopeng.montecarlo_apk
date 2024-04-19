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
import com.autonavi.gbl.multi.observer.DisplayConfigBase;
import com.autonavi.gbl.multi.observer.IDisplayConfigBase;
import com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl;
import com.autonavi.gbl.multi.observer.impl.DisplayViewMode;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = DisplayConfigBase.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class DisplayConfigBaseRouter extends DisplayConfigBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(DisplayConfigBaseRouter.class);
    private static String PACKAGE = ReflexTool.PN(DisplayConfigBaseRouter.class);
    private TypeHelper mHelper;
    private IDisplayConfigBase mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IDisplayConfigBase iDisplayConfigBase) {
        if (iDisplayConfigBase != null) {
            this.mObserver = iDisplayConfigBase;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(DisplayConfigBase.class, iDisplayConfigBase, this);
            }
        }
    }

    private void $constructor(String str, IDisplayConfigBase iDisplayConfigBase) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(DisplayConfigBaseImpl.getCPtr((DisplayConfigBaseImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iDisplayConfigBase);
    }

    public DisplayConfigBaseRouter(String str, IDisplayConfigBase iDisplayConfigBase, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDisplayConfigBase);
    }

    public DisplayConfigBaseRouter(String str, IDisplayConfigBase iDisplayConfigBase) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDisplayConfigBase);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.DisplayConfigBaseRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.DisplayConfigBaseRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl
    public DisplayViewMode getViewMode(int i) {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getViewMode(i);
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl
    public DisplayViewMode getWorkedViewMode() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getWorkedViewMode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int parseConfigString(String str) {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.parseConfigString(str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl, com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        try {
            Method method = DisplayConfigBaseRouter.class.getMethod("applyConfig", IKldDisplayImpl.class);
            if (iKldDisplayImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (KldDisplay) typeHelper.transfer(method, 0, iKldDisplayImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.DisplayConfigBaseRouter.3
                    }));
                }
            }
            IDisplayConfigBase iDisplayConfigBase = this.mObserver;
            if (iDisplayConfigBase != null) {
                return iDisplayConfigBase.applyConfig(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl
    public String getDisplayName() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getDisplayName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl
    public String getSurfaceConfigName() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getSurfaceConfigName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl
    public ArrayList<DisplayViewMode> getModes() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getModes();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl
    public String getMapProfile() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getMapProfile();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl
    public String getLaneProfile() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getLaneProfile();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl
    public int getRenderPolicy() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getRenderPolicy();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl
    public boolean getInnerResume() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getInnerResume();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl
    public boolean getFboEnable() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getFboEnable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl
    public int getNeedAntiAlias() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getNeedAntiAlias();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl
    public int getSamples() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getSamples();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl
    public int getWorkedModeIndex() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getWorkedModeIndex();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public String getTypeName() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getTypeName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void getTypeName(String[] strArr) {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            iDisplayConfigBase.getTypeName(strArr);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public String getConfigName() {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            return iDisplayConfigBase.getConfigName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void getConfigName(String[] strArr) {
        IDisplayConfigBase iDisplayConfigBase = this.mObserver;
        if (iDisplayConfigBase != null) {
            iDisplayConfigBase.getConfigName(strArr);
        }
    }
}
