package com.autonavi.gbl.map.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.map.impl.IDayStatusSystemUtilImpl;
import com.autonavi.gbl.map.observer.IDayStatusSystemUtil;
import com.autonavi.gbl.util.model.DateTime;
@IntfAuto(target = IDayStatusSystemUtil.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class DayStatusSystemUtilRouter extends IDayStatusSystemUtilImpl {
    private static BindTable BIND_TABLE = new BindTable(DayStatusSystemUtilRouter.class);
    private static String PACKAGE = ReflexTool.PN(DayStatusSystemUtilRouter.class);
    private TypeHelper mHelper;
    private IDayStatusSystemUtil mObserver;
    private String mTargetId;

    private void $constructor(String str, IDayStatusSystemUtil iDayStatusSystemUtil) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IDayStatusSystemUtilImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iDayStatusSystemUtil;
    }

    protected DayStatusSystemUtilRouter(String str, IDayStatusSystemUtil iDayStatusSystemUtil, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDayStatusSystemUtil);
    }

    protected DayStatusSystemUtilRouter(String str, IDayStatusSystemUtil iDayStatusSystemUtil) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iDayStatusSystemUtil);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.DayStatusSystemUtilRouter.1
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
    @Override // com.autonavi.gbl.map.impl.IDayStatusSystemUtilImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.router.DayStatusSystemUtilRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.map.impl.IDayStatusSystemUtilImpl
    public Coord2DDouble getLonLat() {
        IDayStatusSystemUtil iDayStatusSystemUtil = this.mObserver;
        if (iDayStatusSystemUtil != null) {
            return iDayStatusSystemUtil.getLonLat();
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.impl.IDayStatusSystemUtilImpl
    public boolean getDateTime(DateTime dateTime) {
        IDayStatusSystemUtil iDayStatusSystemUtil = this.mObserver;
        if (iDayStatusSystemUtil != null) {
            return iDayStatusSystemUtil.getDateTime(dateTime);
        }
        return false;
    }
}
