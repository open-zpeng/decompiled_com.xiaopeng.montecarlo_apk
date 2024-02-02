package com.xiaopeng.montecarlo.appengine;

import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.navcore.speech.aios.NaviModel;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes2.dex */
public class SpeechOverallObserver implements IServicePublisher {
    private static final L.Tag TAG = new L.Tag("SpeechOverallObserver");

    @Publish
    public void onEvent(final String str, final String str2) {
        if (CarFeatureManager.INSTANCE.isApirouterGlobalVoice()) {
            L.Tag tag = TAG;
            L.i(tag, "onEvent event:" + str + ",data:" + str2);
            WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.appengine.SpeechOverallObserver.1
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // java.lang.Runnable
                public void run() {
                    char c;
                    String str3 = str;
                    switch (str3.hashCode()) {
                        case -2136970098:
                            if (str3.equals("command://navi.control.close")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -2132799004:
                            if (str3.equals("command://navi.drive.radar.route")) {
                                c = 20;
                                break;
                            }
                            c = 65535;
                            break;
                        case -2121968904:
                            if (str3.equals("command://navi.control.start")) {
                                c = '0';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1987448085:
                            if (str3.equals("command://navi.search.close")) {
                                c = '\'';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1907058252:
                            if (str3.equals("native://navi.control.charge.close")) {
                                c = '\f';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1667606279:
                            if (str3.equals("command://navi.map.zoomin.max")) {
                                c = '*';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1518898323:
                            if (str3.equals("command://navi.control.overview.close")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1475394262:
                            if (str3.equals("command://navi.drive.avoid.charge")) {
                                c = 15;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1467020709:
                            if (str3.equals("command://navi.ribbon.map.open")) {
                                c = 'C';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1380219901:
                            if (str3.equals("command://navi.map.zoomin")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1361583363:
                            if (str3.equals("native://navi.select.route.count")) {
                                c = '>';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1316967297:
                            if (str3.equals("native://navi.control.settings.open")) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1274994428:
                            if (str3.equals("command://navi.control.vol.on")) {
                                c = '6';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1169768037:
                            if (str3.equals("native://navi.navigating.get")) {
                                c = '#';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1141056686:
                            if (str3.equals("command://navi.drive.highway.first")) {
                                c = '\"';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1121697225:
                            if (str3.equals("native://navi.address.get")) {
                                c = '-';
                                break;
                            }
                            c = 65535;
                            break;
                        case -982285267:
                            if (str3.equals("command://navi.drive.avoid.controls.off")) {
                                c = 19;
                                break;
                            }
                            c = 65535;
                            break;
                        case -977315249:
                            if (str3.equals("command://navi.control.speech.eye")) {
                                c = 24;
                                break;
                            }
                            c = 65535;
                            break;
                        case -957206192:
                            if (str3.equals("command://navi.control.speech.eye.off")) {
                                c = 25;
                                break;
                            }
                            c = 65535;
                            break;
                        case -873701781:
                            if (str3.equals("command://navi.parking.select")) {
                                c = '9';
                                break;
                            }
                            c = 65535;
                            break;
                        case -870121750:
                            if (str3.equals("command://navi.control.vol.off")) {
                                c = '7';
                                break;
                            }
                            c = 65535;
                            break;
                        case -793405345:
                            if (str3.equals("command://navi.drive.highway.no")) {
                                c = ' ';
                                break;
                            }
                            c = 65535;
                            break;
                        case -780474528:
                            if (str3.equals("command://navi.drive.highway.no.off")) {
                                c = '!';
                                break;
                            }
                            c = 65535;
                            break;
                        case -741372363:
                            if (str3.equals("command://navi.control.overview.open")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -735619553:
                            if (str3.equals("command://navi.address.pending.route")) {
                                c = '/';
                                break;
                            }
                            c = 65535;
                            break;
                        case -682936661:
                            if (str3.equals("command://navi.drive.avoid.charge.off")) {
                                c = 16;
                                break;
                            }
                            c = 65535;
                            break;
                        case -629123846:
                            if (str3.equals("command://navi.route.select")) {
                                c = '<';
                                break;
                            }
                            c = 65535;
                            break;
                        case -585100656:
                            if (str3.equals("native://navi.waypoint.search")) {
                                c = '?';
                                break;
                            }
                            c = 65535;
                            break;
                        case -573495894:
                            if (str3.equals("command://navi.control.history")) {
                                c = 'E';
                                break;
                            }
                            c = 65535;
                            break;
                        case -550413506:
                            if (str3.equals("command://navi.side.road")) {
                                c = ')';
                                break;
                            }
                            c = 65535;
                            break;
                        case -483469262:
                            if (str3.equals("command://navi.park.recommend.off")) {
                                c = 'H';
                                break;
                            }
                            c = 65535;
                            break;
                        case -483373155:
                            if (str3.equals("command://navi.drive.avoid.congestion")) {
                                c = '\r';
                                break;
                            }
                            c = 65535;
                            break;
                        case -463743293:
                            if (str3.equals("command://navi.confirm.ok")) {
                                c = ':';
                                break;
                            }
                            c = 65535;
                            break;
                        case -432687108:
                            if (str3.equals("command://navi.control.smart.scale.off")) {
                                c = 27;
                                break;
                            }
                            c = 65535;
                            break;
                        case -287805857:
                            if (str3.equals("command://navi.control.waypoint.start")) {
                                c = '@';
                                break;
                            }
                            c = 65535;
                            break;
                        case -257936759:
                            if (str3.equals("command://navi.control.security.remind")) {
                                c = 28;
                                break;
                            }
                            c = 65535;
                            break;
                        case -245623106:
                            if (str3.equals("command://navi.control.display.car")) {
                                c = '4';
                                break;
                            }
                            c = 65535;
                            break;
                        case -60216351:
                            if (str3.equals("command://navi.confirm.cancel")) {
                                c = ';';
                                break;
                            }
                            c = 65535;
                            break;
                        case 30697630:
                            if (str3.equals("command://navi.control.road.ahead.off")) {
                                c = 31;
                                break;
                            }
                            c = 65535;
                            break;
                        case 162862128:
                            if (str3.equals("command://navi.map.zoomout")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 189975919:
                            if (str3.equals("command://navi.control.display.north")) {
                                c = '3';
                                break;
                            }
                            c = 65535;
                            break;
                        case 219354725:
                            if (str3.equals("command://navi.drive.radar.route.off")) {
                                c = 21;
                                break;
                            }
                            c = 65535;
                            break;
                        case 235759773:
                            if (str3.equals("command://navi.control.road.ahead")) {
                                c = 30;
                                break;
                            }
                            c = 65535;
                            break;
                        case 255171078:
                            if (str3.equals("command://navi.control.speech.general")) {
                                c = 23;
                                break;
                            }
                            c = 65535;
                            break;
                        case 295754221:
                            if (str3.equals("native://navi.route.nearby.search")) {
                                c = '8';
                                break;
                            }
                            c = 65535;
                            break;
                        case 338160499:
                            if (str3.equals("command://navi.control.speech.detail")) {
                                c = '2';
                                break;
                            }
                            c = 65535;
                            break;
                        case 354485006:
                            if (str3.equals("native://navi.control.charge.open")) {
                                c = 11;
                                break;
                            }
                            c = 65535;
                            break;
                        case 398795396:
                            if (str3.equals("command://navi.map.overview")) {
                                c = 7;
                                break;
                            }
                            c = 65535;
                            break;
                        case 431524135:
                            if (str3.equals("command://navi.control.speech.super.simple")) {
                                c = 22;
                                break;
                            }
                            c = 65535;
                            break;
                        case 592257019:
                            if (str3.equals("command://navi.scale.level.set")) {
                                c = 'I';
                                break;
                            }
                            c = 65535;
                            break;
                        case 757845918:
                            if (str3.equals("command://navi.drive.avoid.congestion.off")) {
                                c = 14;
                                break;
                            }
                            c = 65535;
                            break;
                        case 771097812:
                            if (str3.equals("command://navi.control.speech.simple")) {
                                c = '1';
                                break;
                            }
                            c = 65535;
                            break;
                        case 784930555:
                            if (str3.equals("command://navi.control.smart.scale")) {
                                c = 26;
                                break;
                            }
                            c = 65535;
                            break;
                        case 838195437:
                            if (str3.equals("command://navi.road.info.close")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 858683573:
                            if (str3.equals("command://navi.road.info.open")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1047011356:
                            if (str3.equals("command://navi.main.road")) {
                                c = '(';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1082133391:
                            if (str3.equals("command://navi.address.set")) {
                                c = '.';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1137052564:
                            if (str3.equals("command://navi.map.zoomout.min")) {
                                c = '+';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1247853748:
                            if (str3.equals("native://navi.settings.info")) {
                                c = 'F';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1255072401:
                            if (str3.equals("native://navi.poi.search")) {
                                c = '$';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1356046610:
                            if (str3.equals("native://navi.nearby.search")) {
                                c = ',';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1632960358:
                            if (str3.equals("command://navi.small.map.close")) {
                                c = 'B';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1735961708:
                            if (str3.equals("native://navi.select.parking.count")) {
                                c = '=';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1755806727:
                            if (str3.equals("command://navi.ribbon.map.close")) {
                                c = 'D';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1759009930:
                            if (str3.equals("command://navi.control.security.remind.off")) {
                                c = 29;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1777247148:
                            if (str3.equals("command://navi.drive.avoid.controls")) {
                                c = 18;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1793190503:
                            if (str3.equals("command://navi.control.display.3d")) {
                                c = '5';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1854152476:
                            if (str3.equals("command://navi.small.map.open")) {
                                c = 'A';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1890678995:
                            if (str3.equals("command://navi.drive.highway.first.off")) {
                                c = 17;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1961191760:
                            if (str3.equals("command://navi.control.favorite.close")) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1963423819:
                            if (str3.equals("command://navi.enter.find.path")) {
                                c = '%';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2040031459:
                            if (str3.equals("command://navi.exit.find.path")) {
                                c = '&';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2062614204:
                            if (str3.equals("command://navi.park.recommend.on")) {
                                c = 'G';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2141835250:
                            if (str3.equals("command://navi.control.favorite.open")) {
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
                            NaviModel.getInstance().onControlClose(str, str2);
                            return;
                        case 1:
                            NaviModel.getInstance().onMapZoomIn(str, str2);
                            return;
                        case 2:
                            NaviModel.getInstance().onMapZoomOut(str, str2);
                            return;
                        case 3:
                            NaviModel.getInstance().onOpenTraffic(str, str2);
                            return;
                        case 4:
                            NaviModel.getInstance().onCloseTraffic(str, str2);
                            return;
                        case 5:
                            NaviModel.getInstance().onControlOverviewOpen(str, str2);
                            return;
                        case 6:
                            NaviModel.getInstance().onControlOverviewClose(str, str2);
                            return;
                        case 7:
                            NaviModel.getInstance().onMapOverview(str, str2);
                            return;
                        case '\b':
                            NaviModel.getInstance().onControlFavoriteOpen(str, str2);
                            return;
                        case '\t':
                            NaviModel.getInstance().onControlFavoriteClose(str, str2);
                            return;
                        case '\n':
                            NaviModel.getInstance().onControlSettingsOpen(str, str2);
                            return;
                        case 11:
                            NaviModel.getInstance().onControlChargeOpen(str, str2);
                            return;
                        case '\f':
                            NaviModel.getInstance().onControlChargeClose(str, str2);
                            return;
                        case '\r':
                            NaviModel.getInstance().onDriveAvoidCongestion(str, str2);
                            return;
                        case 14:
                            NaviModel.getInstance().onDriveAvoidCongestionOff(str, str2);
                            return;
                        case 15:
                            NaviModel.getInstance().onDriveAvoidCharge(str, str2);
                            return;
                        case 16:
                            NaviModel.getInstance().onDriveAvoidChargeOff(str, str2);
                            return;
                        case 17:
                            NaviModel.getInstance().onDriveHighwayFirstOff(str, str2);
                            return;
                        case 18:
                            NaviModel.getInstance().onDriveAvoidControls(str, str2);
                            return;
                        case 19:
                            NaviModel.getInstance().onDriveAvoidControlsOff(str, str2);
                            return;
                        case 20:
                            NaviModel.getInstance().onDriveRadarRoute(str, str2);
                            return;
                        case 21:
                            NaviModel.getInstance().onDriveRadarRouteOff(str, str2);
                            return;
                        case 22:
                            NaviModel.getInstance().onControlSpeechSuperSimple(str, str2);
                            return;
                        case 23:
                            NaviModel.getInstance().onControlSpeechGeneral(str, str2);
                            return;
                        case 24:
                            NaviModel.getInstance().onControlSpeechEye(str, str2);
                            return;
                        case 25:
                            NaviModel.getInstance().onControlSpeechEyeOff(str, str2);
                            return;
                        case 26:
                            NaviModel.getInstance().onControlSmartScale(str, str2);
                            return;
                        case 27:
                            NaviModel.getInstance().onControlSmartScaleOff(str, str2);
                            return;
                        case 28:
                            NaviModel.getInstance().onControlSecurityRemind(str, str2);
                            return;
                        case 29:
                            NaviModel.getInstance().onControlSecurityRemindOff(str, str2);
                            return;
                        case 30:
                            NaviModel.getInstance().onControlRoadAhead(str, str2);
                            return;
                        case 31:
                            NaviModel.getInstance().onControlRoadAheadOff(str, str2);
                            return;
                        case ' ':
                            NaviModel.getInstance().onDriveHighwayNo(str, str2);
                            return;
                        case '!':
                            NaviModel.getInstance().onDriveHighwayNoOff(str, str2);
                            return;
                        case '\"':
                            NaviModel.getInstance().onDriveHighwayFirst(str, str2);
                            return;
                        case '#':
                            NaviModel.getInstance().onNavigatingGet(str, str2);
                            return;
                        case '$':
                            NaviModel.getInstance().onPoiSearch(str, str2);
                            return;
                        case '%':
                            NaviModel.getInstance().onMapEnterFindPath(str, str2);
                            return;
                        case '&':
                            NaviModel.getInstance().onMapExitFindPath(str, str2);
                            return;
                        case '\'':
                            NaviModel.getInstance().onSearchClose(str, str2);
                            return;
                        case '(':
                            NaviModel.getInstance().onMainRoad(str, str2);
                            return;
                        case ')':
                            NaviModel.getInstance().onSideRoad(str, str2);
                            return;
                        case '*':
                            NaviModel.getInstance().onMapZoominMax(str, str2);
                            return;
                        case '+':
                            NaviModel.getInstance().onMapZoomoutMin(str, str2);
                            return;
                        case ',':
                            NaviModel.getInstance().onNearbySearch(str, str2);
                            return;
                        case '-':
                            NaviModel.getInstance().onAddressGet(str, str2);
                            return;
                        case '.':
                            NaviModel.getInstance().onAddressSet(str, str2);
                            return;
                        case '/':
                            NaviModel.getInstance().onAddressPendingRoute(str, str2);
                            return;
                        case '0':
                            NaviModel.getInstance().onControlStart(str, str2);
                            return;
                        case '1':
                            NaviModel.getInstance().onControlSpeechSimple(str, str2);
                            return;
                        case '2':
                            NaviModel.getInstance().onControlSpeechDetail(str, str2);
                            return;
                        case '3':
                            NaviModel.getInstance().onControlDisPlayNorth(str, str2);
                            return;
                        case '4':
                            NaviModel.getInstance().onControlDisPlayCar(str, str2);
                            return;
                        case '5':
                            NaviModel.getInstance().onControlDisplay3D(str, str2);
                            return;
                        case '6':
                            NaviModel.getInstance().onControlVolOn(str, str2);
                            return;
                        case '7':
                            NaviModel.getInstance().onControlVolOff(str, str2);
                            return;
                        case '8':
                            NaviModel.getInstance().onRouteNearbySearch(str, str2);
                            return;
                        case '9':
                            NaviModel.getInstance().onParkingSelect(str, str2);
                            return;
                        case ':':
                            NaviModel.getInstance().onConfirmOk(str, str2);
                            return;
                        case ';':
                            NaviModel.getInstance().onConfirmCancel(str, str2);
                            return;
                        case '<':
                            NaviModel.getInstance().onRouteSelect(str, str2);
                            return;
                        case '=':
                            NaviModel.getInstance().onSelectParkingCount(str, str2);
                            return;
                        case '>':
                            NaviModel.getInstance().onSelectRouteCount(str, str2);
                            return;
                        case '?':
                            NaviModel.getInstance().onWaypointSearch(str, str2);
                            return;
                        case '@':
                            NaviModel.getInstance().onControlWaypointStart(str, str2);
                            return;
                        case 'A':
                            NaviModel.getInstance().onControlOpenSmallMap(str, str2);
                            return;
                        case 'B':
                            NaviModel.getInstance().onControlCloseSmallMap(str, str2);
                            return;
                        case 'C':
                            NaviModel.getInstance().onControlOpenRibbonMap(str, str2);
                            return;
                        case 'D':
                            NaviModel.getInstance().onControlCloseRibbonMap(str, str2);
                            return;
                        case 'E':
                            NaviModel.getInstance().onControlHistory(str, str2);
                            return;
                        case 'F':
                            NaviModel.getInstance().onGetSettingsInfo(str, str2);
                            return;
                        case 'G':
                            NaviModel.getInstance().onControlParkRecommendOn(str, str2);
                            return;
                        case 'H':
                            NaviModel.getInstance().onControlParkRecommendOff(str, str2);
                            return;
                        case 'I':
                            NaviModel.getInstance().onSetScaleLevel(str, str2);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    @Publish
    public void onQuery(final String str, final String str2, final String str3) {
        if (CarFeatureManager.INSTANCE.isApirouterGlobalVoice()) {
            L.Tag tag = TAG;
            L.i(tag, "onQuery event:" + str + ",data:" + str2 + ",callback:" + str3);
            WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.appengine.SpeechOverallObserver.2
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // java.lang.Runnable
                public void run() {
                    char c;
                    String str4 = str;
                    switch (str4.hashCode()) {
                        case -1697099311:
                            if (str4.equals("navi.is.cruise")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1571917085:
                            if (str4.equals("navi.scale.current.level")) {
                                c = '\f';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1195178996:
                            if (str4.equals("navi.favorite.open.status")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case -851414168:
                            if (str4.equals("navi.get.navigation.info")) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case -372606704:
                            if (str4.equals("navi.is.navigation")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -98628845:
                            if (str4.equals("navi.main.road.status")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case 18796803:
                            if (str4.equals("navi.is.zoomout.min")) {
                                c = 11;
                                break;
                            }
                            c = 65535;
                            break;
                        case 238106971:
                            if (str4.equals("navi.is.sr")) {
                                c = '\r';
                                break;
                            }
                            c = 65535;
                            break;
                        case 334610996:
                            if (str4.equals("navi.common.addr.get")) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1182098865:
                            if (str4.equals("navi.side.road.status")) {
                                c = 7;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1454660265:
                            if (str4.equals("navi.is.calculate.path")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1693312668:
                            if (str4.equals("navi.is.explore.path")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2037098922:
                            if (str4.equals("navi.is.zoomin.max")) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2041908174:
                            if (str4.equals("navi.open.controls.status")) {
                                c = 5;
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
                            NaviModel.getInstance().isCruise(str, str2, str3);
                            return;
                        case 1:
                            NaviModel.getInstance().isExplorePath(str, str2, str3);
                            return;
                        case 2:
                            NaviModel.getInstance().isNavigation(str, str2, str3);
                            return;
                        case 3:
                            NaviModel.getInstance().isCalculatePath(str, str2, str3);
                            return;
                        case 4:
                            NaviModel.getInstance().getFavoriteOpenStatus(str, str2, str3);
                            return;
                        case 5:
                            NaviModel.getInstance().getOpenControlStatus(str, str2, str3);
                            return;
                        case 6:
                            NaviModel.getInstance().getSwitchMainRoadStatus(str, str2, str3);
                            return;
                        case 7:
                            NaviModel.getInstance().getSwitchSideRoadStatus(str, str2, str3);
                            return;
                        case '\b':
                            NaviModel.getInstance().getCommonAddress(str, str2, str3);
                            return;
                        case '\t':
                            NaviModel.getInstance().getNavigationInfo(str, str2, str3);
                            return;
                        case '\n':
                            NaviModel.getInstance().isZoominMax(str, str2, str3);
                            return;
                        case 11:
                            NaviModel.getInstance().isZoomoutMin(str, str2, str3);
                            return;
                        case '\f':
                            NaviModel.getInstance().getCurrentScaleLevel(str, str2, str3);
                            return;
                        case '\r':
                            NaviModel.getInstance().isLaneMode(str, str2, str3);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }
}
