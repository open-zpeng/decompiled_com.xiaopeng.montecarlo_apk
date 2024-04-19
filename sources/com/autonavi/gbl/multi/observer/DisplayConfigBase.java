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
import com.autonavi.gbl.multi.observer.impl.DisplayConfigBaseImpl;
import com.autonavi.gbl.multi.observer.impl.DisplayViewMode;
import com.autonavi.gbl.multi.router.DisplayConfigBaseRouter;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = DisplayConfigBaseRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class DisplayConfigBase extends KldConfigItemBase implements IDisplayConfigBase {
    private static String PACKAGE = ReflexTool.PN(DisplayConfigBase.class);
    private boolean mHasDestroy;
    private DisplayConfigBaseImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected DisplayConfigBase(long j, boolean z) {
        this(new DisplayConfigBaseRouter("DisplayConfigBase", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IDisplayConfigBase.class}, new Object[]{this});
    }

    public DisplayConfigBase() {
        this(new DisplayConfigBaseRouter("DisplayConfigBase", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IDisplayConfigBase.class}, new Object[]{this});
    }

    public DisplayConfigBase(DisplayConfigBaseImpl displayConfigBaseImpl) {
        super(displayConfigBaseImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(displayConfigBaseImpl);
    }

    private void $constructor(DisplayConfigBaseImpl displayConfigBaseImpl) {
        if (displayConfigBaseImpl != null) {
            this.mService = displayConfigBaseImpl;
            this.mTargetId = String.format("DisplayConfigBase_%s_%d", String.valueOf(DisplayConfigBaseImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public DisplayConfigBaseImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.DisplayConfigBase.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.DisplayConfigBase.2
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
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.DisplayConfigBase.3
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

    public void setWorkedIndex(int i) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            displayConfigBaseImpl.$explicit_setWorkedIndex(i);
        }
    }

    public void setDisplayName(String str) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            displayConfigBaseImpl.$explicit_setDisplayName(str);
        }
    }

    public void setSurfaceConfigName(String str) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            displayConfigBaseImpl.$explicit_setSurfaceConfigName(str);
        }
    }

    public void setModes(ArrayList<DisplayViewMode> arrayList) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            displayConfigBaseImpl.$explicit_setModes(arrayList);
        }
    }

    public void setMapProfile(String str) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            displayConfigBaseImpl.$explicit_setMapProfile(str);
        }
    }

    public void setLaneProfile(String str) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            displayConfigBaseImpl.$explicit_setLaneProfile(str);
        }
    }

    public void setRenderPolicy(int i) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            displayConfigBaseImpl.$explicit_setRenderPolicy(i);
        }
    }

    public void setInnerResume(boolean z) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            displayConfigBaseImpl.$explicit_setInnerResume(z);
        }
    }

    public void setFboEnable(boolean z) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            displayConfigBaseImpl.$explicit_setFboEnable(z);
        }
    }

    public void setNeedAntiAlias(int i) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            displayConfigBaseImpl.$explicit_setNeedAntiAlias(i);
        }
    }

    public void setSamples(int i) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            displayConfigBaseImpl.$explicit_setSamples(i);
        }
    }

    public void setWorkedModeIndex(int i) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            displayConfigBaseImpl.$explicit_setWorkedModeIndex(i);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public DisplayViewMode getViewMode(int i) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_getViewMode(i);
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public DisplayViewMode getWorkedViewMode() {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_getWorkedViewMode();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase, com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int parseConfigString(String str) {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_parseConfigString(str);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.KldConfigItemBase, com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int applyConfig(KldDisplay kldDisplay) {
        try {
            Method method = DisplayConfigBase.class.getMethod("applyConfig", KldDisplay.class);
            if (kldDisplay != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IKldDisplayImpl) typeHelper.transfer(method, 0, kldDisplay) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.observer.DisplayConfigBase.4
                    }));
                }
            }
            DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
            if (displayConfigBaseImpl != null) {
                return displayConfigBaseImpl.$explicit_applyConfig(r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public String getDisplayName() {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_getDisplayName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public String getSurfaceConfigName() {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_getSurfaceConfigName();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public ArrayList<DisplayViewMode> getModes() {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_getModes();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public String getMapProfile() {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_getMapProfile();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public String getLaneProfile() {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_getLaneProfile();
        }
        return null;
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int getRenderPolicy() {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_getRenderPolicy();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public boolean getInnerResume() {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_getInnerResume();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public boolean getFboEnable() {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_getFboEnable();
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int getNeedAntiAlias() {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_getNeedAntiAlias();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int getSamples() {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_getSamples();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.multi.observer.IDisplayConfigBase
    public int getWorkedModeIndex() {
        DisplayConfigBaseImpl displayConfigBaseImpl = this.mService;
        if (displayConfigBaseImpl != null) {
            return displayConfigBaseImpl.$explicit_getWorkedModeIndex();
        }
        return 0;
    }
}
