package com.autonavi.gbl.util.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.observer.IUITask;
import com.autonavi.gbl.util.observer.UITask;
import com.autonavi.gbl.util.observer.impl.UITaskImpl;
@IntfAuto(target = UITask.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class UITaskRouter extends UITaskImpl {
    private static BindTable BIND_TABLE = new BindTable(UITaskRouter.class);
    private static String PACKAGE = ReflexTool.PN(UITaskRouter.class);
    private TypeHelper mHelper;
    private IUITask mObserver;
    private String mTargetId;

    protected Object getObserver() {
        return this.mObserver;
    }

    protected void bindObserver(IUITask iUITask) {
        if (iUITask != null) {
            this.mObserver = iUITask;
            TypeHelper typeHelper = this.mHelper;
            if (typeHelper != null) {
                typeHelper.bind(UITask.class, iUITask, this);
            }
        }
    }

    private void $constructor(String str, IUITask iUITask) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(UITaskImpl.getCPtr((UITaskImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        bindObserver(iUITask);
    }

    public UITaskRouter(String str, IUITask iUITask, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iUITask);
    }

    public UITaskRouter(String str, IUITask iUITask, String str2) {
        super(str2);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iUITask);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.util.observer.impl.UITaskImpl, com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.util.observer.impl.UITaskImpl, com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public void run() {
        IUITask iUITask = this.mObserver;
        if (iUITask != null) {
            iUITask.run();
        }
    }

    @Override // com.autonavi.gbl.util.observer.impl.UITaskImpl, com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public void onCancel() {
        IUITask iUITask = this.mObserver;
        if (iUITask != null) {
            iUITask.onCancel();
        }
    }

    @Override // com.autonavi.gbl.util.observer.impl.UITaskImpl, com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public long getId() {
        IUITask iUITask = this.mObserver;
        if (iUITask != null) {
            return iUITask.getId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.util.observer.impl.RunTaskImpl
    public String getTaskName() {
        IUITask iUITask = this.mObserver;
        if (iUITask != null) {
            return iUITask.getTaskName();
        }
        return null;
    }
}
