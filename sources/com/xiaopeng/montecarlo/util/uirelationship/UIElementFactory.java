package com.xiaopeng.montecarlo.util.uirelationship;

import com.xiaopeng.montecarlo.util.uirelationship.elements.CommonElement;
import com.xiaopeng.montecarlo.util.uirelationship.elements.Cross2DElement;
import com.xiaopeng.montecarlo.util.uirelationship.elements.Cross3DElement;
import com.xiaopeng.montecarlo.util.uirelationship.elements.NgpElement;
import com.xiaopeng.montecarlo.util.uirelationship.elements.OfflineElement;
import com.xiaopeng.montecarlo.util.uirelationship.elements.PopElement;
import com.xiaopeng.montecarlo.util.uirelationship.elements.RecommendParkElement;
/* loaded from: classes3.dex */
public class UIElementFactory {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static UIRelationshipElement createElement(String str) {
        char c;
        switch (str.hashCode()) {
            case -1548612125:
                if (str.equals("offline")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1030610547:
                if (str.equals(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -336545092:
                if (str.equals(UIRelationshipConfig.ELEMENT_RESTRICT_VIEW)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 77239:
                if (str.equals(UIRelationshipConfig.ELEMENT_NGP)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 3522751:
                if (str.equals(UIRelationshipConfig.ELEMENT_SAPA)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 451764197:
                if (str.equals(UIRelationshipConfig.ELEMENT_POI_CARD)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1028187103:
                if (str.equals(UIRelationshipConfig.ELEMENT_INTERVAL_CAMERA)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 1354498967:
                if (str.equals(UIRelationshipConfig.ELEMENT_RECOMMEND_CHARGE)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1646924843:
                if (str.equals(UIRelationshipConfig.ELEMENT_NAVI_PANEL)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 2014772074:
                if (str.equals(UIRelationshipConfig.ELEMENT_TRAFFIC_EVENT)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 2123295441:
                if (str.equals(UIRelationshipConfig.ELEMENT_CROSS_2D)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2123295472:
                if (str.equals(UIRelationshipConfig.ELEMENT_CROSS_3D)) {
                    c = 1;
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
                return new Cross2DElement();
            case 1:
                return new Cross3DElement();
            case 2:
            case 3:
            case 4:
                return new PopElement(str);
            case 5:
                return new RecommendParkElement();
            case 6:
                return new OfflineElement();
            case 7:
                return new NgpElement();
            default:
                return new CommonElement(str);
        }
    }
}
