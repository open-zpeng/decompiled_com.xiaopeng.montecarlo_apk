package com.autonavi.gbl.util.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.observer.IRunTaskThread;
import com.autonavi.gbl.util.observer.RunTask;
import com.autonavi.gbl.util.observer.impl.IRunTaskThreadImpl;
import com.autonavi.gbl.util.observer.impl.RunTaskImpl;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = IRunTaskThread.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class RunTaskThreadRouter extends IRunTaskThreadImpl {
    private static BindTable BIND_TABLE = new BindTable(RunTaskThreadRouter.class);
    private static String PACKAGE = ReflexTool.PN(RunTaskThreadRouter.class);
    private TypeHelper mHelper;
    private IRunTaskThread mObserver;
    private String mTargetId;

    private void $constructor(String str, IRunTaskThread iRunTaskThread) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IRunTaskThreadImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iRunTaskThread;
    }

    protected RunTaskThreadRouter(String str, IRunTaskThread iRunTaskThread, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRunTaskThread);
    }

    protected RunTaskThreadRouter(String str, IRunTaskThread iRunTaskThread) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iRunTaskThread);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.util.observer.impl.IRunTaskThreadImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.util.observer.impl.IRunTaskThreadImpl
    public void post(RunTaskImpl runTaskImpl, long j, BigInteger bigInteger) {
        TypeHelper typeHelper;
        try {
            Method method = RunTaskThreadRouter.class.getMethod("post", RunTaskImpl.class, Long.TYPE, BigInteger.class);
            RunTask runTask = null;
            if (runTaskImpl != null && (typeHelper = this.mHelper) != null) {
                runTask = (RunTask) typeHelper.transfer(method, 0, runTaskImpl);
            }
            IRunTaskThread iRunTaskThread = this.mObserver;
            if (iRunTaskThread != null) {
                iRunTaskThread.post(runTask, j, bigInteger);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.util.observer.impl.IRunTaskThreadImpl
    public void cancel(long j) {
        IRunTaskThread iRunTaskThread = this.mObserver;
        if (iRunTaskThread != null) {
            iRunTaskThread.cancel(j);
        }
    }

    @Override // com.autonavi.gbl.util.observer.impl.IRunTaskThreadImpl
    public void cancel(ArrayList<Long> arrayList) {
        IRunTaskThread iRunTaskThread = this.mObserver;
        if (iRunTaskThread != null) {
            iRunTaskThread.cancel(arrayList);
        }
    }

    @Override // com.autonavi.gbl.util.observer.impl.IRunTaskThreadImpl
    public void clear() {
        IRunTaskThread iRunTaskThread = this.mObserver;
        if (iRunTaskThread != null) {
            iRunTaskThread.clear();
        }
    }
}
