package com.xiaopeng.montecarlo.scenes.mapscene;

import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
/* loaded from: classes2.dex */
public class MapTextureResourcesHelper {
    private static final L.Tag TAG = new L.Tag("MapTextureResourcesHelper");
    public static SparseArray<MarkUtils.MapTextureResource> sResourceList = new SparseArray<>();

    public static SparseArray<MarkUtils.MapTextureResource> getDefaultMapTextureResources() {
        if (sResourceList.size() == 0) {
            sResourceList.put(MarkUtils.MARKER_ID_CAR_NAVIGATION_IN_CROSS, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_ic_xlarge_carlocation_normal)));
            sResourceList.put(67, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.bg_route_texture_very_jam)));
            sResourceList.put(MarkUtils.MARKER_ID_CAR_END, createMapTextureByResId(R.drawable.png_poi_middle_end));
            sResourceList.put(79, createMapTextureByResId(R.drawable.png_poi_middle_end));
            sResourceList.put(80, createMapTextureByResId(R.drawable.png_poi_action_destination));
            sResourceList.put(20, createMapTextureByResId(R.drawable.icon_add_way_poi));
            sResourceList.put(78, createMapTextureByResId(R.drawable.png_poi_middle_start));
            sResourceList.put(MarkUtils.MARKER_ID_BUBBLE_VIA_CHARGE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.poi_medium_normal_nav_passingpoint_blue)));
            sResourceList.put(MarkUtils.MARKER_ID_BUBBLE_PASSED_VIA_CHARGE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.poi_medium_normal_nav_passingpoint_grey)));
            sResourceList.put(361, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.poi_medium_normal_nav_passingpoint_blue)));
            sResourceList.put(MarkUtils.MARKER_ID_BUBBLE_PASSED_FOCUS_VIA_CHARGE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.poi_medium_pressed_nav_passingpoint_grey)));
            sResourceList.put(19, createMapTextureByResId(R.drawable.bubble_end));
            sResourceList.put(18, createMapTextureByResId(R.drawable.bubble_start));
            sResourceList.put(9, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_point_pressed)));
            sResourceList.put(10, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_point_pressed)));
            sResourceList.put(11, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_ic_xlarge_normal_dj)));
            sResourceList.put(12, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_ic_xlarge_normal_dj)));
            sResourceList.put(43, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_vpa_point)));
            sResourceList.put(44, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_vpa_point)));
            sResourceList.put(64, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.bg_route_texture_very_jam)));
            sResourceList.put(2, createMapTextureByResId(R.drawable.threed_arrow_line_outer));
            sResourceList.put(3, createMapTextureByResId(R.drawable.threed_arrow_line_inner));
            sResourceList.put(4, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.navi_threedback)));
            sResourceList.put(68, createMapTextureByResId(R.drawable.threed_arrow_line_inner));
            sResourceList.put(74, createMapTextureByResId(R.drawable.line_3d_filltexid));
            sResourceList.put(75, createMapTextureByResId(R.drawable.map_aolr));
            sResourceList.put(73, createMapTextureByResId(R.drawable.pre_list_img2));
            sResourceList.put(47, createMapTextureByResId(R.drawable.pre_list_img2));
            sResourceList.put(76, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_card_mapofintersection_bg)));
            sResourceList.put(77, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_card_mapofintersection_bg)));
            sResourceList.put(MarkUtils.MARKER_ID_FAVOURITE, createMapTextureByResId(R.drawable.png_poi_small_collection_mapdisplay));
            sResourceList.put(MarkUtils.MARKER_ID_FAVOURITE_NIGHT, createMapTextureByResId(R.drawable.png_poi_small_collection_mapdisplay));
            sResourceList.put(MarkUtils.MARKER_ID_HOME, createMapTextureByResId(R.drawable.png_poi_family));
            sResourceList.put(MarkUtils.MARKER_ID_HOME_NIGHT, createMapTextureByResId(R.drawable.png_poi_family));
            sResourceList.put(364, createMapTextureByResId(R.drawable.png_poi_company));
            sResourceList.put(MarkUtils.MARKER_ID_COMPANY_NIGHT, createMapTextureByResId(R.drawable.png_poi_company));
            sResourceList.put(MarkUtils.MARKER_ID_RECOMMEND_PARK_1, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_middle_charge01)));
            sResourceList.put(MarkUtils.MARKER_ID_RECOMMEND_PARK_2, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_middle_charge02)));
            sResourceList.put(MarkUtils.MARKER_ID_RECOMMEND_PARK_3, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_middle_charge03)));
            sResourceList.put(MarkUtils.MARKER_ID_RECOMMEND_PARK_FOCUS_1, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_middle_charge01_pressed)));
            sResourceList.put(MarkUtils.MARKER_ID_RECOMMEND_PARK_FOCUS_2, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_middle_charge02_pressed)));
            sResourceList.put(MarkUtils.MARKER_ID_RECOMMEND_PARK_FOCUS_3, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_middle_charge03_pressed)));
            sResourceList.put(22, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_42_normal_ic_trafficlight)));
            sResourceList.put(402, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_normal_outside)));
            sResourceList.put(446, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_large_center)));
            sResourceList.put(MarkUtils.MARKER_ID_SEARCH_AROUNT_POI_CENTER_NIGHT, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_large_center)));
            sResourceList.put(MarkUtils.MARKER_ID_DEBUG_GPS, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.debug_gps)));
            sResourceList.put(MarkUtils.MARKER_ID_DEBUG_DR, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.debug_dr)));
            sResourceList.put(450, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.debug_gps_trace_point)));
            sResourceList.put(MarkUtils.MARKER_ID_DEBUG_DR_TRACE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.debug_dr_trace_point)));
            sResourceList.put(MarkUtils.MARKER_ID_RECOMMEND_CHARGE_FREQUENT, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_large_charge_pc_chargingpile_slow_press)));
            sResourceList.put(MarkUtils.MARKER_ID_RECOMMEND_CHARGE_AROUND_XP, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_large_charge_chargingpile_xpeng_pressed)));
            sResourceList.put(MarkUtils.MARKER_ID_RECOMMEND_CHARGE_AROUND_FAST, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_large_charge_pc_chargingpile_quick_pressed)));
            sResourceList.put(MarkUtils.MARKER_ID_RECOMMEND_CHARGE_AROUND_SLOW, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.png_poi_large_charge_pc_chargingpile_slow_press)));
            sResourceList.put(MarkUtils.MARKER_ID_CAR_NAVIGATION_EAGLEYE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_30_normal_ic_carlocation_navigationstate)));
            sResourceList.put(MarkUtils.MARKER_ID_CAR_EAGLEYE_END, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_20_normal_ic_poi_action_destination)));
            sResourceList.put(MarkUtils.MARKER_ID_ROUTE_CHARGE_LAST_REACHABLE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_route_charge_last_reachable)));
            sResourceList.put(MarkUtils.MARKER_ID_ROUTE_CHARGE_REACHABLE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_route_charge_reachable)));
            sResourceList.put(493, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_route_charge_unreachable)));
            sResourceList.put(MarkUtils.MARKER_ID_ROUTE_CHARGE_SELECT_REACHABLE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_route_charge_select_reachable)));
            sResourceList.put(MarkUtils.MARKER_ID_ROUTE_CHARGE_SELECT_LAST_REACHABLE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_route_charge_select_last_reachable)));
            sResourceList.put(MarkUtils.MARKER_ID_ROUTE_CHARGE_FOCUS_LAST_REACHABLE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_route_charge_focus_last_reachable)));
            sResourceList.put(MarkUtils.MARKER_ID_ROUTE_CHARGE_FOCUS_SELECT_LAST_REACHABLE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_route_charge_focus_select_last_reachable)));
            sResourceList.put(MarkUtils.MARKER_ID_ROUTE_CHARGE_FOCUS_REACHABLE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_route_charge_focus_reachable)));
            sResourceList.put(MarkUtils.MARKER_ID_ROUTE_CHARGE_FOCUS_SELECT_REACHABLE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_route_charge_focus_select_reachable)));
            sResourceList.put(500, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_route_charge_focus_unreachable)));
            sResourceList.put(418, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_road_white_front)));
            sResourceList.put(434, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_road_white_back)));
            sResourceList.put(417, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_road_white_front)));
            sResourceList.put(433, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_road_white_back)));
            sResourceList.put(TypedValues.Cycle.TYPE_PATH_ROTATE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_road_white_front)));
            sResourceList.put(432, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_road_white_back)));
            sResourceList.put(415, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_road_white_front)));
            sResourceList.put(431, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_road_white_back)));
            sResourceList.put(419, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_road_white_front)));
            sResourceList.put(435, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_road_white_back)));
            sResourceList.put(420, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_dott_car_light)));
            sResourceList.put(436, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_dott_car_light)));
            sResourceList.put(421, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_dott_car_light)));
            sResourceList.put(MarkUtils.MARKER_ID_ROUTE_BOARDER_LINE_TEXTURE, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_dott_car_light)));
            sResourceList.put(414, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_aolr)));
            sResourceList.put(430, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_aolr)));
            sResourceList.put(407, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_ferry)));
            sResourceList.put(TypedValues.Cycle.TYPE_WAVE_PERIOD, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_ferry)));
            sResourceList.put(411, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_traffic_platenum_restrict_hl)));
            sResourceList.put(27, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_auto_ic_navi_road_jam)));
            sResourceList.put(65, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.map_lr_bad)));
            sResourceList.put(29, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.ic_png_poi_odd_start)));
            sResourceList.put(30, createMapTextureByResId(ThemeWatcherUtil.getDrawableResId(R.drawable.ic_png_poi_odd_final)));
        }
        return sResourceList;
    }

    public static MarkUtils.MapTextureResource createCarLocMapTextureByResId(int i) {
        return new MarkUtils.MapTextureResource(4, 0.0f, 0.0f, false, false, i);
    }

    public static void clearResources() {
        SparseArray<MarkUtils.MapTextureResource> sparseArray = sResourceList;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.xiaopeng.montecarlo.navcore.util.MarkUtils.MapTextureResource createMapTextureByResId(int r15) {
        /*
            r0 = 1063256064(0x3f600000, float:0.875)
            r1 = 1063675494(0x3f666666, float:0.9)
            r2 = 1064094925(0x3f6ccccd, float:0.925)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1056964608(0x3f000000, float:0.5)
            r7 = 9
            r8 = 4
            switch(r15) {
                case 2131230867: goto L87;
                case 2131230868: goto L87;
                default: goto L13;
            }
        L13:
            switch(r15) {
                case 2131230874: goto L80;
                case 2131230876: goto L7d;
                case 2131230937: goto L78;
                case 2131230942: goto L76;
                case 2131230943: goto L76;
                case 2131230944: goto L76;
                case 2131230945: goto L76;
                case 2131230946: goto L76;
                case 2131230947: goto L73;
                case 2131230948: goto L76;
                case 2131230949: goto L76;
                case 2131230950: goto L76;
                case 2131230951: goto L76;
                case 2131230952: goto L73;
                case 2131231209: goto L6f;
                case 2131231310: goto L67;
                case 2131231324: goto L63;
                case 2131231326: goto L5f;
                case 2131231341: goto L5b;
                case 2131231568: goto L55;
                case 2131231891: goto L76;
                case 2131231892: goto L76;
                case 2131231893: goto L76;
                case 2131231894: goto L76;
                case 2131231918: goto L76;
                default: goto L16;
            }
        L16:
            switch(r15) {
                case 2131230915: goto L53;
                case 2131230916: goto L53;
                default: goto L19;
            }
        L19:
            switch(r15) {
                case 2131231037: goto L4e;
                case 2131231038: goto L4e;
                default: goto L1c;
            }
        L1c:
            switch(r15) {
                case 2131231040: goto L4e;
                case 2131231041: goto L4e;
                case 2131231042: goto L4e;
                default: goto L1f;
            }
        L1f:
            switch(r15) {
                case 2131231044: goto L49;
                case 2131231045: goto L49;
                default: goto L22;
            }
        L22:
            switch(r15) {
                case 2131231328: goto L5f;
                case 2131231329: goto L44;
                case 2131231330: goto L44;
                case 2131231331: goto L44;
                case 2131231332: goto L44;
                case 2131231333: goto L44;
                case 2131231334: goto L44;
                case 2131231335: goto L3f;
                case 2131231336: goto L8a;
                case 2131231337: goto L5b;
                default: goto L25;
            }
        L25:
            switch(r15) {
                case 2131231346: goto L5b;
                case 2131231347: goto L5b;
                default: goto L28;
            }
        L28:
            switch(r15) {
                case 2131231378: goto L3a;
                case 2131231379: goto L3a;
                case 2131231380: goto L3a;
                case 2131231381: goto L3a;
                case 2131231382: goto L3a;
                case 2131231383: goto L3a;
                case 2131231384: goto L3a;
                case 2131231385: goto L3a;
                case 2131231386: goto L3a;
                case 2131231387: goto L35;
                default: goto L2b;
            }
        L2b:
            switch(r15) {
                case 2131231886: goto L76;
                case 2131231887: goto L76;
                case 2131231888: goto L76;
                case 2131231889: goto L76;
                default: goto L2e;
            }
        L2e:
            r10 = r3
            r11 = r10
            r13 = r4
            r12 = r5
        L32:
            r9 = r8
            goto L8f
        L35:
            r11 = r0
            r12 = r4
            r13 = r12
            goto L8d
        L3a:
            r0 = 1061997773(0x3f4ccccd, float:0.8)
            goto L8a
        L3f:
            r0 = 1062618530(0x3f5645a2, float:0.837)
            goto L8a
        L44:
            r0 = 1059699294(0x3f29ba5e, float:0.663)
            goto L8a
        L49:
            r10 = r3
            r11 = r10
            r12 = r4
            r13 = r5
            goto L32
        L4e:
            r10 = r3
            r11 = r10
            r12 = r4
        L51:
            r13 = r12
            goto L32
        L53:
            r11 = r2
            goto L8b
        L55:
            r10 = r3
            r11 = r10
            r9 = r5
            r12 = r9
            r13 = r12
            goto L8f
        L5b:
            r0 = 1062232654(0x3f50624e, float:0.814)
            goto L8a
        L5f:
            r0 = 1062601753(0x3f560419, float:0.836)
            goto L8a
        L63:
            r0 = 1063423836(0x3f628f5c, float:0.885)
            goto L8a
        L67:
            r3 = 1046898278(0x3e666666, float:0.225)
            r11 = r2
            r10 = r3
            r13 = r4
            r12 = r5
            goto L8e
        L6f:
            r10 = r3
            r11 = r10
            r12 = r5
            goto L51
        L73:
            r0 = 1061158912(0x3f400000, float:0.75)
            goto L8a
        L76:
            r11 = r1
            goto L8b
        L78:
            r13 = r4
            r12 = r5
            r10 = r6
            r11 = r10
            goto L8e
        L7d:
            r0 = 8
            goto L81
        L80:
            r0 = 7
        L81:
            r9 = r0
            r10 = r3
            r11 = r10
            r13 = r4
            r12 = r5
            goto L8f
        L87:
            r0 = 1063591608(0x3f651eb8, float:0.895)
        L8a:
            r11 = r0
        L8b:
            r13 = r4
            r12 = r5
        L8d:
            r10 = r6
        L8e:
            r9 = r7
        L8f:
            com.xiaopeng.montecarlo.navcore.util.MarkUtils$MapTextureResource r0 = new com.xiaopeng.montecarlo.navcore.util.MarkUtils$MapTextureResource
            r8 = r0
            r14 = r15
            r8.<init>(r9, r10, r11, r12, r13, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.MapTextureResourcesHelper.createMapTextureByResId(int):com.xiaopeng.montecarlo.navcore.util.MarkUtils$MapTextureResource");
    }
}
