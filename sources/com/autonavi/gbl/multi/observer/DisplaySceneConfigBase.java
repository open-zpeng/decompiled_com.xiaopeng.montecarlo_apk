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
import com.autonavi.gbl.multi.observer.impl.DisplaySceneConfigBaseImpl;
import com.autonavi.gbl.multi.router.DisplaySceneConfigBaseRouter;
import java.lang.reflect.Method;
@IntfAuto(target = DisplaySceneConfigBaseRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class DisplaySceneConfigBase extends KldConfigItemBase implements IDisplaySceneConfigBase {
    private static String PACKAGE = ReflexTool.PN(DisplaySceneConfigBase.class);
    private boolean mHasDestroy;
    private DisplaySceneConfigBaseImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected DisplaySceneConfigBase(long j, boolean z) {
        this(new DisplaySceneConfigBaseRouter("DisplaySceneConfigBase", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IDisplaySceneConfigBase.class}, new Object[]{this});
    }

    public DisplaySceneConfigBase() {
        this(new DisplaySceneConfigBaseRouter("DisplaySceneConfigBase", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IDisplaySceneConfigBase.class}, new Object[]{this});
    }

    public DisplaySceneConfigBase(DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl) {
        super(displaySceneConfigBaseImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(displaySceneConfigBaseImpl);
    }

    private void $constructor(DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl) {
        if (displaySceneConfigBaseImpl != null) {
            this.mService = displaySceneConfigBaseImpl;
            this.mTargetId = String.format("DisplaySceneConfigBase_%s_%d", String.valueOf(DisplaySceneConfigBaseImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public DisplaySceneConfigBaseImpl getService() {
        return this.mService;
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.DisplaySceneConfigBase.1
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

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.DisplaySceneConfigBase.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.DisplaySceneConfigBase.3
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

    public void setRenderConfigName(String str) {
        DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl = this.mService;
        if (displaySceneConfigBaseImpl != null) {
            displaySceneConfigBaseImpl.$explicit_setRenderConfigName(str);
        }
    }

    public void setMapConfigName(String str) {
        DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl = this.mService;
        if (displaySceneConfigBaseImpl != null) {
            displaySceneConfigBaseImpl.$explicit_setMapConfigName(str);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase, com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int parseConfigString(String str) {
        DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl = this.mService;
        if (displaySceneConfigBaseImpl != null) {
            return displaySceneConfigBaseImpl.$explicit_parseConfigString(str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase, com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int applyConfig(KldDisplay kldDisplay) {
        try {
            Method method = DisplaySceneConfigBase.class.getMethod("applyConfig", KldDisplay.class);
            if (kldDisplay != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IKldDisplayImpl) typeHelper.transfer(method, 0, kldDisplay) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.DisplaySceneConfigBase.4
                    }));
                }
            }
            DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl = this.mService;
            if (displaySceneConfigBaseImpl != null) {
                return displaySceneConfigBaseImpl.$explicit_applyConfig(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplaySceneConfigBase
    public String getRenderConfigName() {
        DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl = this.mService;
        if (displaySceneConfigBaseImpl != null) {
            return displaySceneConfigBaseImpl.$explicit_getRenderConfigName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplaySceneConfigBase
    public String getMapConfigName() {
        DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl = this.mService;
        if (displaySceneConfigBaseImpl != null) {
            return displaySceneConfigBaseImpl.$explicit_getMapConfigName();
        }
        return null;
    }
}
