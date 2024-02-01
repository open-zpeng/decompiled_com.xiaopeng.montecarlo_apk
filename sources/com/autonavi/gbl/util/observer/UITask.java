package com.autonavi.gbl.util.observer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.observer.impl.UITaskImpl;
import com.autonavi.gbl.util.router.UITaskRouter;
@IntfAuto(target = UITaskRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class UITask extends RunTask implements IUITask {
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
        super(uITaskImpl);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.util.observer.RunTask
    public UITaskImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.util.observer.RunTask
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.util.observer.RunTask
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.util.observer.RunTask
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.util.observer.RunTask
    public synchronized void delete() {
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

    @Override // com.autonavi.gbl.util.observer.RunTask, com.autonavi.gbl.util.observer.IRunTask
    public void run() {
        UITaskImpl uITaskImpl = this.mService;
        if (uITaskImpl == null || uITaskImpl.isCMemOwn()) {
            return;
        }
        this.mService.$explicit_run();
    }

    @Override // com.autonavi.gbl.util.observer.RunTask, com.autonavi.gbl.util.observer.IRunTask
    public void onCancel() {
        UITaskImpl uITaskImpl = this.mService;
        if (uITaskImpl != null) {
            uITaskImpl.$explicit_onCancel();
        }
    }

    @Override // com.autonavi.gbl.util.observer.RunTask, com.autonavi.gbl.util.observer.IRunTask
    public long getId() {
        UITaskImpl uITaskImpl = this.mService;
        if (uITaskImpl == null || uITaskImpl.isCMemOwn()) {
            return 0L;
        }
        return this.mService.$explicit_getId();
    }
}
