package com.autonavi.gbl.user.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.user.usertrack.model.GpsTrackPoint;
import com.autonavi.gbl.user.usertrack.observer.IGpsInfoGetter;
import com.autonavi.gbl.user.usertrack.observer.impl.IGpsInfoGetterImpl;
@IntfAuto(target = IGpsInfoGetter.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class GpsInfoGetterRouter extends IGpsInfoGetterImpl {
    private static BindTable BIND_TABLE = new BindTable(GpsInfoGetterRouter.class);
    private static String PACKAGE = ReflexTool.PN(GpsInfoGetterRouter.class);
    private TypeHelper mHelper;
    private IGpsInfoGetter mObserver;
    private String mTargetId;

    private void $constructor(String str, IGpsInfoGetter iGpsInfoGetter) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGpsInfoGetterImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGpsInfoGetter;
    }

    protected GpsInfoGetterRouter(String str, IGpsInfoGetter iGpsInfoGetter, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGpsInfoGetter);
    }

    protected GpsInfoGetterRouter(String str, IGpsInfoGetter iGpsInfoGetter) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGpsInfoGetter);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.user.usertrack.observer.impl.IGpsInfoGetterImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.user.usertrack.observer.impl.IGpsInfoGetterImpl
    public GpsTrackPoint getGpsTrackPoint() {
        IGpsInfoGetter iGpsInfoGetter = this.mObserver;
        if (iGpsInfoGetter != null) {
            return iGpsInfoGetter.getGpsTrackPoint();
        }
        return null;
    }
}
