package com.autonavi.gbl.lane.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.model.LanePlayerMessage;
import com.autonavi.gbl.lane.observer.ILanePlayerAdapter;
import com.autonavi.gbl.lane.observer.impl.ILanePlayerAdapterImpl;
@IntfAuto(target = ILanePlayerAdapter.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LanePlayerAdapterRouter extends ILanePlayerAdapterImpl {
    private static BindTable BIND_TABLE = new BindTable(LanePlayerAdapterRouter.class);
    private static String PACKAGE = ReflexTool.PN(LanePlayerAdapterRouter.class);
    private TypeHelper mHelper;
    private ILanePlayerAdapter mObserver;
    private String mTargetId;

    private void $constructor(String str, ILanePlayerAdapter iLanePlayerAdapter) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILanePlayerAdapterImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLanePlayerAdapter;
    }

    protected LanePlayerAdapterRouter(String str, ILanePlayerAdapter iLanePlayerAdapter, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLanePlayerAdapter);
    }

    protected LanePlayerAdapterRouter(String str, ILanePlayerAdapter iLanePlayerAdapter) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLanePlayerAdapter);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.lane.observer.impl.ILanePlayerAdapterImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILanePlayerAdapterImpl
    public boolean onLaneData(LanePlayerMessage lanePlayerMessage) {
        ILanePlayerAdapter iLanePlayerAdapter = this.mObserver;
        if (iLanePlayerAdapter != null) {
            return iLanePlayerAdapter.onLaneData(lanePlayerMessage);
        }
        return false;
    }
}
