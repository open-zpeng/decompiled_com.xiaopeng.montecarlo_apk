package com.xiaopeng.montecarlo.scenes.routescene;

import android.view.View;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.navcore.bean.route.RouteDetailInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.RouteDetailItemView;
import com.xiaopeng.montecarlo.views.RouteDetailPanel;
import com.xiaopeng.vui.commons.VuiElementType;
import com.xiaopeng.vui.commons.VuiPriority;
import com.xiaopeng.vui.commons.model.VuiElement;
import com.xiaopeng.vui.commons.model.VuiEvent;
import com.xiaopeng.xui.widget.XLinearLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class RouteVuiHelper {
    private static final L.Tag TAG = new L.Tag(RouteVuiHelper.class.getSimpleName());
    private static List<RouteDetailInfo> sRouteList = new ArrayList();

    public static void clearRouteList() {
        sRouteList.clear();
    }

    public static void updateRouteVui(RouteDetailInfo routeDetailInfo, int i, XLinearLayout xLinearLayout, RouteDetailPanel routeDetailPanel, IBaseScene iBaseScene) {
        if (xLinearLayout == null) {
            return;
        }
        sRouteList.add(routeDetailInfo);
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("updateRouteVui data collection"));
        }
        if (sRouteList.size() == i) {
            if (L.ENABLE) {
                L.d(TAG, L.formatVoiceFullScenesLog("updateRouteVui ready to update vui"));
            }
            for (int i2 = 0; i2 < xLinearLayout.getChildCount(); i2++) {
                RouteDetailItemView routeDetailItemView = (RouteDetailItemView) xLinearLayout.getChildAt(i2);
                updateVuiLabelForRouteDetailView(i2, routeDetailItemView);
                routeDetailItemView.setVuiLabel(String.format("%s|%s", routeDetailItemView.getVuiLabel(), routeDetailItemView.getRouteType()));
                if (L.ENABLE) {
                    L.d(TAG, L.formatVoiceFullScenesLog("updateRouteVui index:" + i2 + ",vuiLabel:" + routeDetailItemView.getVuiLabel()));
                }
            }
            VoiceFullScenesUtil.updateScene(iBaseScene, routeDetailPanel);
        }
    }

    private static void updateVuiLabelForRouteDetailView(int i, RouteDetailItemView routeDetailItemView) {
        routeDetailItemView.setVuiElementType(VuiElementType.GROUP);
        routeDetailItemView.setVuiPriority(VuiPriority.LEVEL1);
        routeDetailItemView.setVuiAction(ContextUtils.getString(R.string.vui_action_click_select_navi_set_selected_detail));
        VoiceFullScenesUtil.setVuiElementTag(routeDetailItemView, "2131297669_" + i);
        if (i == 0) {
            routeDetailItemView.setVuiLabel(ContextUtils.getString(R.string.vui_label_route_first_route));
        } else if (i == 1) {
            routeDetailItemView.setVuiLabel(ContextUtils.getString(R.string.vui_label_route_second_route));
        } else if (i != 2) {
        } else {
            routeDetailItemView.setVuiLabel(ContextUtils.getString(R.string.vui_label_route_third_route));
        }
    }

    private static void formatVuiLabelByRouteSort(RouteDetailItemView routeDetailItemView, List<RouteDetailInfo> list, List<RouteDetailInfo> list2, List<RouteDetailInfo> list3, List<RouteDetailInfo> list4) {
        StringBuilder sb = new StringBuilder();
        RouteDetailInfo routeDetailInfo = routeDetailItemView.getRouteDetailInfo();
        RouteDetailInfo routeDetailInfo2 = list2.get(0);
        RouteDetailInfo routeDetailInfo3 = list3.get(0);
        RouteDetailInfo routeDetailInfo4 = list4.get(0);
        if (routeDetailInfo.getRouteTypeNo().equals(list.get(0).getRouteTypeNo())) {
            sb.append(ContextUtils.getString(R.string.vui_label_route_shortest_path_length));
            sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
        }
        if (routeDetailInfo.getRouteTypeNo().equals(routeDetailInfo2.getRouteTypeNo())) {
            sb.append(ContextUtils.getString(R.string.vui_label_route_least_toll_cost));
            sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
        }
        if (routeDetailInfo.getRouteTypeNo().equals(routeDetailInfo3.getRouteTypeNo())) {
            sb.append(ContextUtils.getString(R.string.vui_label_route_least_traffic_light_count));
            sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
        }
        if (routeDetailInfo.getRouteTypeNo().equals(routeDetailInfo4.getRouteTypeNo())) {
            sb.append(ContextUtils.getString(R.string.vui_label_route_shortest_travel_time));
            sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
            routeDetailItemView.setVuiLabel(String.format("%s|%s", routeDetailItemView.getVuiLabel(), sb.toString()));
        }
    }

    public static boolean onInterceptVuiEvent(View view, VuiEvent vuiEvent, RouteScenePresenter routeScenePresenter, IBaseScene iBaseScene) {
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
        if (hitVuiElement == null || !hitVuiElement.id.contains(String.valueOf((int) R.id.vui_element_id_route_detail_item))) {
            return false;
        }
        handleRouteDetailVuiAction(view, hitVuiElement, routeScenePresenter);
        return true;
    }

    private static void handleRouteDetailVuiAction(View view, VuiElement vuiElement, RouteScenePresenter routeScenePresenter) {
        VoiceFullScenesUtil.showVuiAnimation(view);
        List<String> list = vuiElement.resultActions;
        String id = vuiElement.getId();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("onInterceptVuiEvent id:" + id + ",resultActions:" + list));
        }
        String[] split = id.split(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT);
        int intValue = Integer.valueOf(split[split.length - 1]).intValue();
        if (list.contains(ContextUtils.getString(R.string.vui_action_click))) {
            routeScenePresenter.startGuidance(intValue);
        } else if (list.contains(ContextUtils.getString(R.string.vui_action_set_selected))) {
            routeScenePresenter.setSelectRoute(intValue);
        }
    }

    public static boolean onVuiEvent(View view, VuiEvent vuiEvent, RouteScenePresenter routeScenePresenter, IBaseScene iBaseScene) {
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
        handleAlterLabelVuiAction(view, hitVuiElement, routeScenePresenter);
        return true;
    }

    private static void handleAlterLabelVuiAction(View view, VuiElement vuiElement, RouteScenePresenter routeScenePresenter) {
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
                        routeScenePresenter.setSelectRoute(i);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
