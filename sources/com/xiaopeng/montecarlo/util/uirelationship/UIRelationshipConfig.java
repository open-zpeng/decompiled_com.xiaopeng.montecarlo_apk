package com.xiaopeng.montecarlo.util.uirelationship;

import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
/* loaded from: classes3.dex */
public class UIRelationshipConfig {
    public static final String ELEMENT_CROSS_2D = "cross_2d";
    public static final String ELEMENT_CROSS_3D = "cross_3d";
    public static final String ELEMENT_INTERVAL_CAMERA = "interval_camera";
    public static final String ELEMENT_NAVI_PANEL = "navi_panel";
    public static final String ELEMENT_NGP = "NGP";
    public static final String ELEMENT_OFFLINE_VIEW = "offline";
    public static final String ELEMENT_POI_CARD = "poi_card";
    public static final String ELEMENT_RECOMMEND_CHARGE = "recommend_charge";
    public static final String ELEMENT_RECOMMEND_PARK = "recommend_park";
    public static final String ELEMENT_RESTRICT_VIEW = "restrict";
    public static final String ELEMENT_SAPA = "sapa";
    public static final String ELEMENT_TRAFFIC_EVENT = "traffic_event_pop";
    public static final String TYPE_COMMON = "COMMON";
    public static final String TYPE_CROSS = "cross";
    public static final String TYPE_POP = "POP";
    public String[] ELEMENTS = {ELEMENT_CROSS_2D, ELEMENT_CROSS_3D, ELEMENT_POI_CARD, ELEMENT_TRAFFIC_EVENT, ELEMENT_RECOMMEND_PARK, ELEMENT_RECOMMEND_CHARGE, "offline", ELEMENT_RESTRICT_VIEW, ELEMENT_SAPA, ELEMENT_INTERVAL_CAMERA, ELEMENT_NAVI_PANEL, ELEMENT_NGP};

    /* loaded from: classes3.dex */
    public @interface UIElementDef {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int getPriority(String str) {
        char c;
        switch (str.hashCode()) {
            case -1548612125:
                if (str.equals("offline")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1030610547:
                if (str.equals(ELEMENT_RECOMMEND_PARK)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -336545092:
                if (str.equals(ELEMENT_RESTRICT_VIEW)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 77239:
                if (str.equals(ELEMENT_NGP)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3522751:
                if (str.equals(ELEMENT_SAPA)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 451764197:
                if (str.equals(ELEMENT_POI_CARD)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1028187103:
                if (str.equals(ELEMENT_INTERVAL_CAMERA)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 1354498967:
                if (str.equals(ELEMENT_RECOMMEND_CHARGE)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1646924843:
                if (str.equals(ELEMENT_NAVI_PANEL)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 2014772074:
                if (str.equals(ELEMENT_TRAFFIC_EVENT)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 2123295441:
                if (str.equals(ELEMENT_CROSS_2D)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 2123295472:
                if (str.equals(ELEMENT_CROSS_3D)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return ContextUtils.getInt(R.integer.priority_ngp);
            case 1:
                return ContextUtils.getInt(R.integer.priority_cross_2d);
            case 2:
                return ContextUtils.getInt(R.integer.priority_cross_3d);
            case 3:
                return ContextUtils.getInt(R.integer.priority_poi_card);
            case 4:
                return ContextUtils.getInt(R.integer.priority_traffic_event);
            case 5:
                return ContextUtils.getInt(R.integer.priority_recommend_park);
            case 6:
                return ContextUtils.getInt(R.integer.priority_recommend_charge);
            case 7:
                return ContextUtils.getInt(R.integer.priority_offline);
            case '\b':
                return ContextUtils.getInt(R.integer.priority_restrict);
            case '\t':
                return ContextUtils.getInt(R.integer.priority_sapa);
            case '\n':
                return ContextUtils.getInt(R.integer.priority_interval_camera);
            case 11:
                return ContextUtils.getInt(R.integer.priority_navi_panel);
            default:
                return -1;
        }
    }
}
