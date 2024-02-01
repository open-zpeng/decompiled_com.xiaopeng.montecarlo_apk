package com.xiaopeng.montecarlo.util;

import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import com.autonavi.gbl.common.path.model.SubCameraExtType;
import com.autonavi.gbl.layer.model.RouteBlockTag;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.bean.traffic.CruiseTrafficEventType;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class ResUtil {
    private static final int SPEED_10 = 10;
    private static final int SPEED_100 = 100;
    private static final int SPEED_110 = 110;
    private static final int SPEED_120 = 120;
    private static final int SPEED_15 = 15;
    private static final int SPEED_20 = 20;
    private static final int SPEED_25 = 25;
    private static final int SPEED_30 = 30;
    private static final int SPEED_35 = 35;
    private static final int SPEED_40 = 40;
    private static final int SPEED_5 = 5;
    private static final int SPEED_50 = 50;
    private static final int SPEED_60 = 60;
    private static final int SPEED_70 = 70;
    private static final int SPEED_80 = 80;
    private static final int SPEED_90 = 90;
    private static final L.Tag TAG = new L.Tag("ResUtil");

    public static int getCameraTypeResource(int i) {
        switch (i) {
            case 1:
                return R.drawable.vector_camera_type_illegal_user_light;
            case 2:
                return R.drawable.vector_camera_type_life_belt;
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
            case 13:
            case 14:
            case 22:
            case 23:
                return R.drawable.vector_camera_type_electronic_eye;
            case 5:
                return R.drawable.vector_camera_type_no_calling;
            case 10:
                return R.drawable.vector_camera_type_traffic_lights;
            case 11:
                return R.drawable.vector_camera_type_traffic_restriction;
            case 12:
                return R.drawable.vector_camera_type_environment_limit;
            case 15:
                return R.drawable.vector_camera_type_courtesy_crossing;
            case 16:
                return R.drawable.vector_camera_type_reverse;
            case 17:
                return R.drawable.vector_camera_type_no_parking;
            case 18:
                return R.drawable.vector_camera_type_bicycle_lane;
            case 19:
                return R.drawable.vector_camera_type_bus_way;
            case 20:
                return R.drawable.vector_camera_type_special_lane;
            case 21:
                return R.drawable.vector_camera_type_honk;
            case 24:
                return R.drawable.vector_camera_type_railway_crossing;
            default:
                switch (i) {
                    case 28:
                        return R.drawable.vector_camera_type_car_spacing;
                    case 29:
                        return R.drawable.vector_camera_type_hov;
                    case 30:
                        return R.drawable.vector_camera_type_occupied_line;
                    default:
                        switch (i) {
                            case 99:
                                return R.drawable.vector_camera_type_etc;
                            case 100:
                            case 101:
                            default:
                                return R.drawable.vector_camera_type_electronic_eye;
                        }
                }
        }
    }

    public static int getCongestionLabelMarkId(int i) {
        return i != 2 ? i != 5 ? i != 6 ? i != 7 ? i != 8 ? MarkUtils.MARKER_ID_YONG_DU_LEFT : MarkUtils.MARKER_ID_YONG_DU_RIGHT_DOWN : MarkUtils.MARKER_ID_YONG_DU_LEFT_DOWN : MarkUtils.MARKER_ID_YONG_DU_LEFT_UP : MarkUtils.MARKER_ID_YONG_DU_RIGHT_UP : MarkUtils.MARKER_ID_YONG_DU_RIGHT;
    }

    @DrawableRes
    public static int getCruiseCameraTypeResId(int i) {
        if (i != 5) {
            if (i == 12 || i == 19 || i == 20) {
                return R.drawable.vector_camera_type_railway_crossing;
            }
            if (i != 28) {
                if (i != 29) {
                    switch (i) {
                        case 92:
                            return R.drawable.vector_camera_type_traffic_lights;
                        case 93:
                            return R.drawable.vector_camera_type_special_lane;
                        case 94:
                            return R.drawable.vector_camera_type_bicycle_lane;
                        default:
                            return -1;
                    }
                }
                return R.drawable.vector_camera_type_bus_way;
            }
            return R.drawable.vector_camera_type_electronic_eye;
        }
        return R.drawable.vector_camera_type_electronic_eye;
    }

    public static int getGuideCameraBgId(int i, boolean z) {
        if (i != 1) {
            if (i != 2 && i != 5) {
                if (i != 6 && i != 7) {
                    if (i != 8) {
                        return -1;
                    }
                }
            }
            return z ? R.drawable.bg_guide_camera_right_up_red : R.drawable.bg_guide_camera_right_up;
        }
        return z ? R.drawable.bg_guide_camera_left_up_red : R.drawable.bg_guide_camera_left_up;
    }

    public static int getGuideCameraLayout(int i) {
        if (i != 1) {
            if (i == 2 || i == 5) {
                return R.layout.layout_map_guide_camera_info_right;
            }
            if (i != 6 && i != 7) {
                return R.layout.layout_map_guide_camera_info_right;
            }
        }
        return R.layout.layout_map_guide_camera_info_left;
    }

    public static String getGuideCameraLayoutLeftOrRight(int i) {
        if (i != 1) {
            if (i == 2 || i == 5) {
                return "1";
            }
            if (i != 6 && i != 7) {
                return "1";
            }
        }
        return "0";
    }

    public static int getGuideIntervalCameraLayout(int i) {
        return i != 1 ? (i == 2 || i == 5 || !(i == 6 || i == 7 || i != 8)) ? R.drawable.png_bubble_camera_right_up : R.drawable.png_bubble_camera_left_up : R.drawable.png_bubble_camera_left_up;
    }

    public static int getGuideTrafficLightArrowDirectionId(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 7) {
                    if (i != 8) {
                        return -1;
                    }
                    return R.drawable.vector_ic_traffic_arrow_straight;
                }
                return R.drawable.vector_ic_traffic_arrow_turn_around;
            }
            return R.drawable.vector_ic_traffic_arrow_right;
        }
        return R.drawable.vector_ic_traffic_arrow_left;
    }

    public static int getGuideTrafficLightBgId(int i) {
        return i != 1 ? R.drawable.bg_guide_traffic_light_right_up : R.drawable.bg_guide_traffic_light_left_up;
    }

    public static int getLaneCameraLayout(int i) {
        if (i != 1) {
            if (i != 2) {
                return -1;
            }
            return R.layout.layout_map_lane_camera_info_right;
        }
        return R.layout.layout_map_lane_camera_info_left;
    }

    public static int getLaneGuideTrafficLightBgId(int i) {
        return i != 1 ? R.drawable.bg_lane_guide_traffic_light_right_up : R.drawable.bg_lane_guide_traffic_light_left_up;
    }

    public static int getLaneGuideTurnLayout(int i) {
        if (i != 1) {
            if (i != 2) {
                return -1;
            }
            return R.layout.layout_map_lane_turn_info_right;
        }
        return R.layout.layout_map_lane_turn_info_left;
    }

    public static int getLaneGuideTurnResId(int i) {
        switch (i) {
            case 1:
                return R.drawable.vector_lane_turn_icon_turn_left;
            case 2:
                return R.drawable.vector_lane_turn_icon_turn_right;
            case 3:
                return R.drawable.vector_lane_turn_icon_slight_left;
            case 4:
                return R.drawable.vector_lane_turn_icon_slight_right;
            case 5:
                return R.drawable.vector_lane_turn_icon_turn_hard_left;
            case 6:
                return R.drawable.vector_lane_turn_icon_turn_hard_right;
            case 7:
                return R.drawable.vector_lane_turn_icon_u_turn;
            case 8:
            default:
                return -1;
            case 9:
                return R.drawable.vector_lane_turn_icon_merge_left;
            case 10:
                return R.drawable.vector_lane_turn_icon_merge_right;
        }
    }

    public static int getSpeedCameraResource(int i) {
        switch (i) {
            case 5:
                return R.drawable.vector_speed_limit_5;
            case 10:
                return R.drawable.vector_speed_limit_10;
            case 15:
                return R.drawable.vector_speed_limit_15;
            case 20:
                return R.drawable.vector_speed_limit_20;
            case 25:
                return R.drawable.vector_speed_limit_25;
            case 30:
                return R.drawable.vector_speed_limit_30;
            case 35:
                return R.drawable.vector_speed_limit_35;
            case 40:
                return R.drawable.vector_speed_limit_40;
            case 50:
                return R.drawable.vector_speed_limit_50;
            case 60:
                return R.drawable.vector_speed_limit_60;
            case 70:
                return R.drawable.vector_speed_limit_70;
            case 80:
                return R.drawable.vector_speed_limit_80;
            case 90:
                return R.drawable.vector_speed_limit_90;
            case 100:
                return R.drawable.vector_speed_limit_100;
            case 110:
                return R.drawable.vector_speed_limit_110;
            case 120:
                return R.drawable.vector_speed_limit_120;
            default:
                return R.drawable.vector_camera_type_electronic_eye;
        }
    }

    public static int getManeuverResource(XPManeuverInfo xPManeuverInfo) {
        if (xPManeuverInfo == null) {
            L.e(TAG, ">>> getManeuverResource maneuverInfo is null");
            return 0;
        }
        return getManeuverResource(xPManeuverInfo.mManeuverID);
    }

    public static int getManeuverResource(long j) {
        String string = ContextUtils.getString(R.string.guide_next_road_name_format3, Long.valueOf(j));
        L.Tag tag = TAG;
        L.i(tag, ">>> getManeuverResource maneuverInfo res name = " + string);
        return getResIdByResName(string);
    }

    public static int getNextManeuverResource(long j) {
        String string = ContextUtils.getString(R.string.guide_next_road_name_format2, Long.valueOf(j));
        L.Tag tag = TAG;
        L.i(tag, ">>> getManeuverResource maneuverInfo res name = " + string);
        return getResIdByResName(string);
    }

    public static int getTollGateResource(int i) {
        if (i == 1) {
            return ThemeWatcherUtil.getDrawableResId(R.drawable.landtypenormal);
        }
        if (i == 2) {
            return ThemeWatcherUtil.getDrawableResId(R.drawable.landtypeetc);
        }
        if (i == 4) {
            return ThemeWatcherUtil.getDrawableResId(R.drawable.landtypeautomatric);
        }
        return 0;
    }

    public static int getLaneResource(int i, int i2, boolean z) {
        L.Tag tag = TAG;
        L.i(tag, ">>> getLaneResource backLaneTypee=[ " + i + "] frontLaneType=[" + i2 + "] isNavi=" + z);
        if (!z) {
            if (255 != i) {
                return getResIdByResName(ContextUtils.getString(R.string.guide_landfront_name_format, Integer.toHexString(i)));
            }
            return 0;
        } else if (255 == i) {
            if (255 == i2) {
                return 0;
            }
            return getResIdByResName(ContextUtils.getString(R.string.guide_landfront_name_format, Integer.toHexString(i2)));
        } else if (255 != i2) {
            return getResIdByResName(i == i2 ? ContextUtils.getString(R.string.guide_landfront_name_format, Integer.toHexString(i2)) : ContextUtils.getString(R.string.guide_landfront_name_format2, Integer.toHexString(i), Integer.toHexString(i2)));
        } else if (21 == i) {
            return getResIdByResName(ContextUtils.getString(R.string.guide_landfront_name_format, Integer.toHexString(i)));
        } else {
            return getResIdByResName(ContextUtils.getString(R.string.guide_landback_name_format, Integer.toHexString(i)));
        }
    }

    private static int getResIdByResName(String str) {
        try {
            Field field = R.drawable.class.getField(str);
            field.setAccessible(true);
            try {
                return field.getInt(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, ">>> The resource id can not be obtained by name[" + str + "] !");
                    return 0;
                }
                return 0;
            }
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, ">>> The resource id can not be obtained by name[" + str + "] !");
                return 0;
            }
            return 0;
        }
    }

    public static int getCameraBgResource(int i, boolean z) {
        if (i != 0) {
            if (i == 1) {
                return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_blmap_edog_left);
            }
            if (i != 2) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i != 8) {
                                return 0;
                            }
                            return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_blmap_edog_bottom_right);
                        }
                        return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_blmap_edog_bottom_left);
                    }
                    return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_blmap_edog_top_left);
                }
                return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_blmap_edog_top_right);
            }
        }
        return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_blmap_edog_right);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0019, code lost:
        if (r4 == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001c, code lost:
        r1 = com.xiaopeng.montecarlo.R.drawable.png_blmap_fast_roadcondition_left;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0051, code lost:
        if (r4 == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getAlternativeRouteLabelBgResource(int r3, boolean r4) {
        /*
            r0 = 1
            r1 = 2131231214(0x7f0801ee, float:1.8078503E38)
            r2 = 2131231195(0x7f0801db, float:1.8078464E38)
            if (r3 == r0) goto L51
            r0 = 2
            if (r3 == r0) goto L47
            r0 = 5
            if (r3 == r0) goto L3d
            r0 = 6
            if (r3 == r0) goto L33
            r0 = 7
            if (r3 == r0) goto L29
            r0 = 8
            if (r3 == r0) goto L1e
            if (r4 != 0) goto L1c
            goto L53
        L1c:
            r1 = r2
            goto L53
        L1e:
            if (r4 != 0) goto L24
            r3 = 2131231218(0x7f0801f2, float:1.807851E38)
            goto L27
        L24:
            r3 = 2131231199(0x7f0801df, float:1.8078472E38)
        L27:
            r1 = r3
            goto L53
        L29:
            if (r4 != 0) goto L2f
            r3 = 2131231215(0x7f0801ef, float:1.8078505E38)
            goto L27
        L2f:
            r3 = 2131231196(0x7f0801dc, float:1.8078466E38)
            goto L27
        L33:
            if (r4 != 0) goto L39
            r3 = 2131231216(0x7f0801f0, float:1.8078507E38)
            goto L27
        L39:
            r3 = 2131231197(0x7f0801dd, float:1.8078468E38)
            goto L27
        L3d:
            if (r4 != 0) goto L43
            r3 = 2131231219(0x7f0801f3, float:1.8078513E38)
            goto L27
        L43:
            r3 = 2131231200(0x7f0801e0, float:1.8078474E38)
            goto L27
        L47:
            if (r4 != 0) goto L4d
            r3 = 2131231217(0x7f0801f1, float:1.8078509E38)
            goto L27
        L4d:
            r3 = 2131231198(0x7f0801de, float:1.807847E38)
            goto L27
        L51:
            if (r4 != 0) goto L1c
        L53:
            int r3 = com.xiaopeng.montecarlo.util.ThemeWatcherUtil.getDrawableResId(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.util.ResUtil.getAlternativeRouteLabelBgResource(int, boolean):int");
    }

    public static int getNextRoadTurnResource(long j) {
        String string = ThemeWatcherUtil.isDayMode() ? ContextUtils.getString(R.string.guide_next_road_name_format1, Long.valueOf(j)) : ContextUtils.getString(R.string.guide_next_road_name_format1, Long.valueOf(j));
        L.Tag tag = TAG;
        L.i(tag, ">>> getNextRoadTurnResource maneuverInfo res name = " + string);
        return getResIdByResName(string);
    }

    public static int getExploreRoadNameLabelBgResource(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i == 8) {
                                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_explore_roadname_right_down);
                            }
                            return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_explore_roadname_left);
                        }
                        return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_explore_roadname_left_down);
                    }
                    return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_explore_roadname_left_up);
                }
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_explore_roadname_right_up);
            }
            return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_explore_roadname_right);
        }
        return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_explore_roadname_left);
    }

    public static int getGuideRoadNameLabelBgResource(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i == 8) {
                                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_roadname_right_down);
                            }
                            return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_roadname_left);
                        }
                        return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_roadname_left_down);
                    }
                    return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_roadname_left_up);
                }
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_roadname_right_up);
            }
            return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_roadname_right);
        }
        return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_roadname_left);
    }

    public static int getCongestionLabelBgResource(int i, int i2, boolean z) {
        if (i != 1) {
            if (i != 2) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i == 8) {
                                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_routelabel_right_down);
                            }
                            return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_routelabel_left);
                        }
                        return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_routelabel_left_down);
                    }
                    return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_routelabel_left_up);
                }
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_routelabel_right_up);
            }
            return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_routelabel_right);
        }
        return ThemeWatcherUtil.getDrawableResId(R.drawable.png_blmap_routelabel_left);
    }

    public static int getETAEventIconId(int i, boolean z) {
        if (i == 5) {
            return ThemeWatcherUtil.getDrawableResId(z ? R.drawable.vector_ic_mid_normal_traffic_road_jam : R.drawable.vector_auto_ic_navi_road_jam);
        } else if (i == 6) {
            return ThemeWatcherUtil.getDrawableResId(z ? R.drawable.vector_ic_mid_normal_traffic_limitline : R.drawable.vector_auto_ic_navi_limitline);
        } else if (i == 11 || i == 13) {
            return ThemeWatcherUtil.getDrawableResId(z ? R.drawable.vector_ic_mid_normal_traffic_forbidden : R.drawable.vector_auto_ic_navi_forbidden);
        } else if (i == 7) {
            return ThemeWatcherUtil.getDrawableResId(z ? R.drawable.vector_ic_mid_normal_traffic_control_close : R.drawable.vector_auto_ic_navi_normal_block);
        } else {
            return 0;
        }
    }

    public static String getETAEventName(int i) {
        int i2 = i == 5 ? R.string.recommend_route_traffic_block : i == 6 ? R.string.recommend_route_traffic_restrict : (i == 11 || i == 13) ? R.string.recommend_route_limit_forbid : i == 7 ? R.string.traffic_road_close : 0;
        return i2 > 0 ? ContextUtils.getString(i2) : "";
    }

    public static int getRoadCloseIconResId(int i) {
        if (i == 11057) {
            return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_auto_ic_navi_fog_block);
        }
        if (i != 11059) {
            switch (i) {
                case RouteBlockTag.RouteBlockTagWaterBlock /* 11062 */:
                    return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_auto_ic_navi_water_block);
                case RouteBlockTag.RouteBlockTagSnowCoverBlock /* 11063 */:
                case RouteBlockTag.RouteBlockTagIceBlock /* 11064 */:
                    break;
                default:
                    return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_auto_ic_navi_normal_block);
            }
        }
        return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_auto_ic_navi_snow_block);
    }

    public static int getTrafficEventThemeIconId(String str, boolean z) {
        int trafficEventIconId = getTrafficEventIconId(str, z);
        if (trafficEventIconId > 0) {
            return ThemeWatcherUtil.getDrawableResId(trafficEventIconId);
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:?, code lost:
        return com.xiaopeng.montecarlo.R.drawable.vector_ic_mid_normal_traffic_snow_block;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:?, code lost:
        return com.xiaopeng.montecarlo.R.drawable.vector_auto_ic_navi_snow_block;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
        if (r6 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0116, code lost:
        if (r6 != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0124, code lost:
        if (r6 != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x012f, code lost:
        if (r6 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:?, code lost:
        return com.xiaopeng.montecarlo.R.drawable.vector_ic_mid_normal_traffic_control_close;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:?, code lost:
        return com.xiaopeng.montecarlo.R.drawable.vector_auto_ic_navi_normal_block;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getTrafficEventIconId(java.lang.String r5, boolean r6) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.util.ResUtil.getTrafficEventIconId(java.lang.String, boolean):int");
    }

    public static int getRouteTrafficEventIconId(int i) {
        if (i == 101 || i == 102 || i == 104) {
            return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_auto_ic_navi_accident);
        }
        if (i != 501) {
            if (i != 505) {
                switch (i) {
                    case 201:
                    case 202:
                    case 203:
                        return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_auto_ic_navi_construction);
                    default:
                        return 0;
                }
            }
            return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_auto_ic_navi_accident_obstacle);
        }
        return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_auto_ic_navi_ponding);
    }

    public static String getCruiseTrafficEventName(int i) {
        int i2;
        switch (i) {
            case 101:
            case 102:
                i2 = R.string.traffic_accident;
                break;
            case 201:
                i2 = R.string.traffic_construction;
                break;
            case 301:
            case 302:
            case 303:
            case 304:
                i2 = R.string.traffic_control;
                break;
            case 501:
                i2 = R.string.traffic_road_water;
                break;
            case 505:
                i2 = R.string.traffic_obstacle;
                break;
            case CruiseTrafficEventType.CRUISE_TRAFFIC_POLICE_VIOLATION /* 801 */:
            case CruiseTrafficEventType.CRUISE_TRAFFIC_POLICE_DRUNK /* 802 */:
                i2 = R.string.traffic_police_law_enforce;
                break;
            case CruiseTrafficEventType.CRUISE_SERIOUS_TRAFFIC_EVENT_AND_ROAD_CLOSE /* 102302 */:
                i2 = R.string.traffic_accident_and_control;
                break;
            case CruiseTrafficEventType.CRUISE_CONSTRUCTION_AND_ROAD_CLOSE /* 201302 */:
                i2 = R.string.traffic_construction_and_control;
                break;
            case CruiseTrafficEventType.CRUISE_FOG_AND_ROAD_CLOSE /* 404302 */:
            case CruiseTrafficEventType.CRUISE_RAIN_AND_ROAD_CLOSE /* 406302 */:
            case CruiseTrafficEventType.CRUISE_SNOW_AND_ROAD_CLOSE /* 409302 */:
                i2 = R.string.traffic_weather_and_control;
                break;
            default:
                i2 = 0;
                break;
        }
        return i2 > 0 ? ContextUtils.getString(i2) : "";
    }

    public static String getTrafficName(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("11050".equals(str)) {
            i = R.string.traffic_road_close;
        } else if ("11070".equals(str)) {
            i = R.string.traffic_announcement;
        } else if ("11031".equals(str)) {
            i = R.string.traffic_control;
        } else if ("11060".equals(str)) {
            i = R.string.traffic_urgency;
        } else if ("11071".equals(str)) {
            i = R.string.traffic_live_action;
        } else if ("11011".equals(str)) {
            i = R.string.traffic_automobile_accident;
        } else if ("11010".equals(str)) {
            i = R.string.traffic_accident_obstacle;
        } else if ("11012".equals(str)) {
            i = R.string.traffic_obstacle;
        } else if ("11040".equals(str)) {
            i = R.string.traffic_construction;
        } else if ("11100".equals(str)) {
            i = R.string.traffic_water_block;
        } else if ("11033".equals(str)) {
            i = R.string.traffic_police_law_enforce;
        } else if ("11021".equals(str)) {
            i = R.string.traffic_road_jam;
        } else if ("404302".equals(str)) {
            i = R.string.traffic_fog_block;
        } else if ("409302".equals(str)) {
            i = R.string.traffic_snow_block;
        } else if ("502302".equals(str)) {
            i = R.string.traffic_road_snow;
        } else if ("503302".equals(str)) {
            i = R.string.traffic_road_ice;
        } else {
            i = "501302".equals(str) ? R.string.traffic_road_water : -1;
        }
        if (i == -1) {
            i = R.string.traffic_accident;
        }
        return ContextUtils.getString(i);
    }

    public static int getFacilityIconResId(int i) {
        switch (i) {
            case 0:
                return -1;
            case 1:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_left_in);
            case 2:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_right_in);
            case 3:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_sharp_turn_right);
            case 4:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_reverseturn);
            case 5:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_continuous_curve);
            case 6:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_accident_prone_sections);
            case 7:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_falling_rocks);
            case 8:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_railway_crossing);
            case 9:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_easy_slip_road);
            case 10:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.vector_iconbutton_large_electroniceye_roundbox);
            case 11:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.iconbutton_large_electroniceye_roundbox_blue);
            case 12:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_village);
            case 13:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_left_lane_narrowing);
            case 14:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_right_lane_narrowing);
            case 15:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_lane_narrowing_on_both_sides);
            case 16:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_the_wind);
            case 17:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_school);
            case 18:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_no_overtaking);
            case 19:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_narrow_bridge);
            case 20:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_detour_left_right);
            case 21:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_detour_left);
            case 22:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_detour_right);
            case 23:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_mountain_left);
            case 24:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_mountain_right);
            case 25:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_upper_slope);
            case 26:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_down_slope);
            case 27:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_through_water);
            case 28:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_bumpy_road);
            case 29:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_slow_down);
            case 30:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_attentiondanger);
            case 31:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_zebracrossing);
            default:
                return -1;
        }
    }

    public static int getCruiseFacilityIconResId(int i) {
        switch (i) {
            case 12:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_railway_crossing);
            case 13:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_falling_rocks);
            case 14:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_accident_prone_sections);
            case 15:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_easy_slip_road);
            case 16:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_village);
            case 17:
            case 30:
            case 32:
            case 33:
            case 34:
            case 35:
            case 45:
            case 46:
            case 51:
            case 55:
            case 56:
            case 57:
            default:
                return -1;
            case 18:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_school);
            case 19:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_keeperrailwaycrossing);
            case 20:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_nokeeperrailwaycrossing);
            case 21:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_lane_narrowing_on_both_sides);
            case 22:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_sharp_turn_left);
            case 23:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_sharp_turn_right);
            case 24:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_reverseturn);
            case 25:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_continuous_curve);
            case 26:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_left_in);
            case 27:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_right_in);
            case 28:
            case 29:
                return -1;
            case 31:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_no_overtaking);
            case 36:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_right_lane_narrowing);
            case 37:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_left_lane_narrowing);
            case 38:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_narrow_bridge);
            case 39:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_detour_left_right);
            case 40:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_detour_left);
            case 41:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_detour_right);
            case 42:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_falling_rocks_right);
            case 43:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_mountain_left);
            case 44:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_mountain_right);
            case 47:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_upper_slope);
            case 48:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_down_slope);
            case 49:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_through_water);
            case 50:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_bumpy_road);
            case 52:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_slow_down);
            case 53:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_attentiondanger);
            case 54:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_the_wind);
            case 58:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_tunnel);
            case 59:
                return ThemeWatcherUtil.getDrawableResId(R.drawable.png_auto_ic_road_facilities_ferry);
        }
    }

    public static String getCongestionStatusString(int i) {
        int i2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? 0 : R.string.jam_status_5 : R.string.jam_status_4 : R.string.jam_status_3 : R.string.jam_status_2 : R.string.jam_status_1 : R.string.jam_status_0;
        return i2 == 0 ? "" : ContextUtils.getString(i2);
    }

    public static int getTrafficCongestionColor(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return ThemeWatcherUtil.getColor(R.color.cruise_traffic_congestion_serious_color);
                        }
                        return ThemeWatcherUtil.getColor(R.color.traffic_none_info);
                    }
                    return ThemeWatcherUtil.getColor(R.color.cruise_traffic_congestion_serious_color);
                }
                return ThemeWatcherUtil.getColor(R.color.cruise_traffic_congestion_slow_color);
            }
            return ThemeWatcherUtil.getColor(R.color.cruise_traffic_congestion_normal_color);
        }
        return ThemeWatcherUtil.getColor(R.color.traffic_none_info);
    }

    public static int getGuideCameraIcon(@SubCameraExtType.SubCameraExtType1 int i, int i2) {
        if (7 == i) {
            return i2 > 0 ? getSpeedCameraResource(i2) : R.drawable.vector_ic_mid_scan_speed;
        }
        return getCameraTypeResource(i);
    }

    public static int getGuideTrafficLightArrowDirectionId(String str) {
        boolean z;
        if (str == null) {
            return -1;
        }
        int hashCode = str.hashCode();
        if (hashCode == 3317767) {
            if (str.equals("left")) {
                z = false;
            }
            z = true;
        } else if (hashCode != 108511772) {
            if (hashCode == 1787472634 && str.equals(NaviUtil.LANE_GUIDE_TRAFFIC_LIGHT_STRAIGHT)) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("right")) {
                z = true;
            }
            z = true;
        }
        if (z) {
            if (!z) {
                if (!z) {
                    return -1;
                }
                return R.drawable.vector_ic_traffic_arrow_straight;
            }
            return R.drawable.vector_ic_traffic_arrow_right;
        }
        return R.drawable.vector_ic_traffic_arrow_left;
    }
}
