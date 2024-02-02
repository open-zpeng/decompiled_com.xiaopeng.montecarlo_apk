package com.xiaopeng.montecarlo.speech.command.navi;

import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.montecarlo.speech.command.navi.RouteOrAddViaCommand;
import com.xiaopeng.montecarlo.speech.manager.MergeException;
import com.xiaopeng.montecarlo.speech.utils.SpeechSettingUtil;
import java.util.ArrayList;
@CommandPriority(priority = 21)
/* loaded from: classes3.dex */
public class RouteWithViasCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("RouteWithViasCommand");
    private XPPoiInfo mDest;
    private boolean mIsDebugRoute;
    private boolean mIsExecuteFinish;
    private XPPoiInfo mOrig;
    private RouteManager.IRouteResultListener mRouteListener;
    private int mRouteSelectRef;
    private SpeechSettingUtil.RouteStrategy mSettingParam;
    private int mStartType;
    private ArrayList<XPViaPoint> mViaList;

    public void setDebugRoute(boolean z) {
        this.mIsDebugRoute = z;
    }

    public int getMStartType() {
        return this.mStartType;
    }

    public int getMRouteSelectRef() {
        return this.mRouteSelectRef;
    }

    public RouteWithViasCommand(XPPoiInfo xPPoiInfo) {
        this(xPPoiInfo, null);
    }

    public RouteWithViasCommand(XPPoiInfo xPPoiInfo, ArrayList<XPViaPoint> arrayList) {
        this(xPPoiInfo, arrayList, SpeechSettingUtil.RouteStrategy.ROUTE_PREF_DEFAULT);
    }

    public RouteWithViasCommand(XPPoiInfo xPPoiInfo, ArrayList<XPViaPoint> arrayList, SpeechSettingUtil.RouteStrategy routeStrategy) {
        this(xPPoiInfo, arrayList, routeStrategy, 0, 0);
    }

    public RouteWithViasCommand(XPPoiInfo xPPoiInfo, ArrayList<XPViaPoint> arrayList, SpeechSettingUtil.RouteStrategy routeStrategy, int i, int i2) {
        this.mOrig = null;
        this.mSettingParam = SpeechSettingUtil.RouteStrategy.ROUTE_PREF_DEFAULT;
        this.mIsDebugRoute = false;
        this.mIsExecuteFinish = false;
        this.mStartType = 0;
        this.mRouteSelectRef = 0;
        this.mRouteListener = new RouteManager.IRouteResultListener() { // from class: com.xiaopeng.montecarlo.speech.command.navi.RouteWithViasCommand.1
            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteSuccess(long j, RouteResult routeResult) {
                RouteWithViasCommand.this.mIsExecuteFinish = true;
            }

            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteError(long j, RouteResult routeResult) {
                RouteWithViasCommand.this.onInterrupt();
            }
        };
        this.mViaList = arrayList;
        this.mDest = xPPoiInfo;
        this.mSettingParam = routeStrategy;
        this.mStartType = i;
        this.mRouteSelectRef = i2;
    }

    public RouteWithViasCommand(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2, ArrayList<XPViaPoint> arrayList, SpeechSettingUtil.RouteStrategy routeStrategy, int i) {
        this(xPPoiInfo2, arrayList, routeStrategy, 0, 0);
        this.mStartType = i;
        this.mOrig = xPPoiInfo;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        TBTManager.getInstance().addRouteListener(this.mRouteListener);
        if (this.mDest != null) {
            SpeechNaviEvent speechNaviEvent = new SpeechNaviEvent(312);
            speechNaviEvent.setDest(this.mDest);
            speechNaviEvent.setViaList(this.mViaList);
            speechNaviEvent.setDebugRoute(this.mIsDebugRoute);
            speechNaviEvent.setStartType(this.mStartType);
            speechNaviEvent.setRouteSelectRef(this.mRouteSelectRef);
            XPPoiInfo xPPoiInfo = this.mOrig;
            if (xPPoiInfo != null) {
                speechNaviEvent.setOrig(xPPoiInfo);
            }
            if (this.mSettingParam != SpeechSettingUtil.RouteStrategy.ROUTE_PREF_DEFAULT) {
                speechNaviEvent.setSettingParam(SpeechSettingUtil.modifySettingParam(this.mSettingParam));
            }
            executeSpeechEvent(speechNaviEvent);
        }
    }

    private int getEventType() {
        int i = this.mStartType;
        if (i == 1) {
            return 45;
        }
        return i == 2 ? 46 : 23;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onSuccess() {
        TBTManager.getInstance().removeRouteListener(this.mRouteListener);
        SpeechStatProxy.getInstance().sendStatDataForSpeech(getEventType(), 2);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
        TBTManager.getInstance().removeRouteListener(this.mRouteListener);
        SpeechStatProxy.getInstance().sendStatDataForSpeech(getEventType(), 3);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        if (t instanceof RouteOrAddViaCommand) {
            RouteOrAddViaCommand routeOrAddViaCommand = (RouteOrAddViaCommand) t;
            if (routeOrAddViaCommand.getRouteType() == RouteOrAddViaCommand.RouteType.ROUTE) {
                throw new MergeException();
            }
            if (routeOrAddViaCommand.getRouteType() == RouteOrAddViaCommand.RouteType.ADD_VIA) {
                return true;
            }
        }
        if (t instanceof RouteWithViasCommand) {
            throw new MergeException();
        }
        return super.canMergeCommand(t);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T, S extends BaseSpeechCommand> S mergeCommand(T t) {
        if (t instanceof RouteOrAddViaCommand) {
            RouteOrAddViaCommand routeOrAddViaCommand = (RouteOrAddViaCommand) t;
            if (routeOrAddViaCommand.getRouteType() == RouteOrAddViaCommand.RouteType.ADD_VIA) {
                XPViaPoint xPViaPoint = new XPViaPoint(routeOrAddViaCommand.getPoi());
                ArrayList<XPViaPoint> arrayList = this.mViaList;
                if (arrayList != null) {
                    if (arrayList.size() < 3) {
                        this.mViaList.add(xPViaPoint);
                    } else {
                        L.w(TAG, "mViaList over size");
                    }
                } else {
                    L.w(TAG, "mViaList is null");
                }
            } else if (routeOrAddViaCommand.getRouteType() == RouteOrAddViaCommand.RouteType.ROUTE) {
                throw new MergeException();
            }
        }
        if (t instanceof RouteParamCommand) {
            this.mSettingParam = SpeechSettingUtil.mergeStrategy(this.mSettingParam, ((RouteParamCommand) t).getStrategy());
        }
        if (t instanceof RouteWithViasCommand) {
            throw new MergeException();
        }
        return (S) super.mergeCommand(t);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecuteFinish;
    }
}
