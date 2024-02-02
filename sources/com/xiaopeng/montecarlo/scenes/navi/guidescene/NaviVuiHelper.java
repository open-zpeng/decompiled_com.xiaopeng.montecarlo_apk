package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import android.view.View;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.vui.commons.model.VuiElement;
import com.xiaopeng.vui.commons.model.VuiEvent;
import java.util.List;
import java.util.Map;
@Deprecated
/* loaded from: classes2.dex */
public class NaviVuiHelper {
    private static final L.Tag TAG = new L.Tag(NaviVuiHelper.class.getSimpleName());

    public static boolean onVuiEvent(View view, VuiEvent vuiEvent, NaviScenePresenter naviScenePresenter, IBaseScene iBaseScene) {
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
        handleAlterLabelVuiAction(view, hitVuiElement, naviScenePresenter);
        return true;
    }

    private static void handleAlterLabelVuiAction(View view, VuiElement vuiElement, NaviScenePresenter naviScenePresenter) {
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
                        naviScenePresenter.onSelectRoute(i);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean onInterceptVuiEvent(View view, VuiEvent vuiEvent, NaviScenePresenter naviScenePresenter, IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("onInterceptVuiEvent view:" + view + ",vuiEvent:" + vuiEvent + ",scene:" + iBaseScene));
        }
        if (vuiEvent == null || view == null) {
            return false;
        }
        CommonVuiHelper.getInstance().executeVuiEventBaseOperation(iBaseScene, view);
        VuiElement hitVuiElement = vuiEvent.getHitVuiElement();
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, L.formatVoiceFullScenesLog("onInterceptVuiEvent hit:" + hitVuiElement));
        }
        if (hitVuiElement != null) {
            String str = hitVuiElement.id;
            if (str.contains(String.valueOf((int) R.id.btn_recommend_park1)) || str.contains(String.valueOf((int) R.id.btn_recommend_park2)) || str.contains(String.valueOf((int) R.id.btn_recommend_park3))) {
                handleRecommendParkVuiAction(view, hitVuiElement, naviScenePresenter);
                return true;
            }
            return false;
        }
        return false;
    }

    private static void handleRecommendParkVuiAction(View view, VuiElement vuiElement, NaviScenePresenter naviScenePresenter) {
        VoiceFullScenesUtil.showVuiAnimation(view);
        List<String> list = vuiElement.resultActions;
        if (list.contains(ContextUtils.getString(R.string.vui_action_click))) {
            naviScenePresenter.naviToPark(view);
        } else if (list.contains(ContextUtils.getString(R.string.vui_action_set_selected))) {
            naviScenePresenter.showParkDetail(view);
        }
    }
}
