package com.xiaopeng.montecarlo.navcore.speech.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.protocol.bean.FeedListUIValue;
import com.xiaopeng.speech.protocol.node.navi.bean.PathBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiSearchBean;
import com.xiaopeng.speech.protocol.node.navi.bean.StartNaviBean;
/* loaded from: classes3.dex */
public class SpeechTestReceiver extends BroadcastReceiver {
    private static final L.Tag TAG = new L.Tag("SpeechTestReceiver");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        char c;
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        String string = extras.getString("operate_type");
        L.i(TAG, "action: " + action + " type: " + string);
        switch (string.hashCode()) {
            case -2016703917:
                if (string.equals("detail_broadcast")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case -1908696239:
                if (string.equals("switch_map_mode")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -1822101157:
                if (string.equals("open_setting")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1557446108:
                if (string.equals("switch_overview")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -1477509052:
                if (string.equals("cancel_route")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1462379861:
                if (string.equals("map_mode_2d")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -1462379830:
                if (string.equals("map_mode_3d")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case -1182222401:
                if (string.equals("cloud_route")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1118648973:
                if (string.equals("show_charging")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case -1055206002:
                if (string.equals("map_mode_north_up")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -1034401807:
                if (string.equals(SpeechNaviEvent.SPEECH_OPERATE_TYPE_OPEN_FAVORITE)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -963964872:
                if (string.equals("turn_on_volume")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -865529235:
                if (string.equals("road_info")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case -696285128:
                if (string.equals("zoomin")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -130670988:
                if (string.equals("simple_broadcast")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case -109996389:
                if (string.equals("zoomout")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 3373990:
                if (string.equals("navi")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 108704329:
                if (string.equals(FeedListUIValue.TYPE_ROUTE)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 192377302:
                if (string.equals("go_home")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 215328077:
                if (string.equals("select_park")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 600844798:
                if (string.equals("highway_first")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 736118974:
                if (string.equals("avoid_charge")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 814967101:
                if (string.equals("poi_search")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1211543701:
                if (string.equals("turn_down_volume")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 1223518513:
                if (string.equals("avoid_congestion")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 1415208604:
                if (string.equals("set_home")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1521290563:
                if (string.equals("avoid_highway")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1629937091:
                if (string.equals(SpeechNaviEvent.SPEECH_OPERATE_TYPE_STOP_NAVI)) {
                    c = 4;
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
                StartNaviBean startNaviBean = new StartNaviBean();
                PoiBean poiBean = new PoiBean();
                L.i(TAG, "dest_name: " + extras.getString("dest_name") + " lat: " + extras.getFloat(CPSearchParam.PARAM_KEY_LAT) + " lon: " + extras.getFloat(CPSearchParam.PARAM_KEY_LON));
                poiBean.setDstName(extras.getString("dest_name", "南京东路"));
                poiBean.setLatitude((double) extras.getFloat(CPSearchParam.PARAM_KEY_LAT, 31.238188f));
                poiBean.setLongitude((double) extras.getFloat(CPSearchParam.PARAM_KEY_LON, 121.48684f));
                startNaviBean.setPoiBean(poiBean);
                SpeechRequestFactory.getInstance().postRequest(22, GsonUtil.toJson(startNaviBean));
                return;
            case 1:
                PathBean pathBean = new PathBean();
                PoiBean poiBean2 = new PoiBean();
                poiBean2.setDstName(extras.getString("dest_name", "南京东路"));
                poiBean2.setLatitude(extras.getFloat(CPSearchParam.PARAM_KEY_LAT, 31.238188f));
                poiBean2.setLongitude(extras.getFloat(CPSearchParam.PARAM_KEY_LON, 121.48684f));
                pathBean.setDestPoint(poiBean2);
                pathBean.setStrategy(extras.getInt("strategy", -1));
                SpeechRequestFactory.getInstance().postRequest(23, GsonUtil.toJson(pathBean));
                return;
            case 2:
                SpeechRequestFactory.getInstance().postRequest(53);
                return;
            case 3:
                SpeechRequestFactory.getInstance().postRequest(38, String.valueOf(extras.getInt("select_index", 0)));
                return;
            case 4:
                SpeechRequestFactory.getInstance().postRequest(1);
                return;
            case 5:
                SpeechRequestFactory.getInstance().postRequest(49);
                return;
            case 6:
                PoiBean poiBean3 = new PoiBean();
                L.i(TAG, "dest_name: " + extras.getString("dest_name") + " lat: " + extras.getFloat(CPSearchParam.PARAM_KEY_LAT) + " lon: " + extras.getFloat(CPSearchParam.PARAM_KEY_LON));
                poiBean3.setDstName(extras.getString("dest_name", "南京东路"));
                poiBean3.setLatitude((double) extras.getFloat(CPSearchParam.PARAM_KEY_LAT, 31.238188f));
                poiBean3.setLongitude((double) extras.getFloat(CPSearchParam.PARAM_KEY_LON, 121.48684f));
                SpeechRequestFactory.getInstance().postRequest(45, GsonUtil.toJson(poiBean3));
                return;
            case 7:
                new PoiSearchBean();
                return;
            case '\b':
                L.i(TAG, "isZoomInMax : " + SpeechRequestFactory.getInstance().postRequestForResult(10005));
                SpeechRequestFactory.getInstance().postRequest(41);
                return;
            case '\t':
                L.i(TAG, "isZoomOutMin : " + SpeechRequestFactory.getInstance().postRequestForResult(10006));
                SpeechRequestFactory.getInstance().postRequest(42);
                return;
            case '\n':
                SpeechRequestFactory.getInstance().postRequest(52);
                return;
            case 11:
                SpeechRequestFactory.getInstance().postRequest(10);
                return;
            case '\f':
                SpeechRequestFactory.getInstance().postRequest(9);
                return;
            case '\r':
                SpeechRequestFactory.getInstance().postRequest(32);
                return;
            case 14:
                SpeechRequestFactory.getInstance().postRequest(33);
                return;
            case 15:
                SpeechRequestFactory.getInstance().postRequest(30);
                return;
            case 16:
                SpeechRequestFactory.getInstance().postRequest(29);
                return;
            case 17:
                SpeechRequestFactory.getInstance().postRequest(31);
                return;
            case 18:
                SpeechRequestFactory.getInstance().postRequest(51);
                return;
            case 19:
                SpeechRequestFactory.getInstance().postRequest(14);
                return;
            case 20:
                SpeechRequestFactory.getInstance().postRequest(13);
                return;
            case 21:
                SpeechRequestFactory.getInstance().postRequest(15);
                return;
            case 22:
                SpeechRequestFactory.getInstance().postRequest(16);
                return;
            case 23:
                SpeechRequestFactory.getInstance().postRequest(24);
                return;
            case 24:
                SpeechRequestFactory.getInstance().postRequest(25);
                return;
            case 25:
                SpeechRequestFactory.getInstance().postRequest(50, GsonUtil.toJson(new PoiSearchBean()));
                return;
            case 26:
                SpeechRequestFactory.getInstance().postRequest(39, String.valueOf(extras.getInt("select_index", 0)));
                return;
            case 27:
                SpeechRequestFactory.getInstance().postRequest(54, String.valueOf(extras.getBoolean("show", false)));
                return;
            default:
                return;
        }
    }
}
