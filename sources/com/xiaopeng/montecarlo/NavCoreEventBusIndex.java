package com.xiaopeng.montecarlo;

import com.xiaopeng.lib.framework.moduleinterface.configurationmodule.ConfigurationChangeEvent;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.montecarlo.navcore.aos.TrafficEventServiceWrapper;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.navcore.configurationmodule.ConfigurationModuleManager;
import com.xiaopeng.montecarlo.navcore.event.RouteAosEvent;
import com.xiaopeng.montecarlo.navcore.util.UserLogControl;
import com.xiaopeng.montecarlo.navcore.xptbt.RecommendParkingHelper;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SimpleSubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import org.greenrobot.eventbus.meta.SubscriberMethodInfo;
/* loaded from: classes2.dex */
public class NavCoreEventBusIndex implements SubscriberInfoIndex {
    private static final Map<Class<?>, SubscriberInfo> SUBSCRIBER_INDEX = new HashMap();

    static {
        putIndex(new SimpleSubscriberInfo(RecommendParkingHelper.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onEvent", IIpcService.IpcMessageEvent.class, ThreadMode.BACKGROUND), new SubscriberMethodInfo("onEvent", IpcRouterUtil.IpcRouterEvent.class, ThreadMode.BACKGROUND)}));
        putIndex(new SimpleSubscriberInfo(ConfigurationModuleManager.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onWebConfigurationChanged", ConfigurationChangeEvent.class, ThreadMode.BACKGROUND)}));
        putIndex(new SimpleSubscriberInfo(TrafficEventServiceWrapper.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onAosEvent", RouteAosEvent.class, ThreadMode.BACKGROUND)}));
        putIndex(new SimpleSubscriberInfo(UserLogControl.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onReceiveMqttCmd", IIpcService.IpcMessageEvent.class, ThreadMode.BACKGROUND), new SubscriberMethodInfo("onReceiveMqttCmd", IpcRouterUtil.IpcRouterEvent.class, ThreadMode.BACKGROUND)}));
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
