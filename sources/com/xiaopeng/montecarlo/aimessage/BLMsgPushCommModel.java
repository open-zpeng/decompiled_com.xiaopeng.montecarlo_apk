package com.xiaopeng.montecarlo.aimessage;

import android.text.TextUtils;
import com.autonavi.gbl.user.msgpush.model.AimPoiInfo;
import com.autonavi.gbl.user.msgpush.model.AimPoiPushMsg;
import com.autonavi.gbl.user.msgpush.model.AimRoutePushInfo;
import com.autonavi.gbl.user.msgpush.model.AimRoutePushMsg;
import com.autonavi.gbl.user.msgpush.model.MobileRouteViaPoint;
import com.xiaopeng.libconfig.ipc.bean.MessageContentBean;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.aimessage.type.MapPoint;
import com.xiaopeng.montecarlo.aimessage.type.MapRouteMsg;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.aimessage.type.AiMsg;
import com.xiaopeng.montecarlo.navcore.event.AiMessageBtnEvent;
import com.xiaopeng.montecarlo.navcore.event.AiMessageEvent;
import com.xiaopeng.montecarlo.navcore.event.BLMsgPushEvent;
import com.xiaopeng.montecarlo.navcore.event.BLMsgRoutePushEvent;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.stat.NaviGuiderStatUtil;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class BLMsgPushCommModel {
    public static final long VALID_TIME = 259200000;
    private static final L.Tag TAG = new L.Tag("BLMsgPushCommModel");
    private static BLMsgPushCommModel sInstance = new BLMsgPushCommModel();

    private BLMsgPushCommModel() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BLMsgPushCommModel getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bind() {
        L.i(TAG, "BLMsgPushCommModel bind");
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEvent(AiMessageBtnEvent aiMessageBtnEvent) {
        AimRoutePushInfo aimRoutePushInfo;
        if (aiMessageBtnEvent.getSender() != 100) {
            return;
        }
        String btnContent = aiMessageBtnEvent.getBtnContent();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onBtnClick btnContent = " + btnContent);
        }
        if (2504 == aiMessageBtnEvent.getScene()) {
            AimPoiInfo aimPoiInfo = (AimPoiInfo) GsonUtil.fromJson(btnContent, (Class<Object>) AimPoiInfo.class);
            NaviGuiderStatUtil.bIAmapSend2CarStartRoute(AiMsgUtils.getInstance().getCurrentSceneMode(), aimPoiInfo);
            if (aimPoiInfo != null) {
                MapRouteMsg mapRouteMsg = new MapRouteMsg();
                MapPoint mapPoint = new MapPoint();
                mapPoint.setAddress(aimPoiInfo.address);
                mapPoint.setLat(aimPoiInfo.lat / 1000000.0d);
                mapPoint.setLon(aimPoiInfo.lon / 1000000.0d);
                mapPoint.setAddress(aimPoiInfo.address);
                mapPoint.setName(aimPoiInfo.name);
                mapPoint.setPoiType(aimPoiInfo.poiType);
                mapPoint.setPoiId(aimPoiInfo.poiId);
                mapRouteMsg.setDest(mapPoint);
                AiMsgUtils.getInstance().doRoute(mapRouteMsg, -1);
            }
        } else if (2513 != aiMessageBtnEvent.getScene() || (aimRoutePushInfo = (AimRoutePushInfo) GsonUtil.fromJson(btnContent, (Class<Object>) AimRoutePushInfo.class)) == null || aimRoutePushInfo.routeParam == null) {
        } else {
            MapRouteMsg mapRouteMsg2 = new MapRouteMsg();
            MapPoint mapPoint2 = new MapPoint();
            mapPoint2.setAddress("");
            int i = 0;
            double doubleValue = Double.valueOf(aimRoutePushInfo.routeParam.endPoints.get(0).lat).doubleValue();
            double doubleValue2 = Double.valueOf(aimRoutePushInfo.routeParam.endPoints.get(0).lon).doubleValue();
            mapPoint2.setLat(doubleValue);
            mapPoint2.setLon(doubleValue2);
            mapPoint2.setName(aimRoutePushInfo.routeParam.destination.name);
            mapPoint2.setPoiType(aimRoutePushInfo.routeParam.destination.typeCode);
            mapPoint2.setPoiId(aimRoutePushInfo.routeParam.destination.poiId);
            mapRouteMsg2.setDest(mapPoint2);
            if (CollectionUtils.isNotEmpty(aimRoutePushInfo.routeParam.routeViaPoints)) {
                MapPoint[] mapPointArr = new MapPoint[aimRoutePushInfo.routeParam.routeViaPoints.size()];
                Iterator<MobileRouteViaPoint> it = aimRoutePushInfo.routeParam.routeViaPoints.iterator();
                while (it.hasNext()) {
                    MobileRouteViaPoint next = it.next();
                    if (next != null) {
                        MapPoint mapPoint3 = new MapPoint();
                        mapPoint3.setAddress("");
                        double doubleValue3 = Double.valueOf(next.lat).doubleValue();
                        double doubleValue4 = Double.valueOf(next.lon).doubleValue();
                        mapPoint3.setLat(doubleValue3);
                        mapPoint3.setLon(doubleValue4);
                        mapPoint3.setName(next.name);
                        mapPoint3.setPoiType(next.typeCode);
                        mapPoint3.setPoiId(next.poiId);
                        mapPointArr[i] = mapPoint3;
                        i++;
                    }
                }
                mapRouteMsg2.setVia(mapPointArr);
            }
            AiMsgUtils.getInstance().doRoute(mapRouteMsg2, -1);
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onBLMsgPushEvent(BLMsgPushEvent bLMsgPushEvent) {
        AimPoiPushMsg aimPoiPushMsg;
        if (bLMsgPushEvent == null || (aimPoiPushMsg = bLMsgPushEvent.getAimPoiPushMsg()) == null || XPAccountServiceWrapper.getInstance().isTempType()) {
            return;
        }
        AiMsg aiMsg = new AiMsg();
        String[] strArr = {"", ""};
        String str = null;
        if (aimPoiPushMsg.content != null) {
            boolean z = !TextUtils.isEmpty(aimPoiPushMsg.content.name);
            String string = ContextUtils.getString(R.string.amap_send2car_title);
            String string2 = ContextUtils.getString(R.string.amap_send2car_subtitle);
            Object[] objArr = new Object[1];
            objArr[0] = z ? aimPoiPushMsg.content.name : aimPoiPushMsg.content.address;
            String[] strArr2 = {string, String.format(string2, objArr)};
            String string3 = ContextUtils.getString(R.string.amap_send2car_tts);
            Object[] objArr2 = new Object[1];
            objArr2[0] = z ? aimPoiPushMsg.content.name : aimPoiPushMsg.content.address;
            str = String.format(string3, objArr2);
            strArr = strArr2;
        }
        String json = GsonUtil.toJson(aimPoiPushMsg.content);
        MessageContentBean.MsgButton msgButton = new MessageContentBean.MsgButton();
        msgButton.setName(ContextUtils.getString(R.string.amap_send2car_response_tts));
        msgButton.setContent(json);
        msgButton.setSpeechResponse(true);
        msgButton.setResponseWord(ContextUtils.getString(R.string.amap_send2car_response_word));
        aiMsg.setTitles(strArr);
        aiMsg.setTts(str);
        aiMsg.setButtons(new MessageContentBean.MsgButton[]{msgButton});
        aiMsg.setPermanent(1);
        long currentTimeMillis = System.currentTimeMillis();
        aiMsg.setTs(currentTimeMillis);
        aiMsg.setValidEndTs(VALID_TIME + currentTimeMillis);
        aiMsg.setValidStartTs(currentTimeMillis);
        aiMsg.setPosition(1);
        AiMessageEvent aiMessageEvent = new AiMessageEvent();
        aiMessageEvent.setSender(100);
        aiMessageEvent.setAiMsg(aiMsg);
        aiMessageEvent.setScene(AiMessageEvent.SCENE_BL_SENDTOCAR);
        EventBus.getDefault().post(aiMessageEvent);
        NaviGuiderStatUtil.bIAmapSend2AI(aimPoiPushMsg.content);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onBLMsgRoutePushEvent(BLMsgRoutePushEvent bLMsgRoutePushEvent) {
        AimRoutePushMsg aimRoutePushMsg;
        if (bLMsgRoutePushEvent == null || (aimRoutePushMsg = bLMsgRoutePushEvent.getAimRoutePushMsg()) == null || XPAccountServiceWrapper.getInstance().isTempType()) {
            return;
        }
        AiMsg aiMsg = new AiMsg();
        String[] strArr = {"", ""};
        String str = null;
        if (aimRoutePushMsg.content != null) {
            String str2 = (aimRoutePushMsg.content.routeParam == null || aimRoutePushMsg.content.routeParam.destination == null) ? "" : aimRoutePushMsg.content.routeParam.destination.name;
            boolean z = !TextUtils.isEmpty(str2);
            String string = ContextUtils.getString(R.string.amap_send2car_title);
            String string2 = ContextUtils.getString(R.string.amap_send2car_subtitle);
            Object[] objArr = new Object[1];
            objArr[0] = z ? str2 : "";
            String[] strArr2 = {string, String.format(string2, objArr)};
            String string3 = ContextUtils.getString(R.string.amap_send2car_tts);
            Object[] objArr2 = new Object[1];
            objArr2[0] = z ? str2 : "";
            str = String.format(string3, objArr2);
            strArr = strArr2;
        }
        String json = GsonUtil.toJson(aimRoutePushMsg.content);
        MessageContentBean.MsgButton msgButton = new MessageContentBean.MsgButton();
        msgButton.setName(ContextUtils.getString(R.string.amap_send2car_response_tts));
        msgButton.setContent(json);
        msgButton.setSpeechResponse(true);
        msgButton.setResponseWord(ContextUtils.getString(R.string.amap_send2car_response_word));
        aiMsg.setTitles(strArr);
        aiMsg.setTts(str);
        aiMsg.setButtons(new MessageContentBean.MsgButton[]{msgButton});
        aiMsg.setPermanent(1);
        long currentTimeMillis = System.currentTimeMillis();
        aiMsg.setTs(currentTimeMillis);
        aiMsg.setValidEndTs(VALID_TIME + currentTimeMillis);
        aiMsg.setValidStartTs(currentTimeMillis);
        aiMsg.setPosition(1);
        AiMessageEvent aiMessageEvent = new AiMessageEvent();
        aiMessageEvent.setSender(100);
        aiMessageEvent.setAiMsg(aiMsg);
        aiMessageEvent.setScene(AiMessageEvent.SCENE_BL_SENDTOCAR_ROUTE);
        EventBus.getDefault().post(aiMessageEvent);
    }
}
