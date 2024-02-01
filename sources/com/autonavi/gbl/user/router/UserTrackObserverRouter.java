package com.autonavi.gbl.user.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
import com.autonavi.gbl.user.usertrack.model.FootprintDeleteRecordResult;
import com.autonavi.gbl.user.usertrack.model.FootprintNaviRecordResult;
import com.autonavi.gbl.user.usertrack.model.FootprintSummaryResult;
import com.autonavi.gbl.user.usertrack.model.FootprintSwitchResult;
import com.autonavi.gbl.user.usertrack.model.GpsTrackDepthInfo;
import com.autonavi.gbl.user.usertrack.observer.IUserTrackObserver;
import com.autonavi.gbl.user.usertrack.observer.impl.IUserTrackObserverImpl;
@IntfAuto(target = IUserTrackObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class UserTrackObserverRouter extends IUserTrackObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(UserTrackObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(UserTrackObserverRouter.class);
    private TypeHelper mHelper;
    private IUserTrackObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IUserTrackObserver iUserTrackObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IUserTrackObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iUserTrackObserver;
    }

    protected UserTrackObserverRouter(String str, IUserTrackObserver iUserTrackObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iUserTrackObserver);
    }

    protected UserTrackObserverRouter(String str, IUserTrackObserver iUserTrackObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iUserTrackObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.user.usertrack.observer.impl.IUserTrackObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.user.usertrack.observer.impl.IUserTrackObserverImpl
    public void onStartGpsTrack(int i, String str, String str2) {
        IUserTrackObserver iUserTrackObserver = this.mObserver;
        if (iUserTrackObserver != null) {
            iUserTrackObserver.onStartGpsTrack(i, str, str2);
        }
    }

    @Override // com.autonavi.gbl.user.usertrack.observer.impl.IUserTrackObserverImpl
    public void onCloseGpsTrack(int i, String str, String str2, GpsTrackDepthInfo gpsTrackDepthInfo) {
        IUserTrackObserver iUserTrackObserver = this.mObserver;
        if (iUserTrackObserver != null) {
            iUserTrackObserver.onCloseGpsTrack(i, str, str2, gpsTrackDepthInfo);
        }
    }

    @Override // com.autonavi.gbl.user.usertrack.observer.impl.IUserTrackObserverImpl
    public void onGpsTrackDepInfo(int i, String str, String str2, GpsTrackDepthInfo gpsTrackDepthInfo) {
        IUserTrackObserver iUserTrackObserver = this.mObserver;
        if (iUserTrackObserver != null) {
            iUserTrackObserver.onGpsTrackDepInfo(i, str, str2, gpsTrackDepthInfo);
        }
    }

    @Override // com.autonavi.gbl.user.usertrack.observer.impl.IUserTrackObserverImpl
    public void notify(@SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2) {
        IUserTrackObserver iUserTrackObserver = this.mObserver;
        if (iUserTrackObserver != null) {
            iUserTrackObserver.notify(i, i2);
        }
    }

    @Override // com.autonavi.gbl.user.usertrack.observer.impl.IUserTrackObserverImpl
    public void onFootprintSwitch(FootprintSwitchResult footprintSwitchResult) {
        IUserTrackObserver iUserTrackObserver = this.mObserver;
        if (iUserTrackObserver != null) {
            iUserTrackObserver.onFootprintSwitch(footprintSwitchResult);
        }
    }

    @Override // com.autonavi.gbl.user.usertrack.observer.impl.IUserTrackObserverImpl
    public void onFootprintSummary(FootprintSummaryResult footprintSummaryResult) {
        IUserTrackObserver iUserTrackObserver = this.mObserver;
        if (iUserTrackObserver != null) {
            iUserTrackObserver.onFootprintSummary(footprintSummaryResult);
        }
    }

    @Override // com.autonavi.gbl.user.usertrack.observer.impl.IUserTrackObserverImpl
    public void onFootprintNaviRecordList(FootprintNaviRecordResult footprintNaviRecordResult) {
        IUserTrackObserver iUserTrackObserver = this.mObserver;
        if (iUserTrackObserver != null) {
            iUserTrackObserver.onFootprintNaviRecordList(footprintNaviRecordResult);
        }
    }

    @Override // com.autonavi.gbl.user.usertrack.observer.impl.IUserTrackObserverImpl
    public void onFootprintDeleteRecord(FootprintDeleteRecordResult footprintDeleteRecordResult) {
        IUserTrackObserver iUserTrackObserver = this.mObserver;
        if (iUserTrackObserver != null) {
            iUserTrackObserver.onFootprintDeleteRecord(footprintDeleteRecordResult);
        }
    }
}
