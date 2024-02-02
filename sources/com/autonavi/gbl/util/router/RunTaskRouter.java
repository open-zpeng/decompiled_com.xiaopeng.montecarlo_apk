package com.autonavi.gbl.util.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.observer.IRunTask;
import com.autonavi.gbl.util.observer.RunTask;
import com.autonavi.gbl.util.observer.impl.RunTaskImpl;
@IntfAuto(target = RunTask.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RunTaskRouter extends RunTaskImpl {
    private static BindTable BIND_TABLE = new BindTable(RunTaskRouter.class);
    private static String PACKAGE = ReflexTool.PN(RunTaskRouter.class);
    private TypeHelper mHelper;
    private IRunTask mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IRunTask iRunTask) {
        if (iRunTask != null) {
            this.mObserver = iRunTask;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(RunTask.class, iRunTask, this);
            }
        }
    }

    private void $constructor(String str, IRunTask iRunTask) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(RunTaskImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iRunTask);
    }

    public RunTaskRouter(String str, IRunTask iRunTask, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRunTask);
    }

    public RunTaskRouter(String str, IRunTask iRunTask, String str2) {
        super(str2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRunTask);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.router.RunTaskRouter.1
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
    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.router.RunTaskRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public void run() {
        IRunTask iRunTask = this.mObserver;
        if (iRunTask != null) {
            iRunTask.run();
        }
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public void onCancel() {
        IRunTask iRunTask = this.mObserver;
        if (iRunTask != null) {
            iRunTask.onCancel();
        }
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public long getId() {
        IRunTask iRunTask = this.mObserver;
        if (iRunTask != null) {
            return iRunTask.getId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public String getTaskName() {
        IRunTask iRunTask = this.mObserver;
        if (iRunTask != null) {
            return iRunTask.getTaskName();
        }
        return null;
    }
}
