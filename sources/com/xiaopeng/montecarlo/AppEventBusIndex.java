package com.xiaopeng.montecarlo;

import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.montecarlo.aimessage.BLMsgPushCommModel;
import com.xiaopeng.montecarlo.aimessage.LocalCommModel;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.navcore.event.AIRecommendParkEvent;
import com.xiaopeng.montecarlo.navcore.event.AiMessageBtnEvent;
import com.xiaopeng.montecarlo.navcore.event.AiMessageEvent;
import com.xiaopeng.montecarlo.navcore.event.BLMsgPushEvent;
import com.xiaopeng.montecarlo.navcore.event.BLMsgRoutePushEvent;
import com.xiaopeng.montecarlo.navcore.event.CarGreetingClearRenderRoutesEvent;
import com.xiaopeng.montecarlo.navcore.event.CarGreetingGetAroundTrafficInfoEvent;
import com.xiaopeng.montecarlo.navcore.event.CarGreetingMoveSearchBarEvent;
import com.xiaopeng.montecarlo.navcore.event.CarGreetingRenderRoutesEvent;
import com.xiaopeng.montecarlo.navcore.event.DRDebugEvent;
import com.xiaopeng.montecarlo.navcore.event.FavoriteSyncEvent;
import com.xiaopeng.montecarlo.navcore.event.GuideWrapperNaviEvent;
import com.xiaopeng.montecarlo.navcore.event.ParallelRoadEvent;
import com.xiaopeng.montecarlo.navcore.event.RouteAosEvent;
import com.xiaopeng.montecarlo.navcore.event.SRDebugEvent;
import com.xiaopeng.montecarlo.navcore.event.VoiceFusionExitEvent;
import com.xiaopeng.montecarlo.scenes.cruisescene.CruiseScenePresenter;
import com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviFragment;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper;
import com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchResultPresenter;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SimpleSubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import org.greenrobot.eventbus.meta.SubscriberMethodInfo;
/* loaded from: classes.dex */
public class AppEventBusIndex implements SubscriberInfoIndex {
    private static final Map<Class<?>, SubscriberInfo> SUBSCRIBER_INDEX = new HashMap();

    static {
        putIndex(new SimpleSubscriberInfo(NaviFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onIpcMessageEvent", IIpcService.IpcMessageEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("onIpcMessageEvent", IpcRouterUtil.IpcRouterEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("onParallelRoadEvent", ParallelRoadEvent.class, ThreadMode.MAIN)}));
        putIndex(new SimpleSubscriberInfo(NaviScenePresenter.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEvent", AIRecommendParkEvent.class, ThreadMode.BACKGROUND), new SubscriberMethodInfo("onNaviEvent", GuideWrapperNaviEvent.class, ThreadMode.BACKGROUND)}));
        putIndex(new SimpleSubscriberInfo(SearchFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEvent", FavoriteSyncEvent.class, ThreadMode.MAIN)}));
        putIndex(new SimpleSubscriberInfo(LocalCommModel.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEvent", AiMessageEvent.class, ThreadMode.BACKGROUND)}));
        putIndex(new SimpleSubscriberInfo(SearchResultPresenter.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onParallelRoadEvent", ParallelRoadEvent.class, ThreadMode.MAIN)}));
        putIndex(new SimpleSubscriberInfo(RestrictHelper.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onAosEvent", RouteAosEvent.class, ThreadMode.BACKGROUND)}));
        putIndex(new SimpleSubscriberInfo(BLMsgPushCommModel.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEvent", AiMessageBtnEvent.class, ThreadMode.BACKGROUND), new SubscriberMethodInfo("onBLMsgPushEvent", BLMsgPushEvent.class, ThreadMode.BACKGROUND), new SubscriberMethodInfo("onBLMsgRoutePushEvent", BLMsgRoutePushEvent.class, ThreadMode.BACKGROUND)}));
        putIndex(new SimpleSubscriberInfo(CruiseScenePresenter.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onNaviEvent", GuideWrapperNaviEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("onGetCarGreetingMoveSearchBarEventFromSticky", CarGreetingMoveSearchBarEvent.class, ThreadMode.MAIN, 0, true), new SubscriberMethodInfo("onCarGreetingGetAroundTrafficInfoEventFromSticky", CarGreetingGetAroundTrafficInfoEvent.class, ThreadMode.MAIN, 0, true), new SubscriberMethodInfo("onCarGreetingClearRenderRoutesEventFromSticky", CarGreetingClearRenderRoutesEvent.class, ThreadMode.MAIN, 0, true), new SubscriberMethodInfo("onCarGreetingRenderRoutesEventFromSticky", CarGreetingRenderRoutesEvent.class, ThreadMode.BACKGROUND, 0, true), new SubscriberMethodInfo("onVoiceFusionExit", VoiceFusionExitEvent.class, ThreadMode.MAIN)}));
        putIndex(new SimpleSubscriberInfo(MapScenePresenter.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onParallelRoadEvent", ParallelRoadEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("onDRDebugMessage", DRDebugEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("onSRDebugMessage", SRDebugEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("onNaviEvent", GuideWrapperNaviEvent.class, ThreadMode.MAIN)}));
        putIndex(new SimpleSubscriberInfo(RouteScenePresenter.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEvent", IIpcService.IpcMessageEvent.class, ThreadMode.BACKGROUND), new SubscriberMethodInfo("onEvent", IpcRouterUtil.IpcRouterEvent.class, ThreadMode.BACKGROUND)}));
        putIndex(new SimpleSubscriberInfo(BaseNaviPresenter.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onParallelRoadEvent", ParallelRoadEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("onAiMsgEvent", IpcRouterUtil.IpcRouterEvent.class, ThreadMode.BACKGROUND), new SubscriberMethodInfo("onAiMsgEvent", IIpcService.IpcMessageEvent.class, ThreadMode.BACKGROUND)}));
    }

    private static void putIndex(SubscriberInfo subscriberInfo) {
        SUBSCRIBER_INDEX.put(subscriberInfo.getSubscriberClass(), subscriberInfo);
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfoIndex
    public SubscriberInfo getSubscriberInfo(Class<?> cls) {
        SubscriberInfo subscriberInfo = SUBSCRIBER_INDEX.get(cls);
        if (subscriberInfo != null) {
            return subscriberInfo;
        }
        return null;
    }
}
