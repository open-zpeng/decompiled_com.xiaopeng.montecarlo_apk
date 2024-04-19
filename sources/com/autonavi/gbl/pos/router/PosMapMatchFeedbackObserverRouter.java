package com.autonavi.gbl.pos.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.pos.model.LocMMFeedbackInfo;
import com.autonavi.gbl.pos.observer.IPosMapMatchFeedbackObserver;
import com.autonavi.gbl.pos.observer.impl.IPosMapMatchFeedbackObserverImpl;
@IntfAuto(target = IPosMapMatchFeedbackObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PosMapMatchFeedbackObserverRouter extends IPosMapMatchFeedbackObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(PosMapMatchFeedbackObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(PosMapMatchFeedbackObserverRouter.class);
    private TypeHelper mHelper;
    private IPosMapMatchFeedbackObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IPosMapMatchFeedbackObserver iPosMapMatchFeedbackObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPosMapMatchFeedbackObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPosMapMatchFeedbackObserver;
    }

    protected PosMapMatchFeedbackObserverRouter(String str, IPosMapMatchFeedbackObserver iPosMapMatchFeedbackObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosMapMatchFeedbackObserver);
    }

    protected PosMapMatchFeedbackObserverRouter(String str, IPosMapMatchFeedbackObserver iPosMapMatchFeedbackObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPosMapMatchFeedbackObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.router.PosMapMatchFeedbackObserverRouter.1
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
    @Override // com.autonavi.gbl.pos.observer.impl.IPosMapMatchFeedbackObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.pos.router.PosMapMatchFeedbackObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.pos.observer.impl.IPosMapMatchFeedbackObserverImpl
    public void onMapMatchFeedbackUpdate(LocMMFeedbackInfo locMMFeedbackInfo) {
        IPosMapMatchFeedbackObserver iPosMapMatchFeedbackObserver = this.mObserver;
        if (iPosMapMatchFeedbackObserver != null) {
            iPosMapMatchFeedbackObserver.onMapMatchFeedbackUpdate(locMMFeedbackInfo);
        }
    }
}
