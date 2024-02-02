package com.xiaopeng.montecarlo.speech.command.navi;

import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.navcore.speech.utils.NaviSpeechUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.montecarlo.speech.manager.MergeException;
import java.util.ArrayList;
@CommandPriority(priority = 21)
/* loaded from: classes3.dex */
public class RouteOrAddViaCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("RouteOrAddViaCommand");
    private boolean mIsExecuteFinish;
    private XPPoiInfo mPoi;
    private RouteManager.IRouteResultListener mRouteListener;
    private int mRouteSelectRef;
    private RouteType mRouteType;
    private int mStartType;

    /* loaded from: classes3.dex */
    public enum RouteType {
        ROUTE,
        ADD_VIA
    }

    public XPPoiInfo getPoi() {
        return this.mPoi;
    }

    public RouteType getRouteType() {
        return this.mRouteType;
    }

    public int getStartType() {
        return this.mStartType;
    }

    public int getRouteSelectRef() {
        return this.mRouteSelectRef;
    }

    public RouteOrAddViaCommand(XPPoiInfo xPPoiInfo, RouteType routeType) {
        this(xPPoiInfo, routeType, 0, 0);
    }

    public RouteOrAddViaCommand(XPPoiInfo xPPoiInfo, RouteType routeType, int i, int i2) {
        this.mStartType = 0;
        this.mRouteSelectRef = 0;
        this.mIsExecuteFinish = false;
        this.mRouteListener = new RouteManager.IRouteResultListener() { // from class: com.xiaopeng.montecarlo.speech.command.navi.RouteOrAddViaCommand.1
            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteSuccess(long j, RouteResult routeResult) {
                RouteOrAddViaCommand.this.mIsExecuteFinish = true;
            }

            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteError(long j, RouteResult routeResult) {
                RouteOrAddViaCommand.this.onInterrupt();
            }
        };
        this.mPoi = xPPoiInfo;
        this.mRouteType = routeType;
        this.mStartType = i;
        this.mRouteSelectRef = i2;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        TBTManager.getInstance().addRouteListener(this.mRouteListener);
        if (RouteType.ADD_VIA == this.mRouteType && NaviSpeechUtils.isExistRoute()) {
            postToAddVia();
        } else {
            postToStartRoute();
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

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        return this.mIsExecuteFinish;
    }

    private void postToStartRoute() {
        L.Tag tag = TAG;
        L.i(tag, "startRoute, postToStartRoute: " + this.mPoi);
        XPPoiInfo.generatePoiIdIfEmpty(this.mPoi, 5);
        if (this.mPoi != null) {
            SpeechNaviEvent speechNaviEvent = new SpeechNaviEvent(312);
            speechNaviEvent.setDest(this.mPoi);
            speechNaviEvent.setStartType(this.mStartType);
            speechNaviEvent.setRouteSelectRef(this.mRouteSelectRef);
            L.Tag tag2 = TAG;
            L.i(tag2, "postToStartRoute startType:" + speechNaviEvent.getStartType() + ",routeSelectRef:" + speechNaviEvent.getRouteSelectRef());
            executeSpeechEvent(speechNaviEvent);
        }
    }

    private void postToAddVia() {
        L.Tag tag = TAG;
        L.i(tag, "postToAddVia, mPoi: " + this.mPoi);
        SpeechNaviEvent speechNaviEvent = new SpeechNaviEvent(313);
        speechNaviEvent.setDest(this.mPoi);
        executeSpeechEvent(speechNaviEvent);
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        if (t instanceof RouteOrAddViaCommand) {
            if (getRouteType() != ((RouteOrAddViaCommand) t).getRouteType()) {
                return true;
            }
            throw new MergeException();
        } else if ((t instanceof RouteWithViasCommand) || (t instanceof RouteParamCommand)) {
            return true;
        } else {
            return super.canMergeCommand(t);
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T, S extends BaseSpeechCommand> S mergeCommand(T t) {
        if (t instanceof RouteOrAddViaCommand) {
            if (getRouteType() == RouteType.ROUTE) {
                RouteOrAddViaCommand routeOrAddViaCommand = (RouteOrAddViaCommand) t;
                if (routeOrAddViaCommand.getRouteType() == RouteType.ADD_VIA) {
                    return (S) buildCommand(getPoi(), routeOrAddViaCommand.getPoi());
                }
                if (routeOrAddViaCommand.getRouteType() == RouteType.ROUTE) {
                    throw new MergeException();
                }
            } else if (getRouteType() == RouteType.ADD_VIA) {
                RouteOrAddViaCommand routeOrAddViaCommand2 = (RouteOrAddViaCommand) t;
                if (routeOrAddViaCommand2.getRouteType() == RouteType.ROUTE) {
                    return (S) buildCommand(routeOrAddViaCommand2.getPoi(), getPoi());
                }
                if (routeOrAddViaCommand2.getRouteType() == RouteType.ADD_VIA) {
                    throw new MergeException();
                }
            }
        }
        if (t instanceof RouteParamCommand) {
            return new RouteWithViasCommand(getPoi(), null, ((RouteParamCommand) t).getStrategy());
        }
        if (t instanceof RouteWithViasCommand) {
            return (S) ((RouteWithViasCommand) t).mergeCommand(this);
        }
        return (S) super.mergeCommand(t);
    }

    private <S extends BaseSpeechCommand> S buildCommand(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new XPViaPoint(xPPoiInfo2));
        return new RouteWithViasCommand(xPPoiInfo, arrayList);
    }
}
