package com.xiaopeng.montecarlo.speech.manager;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequest;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.data.GetAddressCommand;
import com.xiaopeng.montecarlo.speech.command.data.SetAddressCommand;
import com.xiaopeng.montecarlo.speech.command.function.SetMapModeCommand;
import com.xiaopeng.montecarlo.speech.command.function.SetVolumeCommand;
import com.xiaopeng.montecarlo.speech.command.function.SwitchOverViewCommand;
import com.xiaopeng.montecarlo.speech.command.function.SwitchToMainRoadCommand;
import com.xiaopeng.montecarlo.speech.command.function.SwitchToSlideRoadCommand;
import com.xiaopeng.montecarlo.speech.command.function.ZoomMapCommand;
import com.xiaopeng.montecarlo.speech.command.navi.RouteOrAddViaCommand;
import com.xiaopeng.montecarlo.speech.command.navi.RouteParamCommand;
import com.xiaopeng.montecarlo.speech.command.navi.RouteWithViasCommand;
import com.xiaopeng.montecarlo.speech.command.navi.SelectRecommendParkCommand;
import com.xiaopeng.montecarlo.speech.command.navi.StartExploreCommand;
import com.xiaopeng.montecarlo.speech.command.navi.StartNaviCommand;
import com.xiaopeng.montecarlo.speech.command.navi.StopNaviCommand;
import com.xiaopeng.montecarlo.speech.command.scene.CloseSceneCommand;
import com.xiaopeng.montecarlo.speech.command.scene.OpenSceneCommand;
import com.xiaopeng.montecarlo.speech.command.search.AlongWaySearchCommand;
import com.xiaopeng.montecarlo.speech.command.search.NearbySearchCommand;
import com.xiaopeng.montecarlo.speech.command.search.POISearchCommand;
import com.xiaopeng.montecarlo.speech.command.search.RoadInfoSearchCommand;
import com.xiaopeng.montecarlo.speech.command.setting.ModifySettingCommand;
import com.xiaopeng.montecarlo.speech.command.voicefusion.InfoflowCardHeightChangedCommand;
import com.xiaopeng.montecarlo.speech.command.voicefusion.InfoflowListStateChangedCommand;
import com.xiaopeng.montecarlo.speech.command.voicefusion.InfoflowScrollEndCommand;
import com.xiaopeng.montecarlo.speech.command.voicefusion.ItemFocusedCommand;
import com.xiaopeng.montecarlo.speech.command.voicefusion.VoiceInterActiveEndCommand;
import com.xiaopeng.montecarlo.speech.command.voicefusion.VoiceSearchFusionDataFetchedCommand;
import com.xiaopeng.montecarlo.speech.command.voicefusion.WidgetCancelCommand;
import com.xiaopeng.montecarlo.speech.utils.SpeechSettingUtil;
import com.xiaopeng.speech.protocol.node.navi.bean.NearbySearchBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PathBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiSearchBean;
import com.xiaopeng.speech.protocol.node.navi.bean.StartNaviBean;
import com.xiaopeng.speech.protocol.node.navi.bean.ViaBean;
import com.xiaopeng.speech.protocol.node.navi.bean.WaypointSearchBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class SpeechCommandBuilder {
    private static final L.Tag TAG = new L.Tag("SpeechCommandBuilder");

    public List<BaseSpeechCommand> createCommands(String str) {
        ArrayList<BaseSpeechCommand> arrayList = new ArrayList<>();
        SpeechRequest speechRequest = (SpeechRequest) GsonUtil.fromJson(str, (Class<Object>) SpeechRequest.class);
        L.Tag tag = TAG;
        L.i(tag, "createCommands: " + speechRequest);
        if (speechRequest == null) {
            return arrayList;
        }
        int type = speechRequest.getType();
        if (type == 4) {
            arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.OPEN_TRAFFIC));
        } else if (type == 5) {
            arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.CLOSE_TRAFFIC));
        } else if (type == 6) {
            arrayList.add(new SwitchOverViewCommand(true));
        } else if (type == 7) {
            arrayList.add(new SwitchOverViewCommand(false));
        } else if (type == 18) {
            arrayList.add(new POISearchCommand((PoiSearchBean) GsonUtil.fromJson(speechRequest.getExtra(), (Class<Object>) PoiSearchBean.class), TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation()));
        } else if (type == 19) {
            arrayList.add(new NearbySearchCommand((NearbySearchBean) GsonUtil.fromJson(speechRequest.getExtra(), (Class<Object>) NearbySearchBean.class), TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation()));
        } else if (type == 41) {
            arrayList.add(new ZoomMapCommand(ZoomMapCommand.ZoomType.ZOOM_IN, -1000));
        } else if (type != 42) {
            switch (type) {
                case 1:
                    arrayList.add(new StopNaviCommand());
                    break;
                case 38:
                    arrayList.add(new StartNaviCommand(Integer.valueOf(speechRequest.getExtra()).intValue()));
                    break;
                case 50:
                    arrayList.add(new RoadInfoSearchCommand((PoiSearchBean) GsonUtil.fromJson(speechRequest.getExtra(), (Class<Object>) PoiSearchBean.class)));
                    break;
                case 20001:
                    arrayList.add(new VoiceInterActiveEndCommand());
                    break;
                case 20002:
                    arrayList.add(new VoiceSearchFusionDataFetchedCommand(speechRequest.getExtra()));
                    break;
                case 20003:
                    arrayList.add(new ItemFocusedCommand(speechRequest.getExtra()));
                    break;
                case 20004:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.AVOID_CONGESTION_CLOSE));
                    break;
                case 20005:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.AVOID_HIGHWAY_CLOSE));
                    break;
                case 20006:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.HIGHWAY_FIRST_CLOSE));
                    break;
                case 20007:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.AVOID_CONTROLS_ON));
                    break;
                case 20008:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.AVOID_CONTROLS_OFF));
                    break;
                case 20009:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.RADAR_ROUTE_ON));
                    break;
                case 20010:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.RADAR_ROUTE_OFF));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_SPEECH_SUPER_SIMPLE /* 20011 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.CONTROL_SPEECH_SUPER_SIMPLE));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_SPEECH_GENERAL /* 20012 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.CONTROL_SPEECH_GENERAL));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_SPEECH_EYE_ON /* 20013 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.SPEECH_EYE_ON));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_SPEECH_EYE_OFF /* 20014 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.SPEECH_EYE_OFF));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_SMART_SCALE_ON /* 20015 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.SMART_SCALE_ON));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_SMART_SCALE_OFF /* 20016 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.SMART_SCALE_OFF));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_SECURITY_REMIND_ON /* 20017 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.SECURITY_REMIND_ON));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_SECURITY_REMIND_OFF /* 20018 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.SECURITY_REMIND_OFF));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_ROAD_AHEAD_ON /* 20019 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.ROAD_AHEAD_ON));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_ROAD_AHEAD_OFF /* 20020 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.ROAD_AHEAD_OFF));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_FAVORITE_CLOSE /* 20021 */:
                    arrayList.add(new CloseSceneCommand(StatusConst.Mode.SEARCH));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_SEARCH_CLOSE /* 20022 */:
                    arrayList.add(new CloseSceneCommand(StatusConst.Mode.SEARCH));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_SWITCH_TO_MAIN_ROAD /* 20023 */:
                    arrayList.add(new SwitchToMainRoadCommand());
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_SWITCH_TO_SLID_ROAD /* 20024 */:
                    arrayList.add(new SwitchToSlideRoadCommand());
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_ZOOM_OUT_MIN /* 20025 */:
                    arrayList.add(new ZoomMapCommand(ZoomMapCommand.ZoomType.ZOOM_OUT_MIN, -1000));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_ZOOM_IN_MAX /* 20026 */:
                    arrayList.add(new ZoomMapCommand(ZoomMapCommand.ZoomType.ZOOM_IN_MAX, -1000));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_AVOID_CHARGE_OFF /* 20027 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.AVOID_CHARGE_OFF));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_OPEN_SMALL_MAP /* 20028 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.SMALL_MAP_OPEN));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_CLOSE_SMALL_MAP /* 20029 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.SMALL_MAP_CLOSE));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_OPEN_RIBBON_MAP /* 20030 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.RIBBON_MAP_OPEN));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_CONTROL_CLOSE_RIBBON_MAP /* 20031 */:
                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.RIBBON_MAP_CLOSE));
                    break;
                case SpeechRequestFactory.SPEECH_CMD_INFOFLOW_SCROLL_END /* 20032 */:
                    arrayList.add(new InfoflowScrollEndCommand(speechRequest.getExtra()));
                    break;
                default:
                    switch (type) {
                        case 9:
                            arrayList.add(new OpenSceneCommand(StatusConst.Mode.SEARCH, 1));
                            break;
                        case 10:
                            arrayList.add(new OpenSceneCommand(StatusConst.Mode.SETTING));
                            break;
                        case 11:
                            arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.OPEN_CHARGE));
                            break;
                        case 12:
                            arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.CLOSE_CHARGE));
                            break;
                        case 13:
                            arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.AVOID_CONGESTION));
                            break;
                        case 14:
                            arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.AVOID_CHARGE));
                            break;
                        case 15:
                            arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.AVOID_HIGHWAY));
                            break;
                        case 16:
                            arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.HIGHWAY_FIRST));
                            break;
                        default:
                            switch (type) {
                                case 22:
                                    executeControlStart(arrayList, speechRequest);
                                    break;
                                case 23:
                                    executeControlWaypointStart(arrayList, speechRequest);
                                    break;
                                case 24:
                                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.SIMPLE_BROADCAST));
                                    break;
                                case 25:
                                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.DETAIL_BROADCAST));
                                    break;
                                default:
                                    switch (type) {
                                        case 29:
                                            arrayList.add(new SetMapModeCommand(SetMapModeCommand.MapMode.HEAD_UP_3D));
                                            break;
                                        case 30:
                                            arrayList.add(new SetMapModeCommand(SetMapModeCommand.MapMode.HEAD_UP_2D));
                                            break;
                                        case 31:
                                            arrayList.add(new SetMapModeCommand(SetMapModeCommand.MapMode.NORTH_UP));
                                            break;
                                        case 32:
                                            if (!TextUtils.isEmpty(speechRequest.getExtra())) {
                                                "1".equals(speechRequest.getExtra());
                                            }
                                            arrayList.add(new SetVolumeCommand(true));
                                            break;
                                        case 33:
                                            if (!TextUtils.isEmpty(speechRequest.getExtra())) {
                                                "1".equals(speechRequest.getExtra());
                                            }
                                            arrayList.add(new SetVolumeCommand(false));
                                            break;
                                        case 34:
                                            arrayList.add(new AlongWaySearchCommand((NearbySearchBean) GsonUtil.fromJson(speechRequest.getExtra(), (Class<Object>) NearbySearchBean.class), TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation()));
                                            break;
                                        case 35:
                                            arrayList.add(new SelectRecommendParkCommand(Integer.valueOf(speechRequest.getExtra()).intValue()));
                                            break;
                                        default:
                                            switch (type) {
                                                case 44:
                                                    arrayList.add(new POISearchCommand((WaypointSearchBean) GsonUtil.fromJson(speechRequest.getExtra(), (Class<Object>) WaypointSearchBean.class), TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation()));
                                                    break;
                                                case 45:
                                                    arrayList.add(new SetAddressCommand(SetAddressCommand.AddressType.HOME, (PoiBean) GsonUtil.fromJson(speechRequest.getExtra(), (Class<Object>) PoiBean.class)));
                                                    break;
                                                case 46:
                                                    arrayList.add(new SetAddressCommand(SetAddressCommand.AddressType.COMPANY, (PoiBean) GsonUtil.fromJson(speechRequest.getExtra(), (Class<Object>) PoiBean.class)));
                                                    break;
                                                case 47:
                                                    arrayList.add(new GetAddressCommand(GetAddressCommand.AddressType.HOME));
                                                    break;
                                                case 48:
                                                    arrayList.add(new GetAddressCommand(GetAddressCommand.AddressType.COMPANY));
                                                    break;
                                                default:
                                                    switch (type) {
                                                        case 55:
                                                            arrayList.add(new OpenSceneCommand(StatusConst.Mode.SEARCH, 0));
                                                            break;
                                                        case 56:
                                                            arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.SCRATCH_SPOT_BROADCAST_OPEN));
                                                            break;
                                                        case 57:
                                                            arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.SCRATCH_SPOT_BROADCAST_CLOSE));
                                                            break;
                                                        default:
                                                            switch (type) {
                                                                case SpeechRequestFactory.SPEECH_CMD_CONTROL_START_EXPLORE /* 20034 */:
                                                                    arrayList.add(new StartExploreCommand());
                                                                    break;
                                                                case SpeechRequestFactory.SPEECH_CMD_ON_WIDGET_LIST_EXPAND /* 20035 */:
                                                                    arrayList.add(new InfoflowListStateChangedCommand(true));
                                                                    break;
                                                                case SpeechRequestFactory.SPEECH_CMD_INFOFLOW_CARD_HEIGHT_CHANGED /* 20036 */:
                                                                    arrayList.add(new InfoflowCardHeightChangedCommand(speechRequest.getExtra()));
                                                                    break;
                                                                case SpeechRequestFactory.SPEECH_CMD_ON_WIDGET_CANCEL /* 20037 */:
                                                                    arrayList.add(new WidgetCancelCommand());
                                                                    break;
                                                                case SpeechRequestFactory.SPEECH_CMD_CONTROL_RECOMMEND_PARK_ON /* 20038 */:
                                                                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.RECOMMEND_PARK_ON));
                                                                    break;
                                                                case SpeechRequestFactory.SPEECH_CMD_CONTROL_RECOMMEND_PARK_OFF /* 20039 */:
                                                                    arrayList.add(new ModifySettingCommand(ModifySettingCommand.SettingParam.RECOMMEND_PARK_OFF));
                                                                    break;
                                                                case SpeechRequestFactory.SPEECH_CMD_CONTROL_SET_SCALE_LEVEL /* 20040 */:
                                                                    arrayList.add(new ZoomMapCommand(ZoomMapCommand.ZoomType.ZOOM_TO_SPECIFIED_LEVEL, ((Integer) GsonUtil.fromJson(speechRequest.getExtra(), (Class<Object>) Integer.TYPE)).intValue()));
                                                                    break;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } else {
            arrayList.add(new ZoomMapCommand(ZoomMapCommand.ZoomType.ZOOM_OUT, -1000));
        }
        return arrayList;
    }

    private void executeControlWaypointStart(ArrayList<BaseSpeechCommand> arrayList, SpeechRequest speechRequest) {
        PathBean pathBean = (PathBean) GsonUtil.fromJson(speechRequest.getExtra(), (Class<Object>) PathBean.class);
        if (pathBean != null) {
            XPPoiInfo xPPoiInfo = new XPPoiInfo(pathBean.getDestPoint());
            ArrayList<ViaBean> viaPoints = pathBean.getViaPoints();
            ArrayList arrayList2 = new ArrayList();
            if (viaPoints != null) {
                Iterator<ViaBean> it = viaPoints.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new XPViaPoint(it.next()));
                }
            }
            SpeechSettingUtil.RouteStrategy strategy = SpeechSettingUtil.RouteStrategy.getStrategy(pathBean.getStrategy());
            int naviType = pathBean.getNaviType();
            int routeSelectRef = pathBean.getRouteSelectRef();
            L.Tag tag = TAG;
            L.i(tag, "execute Control Way point Start startType:" + naviType + ",routeSelectRef:" + routeSelectRef);
            arrayList.add(new RouteWithViasCommand(xPPoiInfo, arrayList2, strategy, naviType, routeSelectRef));
            return;
        }
        L.w(TAG, "SPEECH_CMD_CONTROL_WAYPOINT_START, pathBean is null");
    }

    private void executeControlStart(ArrayList<BaseSpeechCommand> arrayList, SpeechRequest speechRequest) {
        StartNaviBean startNaviBean = (StartNaviBean) GsonUtil.fromJson(speechRequest.getExtra(), (Class<Object>) StartNaviBean.class);
        if (startNaviBean == null) {
            arrayList.add(new StartNaviCommand());
            return;
        }
        SpeechSettingUtil.RouteStrategy strategy = SpeechSettingUtil.RouteStrategy.getStrategy(startNaviBean.getPathRef());
        int naviType = startNaviBean.getNaviType();
        int routeSelectRef = startNaviBean.getRouteSelectRef();
        if (strategy != SpeechSettingUtil.RouteStrategy.ROUTE_PREF_DEFAULT) {
            arrayList.add(new RouteParamCommand(strategy));
        }
        if (StartNaviBean.NaviType.WAYPOINT == startNaviBean.getType()) {
            arrayList.add(new RouteOrAddViaCommand(new XPPoiInfo(startNaviBean.getPoiBean()), RouteOrAddViaCommand.RouteType.ADD_VIA));
        } else if (StartNaviBean.NaviType.POI == startNaviBean.getType()) {
            L.Tag tag = TAG;
            L.i(tag, "executeControlStart startType:" + naviType + ",routeSelectRef:" + routeSelectRef);
            arrayList.add(new RouteOrAddViaCommand(new XPPoiInfo(startNaviBean.getPoiBean()), RouteOrAddViaCommand.RouteType.ROUTE, naviType, routeSelectRef));
        } else {
            L.i(TAG, "SPEECH_CMD_CONTROL_START, route type error");
        }
    }
}
