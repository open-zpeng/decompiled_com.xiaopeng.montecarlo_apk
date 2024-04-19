package com.xiaopeng.speech.protocol.node.navi;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.speech.SpeechClient;
import com.xiaopeng.speech.SpeechNode;
import com.xiaopeng.speech.actorapi.ResultActor;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import com.xiaopeng.speech.common.util.LogUtils;
import com.xiaopeng.speech.jarvisproto.FeedUIEvent;
import com.xiaopeng.speech.jarvisproto.WakeupResult;
import com.xiaopeng.speech.protocol.bean.FeedListUIValue;
import com.xiaopeng.speech.protocol.event.ContextEvent;
import com.xiaopeng.speech.protocol.event.NaviEvent;
import com.xiaopeng.speech.protocol.node.navi.bean.AddressBean;
import com.xiaopeng.speech.protocol.node.navi.bean.NaviPreferenceBean;
import com.xiaopeng.speech.protocol.node.navi.bean.NearbySearchBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PathBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiSearchBean;
import com.xiaopeng.speech.protocol.node.navi.bean.RouteSelectBean;
import com.xiaopeng.speech.protocol.node.navi.bean.SelectParkingBean;
import com.xiaopeng.speech.protocol.node.navi.bean.SelectRouteBean;
import com.xiaopeng.speech.protocol.node.navi.bean.StartNaviBean;
import com.xiaopeng.speech.protocol.node.navi.bean.WaypointSearchBean;
import com.xiaopeng.speech.speechwidget.ContentWidget;
import com.xiaopeng.speech.speechwidget.ListWidget;
import com.xiaopeng.speech.speechwidget.SpeechWidget;
import com.xiaopeng.speech.speechwidget.TextWidget;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NaviNode extends SpeechNode<NaviListener> {
    private static final String ACTIVE_VOICE_TASK = "主动语音";
    public static final String ALL_ROUTE_WIDGET_ID = "-Route-2";
    public static final String BASE_ROUTE_WIDGET_ID = "-Route-1";
    private static final String COMMAND_SPLIT = "#";
    private static final String KEY_MODE = "mode";
    private static final String KEY_PULLUP_NAVI = "pullUpNavi";
    private static final String OFFLINE_SKILL = "离线命令词";
    private static final String SELECT_PARKING_INTENT = "停车场主动语音";
    private static final String SELECT_ROUTE_INTENT = "路线主动语音";
    private static final int STOP_DIALOG_OPT_FORCE = 0;
    private static final int STOP_DIALOG_OPT_OPTIONAL = 1;
    private boolean mAddressPendingRoute = false;

    @SpeechAnnotation(event = "command://navi.control.close")
    public void onControlClose(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlClose();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.map.zoomin")
    public void onMapZoomIn(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onMapZoomIn();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.map.zoomout")
    public void onMapZoomOut(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onMapZoomOut();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.road.info.open")
    public void onOpenTraffic(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onOpenTraffic();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.road.info.close")
    public void onCloseTraffic(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onCloseTraffic();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.overview.open")
    public void onControlOverviewOpen(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlOverviewOpen();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.overview.close")
    public void onControlOverviewClose(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlOverviewClose();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.map.overview")
    public void onMapOverview(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onMapOverview();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.favorite.open")
    public void onControlFavoriteOpen(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlFavoriteOpen();
            }
        }
    }

    @SpeechAnnotation(event = "native://navi.control.settings.open")
    public void onControlSettingsOpen(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlSettingsOpen();
            }
        }
    }

    @SpeechAnnotation(event = "native://navi.control.charge.open")
    public void onControlChargeOpen(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlChargeOpen();
            }
        }
    }

    @SpeechAnnotation(event = "native://navi.control.charge.close")
    public void onControlChargeClose(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlChargeClose();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.drive.avoid.congestion")
    public void onDriveAvoidCongestion(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDriveAvoidCongestion();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.drive.avoid.congestion.off")
    public void onDriveAvoidCongestionOff(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDriveAvoidCongestionOff();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.drive.avoid.charge")
    public void onDriveAvoidCharge(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDriveAvoidCharge();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.drive.avoid.charge.off")
    public void onDriveAvoidChargeOff(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDriveAvoidChargeOff();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.drive.highway.first.off")
    public void onDriveHighwayFirstOff(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDriveHighwayFirstOff();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.drive.avoid.controls")
    public void onDriveAvoidControls(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDriveAvoidControls();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.drive.avoid.controls.off")
    public void onDriveAvoidControlsOff(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDriveAvoidControlsOff();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.drive.radar.route")
    public void onDriveRadarRoute(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDriveRadarRoute();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.drive.radar.route.off")
    public void onDriveRadarRouteOff(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDriveRadarRouteOff();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.speech.super.simple")
    public void onControlSpeechSuperSimple(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlSpeechSuperSimple();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.speech.general")
    public void onControlSpeechGeneral(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlSpeechGeneral();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.speech.eye")
    public void onControlSpeechEye(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlSpeechEye();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.speech.eye.off")
    public void onControlSpeechEyeOff(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlSpeechEyeOff();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.smart.scale")
    public void onControlSmartScale(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlSmartScale();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.smart.scale.off")
    public void onControlSmartScaleOff(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlSmartScaleOff();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.security.remind")
    public void onControlSecurityRemind(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlSecurityRemind();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.road.ahead")
    public void onControlRoadAhead(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlRoadAhead();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.drive.highway.no")
    public void onDriveHighwayNo(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDriveHighwayNo();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.drive.highway.no.off")
    public void onDriveHighwayNoOff(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDriveHighwayNoOff();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.drive.highway.first")
    public void onDriveHighwayFirst(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDriveHighwayFirst();
            }
        }
    }

    @SpeechAnnotation(event = "native://navi.navigating.get")
    public void onNavigatingGet(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onNavigatingGet();
            }
        }
    }

    @SpeechAnnotation(event = "native://navi.poi.search")
    public void onPoiSearch(String str, String str2) {
        PoiSearchBean fromJson = PoiSearchBean.fromJson(str2);
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onPoiSearch(fromJson);
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.security.remind.off")
    public void onControlSecurityRemindOff(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlSecurityRemindOff();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.enter.find.path")
    public void onMapEnterFindPath(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onMapEnterFindPath();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.exit.find.path")
    public void onMapExitFindPath(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onMapExitFindPath();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.search.close")
    public void onSearchClose(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onSearchClose();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.main.road")
    public void onMainRoad(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onMainRoad();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.side.road")
    public void onSideRoad(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onSideRoad();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.favorite.close")
    public void onControlFavoriteClose(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlFavoriteClose();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.road.ahead.off")
    public void onControlRoadAheadOff(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlRoadAheadOff();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.map.zoomin.max")
    public void onMapZoominMax(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onMapZoominMax();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.map.zoomout.min")
    public void onMapZoomoutMin(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onMapZoomoutMin();
            }
        }
    }

    @SpeechAnnotation(event = "native://navi.nearby.search")
    public void onNearbySearch(String str, String str2) {
        NearbySearchBean fromJson = NearbySearchBean.fromJson(str2);
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onNearbySearch(fromJson);
            }
        }
    }

    public void postPoiResult(String str, List<PoiBean> list) {
        postPoiResult("native://navi.poi.search", str, list);
    }

    public void postNearbyResult(String str, List<PoiBean> list) {
        postPoiResult("native://navi.nearby.search", str, list);
    }

    public void postSearchPoiResult(String str, String str2, List<PoiBean> list) {
        postPoiResult(str, str2, list);
    }

    public void postAddressPosResult(String str, List<PoiBean> list) {
        postPoiResult("native://navi.poi.search", str, list);
    }

    public void postWaypointsFull(String str) {
        postWaypointSearchResult(str, null, true, true);
    }

    public void postWaypointsNotExitRoute(String str) {
        postWaypointSearchResult(str, null, false, false);
    }

    public void postWaypointSearchResult(String str, List<PoiBean> list) {
        postWaypointSearchResult(str, list, true, false);
    }

    private void postWaypointSearchResult(String str, List<PoiBean> list, boolean z, boolean z2) {
        ListWidget listWidget = new ListWidget();
        listWidget.setTitle(str);
        listWidget.setExist(z);
        listWidget.setExtraType("navi");
        listWidget.addContent("isWaypointListFull", String.valueOf(z2));
        if (list != null) {
            for (PoiBean poiBean : list) {
                ContentWidget contentWidget = new ContentWidget();
                contentWidget.setTitle(poiBean.getName());
                contentWidget.setSubTitle(poiBean.getAddress());
                try {
                    contentWidget.addExtra("navi", poiBean.toJson().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listWidget.addContentWidget(contentWidget);
            }
        }
        SpeechClient.instance().getActorBridge().send(new ResultActor("native://navi.waypoint.search").setResult(listWidget));
    }

    private void postPoiResult(String str, String str2, List<PoiBean> list) {
        ListWidget listWidget = new ListWidget();
        listWidget.setTitle(str2);
        listWidget.setExtraType("navi");
        if (list != null) {
            for (PoiBean poiBean : list) {
                ContentWidget contentWidget = new ContentWidget();
                contentWidget.setTitle(poiBean.getName());
                contentWidget.setSubTitle(poiBean.getAddress());
                try {
                    contentWidget.addExtra("navi", poiBean.toJson().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listWidget.addContentWidget(contentWidget);
            }
        }
        SpeechClient.instance().getActorBridge().send(new ResultActor(str).setResult(listWidget));
    }

    @SpeechAnnotation(event = "native://navi.address.get")
    public void onAddressGet(String str, String str2) {
        AddressBean fromJson = AddressBean.fromJson(str2);
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onAddressGet(fromJson);
            }
        }
        this.mAddressPendingRoute = false;
    }

    public void postAddressGetResult(boolean z, boolean z2, PoiBean poiBean) {
        TextWidget textWidget = new TextWidget();
        textWidget.setText(z ? "success" : "fail");
        textWidget.addContent("hasBigData", z2 ? "true" : "false");
        if (poiBean != null) {
            try {
                textWidget.addContent("address", poiBean.getAddress());
                textWidget.addExtra("navi", poiBean.toJson().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        SpeechClient.instance().getActorBridge().send(new ResultActor("native://navi.address.get").setResult(textWidget));
    }

    @SpeechAnnotation(event = "command://navi.address.pending.route")
    public void onAddressPendingRoute(String str, String str2) {
        LogUtils.i(this, "pending route");
        this.mAddressPendingRoute = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    @com.xiaopeng.speech.annotation.SpeechAnnotation(event = "command://navi.address.set")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAddressSet(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            com.xiaopeng.speech.protocol.node.navi.bean.AddressBean r9 = new com.xiaopeng.speech.protocol.node.navi.bean.AddressBean
            r9.<init>()
            r0 = 0
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L40
            r2.<init>(r10)     // Catch: org.json.JSONException -> L40
            java.lang.String r10 = "addressType"
            java.lang.String r10 = r2.optString(r10)     // Catch: org.json.JSONException -> L40
            r9.setAddressType(r10)     // Catch: org.json.JSONException -> L40
            java.lang.String r10 = "poi"
            java.lang.String r10 = r2.optString(r10)     // Catch: org.json.JSONException -> L40
            com.xiaopeng.speech.protocol.node.navi.bean.PoiBean r10 = com.xiaopeng.speech.protocol.node.navi.bean.PoiBean.fromJson(r10)     // Catch: org.json.JSONException -> L40
            java.lang.String r3 = "pref"
            java.lang.String r3 = r2.optString(r3)     // Catch: org.json.JSONException -> L3d
            java.lang.String r4 = "type"
            java.lang.String r0 = r2.optString(r4)     // Catch: org.json.JSONException -> L3b
            java.lang.String r4 = "naviType"
            int r4 = r2.optInt(r4)     // Catch: org.json.JSONException -> L3b
            java.lang.String r5 = "routeSelectRef"
            int r2 = r2.optInt(r5)     // Catch: org.json.JSONException -> L39
            goto L48
        L39:
            r2 = move-exception
            goto L44
        L3b:
            r2 = move-exception
            goto L43
        L3d:
            r2 = move-exception
            r3 = r0
            goto L43
        L40:
            r2 = move-exception
            r10 = r0
            r3 = r10
        L43:
            r4 = r1
        L44:
            r2.printStackTrace()
            r2 = r1
        L48:
            com.xiaopeng.speech.common.util.SimpleCallbackList<T> r5 = r8.mListenerList
            java.lang.Object[] r5 = r5.collectCallbacks()
            if (r5 == 0) goto L5e
            r6 = r1
        L51:
            int r7 = r5.length
            if (r6 >= r7) goto L5e
            r7 = r5[r6]
            com.xiaopeng.speech.protocol.node.navi.NaviListener r7 = (com.xiaopeng.speech.protocol.node.navi.NaviListener) r7
            r7.onAddressSet(r9, r10)
            int r6 = r6 + 1
            goto L51
        L5e:
            boolean r9 = r8.mAddressPendingRoute
            if (r9 == 0) goto L70
            com.xiaopeng.speech.protocol.node.navi.bean.StartNaviBean r9 = new com.xiaopeng.speech.protocol.node.navi.bean.StartNaviBean
            r9.<init>(r10, r3, r0)
            r9.setNaviType(r4)
            r9.setRouteSelectRef(r2)
            r8.doControlStart(r9)
        L70:
            r8.mAddressPendingRoute = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.protocol.node.navi.NaviNode.onAddressSet(java.lang.String, java.lang.String):void");
    }

    @SpeechAnnotation(event = "command://navi.control.start")
    public void onControlStart(String str, String str2) {
        int i;
        PoiBean poiBean;
        String str3;
        int i2;
        String str4 = null;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            poiBean = PoiBean.fromJson(jSONObject.optString("poi"));
            try {
                str3 = jSONObject.optString("pref");
                try {
                    str4 = jSONObject.optString("type");
                    i = jSONObject.optInt(SystemConst.NAVI_TYPE_KEY);
                    try {
                        i2 = jSONObject.optInt("routeSelectRef");
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                        i2 = 0;
                        StartNaviBean startNaviBean = new StartNaviBean(poiBean, str3, str4);
                        startNaviBean.setNaviType(i);
                        startNaviBean.setRouteSelectRef(i2);
                        LogUtils.d("NaviNode", "StartNaviBean = %s", startNaviBean.toString());
                        doControlStart(startNaviBean);
                    }
                } catch (JSONException e2) {
                    e = e2;
                    i = 0;
                }
            } catch (JSONException e3) {
                e = e3;
                i = 0;
                str3 = null;
            }
        } catch (JSONException e4) {
            e = e4;
            i = 0;
            poiBean = null;
            str3 = null;
        }
        StartNaviBean startNaviBean2 = new StartNaviBean(poiBean, str3, str4);
        startNaviBean2.setNaviType(i);
        startNaviBean2.setRouteSelectRef(i2);
        LogUtils.d("NaviNode", "StartNaviBean = %s", startNaviBean2.toString());
        doControlStart(startNaviBean2);
    }

    private void doControlStart(StartNaviBean startNaviBean) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlStart(startNaviBean);
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.speech.simple")
    public void onControlSpeechSimple(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlSpeechSimple();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.speech.detail")
    public void onControlSpeechDetail(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlSpeechDetail();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.display.north")
    public void onControlDisPlayNorth(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlDisPlayNorth();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.display.car")
    public void onControlDisPlayCar(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlDisPlayCar();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.display.3d")
    public void onControlDisplay3D(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlDisplay3D();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[LOOP:0: B:11:0x0027->B:13:0x002a, LOOP_START, PHI: r2 
      PHI: (r2v1 int) = (r2v0 int), (r2v2 int) binds: [B:10:0x0025, B:13:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[ORIG_RETURN, RETURN] */
    @com.xiaopeng.speech.annotation.SpeechAnnotation(event = "command://navi.control.vol.on")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onControlVolOn(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r5 = "mode"
            com.xiaopeng.speech.common.util.SimpleCallbackList<T> r0 = r4.mListenerList
            java.lang.Object[] r0 = r0.collectCallbacks()
            r1 = 1
            r2 = 0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L20
            r3.<init>(r6)     // Catch: java.lang.Exception -> L20
            java.lang.String r6 = "pullUpNavi"
            boolean r1 = r3.optBoolean(r6, r2)     // Catch: java.lang.Exception -> L20
            boolean r6 = r3.has(r5)     // Catch: java.lang.Exception -> L20
            if (r6 == 0) goto L24
            int r5 = r3.optInt(r5)     // Catch: java.lang.Exception -> L20
            goto L25
        L20:
            r5 = move-exception
            r5.printStackTrace()
        L24:
            r5 = r2
        L25:
            if (r0 == 0) goto L34
        L27:
            int r6 = r0.length
            if (r2 >= r6) goto L34
            r6 = r0[r2]
            com.xiaopeng.speech.protocol.node.navi.NaviListener r6 = (com.xiaopeng.speech.protocol.node.navi.NaviListener) r6
            r6.onControlVolOn(r1, r5)
            int r2 = r2 + 1
            goto L27
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.protocol.node.navi.NaviNode.onControlVolOn(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[LOOP:0: B:11:0x0027->B:13:0x002a, LOOP_START, PHI: r2 
      PHI: (r2v1 int) = (r2v0 int), (r2v2 int) binds: [B:10:0x0025, B:13:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[ORIG_RETURN, RETURN] */
    @com.xiaopeng.speech.annotation.SpeechAnnotation(event = "command://navi.control.vol.off")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onControlVolOff(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r5 = "mode"
            com.xiaopeng.speech.common.util.SimpleCallbackList<T> r0 = r4.mListenerList
            java.lang.Object[] r0 = r0.collectCallbacks()
            r1 = 1
            r2 = 0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L20
            r3.<init>(r6)     // Catch: java.lang.Exception -> L20
            java.lang.String r6 = "pullUpNavi"
            boolean r1 = r3.optBoolean(r6, r2)     // Catch: java.lang.Exception -> L20
            boolean r6 = r3.has(r5)     // Catch: java.lang.Exception -> L20
            if (r6 == 0) goto L24
            int r5 = r3.optInt(r5)     // Catch: java.lang.Exception -> L20
            goto L25
        L20:
            r5 = move-exception
            r5.printStackTrace()
        L24:
            r5 = r2
        L25:
            if (r0 == 0) goto L34
        L27:
            int r6 = r0.length
            if (r2 >= r6) goto L34
            r6 = r0[r2]
            com.xiaopeng.speech.protocol.node.navi.NaviListener r6 = (com.xiaopeng.speech.protocol.node.navi.NaviListener) r6
            r6.onControlVolOff(r1, r5)
            int r2 = r2 + 1
            goto L27
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.protocol.node.navi.NaviNode.onControlVolOff(java.lang.String, java.lang.String):void");
    }

    @SpeechAnnotation(event = "native://navi.route.nearby.search")
    public void onRouteNearbySearch(String str, String str2) {
        NearbySearchBean fromJson = NearbySearchBean.fromJson(str2);
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onRouteNearbySearch(fromJson);
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.parking.select")
    public void onParkingSelect(String str, String str2) {
        SelectParkingBean fromJson = SelectParkingBean.fromJson(str2);
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onParkingSelect(fromJson);
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.confirm.ok")
    public void onConfirmOk(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onConfirmOk();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.confirm.cancel")
    public void onConfirmCancel(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onConfirmCancel();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.route.select")
    public void onRouteSelect(String str, String str2) {
        SelectRouteBean fromJson = SelectRouteBean.fromJson(str2);
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onRouteSelect(fromJson);
            }
        }
    }

    @SpeechAnnotation(event = "native://navi.select.parking.count")
    public void onSelectParkingCount(String str, String str2) {
        SelectParkingBean fromJson = SelectParkingBean.fromJson(str2);
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onSelectParkingCount(fromJson);
            }
        }
    }

    @SpeechAnnotation(event = "native://navi.select.route.count")
    public void onSelectRouteCount(String str, String str2) {
        SelectRouteBean fromJson = SelectRouteBean.fromJson(str2);
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onSelectRouteCount(fromJson);
            }
        }
    }

    public void onDataControlDisplay3dTts(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDataControlDisplay3dTts();
            }
        }
    }

    public void onDataControlDisplayCarTts(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDataControlDisplayCarTts();
            }
        }
    }

    public void onDataControlDisplayNorthTts(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDataControlDisplayNorthTts();
            }
        }
    }

    public void onDriveAdvoidTrafficControl(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onDriveAdvoidTrafficControl();
            }
        }
    }

    @SpeechAnnotation(event = "native://navi.waypoint.search")
    public void onWaypointSearch(String str, String str2) {
        WaypointSearchBean fromJson = WaypointSearchBean.fromJson(str2);
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onWaypointSearch(fromJson);
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.control.waypoint.start")
    public void onControlWaypointStart(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        PathBean fromJson = PathBean.fromJson(str2);
        LogUtils.d("NaviNode, pathBean =%s", fromJson == null ? "data is null" : fromJson.toString());
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlWaypointStart(fromJson);
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.small.map.open")
    public void onControlOpenSmallMap(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlOpenSmallMap();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.small.map.close")
    public void onControlCloseSmallMap(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlCloseSmallMap();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.ribbon.map.open")
    public void onControlOpenRibbonMap(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlOpenRibbonMap();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.ribbon.map.close")
    public void onControlCloseRibbonMap(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlCloseRibbonMap();
            }
        }
    }

    public void selectParking(String str) {
        String str2;
        SpeechClient.instance().getWakeupEngine().stopDialog();
        try {
            str2 = new JSONObject().put("tts", str).put("isLocalSkill", true).put("intent", SELECT_PARKING_INTENT).put("isAsrModeOffline", false).put(WakeupResult.REASON_COMMAND, "native://navi.select.parking.count#command://navi.parking.select#command://navi.confirm.cancel").toString();
        } catch (JSONException e) {
            e.printStackTrace();
            str2 = "";
        }
        SpeechClient.instance().getAgent().triggerIntent(OFFLINE_SKILL, ACTIVE_VOICE_TASK, SELECT_PARKING_INTENT, str2);
    }

    @Deprecated
    public void selectRoute(String str) {
        String str2;
        SpeechClient.instance().getWakeupEngine().stopDialog();
        try {
            str2 = new JSONObject().put("tts", str).put("isLocalSkill", true).put("intent", SELECT_ROUTE_INTENT).put("isAsrModeOffline", false).put(WakeupResult.REASON_COMMAND, "native://navi.select.route.count#command://navi.route.select#command://navi.confirm.cancel").toString();
        } catch (JSONException e) {
            e.printStackTrace();
            str2 = "";
        }
        SpeechClient.instance().getAgent().triggerIntent(OFFLINE_SKILL, ACTIVE_VOICE_TASK, SELECT_ROUTE_INTENT, str2);
    }

    public void selectRoute(List<RouteSelectBean> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (RouteSelectBean routeSelectBean : list) {
                    jSONArray.put(routeSelectBean.toJson());
                }
            }
            jSONObject.put("route_list", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SpeechClient.instance().getAgent().triggerEvent(FeedUIEvent.LIST_ROUT_UPLOAD, jSONObject.toString());
    }

    public void updateRouteSelect(List<RouteSelectBean> list) {
        ListWidget listWidget = new ListWidget();
        listWidget.setTitle(FeedListUIValue.TYPE_ROUTE);
        listWidget.setExtraType(ListWidget.EXTRA_TYPE_NAVI_ROUTE);
        if (list != null && list.size() > 0) {
            for (RouteSelectBean routeSelectBean : list) {
                ContentWidget contentWidget = new ContentWidget();
                contentWidget.setTitle(routeSelectBean.totalTimeLine1);
                contentWidget.setSubTitle(routeSelectBean.routeTypeName);
                try {
                    contentWidget.addExtra(ListWidget.EXTRA_TYPE_NAVI_ROUTE, routeSelectBean.toJson().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listWidget.addContentWidget(contentWidget);
            }
        }
        LogUtils.i("updateRouteSelect", "updateRouteSelect:" + listWidget.toString());
        SpeechClient.instance().getAgent().sendEvent(ContextEvent.WIDGET_LIST, listWidget.toString());
    }

    private SpeechWidget getRouteSelectWidget(List<RouteSelectBean> list) {
        ListWidget listWidget = new ListWidget();
        listWidget.setTitle(FeedListUIValue.TYPE_ROUTE);
        listWidget.setExtraType(ListWidget.EXTRA_TYPE_NAVI_ROUTE);
        if (list != null && list.size() > 0) {
            for (RouteSelectBean routeSelectBean : list) {
                ContentWidget contentWidget = new ContentWidget();
                contentWidget.setTitle(routeSelectBean.totalTimeLine1);
                contentWidget.setSubTitle(routeSelectBean.routeTypeName);
                try {
                    contentWidget.addExtra(ListWidget.EXTRA_TYPE_NAVI_ROUTE, routeSelectBean.toJson().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listWidget.addContentWidget(contentWidget);
            }
        }
        return listWidget;
    }

    public void stopSpeechDialog() {
        SpeechClient.instance().getWakeupEngine().stopDialog();
    }

    public void stopSpeechDialog(int i) {
        LogUtils.i(this, "stopDialog option: " + i);
        if (i == 0) {
            SpeechClient.instance().getWakeupEngine().stopDialog();
        } else {
            SpeechClient.instance().getAgent().sendUIEvent(FeedUIEvent.SCRIPT_QUIT, null);
        }
    }

    public void startSpeechDialog() {
        SpeechClient.instance().getAgent().triggerEvent(FeedUIEvent.SCRIPT_QUIT, null);
    }

    public void directNavigation() {
        SpeechClient.instance().getAgent().triggerEvent(FeedUIEvent.SCRIPT_QUIT, null);
    }

    @SpeechAnnotation(event = "command://navi.control.history")
    public void onControlHistory(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlHistory();
            }
        }
    }

    public void syncRoute(List<RouteSelectBean> list, String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (RouteSelectBean routeSelectBean : list) {
                    jSONArray.put(routeSelectBean.toJson());
                }
            }
            jSONObject.put("route_list", jSONArray.toString());
            jSONObject.put("localStory", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (z) {
            SpeechClient.instance().getAgent().triggerEvent(FeedUIEvent.LIST_ROUT_UPLOAD, jSONObject.toString());
        }
        syncRouteToInfoFlow(list, str, z);
    }

    public void syncRouteToInfoFlow(List<RouteSelectBean> list, String str, boolean z) {
        ListWidget listWidget = new ListWidget();
        listWidget.setTitle(FeedListUIValue.TYPE_ROUTE);
        listWidget.setExtraType(ListWidget.EXTRA_TYPE_NAVI_ROUTE);
        if (z) {
            listWidget.setWidgetId(str + BASE_ROUTE_WIDGET_ID);
        } else {
            listWidget.setWidgetId(str + ALL_ROUTE_WIDGET_ID);
        }
        if (list != null && list.size() > 0) {
            for (RouteSelectBean routeSelectBean : list) {
                ContentWidget contentWidget = new ContentWidget();
                contentWidget.setTitle(routeSelectBean.totalTimeLine1);
                contentWidget.setSubTitle(routeSelectBean.routeTypeName);
                try {
                    contentWidget.addExtra(ListWidget.EXTRA_TYPE_NAVI_ROUTE, routeSelectBean.toJson().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listWidget.addContentWidget(contentWidget);
            }
        }
        LogUtils.i("NaviNode", "syncRouteToInfoFlow:" + listWidget.toString());
        SpeechClient.instance().getAgent().sendEvent(ContextEvent.WIDGET_LIST, listWidget.toString());
    }

    @SpeechAnnotation(event = "native://navi.settings.info")
    public void onGetSettingsInfo(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onGetSettingsInfo();
            }
        }
    }

    public void postSettingsInfo(String str) {
        SpeechClient.instance().getActorBridge().send(new ResultActor("native://navi.settings.info").setResult(str));
    }

    @SpeechAnnotation(event = "command://navi.park.recommend.on")
    public void onControlParkRecommendOn(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlParkRecommendOn();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.park.recommend.off")
    public void onControlParkRecommendOff(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlParkRecommendOff();
            }
        }
    }

    @SpeechAnnotation(event = "command://navi.scale.level.set")
    public void onSetScaleLevel(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks == null || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("level")) {
                int i = jSONObject.getInt("level");
                for (Object obj : collectCallbacks) {
                    ((NaviListener) obj).onSetScaleLevel(i);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SpeechAnnotation(event = NaviEvent.ALERTS_PREFERENCE_SET)
    public void onAlertsPreferenceSet(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks == null || TextUtils.isEmpty(str2)) {
            return;
        }
        NaviPreferenceBean fromJson = NaviPreferenceBean.fromJson(str2);
        for (Object obj : collectCallbacks) {
            ((NaviListener) obj).onAlertsPreferenceSet(fromJson);
        }
    }

    @SpeechAnnotation(event = NaviEvent.AVOID_ROUTE_SET)
    public void onAvoidRouteSet(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks == null || TextUtils.isEmpty(str2)) {
            return;
        }
        NaviPreferenceBean fromJson = NaviPreferenceBean.fromJson(str2);
        for (Object obj : collectCallbacks) {
            ((NaviListener) obj).onAvoidRouteSet(fromJson);
        }
    }

    @SpeechAnnotation(event = NaviEvent.AUTO_REROUTE_BETTER_ROUTE)
    public void onAutoRerouteBetterRoute(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onAutoRerouteBetterRoute();
            }
        }
    }

    @SpeechAnnotation(event = NaviEvent.AUTO_REROUTE_ASK_FIRST)
    public void onAutoRerouteAskFirst(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onAutoRerouteAskFirst();
            }
        }
    }

    @SpeechAnnotation(event = NaviEvent.AUTO_REROUTE_NEVER)
    public void onAutoRerouteNever(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onAutoRerouteNever();
            }
        }
    }

    @SpeechAnnotation(event = NaviEvent.MAP_SHOW_SET)
    public void onMapShowSet(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks == null || TextUtils.isEmpty(str2)) {
            return;
        }
        NaviPreferenceBean fromJson = NaviPreferenceBean.fromJson(str2);
        for (Object obj : collectCallbacks) {
            ((NaviListener) obj).onMapShowSet(fromJson);
        }
    }

    @SpeechAnnotation(event = NaviEvent.CONTROL_POI_DETAILS_FAVORITE_ADD)
    public void onPoiDetailsFavoriteAdd(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onPoiDetailsFavoriteAdd();
            }
        }
    }

    @SpeechAnnotation(event = NaviEvent.CONTROL_POI_DETAILS_FAVORITE_DEL)
    public void onPoiDetailsFavoriteDel(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onPoiDetailsFavoriteDel();
            }
        }
    }

    @SpeechAnnotation(event = NaviEvent.CONTROL_SETTINGS_CLOSE)
    public void onControlSettingsCLose(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlSettingsClose();
            }
        }
    }

    @SpeechAnnotation(event = NaviEvent.CONTROL_HISTORY_CLOSE)
    public void onControlHistoryCLose(String str, String str2) {
        Object[] collectCallbacks = this.mListenerList.collectCallbacks();
        if (collectCallbacks != null) {
            for (Object obj : collectCallbacks) {
                ((NaviListener) obj).onControlHistoryClose();
            }
        }
    }
}
