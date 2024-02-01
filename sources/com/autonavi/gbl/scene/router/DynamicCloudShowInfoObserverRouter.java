package com.autonavi.gbl.scene.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GReStrictedAreaDataRuleRes;
import com.autonavi.gbl.common.model.DynamicTips;
import com.autonavi.gbl.common.model.RestrictRuleResult;
import com.autonavi.gbl.scene.observer.IDynamicCloudShowInfoObserver;
import com.autonavi.gbl.scene.observer.impl.IDynamicCloudShowInfoObserverImpl;
@IntfAuto(target = IDynamicCloudShowInfoObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class DynamicCloudShowInfoObserverRouter extends IDynamicCloudShowInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(DynamicCloudShowInfoObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(DynamicCloudShowInfoObserverRouter.class);
    private TypeHelper mHelper;
    private IDynamicCloudShowInfoObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IDynamicCloudShowInfoObserver iDynamicCloudShowInfoObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IDynamicCloudShowInfoObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iDynamicCloudShowInfoObserver;
    }

    protected DynamicCloudShowInfoObserverRouter(String str, IDynamicCloudShowInfoObserver iDynamicCloudShowInfoObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDynamicCloudShowInfoObserver);
    }

    protected DynamicCloudShowInfoObserverRouter(String str, IDynamicCloudShowInfoObserver iDynamicCloudShowInfoObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDynamicCloudShowInfoObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.observer.impl.IDynamicCloudShowInfoObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.scene.observer.impl.IDynamicCloudShowInfoObserverImpl
    public void onRestrictedDataResult(RestrictRuleResult restrictRuleResult, GReStrictedAreaDataRuleRes gReStrictedAreaDataRuleRes) {
        IDynamicCloudShowInfoObserver iDynamicCloudShowInfoObserver = this.mObserver;
        if (iDynamicCloudShowInfoObserver != null) {
            iDynamicCloudShowInfoObserver.onRestrictedDataResult(restrictRuleResult, gReStrictedAreaDataRuleRes);
        }
    }

    @Override // com.autonavi.gbl.scene.observer.impl.IDynamicCloudShowInfoObserverImpl
    public void onDynamicalTipsNotify(DynamicTips dynamicTips) {
        IDynamicCloudShowInfoObserver iDynamicCloudShowInfoObserver = this.mObserver;
        if (iDynamicCloudShowInfoObserver != null) {
            iDynamicCloudShowInfoObserver.onDynamicalTipsNotify(dynamicTips);
        }
    }
}
