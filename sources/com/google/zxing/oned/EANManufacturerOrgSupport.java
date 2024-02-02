package com.google.zxing.oned;

import com.autonavi.gbl.map.layer.model.LayerPriorityType;
import com.autonavi.gbl.user.behavior.model.ConfigKey;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.xiaopeng.lib.apirouter.ClientConstants;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
final class EANManufacturerOrgSupport {
    private final List<int[]> ranges = new ArrayList();
    private final List<String> countryIdentifiers = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String lookupCountryIdentifier(String str) {
        int[] iArr;
        int i;
        initIfNeeded();
        int parseInt = Integer.parseInt(str.substring(0, 3));
        int size = this.ranges.size();
        for (int i2 = 0; i2 < size && parseInt >= (i = (iArr = this.ranges.get(i2))[0]); i2++) {
            if (iArr.length != 1) {
                i = iArr[1];
            }
            if (parseInt <= i) {
                return this.countryIdentifiers.get(i2);
            }
        }
        return null;
    }

    private void add(int[] iArr, String str) {
        this.ranges.add(iArr);
        this.countryIdentifiers.add(str);
    }

    private synchronized void initIfNeeded() {
        if (this.ranges.isEmpty()) {
            add(new int[]{0, 19}, "US/CA");
            add(new int[]{30, 39}, "US");
            add(new int[]{60, 139}, "US/CA");
            add(new int[]{300, 379}, "FR");
            add(new int[]{380}, "BG");
            add(new int[]{383}, "SI");
            add(new int[]{385}, "HR");
            add(new int[]{387}, "BA");
            add(new int[]{400, 440}, "DE");
            add(new int[]{450, 459}, "JP");
            add(new int[]{460, MarkUtils.MARKER_ID_CRUISE_TRAFFIC}, "RU");
            add(new int[]{471}, "TW");
            add(new int[]{MarkUtils.MARKER_ID_ETA_EVENT}, "EE");
            add(new int[]{475}, "LV");
            add(new int[]{476}, "AZ");
            add(new int[]{477}, "LT");
            add(new int[]{478}, "UZ");
            add(new int[]{479}, "LK");
            add(new int[]{MarkUtils.MARKER_ID_BLOCK_EVENT}, "PH");
            add(new int[]{481}, "BY");
            add(new int[]{482}, "UA");
            add(new int[]{MarkUtils.MARKER_ID_GUIDE_EVENT}, "MD");
            add(new int[]{MarkUtils.MARKER_ID_RECOMMEND_CHARGE_FREQUENT}, "AM");
            add(new int[]{MarkUtils.MARKER_ID_RECOMMEND_CHARGE_AROUND_XP}, "GE");
            add(new int[]{MarkUtils.MARKER_ID_RECOMMEND_CHARGE_AROUND_FAST}, "KZ");
            add(new int[]{MarkUtils.MARKER_ID_CAR_NAVIGATION_EAGLEYE}, "HK");
            add(new int[]{MarkUtils.MARKER_ID_CAR_EAGLEYE_END, MarkUtils.MARKER_ID_ROUTE_CHARGE_FOCUS_SELECT_REACHABLE}, "JP");
            add(new int[]{500, 509}, "GB");
            add(new int[]{520}, "GR");
            add(new int[]{BLParams.GuideOverlayTypeIntervalCamera}, ExpandedProductParsedResult.POUND);
            add(new int[]{BLParams.GuideOverlayTypeVectorCross}, "CY");
            add(new int[]{BLParams.GuideOverlayTypeBuilding}, "MK");
            add(new int[]{BLParams.GuideOverlayTypeETAEvent}, "MT");
            add(new int[]{539}, "IE");
            add(new int[]{540, 549}, "BE/LU");
            add(new int[]{560}, "PT");
            add(new int[]{569}, "IS");
            add(new int[]{570, 579}, "DK");
            add(new int[]{590}, "PL");
            add(new int[]{594}, "RO");
            add(new int[]{599}, "HU");
            add(new int[]{600, 601}, "ZA");
            add(new int[]{603}, "GH");
            add(new int[]{608}, "BH");
            add(new int[]{609}, "MU");
            add(new int[]{611}, "MA");
            add(new int[]{ConfigKey.ConfigKeyRealTrafficShare}, "DZ");
            add(new int[]{616}, "KE");
            add(new int[]{618}, "CI");
            add(new int[]{619}, "TN");
            add(new int[]{621}, "SY");
            add(new int[]{622}, "EG");
            add(new int[]{624}, "LY");
            add(new int[]{625}, "JO");
            add(new int[]{626}, "IR");
            add(new int[]{627}, "KW");
            add(new int[]{628}, "SA");
            add(new int[]{629}, "AE");
            add(new int[]{640, 649}, "FI");
            add(new int[]{690, 695}, "CN");
            add(new int[]{700, 709}, "NO");
            add(new int[]{729}, "IL");
            add(new int[]{730, 739}, "SE");
            add(new int[]{740}, "GT");
            add(new int[]{741}, "SV");
            add(new int[]{742}, "HN");
            add(new int[]{743}, "NI");
            add(new int[]{744}, "CR");
            add(new int[]{745}, "PA");
            add(new int[]{746}, "DO");
            add(new int[]{LayerPriorityType.LayerPriorityCruiseCongestionPrompt}, "MX");
            add(new int[]{754, 755}, "CA");
            add(new int[]{759}, "VE");
            add(new int[]{760, 769}, "CH");
            add(new int[]{BLParams.RouteOverlayCruise}, "CO");
            add(new int[]{BLParams.RouteOverlayCompare}, "UY");
            add(new int[]{BLParams.RouteOverlayTrafficBlockTips}, "PE");
            add(new int[]{BLParams.RouteOverlayTrafficJamLine}, "BO");
            add(new int[]{BLParams.RouteOverlayRangeOnMap}, "AR");
            add(new int[]{780}, "CL");
            add(new int[]{784}, "PY");
            add(new int[]{785}, "PE");
            add(new int[]{786}, "EC");
            add(new int[]{789, 790}, "BR");
            add(new int[]{800, 839}, "IT");
            add(new int[]{840, 849}, "ES");
            add(new int[]{850}, "CU");
            add(new int[]{858}, "SK");
            add(new int[]{859}, "CZ");
            add(new int[]{860}, "YU");
            add(new int[]{865}, "MN");
            add(new int[]{867}, "KP");
            add(new int[]{868, 869}, "TR");
            add(new int[]{870, 879}, "NL");
            add(new int[]{880}, "KR");
            add(new int[]{885}, "TH");
            add(new int[]{888}, "SG");
            add(new int[]{890}, "IN");
            add(new int[]{893}, "VN");
            add(new int[]{896}, "PK");
            add(new int[]{899}, ClientConstants.TRANSACT.ID);
            add(new int[]{900, 919}, "AT");
            add(new int[]{930, 939}, "AU");
            add(new int[]{940, 949}, "AZ");
            add(new int[]{955}, "MY");
            add(new int[]{958}, "MO");
        }
    }
}
