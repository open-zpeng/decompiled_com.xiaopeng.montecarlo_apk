package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.MapResourceParam;
import com.autonavi.gbl.map.model.ReportCode;
import com.autonavi.gbl.map.model.ReportType;
import com.autonavi.gbl.map.observer.IBLMapEngineProxy;
import com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl;
@IntfAuto(target = IBLMapEngineProxy.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class BLMapEngineProxyRouter extends IBLMapEngineProxyImpl {
    private static BindTable BIND_TABLE = new BindTable(BLMapEngineProxyRouter.class);
    private static String PACKAGE = ReflexTool.PN(BLMapEngineProxyRouter.class);
    private TypeHelper mHelper;
    private IBLMapEngineProxy mObserver;
    private String mTargetId;

    private void $constructor(String str, IBLMapEngineProxy iBLMapEngineProxy) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IBLMapEngineProxyImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iBLMapEngineProxy;
    }

    protected BLMapEngineProxyRouter(String str, IBLMapEngineProxy iBLMapEngineProxy, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLMapEngineProxy);
    }

    protected BLMapEngineProxyRouter(String str, IBLMapEngineProxy iBLMapEngineProxy) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLMapEngineProxy);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.BLMapEngineProxyRouter.1
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
    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.BLMapEngineProxyRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public byte[] requireMapResource(long j, MapResourceParam mapResourceParam) {
        IBLMapEngineProxy iBLMapEngineProxy = this.mObserver;
        if (iBLMapEngineProxy != null) {
            return iBLMapEngineProxy.requireMapResource(j, mapResourceParam);
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public void onMapLogReporter(long j, @ReportType.ReportType1 int i, @ReportCode.ReportCode1 int i2, String str) {
        IBLMapEngineProxy iBLMapEngineProxy = this.mObserver;
        if (iBLMapEngineProxy != null) {
            iBLMapEngineProxy.onMapLogReporter(j, i, i2, str);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public void onSendBehaviorLog(long j, String str, String str2, String str3) {
        IBLMapEngineProxy iBLMapEngineProxy = this.mObserver;
        if (iBLMapEngineProxy != null) {
            iBLMapEngineProxy.onSendBehaviorLog(j, str, str2, str3);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public void requireMapRender(long j, int i, int i2) {
        IBLMapEngineProxy iBLMapEngineProxy = this.mObserver;
        if (iBLMapEngineProxy != null) {
            iBLMapEngineProxy.requireMapRender(j, i, i2);
        }
    }
}
