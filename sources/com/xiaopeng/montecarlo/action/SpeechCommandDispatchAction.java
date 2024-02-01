package com.xiaopeng.montecarlo.action;

import android.content.Intent;
import android.os.Bundle;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.mapoverlay.StartPointDecorator;
import com.xiaopeng.montecarlo.mapoverlay.WayPointDecorator;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.service.navi.parser.NaviSpeechParser;
import com.xiaopeng.montecarlo.speech.command.navi.RouteWithViasCommand;
import com.xiaopeng.montecarlo.speech.command.navi.StopNaviCommand;
import com.xiaopeng.montecarlo.speech.utils.SpeechSettingUtil;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SpeechCommandDispatchAction implements IIntentAction {
    private static final L.Tag TAG = new L.Tag("speechcmd");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.montecarlo.action.IIntentAction
    public boolean handlerIntentAction(IIntentActionContext iIntentActionContext, Intent intent) {
        boolean z;
        if (iIntentActionContext != null) {
            if (intent == null) {
                throw new IllegalArgumentException("intent is null");
            }
            L.i(TAG, "=============>operateSpeechCommand");
            Bundle extras = intent.getExtras();
            if (extras == null) {
                L.e(TAG, "handlerIntentAction null == bundle ");
                return false;
            }
            String string = extras.getString("operate_type", "");
            L.i(TAG, "startRoute onNewIntent operate_type: " + string);
            switch (string.hashCode()) {
                case -1497329168:
                    if (string.equals(SpeechNaviEvent.SPEECH_OPERATE_TYPE_POST_REQUEST)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1034401807:
                    if (string.equals(SpeechNaviEvent.SPEECH_OPERATE_TYPE_OPEN_FAVORITE)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1578037192:
                    if (string.equals(SpeechNaviEvent.SPEECH_OPERATE_TYPE_START_ROUTE_WITH_VIA)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 1629937091:
                    if (string.equals(SpeechNaviEvent.SPEECH_OPERATE_TYPE_STOP_NAVI)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1819168173:
                    if (string.equals(SpeechNaviEvent.SPEECH_OPERATE_TYPE_DEBUG_ROUTE_REQUEST)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            if (!z) {
                L.i(TAG, "startRoute onNewIntent SPEECH_OPERATE_TYPE_START_ROUTE_WITH_VIA");
                getMapViewWrapper(iIntentActionContext).getBizControlManager().removeRoute(769, true);
                ArrayList parcelableArrayList = extras.getParcelableArrayList(BaseMapDecorator.KEY_POI_LIST);
                ArrayList parcelableArrayList2 = extras.getParcelableArrayList(WayPointDecorator.KEY_VIA_LIST);
                int i = extras.getInt("start_type");
                int i2 = extras.getInt(StartPointDecorator.KEY_ROUTE_SELECT_REF);
                int i3 = extras.getInt(StartPointDecorator.KEY_SETTING_PARAM);
                if (parcelableArrayList != null && parcelableArrayList.size() > 1) {
                    XPPoiInfo xPPoiInfo = (XPPoiInfo) parcelableArrayList.get(0);
                    XPPoiInfo xPPoiInfo2 = (XPPoiInfo) parcelableArrayList.get(1);
                    L.Tag tag = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("startRoute startInfo: ");
                    sb.append(xPPoiInfo);
                    sb.append(" endInfo: ");
                    sb.append(xPPoiInfo2);
                    sb.append(" vias: ");
                    sb.append(parcelableArrayList2 == null ? "null" : Integer.valueOf(parcelableArrayList2.size()));
                    sb.append(",startType:");
                    sb.append(i);
                    sb.append(",routeSelectRef:");
                    sb.append(i2);
                    L.i(tag, sb.toString());
                    Bundle bundle = new RouteRequest.Builder(RouteRequest.RouteRequestType.ROUTE_REQUEST_NORMAL).setStartXP(xPPoiInfo).setEndXP(xPPoiInfo2).setViasXP(parcelableArrayList2).setStartType(i).setRouteSelectRef(i2).setRoutePreference(i3).build().toBundle();
                    if (!extras.getBoolean(IntentActions.ActionsKey.KEY_DEBUG_FLAG, false)) {
                        bundle.putString(SystemConst.ROUTE_TYPE_KEY, SystemConst.ROUTE_TYPE_FROM_SPEECH);
                    }
                    iIntentActionContext.getMainContext().startScene(iIntentActionContext.getMainContext().getCurrentScene(), new RouteBridge().setBundle(bundle), 102);
                }
            } else if (z) {
                L.i(TAG, "startRoute onNewIntent SPEECH_OPERATE_TYPE_OPEN_FAVORITE");
                Bundle bundle2 = new Bundle();
                bundle2.putInt(SearchBridge.SEARCH_MODE, 100);
                bundle2.putInt(SearchBridge.FROM_SCENE_INDEX, -1);
                bundle2.putInt(SearchBridge.KEY_START_FROM, 1);
                bundle2.putInt(SearchBridge.SUB_CONTAINER_TYPE, 1);
                iIntentActionContext.getMainContext().startScene(iIntentActionContext.getMainContext().getCurrentScene(), new SearchBridge().setBundle(bundle2), 0);
            } else if (z) {
                String string2 = extras.getString(SpeechRequestFactory.PARAM_SPEECH_REQUEST);
                L.Tag tag2 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("startRoute onNewIntent SPEECH_OPERATE_TYPE_POST_REQUEST ");
                sb2.append(L.ENABLE ? string2 : "");
                L.i(tag2, sb2.toString());
                new NaviSpeechParser().handleSpeechCmd(string2);
            } else if (z) {
                ArrayList arrayList = new ArrayList();
                StopNaviCommand stopNaviCommand = new StopNaviCommand();
                NaviSpeechParser naviSpeechParser = new NaviSpeechParser();
                arrayList.add(stopNaviCommand);
                naviSpeechParser.handleCommandList(arrayList);
            } else if (z) {
                String string3 = extras.getString(DebugConfiguration.DebugIntentActionExtra.DEST);
                if (string3 == null) {
                    L.w(TAG, "no destStr");
                } else {
                    XPPoiInfo xPPoiByString = NavCoreUtil.getXPPoiByString(string3, false);
                    if (xPPoiByString == null) {
                        L.w(TAG, "no dest");
                    } else {
                        String string4 = extras.getString(DebugConfiguration.DebugIntentActionExtra.ORIG);
                        XPPoiInfo xPPoiByString2 = string4 != null ? NavCoreUtil.getXPPoiByString(string4, true) : null;
                        ArrayList<XPViaPoint> arrayList2 = new ArrayList<>();
                        String string5 = extras.getString(DebugConfiguration.DebugIntentActionExtra.VIAS);
                        if (string5 != null) {
                            arrayList2 = NavCoreUtil.getVIAsByString(string5);
                        }
                        int i4 = extras.getInt("start_type", 0);
                        ArrayList arrayList3 = new ArrayList();
                        RouteWithViasCommand routeWithViasCommand = new RouteWithViasCommand(xPPoiByString2, xPPoiByString, arrayList2, SpeechSettingUtil.RouteStrategy.getStrategy(extras.getInt("strategy", SpeechSettingUtil.RouteStrategy.ROUTE_PREF_DEFAULT.getIndex())), i4);
                        routeWithViasCommand.setDebugRoute(true);
                        NaviSpeechParser naviSpeechParser2 = new NaviSpeechParser();
                        arrayList3.add(routeWithViasCommand);
                        naviSpeechParser2.handleCommandList(arrayList3);
                    }
                }
            }
            return true;
        }
        throw new IllegalArgumentException("IIntentActionContext is null ");
    }

    private MapViewWrapper getMapViewWrapper(IIntentActionContext iIntentActionContext) {
        return iIntentActionContext.getMainContext().getMapView();
    }
}
