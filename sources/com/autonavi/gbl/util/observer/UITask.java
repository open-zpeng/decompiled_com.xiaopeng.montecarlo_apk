package com.autonavi.gbl.util.observer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.observer.impl.UITaskImpl;
import com.autonavi.gbl.util.router.UITaskRouter;
@IntfAuto(target = UITaskRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class UITask implements IUITask {
    private static String PACKAGE = ReflexTool.PN(UITask.class);
    private boolean mHasDestroy;
    private UITaskImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected UITask(long j, boolean z) {
        this(new UITaskRouter("UITask", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IUITask.class}, new Object[]{this});
    }

    public UITask(String str) {
        this(new UITaskRouter("UITask", null, str));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IUITask.class}, new Object[]{this});
    }

    public UITask(UITaskImpl uITaskImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(uITaskImpl);
    }

    private void $constructor(UITaskImpl uITaskImpl) {
        if (uITaskImpl != null) {
            this.mService = uITaskImpl;
            this.mTargetId = String.format("UITask_%s_%d", String.valueOf(UITaskImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    public UITaskImpl getService() {
        return this.mService;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.observer.UITask.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.observer.UITask.2
        }));
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.observer.UITask.3
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

    @Override // com.autonavi.gbl.util.observer.IUITask
    public void run() {
        UITaskImpl uITaskImpl = this.mService;
        if (uITaskImpl != null) {
            uITaskImpl.$explicit_run();
        }
    }

    @Override // com.autonavi.gbl.util.observer.IUITask
    public void onCancel() {
        UITaskImpl uITaskImpl = this.mService;
        if (uITaskImpl != null) {
            uITaskImpl.$explicit_onCancel();
        }
    }

    @Override // com.autonavi.gbl.util.observer.IUITask
    public long getId() {
        UITaskImpl uITaskImpl = this.mService;
        if (uITaskImpl != null) {
            return uITaskImpl.$explicit_getId();
        }
        return 0L;
    }
}
