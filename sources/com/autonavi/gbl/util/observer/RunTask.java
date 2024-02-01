package com.autonavi.gbl.util.observer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.observer.impl.RunTaskImpl;
import com.autonavi.gbl.util.router.RunTaskRouter;
@IntfAuto(target = RunTaskRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class RunTask implements IRunTask {
    private static String PACKAGE = ReflexTool.PN(RunTask.class);
    private boolean mHasDestroy;
    private RunTaskImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    /* JADX INFO: Access modifiers changed from: protected */
    public void clean() {
    }

    protected RunTask(long j, boolean z) {
        this(new RunTaskRouter("RunTask", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRunTask.class}, new Object[]{this});
    }

    public RunTask(String str) {
        this(new RunTaskRouter("RunTask", null, str));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IRunTask.class}, new Object[]{this});
    }

    public RunTask(RunTaskImpl runTaskImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(runTaskImpl);
    }

    private void $constructor(RunTaskImpl runTaskImpl) {
        if (runTaskImpl != null) {
            this.mService = runTaskImpl;
            this.mTargetId = String.format("RunTask_%s_%d", String.valueOf(RunTaskImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected RunTaskImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

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

    @Override // com.autonavi.gbl.util.observer.IRunTask
    public void run() {
        RunTaskImpl runTaskImpl = this.mService;
        if (runTaskImpl == null || runTaskImpl.isCMemOwn()) {
            return;
        }
        this.mService.$explicit_run();
    }

    @Override // com.autonavi.gbl.util.observer.IRunTask
    public void onCancel() {
        RunTaskImpl runTaskImpl = this.mService;
        if (runTaskImpl != null) {
            runTaskImpl.$explicit_onCancel();
        }
    }

    @Override // com.autonavi.gbl.util.observer.IRunTask
    public long getId() {
        RunTaskImpl runTaskImpl = this.mService;
        if (runTaskImpl == null || runTaskImpl.isCMemOwn()) {
            return 0L;
        }
        return this.mService.$explicit_getId();
    }

    @Override // com.autonavi.gbl.util.observer.IRunTask
    public String getTaskName() {
        RunTaskImpl runTaskImpl = this.mService;
        if (runTaskImpl != null) {
            return runTaskImpl.$explicit_getTaskName();
        }
        return null;
    }
}
