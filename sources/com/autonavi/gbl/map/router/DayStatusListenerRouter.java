package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.IDayStatusListenerImpl;
import com.autonavi.gbl.map.model.DAY_STATUS;
import com.autonavi.gbl.map.observer.IDayStatusListener;
@IntfAuto(target = IDayStatusListener.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class DayStatusListenerRouter extends IDayStatusListenerImpl {
    private static BindTable BIND_TABLE = new BindTable(DayStatusListenerRouter.class);
    private static String PACKAGE = ReflexTool.PN(DayStatusListenerRouter.class);
    private TypeHelper mHelper;
    private IDayStatusListener mObserver;
    private String mTargetId;

    private void $constructor(String str, IDayStatusListener iDayStatusListener) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IDayStatusListenerImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iDayStatusListener;
    }

    protected DayStatusListenerRouter(String str, IDayStatusListener iDayStatusListener, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDayStatusListener);
    }

    protected DayStatusListenerRouter(String str, IDayStatusListener iDayStatusListener) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDayStatusListener);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.IDayStatusListenerImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.impl.IDayStatusListenerImpl
    public boolean onDayStatus(@DAY_STATUS.DAY_STATUS1 int i) {
        IDayStatusListener iDayStatusListener = this.mObserver;
        if (iDayStatusListener != null) {
            return iDayStatusListener.onDayStatus(i);
        }
        return false;
    }
}
