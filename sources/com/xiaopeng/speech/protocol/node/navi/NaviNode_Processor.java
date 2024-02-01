package com.xiaopeng.speech.protocol.node.navi;

import com.xiaopeng.speech.annotation.ICommandProcessor;
import com.xiaopeng.speech.protocol.event.NaviEvent;
/* loaded from: classes3.dex */
public class NaviNode_Processor implements ICommandProcessor {
    private NaviNode mTarget;

    public NaviNode_Processor(NaviNode naviNode) {
        this.mTarget = naviNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void performCommand(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -2136970098:
                if (str.equals("command://navi.control.close")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -2132799004:
                if (str.equals("command://navi.drive.radar.route")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case -2121968904:
                if (str.equals("command://navi.control.start")) {
                    c = '1';
                    break;
                }
                c = 65535;
                break;
            case -1987448085:
                if (str.equals("command://navi.search.close")) {
                    c = '&';
                    break;
                }
                c = 65535;
                break;
            case -1976299101:
                if (str.equals(NaviEvent.CONTROL_NAVI_SEARCH_ON_WAY)) {
                    c = 's';
                    break;
                }
                c = 65535;
                break;
            case -1920967676:
                if (str.equals(NaviEvent.CONTROL_CHARGE_SERVICE_OPEN)) {
                    c = 'X';
                    break;
                }
                c = 65535;
                break;
            case -1909621251:
                if (str.equals(NaviEvent.AUTO_REROUTE_ASK_FIRST)) {
                    c = 'O';
                    break;
                }
                c = 65535;
                break;
            case -1907058252:
                if (str.equals("native://navi.control.charge.close")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1892218233:
                if (str.equals(NaviEvent.CONTROL_DISPLAY_DASHBOARD_2D_HEAD_UP)) {
                    c = 'j';
                    break;
                }
                c = 65535;
                break;
            case -1775506535:
                if (str.equals(NaviEvent.MOVE_NAV_METRE_SET)) {
                    c = 'K';
                    break;
                }
                c = 65535;
                break;
            case -1667606279:
                if (str.equals("command://navi.map.zoomin.max")) {
                    c = '+';
                    break;
                }
                c = 65535;
                break;
            case -1667539314:
                if (str.equals(NaviEvent.AUTO_REROUTE_NEVER)) {
                    c = 'P';
                    break;
                }
                c = 65535;
                break;
            case -1657836062:
                if (str.equals(NaviEvent.CONTROL_DISPLAY_3D_HEAD_UP)) {
                    c = 'i';
                    break;
                }
                c = 65535;
                break;
            case -1582358593:
                if (str.equals(NaviEvent.LIST_ITEM_SELECTED)) {
                    c = 'V';
                    break;
                }
                c = 65535;
                break;
            case -1518898323:
                if (str.equals("command://navi.control.overview.close")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1475394262:
                if (str.equals("command://navi.drive.avoid.charge")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1467020709:
                if (str.equals("command://navi.ribbon.map.open")) {
                    c = 'D';
                    break;
                }
                c = 65535;
                break;
            case -1398319899:
                if (str.equals(NaviEvent.CONTROL_NAVI_SEARCH_FILTER)) {
                    c = 't';
                    break;
                }
                c = 65535;
                break;
            case -1380219901:
                if (str.equals("command://navi.map.zoomin")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1374493260:
                if (str.equals(NaviEvent.CONTROL_REALTIME_TRAFFIC_OFF)) {
                    c = 'l';
                    break;
                }
                c = 65535;
                break;
            case -1361583363:
                if (str.equals("native://navi.select.route.count")) {
                    c = '?';
                    break;
                }
                c = 65535;
                break;
            case -1355829822:
                if (str.equals(NaviEvent.CONTROL_REALTIME_TRAFFIC)) {
                    c = 'm';
                    break;
                }
                c = 65535;
                break;
            case -1316967297:
                if (str.equals("native://navi.control.settings.open")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1294433002:
                if (str.equals(NaviEvent.CONTROL_DRIVE_CHARGE_LESS)) {
                    c = '`';
                    break;
                }
                c = 65535;
                break;
            case -1274994428:
                if (str.equals("command://navi.control.vol.on")) {
                    c = '7';
                    break;
                }
                c = 65535;
                break;
            case -1177374369:
                if (str.equals(NaviEvent.CONTROL_SPEECH_STANDARD)) {
                    c = 'Y';
                    break;
                }
                c = 65535;
                break;
            case -1169768037:
                if (str.equals("native://navi.navigating.get")) {
                    c = '!';
                    break;
                }
                c = 65535;
                break;
            case -1141056686:
                if (str.equals("command://navi.drive.highway.first")) {
                    c = ' ';
                    break;
                }
                c = 65535;
                break;
            case -1139173622:
                if (str.equals(NaviEvent.CONTROL_SMART_CHARGING_ROUTE)) {
                    c = '\\';
                    break;
                }
                c = 65535;
                break;
            case -1121697225:
                if (str.equals("native://navi.address.get")) {
                    c = '.';
                    break;
                }
                c = 65535;
                break;
            case -982285267:
                if (str.equals("command://navi.drive.avoid.controls.off")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -977315249:
                if (str.equals("command://navi.control.speech.eye")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case -957206192:
                if (str.equals("command://navi.control.speech.eye.off")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case -873701781:
                if (str.equals("command://navi.parking.select")) {
                    c = ':';
                    break;
                }
                c = 65535;
                break;
            case -870121750:
                if (str.equals("command://navi.control.vol.off")) {
                    c = '8';
                    break;
                }
                c = 65535;
                break;
            case -793405345:
                if (str.equals("command://navi.drive.highway.no")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case -780474528:
                if (str.equals("command://navi.drive.highway.no.off")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case -741372363:
                if (str.equals("command://navi.control.overview.open")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -735619553:
                if (str.equals("command://navi.address.pending.route")) {
                    c = '/';
                    break;
                }
                c = 65535;
                break;
            case -730028907:
                if (str.equals(NaviEvent.CONTROL_BRIDGE_3D_MAP_OFF)) {
                    c = 'q';
                    break;
                }
                c = 65535;
                break;
            case -682936661:
                if (str.equals("command://navi.drive.avoid.charge.off")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -631594857:
                if (str.equals(NaviEvent.CONTROL_DRIVE_CHARGE_LESS_OFF)) {
                    c = 'a';
                    break;
                }
                c = 65535;
                break;
            case -629123846:
                if (str.equals("command://navi.route.select")) {
                    c = '=';
                    break;
                }
                c = 65535;
                break;
            case -585100656:
                if (str.equals("native://navi.waypoint.search")) {
                    c = '@';
                    break;
                }
                c = 65535;
                break;
            case -573495894:
                if (str.equals("command://navi.control.history")) {
                    c = 'F';
                    break;
                }
                c = 65535;
                break;
            case -550413506:
                if (str.equals("command://navi.side.road")) {
                    c = '(';
                    break;
                }
                c = 65535;
                break;
            case -483469262:
                if (str.equals("command://navi.park.recommend.off")) {
                    c = 'I';
                    break;
                }
                c = 65535;
                break;
            case -483373155:
                if (str.equals("command://navi.drive.avoid.congestion")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -471273732:
                if (str.equals(NaviEvent.MAP_SHOW_SET)) {
                    c = 'Q';
                    break;
                }
                c = 65535;
                break;
            case -463743293:
                if (str.equals("command://navi.confirm.ok")) {
                    c = ';';
                    break;
                }
                c = 65535;
                break;
            case -432687108:
                if (str.equals("command://navi.control.smart.scale.off")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case -336305704:
                if (str.equals(NaviEvent.CONTROL_POI_DETAILS_FAVORITE_ADD)) {
                    c = 'R';
                    break;
                }
                c = 65535;
                break;
            case -336302782:
                if (str.equals(NaviEvent.CONTROL_POI_DETAILS_FAVORITE_DEL)) {
                    c = 'S';
                    break;
                }
                c = 65535;
                break;
            case -287805857:
                if (str.equals("command://navi.control.waypoint.start")) {
                    c = 'A';
                    break;
                }
                c = 65535;
                break;
            case -264073182:
                if (str.equals(NaviEvent.CONTROL_DRIVE_HIGHROAD_FIRST_OFF)) {
                    c = 'c';
                    break;
                }
                c = 65535;
                break;
            case -257936759:
                if (str.equals("command://navi.control.security.remind")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case -245623106:
                if (str.equals("command://navi.control.display.car")) {
                    c = '5';
                    break;
                }
                c = 65535;
                break;
            case -231766597:
                if (str.equals(NaviEvent.CONTROL_SPEECH_MUTE)) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case -60216351:
                if (str.equals("command://navi.confirm.cancel")) {
                    c = '<';
                    break;
                }
                c = 65535;
                break;
            case 30697630:
                if (str.equals("command://navi.control.road.ahead.off")) {
                    c = '*';
                    break;
                }
                c = 65535;
                break;
            case 149618401:
                if (str.equals(NaviEvent.CONTROL_DISPLAY_2D_HEAD_UP)) {
                    c = 'h';
                    break;
                }
                c = 65535;
                break;
            case 162862128:
                if (str.equals("command://navi.map.zoomout")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 189975919:
                if (str.equals("command://navi.control.display.north")) {
                    c = '4';
                    break;
                }
                c = 65535;
                break;
            case 219354725:
                if (str.equals("command://navi.drive.radar.route.off")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 235759773:
                if (str.equals("command://navi.control.road.ahead")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case 255171078:
                if (str.equals("command://navi.control.speech.general")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 295754221:
                if (str.equals("native://navi.route.nearby.search")) {
                    c = '9';
                    break;
                }
                c = 65535;
                break;
            case 304625684:
                if (str.equals(NaviEvent.CONTROL_BRIDGE_3D_MAP)) {
                    c = 'p';
                    break;
                }
                c = 65535;
                break;
            case 321574903:
                if (str.equals(NaviEvent.CONTROL_SPEECH_CRUISE)) {
                    c = 'Z';
                    break;
                }
                c = 65535;
                break;
            case 338160499:
                if (str.equals("command://navi.control.speech.detail")) {
                    c = '3';
                    break;
                }
                c = 65535;
                break;
            case 354485006:
                if (str.equals("native://navi.control.charge.open")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 370094847:
                if (str.equals(NaviEvent.CONTROL_SMART_RECOMMEND_OFF)) {
                    c = '_';
                    break;
                }
                c = 65535;
                break;
            case 398795396:
                if (str.equals("command://navi.map.overview")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 431524135:
                if (str.equals("command://navi.control.speech.super.simple")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 560836717:
                if (str.equals(NaviEvent.ALERTS_PREFERENCE_SET)) {
                    c = 'L';
                    break;
                }
                c = 65535;
                break;
            case 592257019:
                if (str.equals("command://navi.scale.level.set")) {
                    c = 'J';
                    break;
                }
                c = 65535;
                break;
            case 595294600:
                if (str.equals(NaviEvent.CONTROL_DISPLAY_DASHBOARD_3D_HEAD_UP)) {
                    c = 'k';
                    break;
                }
                c = 65535;
                break;
            case 631501345:
                if (str.equals(NaviEvent.CONTROL_DRIVE_HIGHROAD_FIRST)) {
                    c = 'b';
                    break;
                }
                c = 65535;
                break;
            case 757845918:
                if (str.equals("command://navi.drive.avoid.congestion.off")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 771097812:
                if (str.equals("command://navi.control.speech.simple")) {
                    c = '2';
                    break;
                }
                c = 65535;
                break;
            case 784930555:
                if (str.equals("command://navi.control.smart.scale")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 838195437:
                if (str.equals("command://navi.road.info.close")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 858683573:
                if (str.equals("command://navi.road.info.open")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 879979243:
                if (str.equals(NaviEvent.CONTROL_TRAFFIC_INCIDENT)) {
                    c = 'n';
                    break;
                }
                c = 65535;
                break;
            case 950634676:
                if (str.equals(NaviEvent.CONTROL_HISTORY_CLOSE)) {
                    c = 'U';
                    break;
                }
                c = 65535;
                break;
            case 1038102608:
                if (str.equals(NaviEvent.CONTROL_COMMUTER_ROUTE_SHOW)) {
                    c = 'f';
                    break;
                }
                c = 65535;
                break;
            case 1047011356:
                if (str.equals("command://navi.main.road")) {
                    c = '\'';
                    break;
                }
                c = 65535;
                break;
            case 1082133391:
                if (str.equals("command://navi.address.set")) {
                    c = '0';
                    break;
                }
                c = 65535;
                break;
            case 1131538013:
                if (str.equals(NaviEvent.CONTROL_TRAFFIC_INCIDENT_OFF)) {
                    c = 'o';
                    break;
                }
                c = 65535;
                break;
            case 1137052564:
                if (str.equals("command://navi.map.zoomout.min")) {
                    c = ',';
                    break;
                }
                c = 65535;
                break;
            case 1231219392:
                if (str.equals(NaviEvent.CONTROL_COMMUTER_ROUTE_SHOW_OFF)) {
                    c = 'g';
                    break;
                }
                c = 65535;
                break;
            case 1247853748:
                if (str.equals("native://navi.settings.info")) {
                    c = 'G';
                    break;
                }
                c = 65535;
                break;
            case 1255072401:
                if (str.equals("native://navi.poi.search")) {
                    c = '\"';
                    break;
                }
                c = 65535;
                break;
            case 1278482280:
                if (str.equals(NaviEvent.CONTROL_DRIVE_TIME_FIRST)) {
                    c = 'd';
                    break;
                }
                c = 65535;
                break;
            case 1356046610:
                if (str.equals("native://navi.nearby.search")) {
                    c = '-';
                    break;
                }
                c = 65535;
                break;
            case 1358906657:
                if (str.equals(NaviEvent.CONTROL_NAVI_SEARCH)) {
                    c = 'r';
                    break;
                }
                c = 65535;
                break;
            case 1368824568:
                if (str.equals(NaviEvent.CONTROL_SPEECH_CRUISE_OFF)) {
                    c = '[';
                    break;
                }
                c = 65535;
                break;
            case 1478072459:
                if (str.equals(NaviEvent.CONTROL_SMART_CHARGING_ROUTE_OFF)) {
                    c = ']';
                    break;
                }
                c = 65535;
                break;
            case 1545648617:
                if (str.equals(NaviEvent.CONTROL_DRIVE_TIME_FIRST_OFF)) {
                    c = 'e';
                    break;
                }
                c = 65535;
                break;
            case 1631355563:
                if (str.equals(NaviEvent.AVOID_ROUTE_SET)) {
                    c = 'M';
                    break;
                }
                c = 65535;
                break;
            case 1632960358:
                if (str.equals("command://navi.small.map.close")) {
                    c = 'C';
                    break;
                }
                c = 65535;
                break;
            case 1687314057:
                if (str.equals(NaviEvent.AUTO_REROUTE_BETTER_ROUTE)) {
                    c = 'N';
                    break;
                }
                c = 65535;
                break;
            case 1735961708:
                if (str.equals("native://navi.select.parking.count")) {
                    c = '>';
                    break;
                }
                c = 65535;
                break;
            case 1755806727:
                if (str.equals("command://navi.ribbon.map.close")) {
                    c = 'E';
                    break;
                }
                c = 65535;
                break;
            case 1759009930:
                if (str.equals("command://navi.control.security.remind.off")) {
                    c = '#';
                    break;
                }
                c = 65535;
                break;
            case 1777247148:
                if (str.equals("command://navi.drive.avoid.controls")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1793190503:
                if (str.equals("command://navi.control.display.3d")) {
                    c = '6';
                    break;
                }
                c = 65535;
                break;
            case 1832000151:
                if (str.equals(NaviEvent.CONTROL_SETTINGS_CLOSE)) {
                    c = 'T';
                    break;
                }
                c = 65535;
                break;
            case 1854152476:
                if (str.equals("command://navi.small.map.open")) {
                    c = 'B';
                    break;
                }
                c = 65535;
                break;
            case 1890678995:
                if (str.equals("command://navi.drive.highway.first.off")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1926343575:
                if (str.equals(NaviEvent.CONTROL_GAODE_ACCOUNT_BING_PAGE_OPEN)) {
                    c = 'W';
                    break;
                }
                c = 65535;
                break;
            case 1961191760:
                if (str.equals("command://navi.control.favorite.close")) {
                    c = ')';
                    break;
                }
                c = 65535;
                break;
            case 1963423819:
                if (str.equals("command://navi.enter.find.path")) {
                    c = '$';
                    break;
                }
                c = 65535;
                break;
            case 2040031459:
                if (str.equals("command://navi.exit.find.path")) {
                    c = '%';
                    break;
                }
                c = 65535;
                break;
            case 2062614204:
                if (str.equals("command://navi.park.recommend.on")) {
                    c = 'H';
                    break;
                }
                c = 65535;
                break;
            case 2068220798:
                if (str.equals(NaviEvent.CONTROL_SMART_RECOMMEND)) {
                    c = '^';
                    break;
                }
                c = 65535;
                break;
            case 2141835250:
                if (str.equals("command://navi.control.favorite.open")) {
                    c = '\b';
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
                this.mTarget.onControlClose(str, str2);
                return;
            case 1:
                this.mTarget.onMapZoomIn(str, str2);
                return;
            case 2:
                this.mTarget.onMapZoomOut(str, str2);
                return;
            case 3:
                this.mTarget.onOpenTraffic(str, str2);
                return;
            case 4:
                this.mTarget.onCloseTraffic(str, str2);
                return;
            case 5:
                this.mTarget.onControlOverviewOpen(str, str2);
                return;
            case 6:
                this.mTarget.onControlOverviewClose(str, str2);
                return;
            case 7:
                this.mTarget.onMapOverview(str, str2);
                return;
            case '\b':
                this.mTarget.onControlFavoriteOpen(str, str2);
                return;
            case '\t':
                this.mTarget.onControlSettingsOpen(str, str2);
                return;
            case '\n':
                this.mTarget.onControlChargeOpen(str, str2);
                return;
            case 11:
                this.mTarget.onControlChargeClose(str, str2);
                return;
            case '\f':
                this.mTarget.onDriveAvoidCongestion(str, str2);
                return;
            case '\r':
                this.mTarget.onDriveAvoidCongestionOff(str, str2);
                return;
            case 14:
                this.mTarget.onDriveAvoidCharge(str, str2);
                return;
            case 15:
                this.mTarget.onDriveAvoidChargeOff(str, str2);
                return;
            case 16:
                this.mTarget.onDriveHighwayFirstOff(str, str2);
                return;
            case 17:
                this.mTarget.onDriveAvoidControls(str, str2);
                return;
            case 18:
                this.mTarget.onDriveAvoidControlsOff(str, str2);
                return;
            case 19:
                this.mTarget.onDriveRadarRoute(str, str2);
                return;
            case 20:
                this.mTarget.onDriveRadarRouteOff(str, str2);
                return;
            case 21:
                this.mTarget.onControlSpeechMute(str, str2);
                return;
            case 22:
                this.mTarget.onControlSpeechSuperSimple(str, str2);
                return;
            case 23:
                this.mTarget.onControlSpeechGeneral(str, str2);
                return;
            case 24:
                this.mTarget.onControlSpeechEye(str, str2);
                return;
            case 25:
                this.mTarget.onControlSpeechEyeOff(str, str2);
                return;
            case 26:
                this.mTarget.onControlSmartScale(str, str2);
                return;
            case 27:
                this.mTarget.onControlSmartScaleOff(str, str2);
                return;
            case 28:
                this.mTarget.onControlSecurityRemind(str, str2);
                return;
            case 29:
                this.mTarget.onControlRoadAhead(str, str2);
                return;
            case 30:
                this.mTarget.onDriveHighwayNo(str, str2);
                return;
            case 31:
                this.mTarget.onDriveHighwayNoOff(str, str2);
                return;
            case ' ':
                this.mTarget.onDriveHighwayFirst(str, str2);
                return;
            case '!':
                this.mTarget.onNavigatingGet(str, str2);
                return;
            case '\"':
                this.mTarget.onPoiSearch(str, str2);
                return;
            case '#':
                this.mTarget.onControlSecurityRemindOff(str, str2);
                return;
            case '$':
                this.mTarget.onMapEnterFindPath(str, str2);
                return;
            case '%':
                this.mTarget.onMapExitFindPath(str, str2);
                return;
            case '&':
                this.mTarget.onSearchClose(str, str2);
                return;
            case '\'':
                this.mTarget.onMainRoad(str, str2);
                return;
            case '(':
                this.mTarget.onSideRoad(str, str2);
                return;
            case ')':
                this.mTarget.onControlFavoriteClose(str, str2);
                return;
            case '*':
                this.mTarget.onControlRoadAheadOff(str, str2);
                return;
            case '+':
                this.mTarget.onMapZoominMax(str, str2);
                return;
            case ',':
                this.mTarget.onMapZoomoutMin(str, str2);
                return;
            case '-':
                this.mTarget.onNearbySearch(str, str2);
                return;
            case '.':
                this.mTarget.onAddressGet(str, str2);
                return;
            case '/':
                this.mTarget.onAddressPendingRoute(str, str2);
                return;
            case '0':
                this.mTarget.onAddressSet(str, str2);
                return;
            case '1':
                this.mTarget.onControlStart(str, str2);
                return;
            case '2':
                this.mTarget.onControlSpeechSimple(str, str2);
                return;
            case '3':
                this.mTarget.onControlSpeechDetail(str, str2);
                return;
            case '4':
                this.mTarget.onControlDisPlayNorth(str, str2);
                return;
            case '5':
                this.mTarget.onControlDisPlayCar(str, str2);
                return;
            case '6':
                this.mTarget.onControlDisplay3D(str, str2);
                return;
            case '7':
                this.mTarget.onControlVolOn(str, str2);
                return;
            case '8':
                this.mTarget.onControlVolOff(str, str2);
                return;
            case '9':
                this.mTarget.onRouteNearbySearch(str, str2);
                return;
            case ':':
                this.mTarget.onParkingSelect(str, str2);
                return;
            case ';':
                this.mTarget.onConfirmOk(str, str2);
                return;
            case '<':
                this.mTarget.onConfirmCancel(str, str2);
                return;
            case '=':
                this.mTarget.onRouteSelect(str, str2);
                return;
            case '>':
                this.mTarget.onSelectParkingCount(str, str2);
                return;
            case '?':
                this.mTarget.onSelectRouteCount(str, str2);
                return;
            case '@':
                this.mTarget.onWaypointSearch(str, str2);
                return;
            case 'A':
                this.mTarget.onControlWaypointStart(str, str2);
                return;
            case 'B':
                this.mTarget.onControlOpenSmallMap(str, str2);
                return;
            case 'C':
                this.mTarget.onControlCloseSmallMap(str, str2);
                return;
            case 'D':
                this.mTarget.onControlOpenRibbonMap(str, str2);
                return;
            case 'E':
                this.mTarget.onControlCloseRibbonMap(str, str2);
                return;
            case 'F':
                this.mTarget.onControlHistory(str, str2);
                return;
            case 'G':
                this.mTarget.onGetSettingsInfo(str, str2);
                return;
            case 'H':
                this.mTarget.onControlParkRecommendOn(str, str2);
                return;
            case 'I':
                this.mTarget.onControlParkRecommendOff(str, str2);
                return;
            case 'J':
                this.mTarget.onSetScaleLevel(str, str2);
                return;
            case 'K':
                this.mTarget.onSetOritentionMetre(str, str2);
                return;
            case 'L':
                this.mTarget.onAlertsPreferenceSet(str, str2);
                return;
            case 'M':
                this.mTarget.onAvoidRouteSet(str, str2);
                return;
            case 'N':
                this.mTarget.onAutoRerouteBetterRoute(str, str2);
                return;
            case 'O':
                this.mTarget.onAutoRerouteAskFirst(str, str2);
                return;
            case 'P':
                this.mTarget.onAutoRerouteNever(str, str2);
                return;
            case 'Q':
                this.mTarget.onMapShowSet(str, str2);
                return;
            case 'R':
                this.mTarget.onPoiDetailsFavoriteAdd(str, str2);
                return;
            case 'S':
                this.mTarget.onPoiDetailsFavoriteDel(str, str2);
                return;
            case 'T':
                this.mTarget.onControlSettingsCLose(str, str2);
                return;
            case 'U':
                this.mTarget.onControlHistoryCLose(str, str2);
                return;
            case 'V':
                this.mTarget.onListItemSelected(str, str2);
                return;
            case 'W':
                this.mTarget.onControlGaodeAccountPageOpen(str, str2);
                return;
            case 'X':
                this.mTarget.onControlChargeServiceOpen(str, str2);
                return;
            case 'Y':
                this.mTarget.onControlSpeechStandard(str, str2);
                return;
            case 'Z':
                this.mTarget.onControlSpeechCruise(str, str2);
                return;
            case '[':
                this.mTarget.onControlSpeechCruiseOff(str, str2);
                return;
            case '\\':
                this.mTarget.onControlSmartChargingRoute(str, str2);
                return;
            case ']':
                this.mTarget.onControlSmartChargingRouteOff(str, str2);
                return;
            case '^':
                this.mTarget.onControlSmartRecommend(str, str2);
                return;
            case '_':
                this.mTarget.onControlSmartRecommendOff(str, str2);
                return;
            case '`':
                this.mTarget.onControlDriveChargeLess(str, str2);
                return;
            case 'a':
                this.mTarget.onControlDriveChargeLessOff(str, str2);
                return;
            case 'b':
                this.mTarget.onControlHighroadFirst(str, str2);
                return;
            case 'c':
                this.mTarget.onControlHighroadFirstOff(str, str2);
                return;
            case 'd':
                this.mTarget.onControlTimeFirst(str, str2);
                return;
            case 'e':
                this.mTarget.onControlTimeFirstOff(str, str2);
                return;
            case 'f':
                this.mTarget.onControlCommuterRouteShow(str, str2);
                return;
            case 'g':
                this.mTarget.onControlCommuterRouteShowOff(str, str2);
                return;
            case 'h':
                this.mTarget.onControlDisplay2DHeadUp(str, str2);
                return;
            case 'i':
                this.mTarget.onControlDisplay3DHeadUp(str, str2);
                return;
            case 'j':
                this.mTarget.onControlDashboardDisplay2DHeadUp(str, str2);
                return;
            case 'k':
                this.mTarget.onControlDashboardDisplay3DHeadUp(str, str2);
                return;
            case 'l':
                this.mTarget.onControlRealtimeTrafficOff(str, str2);
                return;
            case 'm':
                this.mTarget.onControlRealtimeTraffic(str, str2);
                return;
            case 'n':
                this.mTarget.onControlTrafficIncident(str, str2);
                return;
            case 'o':
                this.mTarget.onControlTrafficIncidentOff(str, str2);
                return;
            case 'p':
                this.mTarget.onControlBridge3DMap(str, str2);
                return;
            case 'q':
                this.mTarget.onControlBridge3DMapOff(str, str2);
                return;
            case 'r':
                this.mTarget.onNaviSearch(str, str2);
                return;
            case 's':
                this.mTarget.onNaviSearchOnWay(str, str2);
                return;
            case 't':
                this.mTarget.onNaviSearchFilter(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] getSubscribeEvents() {
        return new String[]{"command://navi.control.close", "command://navi.map.zoomin", "command://navi.map.zoomout", "command://navi.road.info.open", "command://navi.road.info.close", "command://navi.control.overview.open", "command://navi.control.overview.close", "command://navi.map.overview", "command://navi.control.favorite.open", "native://navi.control.settings.open", "native://navi.control.charge.open", "native://navi.control.charge.close", "command://navi.drive.avoid.congestion", "command://navi.drive.avoid.congestion.off", "command://navi.drive.avoid.charge", "command://navi.drive.avoid.charge.off", "command://navi.drive.highway.first.off", "command://navi.drive.avoid.controls", "command://navi.drive.avoid.controls.off", "command://navi.drive.radar.route", "command://navi.drive.radar.route.off", NaviEvent.CONTROL_SPEECH_MUTE, "command://navi.control.speech.super.simple", "command://navi.control.speech.general", "command://navi.control.speech.eye", "command://navi.control.speech.eye.off", "command://navi.control.smart.scale", "command://navi.control.smart.scale.off", "command://navi.control.security.remind", "command://navi.control.road.ahead", "command://navi.drive.highway.no", "command://navi.drive.highway.no.off", "command://navi.drive.highway.first", "native://navi.navigating.get", "native://navi.poi.search", "command://navi.control.security.remind.off", "command://navi.enter.find.path", "command://navi.exit.find.path", "command://navi.search.close", "command://navi.main.road", "command://navi.side.road", "command://navi.control.favorite.close", "command://navi.control.road.ahead.off", "command://navi.map.zoomin.max", "command://navi.map.zoomout.min", "native://navi.nearby.search", "native://navi.address.get", "command://navi.address.pending.route", "command://navi.address.set", "command://navi.control.start", "command://navi.control.speech.simple", "command://navi.control.speech.detail", "command://navi.control.display.north", "command://navi.control.display.car", "command://navi.control.display.3d", "command://navi.control.vol.on", "command://navi.control.vol.off", "native://navi.route.nearby.search", "command://navi.parking.select", "command://navi.confirm.ok", "command://navi.confirm.cancel", "command://navi.route.select", "native://navi.select.parking.count", "native://navi.select.route.count", "native://navi.waypoint.search", "command://navi.control.waypoint.start", "command://navi.small.map.open", "command://navi.small.map.close", "command://navi.ribbon.map.open", "command://navi.ribbon.map.close", "command://navi.control.history", "native://navi.settings.info", "command://navi.park.recommend.on", "command://navi.park.recommend.off", "command://navi.scale.level.set", NaviEvent.MOVE_NAV_METRE_SET, NaviEvent.ALERTS_PREFERENCE_SET, NaviEvent.AVOID_ROUTE_SET, NaviEvent.AUTO_REROUTE_BETTER_ROUTE, NaviEvent.AUTO_REROUTE_ASK_FIRST, NaviEvent.AUTO_REROUTE_NEVER, NaviEvent.MAP_SHOW_SET, NaviEvent.CONTROL_POI_DETAILS_FAVORITE_ADD, NaviEvent.CONTROL_POI_DETAILS_FAVORITE_DEL, NaviEvent.CONTROL_SETTINGS_CLOSE, NaviEvent.CONTROL_HISTORY_CLOSE, NaviEvent.LIST_ITEM_SELECTED, NaviEvent.CONTROL_GAODE_ACCOUNT_BING_PAGE_OPEN, NaviEvent.CONTROL_CHARGE_SERVICE_OPEN, NaviEvent.CONTROL_SPEECH_STANDARD, NaviEvent.CONTROL_SPEECH_CRUISE, NaviEvent.CONTROL_SPEECH_CRUISE_OFF, NaviEvent.CONTROL_SMART_CHARGING_ROUTE, NaviEvent.CONTROL_SMART_CHARGING_ROUTE_OFF, NaviEvent.CONTROL_SMART_RECOMMEND, NaviEvent.CONTROL_SMART_RECOMMEND_OFF, NaviEvent.CONTROL_DRIVE_CHARGE_LESS, NaviEvent.CONTROL_DRIVE_CHARGE_LESS_OFF, NaviEvent.CONTROL_DRIVE_HIGHROAD_FIRST, NaviEvent.CONTROL_DRIVE_HIGHROAD_FIRST_OFF, NaviEvent.CONTROL_DRIVE_TIME_FIRST, NaviEvent.CONTROL_DRIVE_TIME_FIRST_OFF, NaviEvent.CONTROL_COMMUTER_ROUTE_SHOW, NaviEvent.CONTROL_COMMUTER_ROUTE_SHOW_OFF, NaviEvent.CONTROL_DISPLAY_2D_HEAD_UP, NaviEvent.CONTROL_DISPLAY_3D_HEAD_UP, NaviEvent.CONTROL_DISPLAY_DASHBOARD_2D_HEAD_UP, NaviEvent.CONTROL_DISPLAY_DASHBOARD_3D_HEAD_UP, NaviEvent.CONTROL_REALTIME_TRAFFIC_OFF, NaviEvent.CONTROL_REALTIME_TRAFFIC, NaviEvent.CONTROL_TRAFFIC_INCIDENT, NaviEvent.CONTROL_TRAFFIC_INCIDENT_OFF, NaviEvent.CONTROL_BRIDGE_3D_MAP, NaviEvent.CONTROL_BRIDGE_3D_MAP_OFF, NaviEvent.CONTROL_NAVI_SEARCH, NaviEvent.CONTROL_NAVI_SEARCH_ON_WAY, NaviEvent.CONTROL_NAVI_SEARCH_FILTER};
    }
}
