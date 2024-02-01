package com.xiaopeng.montecarlo.appengine;

import android.content.Intent;
import android.os.Bundle;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.MainActivity;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.CarGreetingClearRenderRoutesEvent;
import com.xiaopeng.montecarlo.navcore.event.CarGreetingGetAroundTrafficInfoEvent;
import com.xiaopeng.montecarlo.navcore.event.CarGreetingMoveSearchBarEvent;
import com.xiaopeng.montecarlo.navcore.event.CarGreetingRenderRoutesEvent;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CarGreetingInfoService implements IServicePublisher {
    private static final L.Tag TAG = new L.Tag("CarGInfoService");

    @Publish
    public void setActiveState(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "setActiveState activeState=" + z);
        if (z) {
            StateManager.getInstance().switchActiveState();
        } else {
            StateManager.getInstance().switchImmersionState();
        }
    }

    @Publish
    public void renderRoutes(String str) {
        backtoForeground();
        L.Tag tag = TAG;
        L.i(tag, "renderRoutes endInfo=" + str);
        CarGreetingRenderRoutesEvent carGreetingRenderRoutesEvent = new CarGreetingRenderRoutesEvent();
        try {
            XPPoiInfo xPPoiInfo = new XPPoiInfo();
            JSONObject jSONObject = new JSONObject(str);
            double optDouble = jSONObject.optDouble(CPSearchParam.PARAM_KEY_LAT);
            double optDouble2 = jSONObject.optDouble(CPSearchParam.PARAM_KEY_LON);
            if (!NavCoreUtil.isValidLatLon(optDouble, optDouble2)) {
                L.e(TAG, "renderRoutes lat or lon is invalidate");
                return;
            }
            String optString = jSONObject.optString("name");
            xPPoiInfo.setDisplayLat(optDouble);
            xPPoiInfo.setDisplayLon(optDouble2);
            xPPoiInfo.setName(optString);
            carGreetingRenderRoutesEvent.setEndInfo(GsonUtil.toJson(xPPoiInfo));
            EventBus.getDefault().postSticky(carGreetingRenderRoutesEvent);
        } catch (JSONException e) {
            L.Tag tag2 = TAG;
            L.e(tag2, "renderRoutes json error =" + e.getMessage());
        }
    }

    @Publish
    public void clearRenderRoutes() {
        L.i(TAG, "clearRenderRoutes");
        if (TBTManager.getInstance().getCurrentStatus() == 0) {
            EventBus.getDefault().postSticky(new CarGreetingClearRenderRoutesEvent());
        }
    }

    @Publish
    public void onMoveSearchBar(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "onMoveSearchBar isDownMove=" + z);
        EventBus.getDefault().postSticky(new CarGreetingMoveSearchBarEvent(z));
    }

    @Publish
    public void getAroundTrafficInfo(int i) {
        backtoForeground();
        L.Tag tag = TAG;
        L.i(tag, "getAroundTrafficInfo ratioScale=" + i);
        if (i <= 0) {
            i = 13;
        }
        EventBus.getDefault().postSticky(new CarGreetingGetAroundTrafficInfoEvent(i));
    }

    private void backtoForeground() {
        if (RootUtil.isTopActivity(String.format("%s.%s", RootUtil.getPackageName(), MainActivity.class.getSimpleName()))) {
            return;
        }
        Bundle bundle = new Bundle();
        Intent intent = new Intent(ContextUtils.getContext(), MainActivity.class);
        bundle.putString(IntentActions.ActionsKey.KEY_ACTION, IntentActions.ACTION_ACTIVITY_TO_FRONT);
        intent.putExtras(bundle);
        ContextUtils.startActivityWithNewTask(intent);
    }
}
