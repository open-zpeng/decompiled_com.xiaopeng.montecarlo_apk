package com.autonavi.gbl.lane.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.lane.model.AutopilotData;
import com.autonavi.gbl.lane.model.CarHWInfo;
import com.autonavi.gbl.lane.model.CarStyleInfo;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.DecisionDirectionStyle;
import com.autonavi.gbl.lane.model.DecisionLineStyleInfo;
import com.autonavi.gbl.lane.model.ELKLineInfo;
import com.autonavi.gbl.lane.model.ELKLineStyle;
import com.autonavi.gbl.lane.model.LDWLineInfo;
import com.autonavi.gbl.lane.model.LDWLineStyle;
import com.autonavi.gbl.lane.model.LKALineInfo;
import com.autonavi.gbl.lane.model.LKALineStyle;
import com.autonavi.gbl.lane.model.LaneRenderScreen;
import com.autonavi.gbl.lane.model.LaneSRRangeFilterParam;
import com.autonavi.gbl.lane.model.LaneSideLineInfo;
import com.autonavi.gbl.lane.model.LaneSideLineStyle;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.autonavi.gbl.lane.observer.ILaneServicePlayerObserver;
import com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl;
import com.autonavi.gbl.pos.model.LocSignData;
import java.lang.reflect.Method;
@IntfAuto(target = ILaneServicePlayerObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class LaneServicePlayerObserverRouter extends ILaneServicePlayerObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneServicePlayerObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(LaneServicePlayerObserverRouter.class);
    private TypeHelper mHelper;
    private ILaneServicePlayerObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ILaneServicePlayerObserver iLaneServicePlayerObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ILaneServicePlayerObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iLaneServicePlayerObserver;
    }

    protected LaneServicePlayerObserverRouter(String str, ILaneServicePlayerObserver iLaneServicePlayerObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneServicePlayerObserver);
    }

    protected LaneServicePlayerObserverRouter(String str, ILaneServicePlayerObserver iLaneServicePlayerObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iLaneServicePlayerObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.router.LaneServicePlayerObserverRouter.1
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
    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.router.LaneServicePlayerObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onPlayProgress(long j, long j2, String str, long j3, long j4) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onPlayProgress(j, j2, str, j3, j4);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onLocSignData(LocSignData locSignData) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onLocSignData(locSignData);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onSRObject(@LaneRenderScreen.LaneRenderScreen1 int i, SRObjects sRObjects) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onSRObject(i, sRObjects);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onCarHW(@LaneRenderScreen.LaneRenderScreen1 int i, CarHWInfo carHWInfo) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onCarHW(i, carHWInfo);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onCarStyle(@LaneRenderScreen.LaneRenderScreen1 int i, CarStyleInfo carStyleInfo) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onCarStyle(i, carStyleInfo);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onDecisionLineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, DecisionLineStyleInfo decisionLineStyleInfo) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onDecisionLineStyle(i, decisionLineStyleInfo);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onDecisionDirectionStyle(@LaneRenderScreen.LaneRenderScreen1 int i, DecisionDirectionStyle decisionDirectionStyle) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onDecisionDirectionStyle(i, decisionDirectionStyle);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onDecision(@LaneRenderScreen.LaneRenderScreen1 int i, Decision decision) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onDecision(i, decision);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onWarn(@LaneRenderScreen.LaneRenderScreen1 int i, WarnInfos warnInfos) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onWarn(i, warnInfos);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onOpenDynamicViewAngle(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onOpenDynamicViewAngle(i, z);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onOpenLCC(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onOpenLCC(i, z);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onOpenLNDSDataDownload(boolean z) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onOpenLNDSDataDownload(z);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onLaneSideStyle(@LaneRenderScreen.LaneRenderScreen1 int i, LaneSideLineStyle laneSideLineStyle) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onLaneSideStyle(i, laneSideLineStyle);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onLaneSideLineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, LaneSideLineInfo laneSideLineInfo) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onLaneSideLineInfo(i, laneSideLineInfo);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onLKALineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, LKALineStyle lKALineStyle) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onLKALineStyle(i, lKALineStyle);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onLKALineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, LKALineInfo lKALineInfo) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onLKALineInfo(i, lKALineInfo);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onLDWLineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, LDWLineStyle lDWLineStyle) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onLDWLineStyle(i, lDWLineStyle);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onLDWLineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, LDWLineInfo lDWLineInfo) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onLDWLineInfo(i, lDWLineInfo);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onELKLineStyle(@LaneRenderScreen.LaneRenderScreen1 int i, ELKLineStyle eLKLineStyle) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onELKLineStyle(i, eLKLineStyle);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onELKLineInfo(@LaneRenderScreen.LaneRenderScreen1 int i, ELKLineInfo eLKLineInfo) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onELKLineInfo(i, eLKLineInfo);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onAutopilotData(AutopilotData autopilotData) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onAutopilotData(autopilotData);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onRequestRoute(IRouteOptionImpl iRouteOptionImpl) {
        try {
            Method method = LaneServicePlayerObserverRouter.class.getMethod("onRequestRoute", IRouteOptionImpl.class);
            if (iRouteOptionImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (RouteOption) typeHelper.transfer(method, 0, iRouteOptionImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $routeOption == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.router.LaneServicePlayerObserverRouter.3
                    }));
                }
            }
            ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
            if (iLaneServicePlayerObserver != null) {
                return iLaneServicePlayerObserver.onRequestRoute(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onShowNaviLine(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onShowNaviLine(i, z);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onShowNaviLineFishbone(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onShowNaviLineFishbone(i, z);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onShowNaviLineOutline(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onShowNaviLineOutline(i, z);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onLaneChangeFocusing(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onLaneChangeFocusing(i, z);
        }
        return false;
    }

    @Override // com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl
    public boolean onSRRangeFilterParam(@LaneRenderScreen.LaneRenderScreen1 int i, LaneSRRangeFilterParam laneSRRangeFilterParam) {
        ILaneServicePlayerObserver iLaneServicePlayerObserver = this.mObserver;
        if (iLaneServicePlayerObserver != null) {
            return iLaneServicePlayerObserver.onSRRangeFilterParam(i, laneSRRangeFilterParam);
        }
        return false;
    }
}
