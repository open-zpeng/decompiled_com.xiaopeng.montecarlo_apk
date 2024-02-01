package com.autonavi.gbl.lane.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.observer.ILaneDigitalTrackObserver;
import com.autonavi.gbl.lane.observer.impl.ILaneDigitalTrackObserverImpl;
import com.autonavi.gbl.util.model.BinaryStream;
@IntfAuto(target = ILaneDigitalTrackObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LaneDigitalTrackObserverRouter extends ILaneDigitalTrackObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneDigitalTrackObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneDigitalTrackObserverRouter.class);
    private TypeHelper mHelper;
    private ILaneDigitalTrackObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILaneDigitalTrackObserver iLaneDigitalTrackObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILaneDigitalTrackObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLaneDigitalTrackObserver;
    }

    protected LaneDigitalTrackObserverRouter(String str, ILaneDigitalTrackObserver iLaneDigitalTrackObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneDigitalTrackObserver);
    }

    protected LaneDigitalTrackObserverRouter(String str, ILaneDigitalTrackObserver iLaneDigitalTrackObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneDigitalTrackObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.lane.observer.impl.ILaneDigitalTrackObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneDigitalTrackObserverImpl
    public void onUpdateDigitalTrack(BinaryStream binaryStream) {
        ILaneDigitalTrackObserver iLaneDigitalTrackObserver = this.mObserver;
        if (iLaneDigitalTrackObserver != null) {
            iLaneDigitalTrackObserver.onUpdateDigitalTrack(binaryStream);
        }
    }
}
