package com.xiaopeng.montecarlo.scenes.navi;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreScenePresenter;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.vui.commons.model.VuiElement;
import com.xiaopeng.vui.commons.model.VuiEvent;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class CommonNaviVuiHelper {
    private static final L.Tag TAG = new L.Tag(CommonNaviVuiHelper.class.getSimpleName());

    public static boolean onVuiEventHandleRouteAlterLabel(View view, VuiEvent vuiEvent, BaseNaviPresenter<?> baseNaviPresenter, IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("onVuiEvent view:" + view + ",vuiEvent:" + vuiEvent + ",scene:" + iBaseScene));
        }
        if (vuiEvent == null || view == null) {
            return false;
        }
        CommonVuiHelper.getInstance().executeVuiEventBaseOperation(iBaseScene, view);
        VuiElement hitVuiElement = vuiEvent.getHitVuiElement();
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, L.formatVoiceFullScenesLog("onVuiEvent hit:" + hitVuiElement));
        }
        if (hitVuiElement == null || !hitVuiElement.id.equals(String.valueOf((int) R.id.route_alert_label_item))) {
            return false;
        }
        handleAlterLabelVuiAction(view, hitVuiElement, baseNaviPresenter);
        return true;
    }

    private static void handleAlterLabelVuiAction(View view, VuiElement vuiElement, BaseNaviPresenter<?> baseNaviPresenter) {
        Map map;
        int i;
        try {
            Map map2 = (Map) vuiElement.getValues();
            if (map2 != null) {
                List<String> list = vuiElement.resultActions;
                if (CollectionUtils.isNotEmpty(list) && list.contains("SetValue") && (map = (Map) map2.get("SetValue")) != null) {
                    String str = (String) map.get("value");
                    VoiceFullScenesUtil.showVuiAnimation(view);
                    if (ContextUtils.getString(R.string.vui_label_map_style_alternative_path_1).contains(str)) {
                        i = 0;
                    } else if (ContextUtils.getString(R.string.vui_label_map_style_alternative_path_2).contains(str)) {
                        i = 1;
                    } else {
                        i = ContextUtils.getString(R.string.vui_label_map_style_alternative_path_3).contains(str) ? 2 : -1;
                    }
                    if (i != -1) {
                        if (L.ENABLE) {
                            L.Tag tag = TAG;
                            L.d(tag, L.formatVoiceFullScenesLog("handleAlterLabelVuiAction index:" + i));
                        }
                        baseNaviPresenter.onSelectRoute(i);
                        VoiceFullScenesUtil.updateStatefulButtonState(view, i);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static VuiElement onInterceptFindTargetVuiElement(View view, VuiEvent vuiEvent, IBaseScene iBaseScene, int... iArr) {
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("onInterceptVuiEvent view:" + view + ",vuiEvent:" + vuiEvent + ",scene:" + iBaseScene));
        }
        if (vuiEvent == null || view == null) {
            return null;
        }
        CommonVuiHelper.getInstance().executeVuiEventBaseOperation(iBaseScene, view);
        VuiElement hitVuiElement = vuiEvent.getHitVuiElement();
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("onInterceptVuiEvent hit:" + hitVuiElement));
        }
        if (hitVuiElement == null || iArr == null || TextUtils.isEmpty(hitVuiElement.id)) {
            return null;
        }
        for (int i : iArr) {
            if (hitVuiElement.id.contains(String.valueOf(i))) {
                return hitVuiElement;
            }
        }
        return null;
    }

    public static void handleRecommendParkVuiAction(@NonNull View view, @NonNull VuiElement vuiElement, @NonNull NaviScenePresenter naviScenePresenter) {
        VoiceFullScenesUtil.showVuiAnimation(view);
        List<String> list = vuiElement.resultActions;
        if (list.contains(ContextUtils.getString(R.string.vui_action_click))) {
            naviScenePresenter.naviToPark(view);
        } else if (list.contains(ContextUtils.getString(R.string.vui_action_set_selected))) {
            naviScenePresenter.showParkDetail(view);
        }
    }

    public static void handleSelectRouteVuiAction(@NonNull View view, @NonNull VuiElement vuiElement, @NonNull ExploreScenePresenter exploreScenePresenter) {
        VoiceFullScenesUtil.showVuiAnimation(view);
        String id = vuiElement.getId();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("handleAlterLabelVuiAction id:" + id));
        }
        String[] split = id.split(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT);
        exploreScenePresenter.onSelectRoute(Integer.parseInt(split[split.length - 1]));
    }
}
