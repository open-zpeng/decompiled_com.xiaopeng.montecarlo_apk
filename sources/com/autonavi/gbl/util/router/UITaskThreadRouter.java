package com.autonavi.gbl.util.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.observer.IUITaskThread;
import com.autonavi.gbl.util.observer.UITask;
import com.autonavi.gbl.util.observer.impl.IUITaskThreadImpl;
import com.autonavi.gbl.util.observer.impl.UITaskImpl;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = IUITaskThread.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class UITaskThreadRouter extends IUITaskThreadImpl {
    private static BindTable BIND_TABLE = new BindTable(UITaskThreadRouter.class);
    private static String PACKAGE = ReflexTool.PN(UITaskThreadRouter.class);
    private TypeHelper mHelper;
    private IUITaskThread mObserver;
    private String mTargetId;

    private void $constructor(String str, IUITaskThread iUITaskThread) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IUITaskThreadImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iUITaskThread;
    }

    protected UITaskThreadRouter(String str, IUITaskThread iUITaskThread, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iUITaskThread);
    }

    protected UITaskThreadRouter(String str, IUITaskThread iUITaskThread) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iUITaskThread);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.router.UITaskThreadRouter.1
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
    @Override // com.autonavi.gbl.util.observer.impl.IUITaskThreadImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.router.UITaskThreadRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.util.observer.impl.IUITaskThreadImpl
    public void post(UITaskImpl uITaskImpl, long j, BigInteger bigInteger) {
        try {
            Method method = UITaskThreadRouter.class.getMethod("post", UITaskImpl.class, Long.TYPE, BigInteger.class);
            if (uITaskImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (UITask) typeHelper.transfer(method, 0, uITaskImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $task == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.router.UITaskThreadRouter.3
                    }));
                }
            }
            IUITaskThread iUITaskThread = this.mObserver;
            if (iUITaskThread != null) {
                iUITaskThread.post(r1, j, bigInteger);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.util.observer.impl.IUITaskThreadImpl
    public void cancel(long j) {
        IUITaskThread iUITaskThread = this.mObserver;
        if (iUITaskThread != null) {
            iUITaskThread.cancel(j);
        }
    }

    @Override // com.autonavi.gbl.util.observer.impl.IUITaskThreadImpl
    public void cancel(ArrayList<Long> arrayList) {
        IUITaskThread iUITaskThread = this.mObserver;
        if (iUITaskThread != null) {
            iUITaskThread.cancel(arrayList);
        }
    }

    @Override // com.autonavi.gbl.util.observer.impl.IUITaskThreadImpl
    public void clear() {
        IUITaskThread iUITaskThread = this.mObserver;
        if (iUITaskThread != null) {
            iUITaskThread.clear();
        }
    }
}
