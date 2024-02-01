package com.autonavi.gbl.util.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.observer.ITimeSource;
import com.autonavi.gbl.util.observer.impl.TimeSourceImpl;
@IntfAuto(target = ITimeSource.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class TimeSourceRouter extends TimeSourceImpl {
    private static BindTable BIND_TABLE = new BindTable(TimeSourceRouter.class);
    private static String PACKAGE = ReflexTool.PN(TimeSourceRouter.class);
    private TypeHelper mHelper;
    private ITimeSource mObserver;
    private String mTargetId;

    private void $constructor(String str, ITimeSource iTimeSource) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(TimeSourceImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iTimeSource;
    }

    protected TimeSourceRouter(String str, ITimeSource iTimeSource, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iTimeSource);
    }

    protected TimeSourceRouter(String str, ITimeSource iTimeSource) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iTimeSource);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.util.observer.impl.TimeSourceImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.util.observer.impl.TimeSourceImpl
    public long getTickCountUS() {
        ITimeSource iTimeSource = this.mObserver;
        if (iTimeSource != null) {
            return iTimeSource.getTickCountUS();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.util.observer.impl.TimeSourceImpl
    public long getLocalTimeUS() {
        ITimeSource iTimeSource = this.mObserver;
        if (iTimeSource != null) {
            return iTimeSource.getLocalTimeUS();
        }
        return 0L;
    }
}
