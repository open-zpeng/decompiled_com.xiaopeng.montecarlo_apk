package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.model.MapResourceParam;
import com.autonavi.gbl.map.model.ReportCode;
import com.autonavi.gbl.map.model.ReportType;
import com.autonavi.gbl.map.observer.IBLMapViewProxy;
import com.autonavi.gbl.map.observer.impl.IBLMapViewProxyImpl;
@IntfAuto(target = IBLMapViewProxy.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class BLMapViewProxyRouter extends IBLMapViewProxyImpl {
    private static BindTable BIND_TABLE = new BindTable(BLMapViewProxyRouter.class);
    private static String PACKAGE = ReflexTool.PN(BLMapViewProxyRouter.class);
    private TypeHelper mHelper;
    private IBLMapViewProxy mObserver;
    private String mTargetId;

    private void $constructor(String str, IBLMapViewProxy iBLMapViewProxy) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IBLMapViewProxyImpl.getCPtr((IBLMapViewProxyImpl) this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iBLMapViewProxy;
    }

    protected BLMapViewProxyRouter(String str, IBLMapViewProxy iBLMapViewProxy, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLMapViewProxy);
    }

    protected BLMapViewProxyRouter(String str, IBLMapViewProxy iBLMapViewProxy) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iBLMapViewProxy);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.observer.impl.IBLMapViewProxyImpl, com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapViewProxyImpl
    public void reloadMapResource(long j, byte[] bArr, int i) {
        IBLMapViewProxy iBLMapViewProxy = this.mObserver;
        if (iBLMapViewProxy != null) {
            iBLMapViewProxy.reloadMapResource(j, bArr, i);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapViewProxyImpl, com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public void requireMapRender(long j, int i, int i2) {
        IBLMapViewProxy iBLMapViewProxy = this.mObserver;
        if (iBLMapViewProxy != null) {
            iBLMapViewProxy.requireMapRender(j, i, i2);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public byte[] requireMapResource(long j, MapResourceParam mapResourceParam) {
        IBLMapViewProxy iBLMapViewProxy = this.mObserver;
        if (iBLMapViewProxy != null) {
            return iBLMapViewProxy.requireMapResource(j, mapResourceParam);
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public void onMapLogReporter(long j, @ReportType.ReportType1 int i, @ReportCode.ReportCode1 int i2, String str) {
        IBLMapViewProxy iBLMapViewProxy = this.mObserver;
        if (iBLMapViewProxy != null) {
            iBLMapViewProxy.onMapLogReporter(j, i, i2, str);
        }
    }

    @Override // com.autonavi.gbl.map.observer.impl.IBLMapEngineProxyImpl
    public void onSendBehaviorLog(long j, String str, String str2, String str3) {
        IBLMapViewProxy iBLMapViewProxy = this.mObserver;
        if (iBLMapViewProxy != null) {
            iBLMapViewProxy.onSendBehaviorLog(j, str, str2, str3);
        }
    }
}
