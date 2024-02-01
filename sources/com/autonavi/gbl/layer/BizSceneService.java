package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.BizSceneContextImpl;
import com.autonavi.gbl.layer.impl.IBizSceneServiceImpl;
import com.autonavi.gbl.layer.model.SceneConfigOption;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
@IntfAuto(target = IBizSceneServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizSceneService implements IService {
    private static String PACKAGE = ReflexTool.PN(BizSceneService.class);
    private IBizSceneServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected BizSceneService(long j, boolean z) {
        this((IBizSceneServiceImpl) ReflexTool.invokeDeclConstructorSafe(IBizSceneServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizSceneService.class, this, this.mControl);
        }
    }

    public BizSceneService(IBizSceneServiceImpl iBizSceneServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizSceneServiceImpl);
    }

    private void $constructor(IBizSceneServiceImpl iBizSceneServiceImpl) {
        if (iBizSceneServiceImpl != null) {
            this.mControl = iBizSceneServiceImpl;
            this.mTargetId = String.format("BizSceneService_%s_%d", String.valueOf(IBizSceneServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBizSceneServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IBizSceneServiceImpl iBizSceneServiceImpl = this.mControl;
        if (iBizSceneServiceImpl != null) {
            return iBizSceneServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IBizSceneServiceImpl iBizSceneServiceImpl = this.mControl;
        if (iBizSceneServiceImpl != null) {
            return iBizSceneServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IBizSceneServiceImpl iBizSceneServiceImpl = this.mControl;
        if (iBizSceneServiceImpl != null) {
            iBizSceneServiceImpl.onCreate();
        }
    }

    public int init(String str) {
        IBizSceneServiceImpl iBizSceneServiceImpl = this.mControl;
        if (iBizSceneServiceImpl != null) {
            return iBizSceneServiceImpl.init(str);
        }
        return Integer.MIN_VALUE;
    }

    public int invokeScene(BizSceneContext bizSceneContext) {
        TypeHelper typeHelper;
        try {
            Method method = BizSceneService.class.getMethod("invokeScene", BizSceneContext.class);
            BizSceneContextImpl bizSceneContextImpl = null;
            if (bizSceneContext != null && (typeHelper = this.mTypeHelper) != null) {
                bizSceneContextImpl = (BizSceneContextImpl) typeHelper.transfer(method, 0, bizSceneContext);
            }
            IBizSceneServiceImpl iBizSceneServiceImpl = this.mControl;
            if (iBizSceneServiceImpl != null) {
                return iBizSceneServiceImpl.invokeScene(bizSceneContextImpl);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public int updateConfig(SceneConfigOption sceneConfigOption) {
        IBizSceneServiceImpl iBizSceneServiceImpl = this.mControl;
        if (iBizSceneServiceImpl != null) {
            return iBizSceneServiceImpl.updateConfig(sceneConfigOption);
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IBizSceneServiceImpl iBizSceneServiceImpl = this.mControl;
        if (iBizSceneServiceImpl != null) {
            iBizSceneServiceImpl.unInit();
        }
    }

    public String getVersion() {
        IBizSceneServiceImpl iBizSceneServiceImpl = this.mControl;
        if (iBizSceneServiceImpl != null) {
            return iBizSceneServiceImpl.getVersion();
        }
        return null;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IBizSceneServiceImpl iBizSceneServiceImpl = this.mControl;
        if (iBizSceneServiceImpl != null) {
            return iBizSceneServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public int getServiceID() {
        IBizSceneServiceImpl iBizSceneServiceImpl = this.mControl;
        if (iBizSceneServiceImpl != null) {
            return iBizSceneServiceImpl.getServiceID();
        }
        return 0;
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
