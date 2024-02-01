package com.autonavi.gbl.scene;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl;
import com.autonavi.gbl.scene.impl.ISceneModuleServiceImpl;
import com.autonavi.gbl.scene.model.InitSceneModuleParam;
import com.autonavi.gbl.scene.model.SceneModuleID;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
@IntfAuto(target = ISceneModuleServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class SceneModuleService implements IService {
    private static String PACKAGE = ReflexTool.PN(SceneModuleService.class);
    private ISceneModuleServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected SceneModuleService(long j, boolean z) {
        this((ISceneModuleServiceImpl) ReflexTool.invokeDeclConstructorSafe(ISceneModuleServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(SceneModuleService.class, this, this.mControl);
        }
    }

    public SceneModuleService(ISceneModuleServiceImpl iSceneModuleServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iSceneModuleServiceImpl);
    }

    private void $constructor(ISceneModuleServiceImpl iSceneModuleServiceImpl) {
        if (iSceneModuleServiceImpl != null) {
            this.mControl = iSceneModuleServiceImpl;
            this.mTargetId = String.format("SceneModuleService_%s_%d", String.valueOf(ISceneModuleServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ISceneModuleServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        ISceneModuleServiceImpl iSceneModuleServiceImpl = this.mControl;
        if (iSceneModuleServiceImpl != null) {
            return iSceneModuleServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        ISceneModuleServiceImpl iSceneModuleServiceImpl = this.mControl;
        if (iSceneModuleServiceImpl != null) {
            return iSceneModuleServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        ISceneModuleServiceImpl iSceneModuleServiceImpl = this.mControl;
        if (iSceneModuleServiceImpl != null) {
            iSceneModuleServiceImpl.onCreate();
        }
    }

    public int init(InitSceneModuleParam initSceneModuleParam) {
        ISceneModuleServiceImpl iSceneModuleServiceImpl = this.mControl;
        if (iSceneModuleServiceImpl != null) {
            return iSceneModuleServiceImpl.init(initSceneModuleParam);
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        ISceneModuleServiceImpl iSceneModuleServiceImpl = this.mControl;
        if (iSceneModuleServiceImpl != null) {
            iSceneModuleServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        ISceneModuleServiceImpl iSceneModuleServiceImpl = this.mControl;
        if (iSceneModuleServiceImpl != null) {
            return iSceneModuleServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public String getVersion() {
        ISceneModuleServiceImpl iSceneModuleServiceImpl = this.mControl;
        if (iSceneModuleServiceImpl != null) {
            return iSceneModuleServiceImpl.getVersion();
        }
        return null;
    }

    public BaseSceneModule getModuleByType(@SceneModuleID.SceneModuleID1 int i) {
        IBaseSceneModuleImpl moduleByType;
        TypeHelper typeHelper;
        try {
            Method method = SceneModuleService.class.getMethod("getModuleByType", Integer.TYPE);
            ISceneModuleServiceImpl iSceneModuleServiceImpl = this.mControl;
            if (iSceneModuleServiceImpl == null || (moduleByType = iSceneModuleServiceImpl.getModuleByType(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BaseSceneModule) typeHelper.transfer(method, -1, (Object) moduleByType, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
