package com.autonavi.gbl.lane.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.LaneResourceRequest;
import com.autonavi.gbl.lane.model.LaneResourceRequestFile;
import com.autonavi.gbl.lane.model.LaneResourceResponse;
import com.autonavi.gbl.lane.observer.ILaneResourceProxy;
import com.autonavi.gbl.lane.observer.impl.ILaneResourceProxyImpl;
@IntfAuto(target = ILaneResourceProxy.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LaneResourceProxyRouter extends ILaneResourceProxyImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneResourceProxyRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneResourceProxyRouter.class);
    private TypeHelper mHelper;
    private ILaneResourceProxy mObserver;
    private String mTargetId;

    private void $constructor(String str, ILaneResourceProxy iLaneResourceProxy) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILaneResourceProxyImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLaneResourceProxy;
    }

    protected LaneResourceProxyRouter(String str, ILaneResourceProxy iLaneResourceProxy, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneResourceProxy);
    }

    protected LaneResourceProxyRouter(String str, ILaneResourceProxy iLaneResourceProxy) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneResourceProxy);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.router.LaneResourceProxyRouter.1
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
    @Override // com.autonavi.gbl.lane.observer.impl.ILaneResourceProxyImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.router.LaneResourceProxyRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneResourceProxyImpl
    public LaneResourceResponse onRequestResource(LaneResourceRequest laneResourceRequest) {
        ILaneResourceProxy iLaneResourceProxy = this.mObserver;
        if (iLaneResourceProxy != null) {
            return iLaneResourceProxy.onRequestResource(laneResourceRequest);
        }
        return null;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneResourceProxyImpl
    public LaneResourceResponse onRequestResourceFile(LaneResourceRequestFile laneResourceRequestFile) {
        ILaneResourceProxy iLaneResourceProxy = this.mObserver;
        if (iLaneResourceProxy != null) {
            return iLaneResourceProxy.onRequestResourceFile(laneResourceRequestFile);
        }
        return null;
    }
}
