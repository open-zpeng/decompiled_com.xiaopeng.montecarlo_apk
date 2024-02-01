package com.xiaopeng.montecarlo.aimessage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.libconfig.ipc.bean.MessageContentBean;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.aimessage.type.CommContent;
import com.xiaopeng.montecarlo.aimessage.type.CommMsg;
import com.xiaopeng.montecarlo.aimessage.type.MapRouteMsg;
import com.xiaopeng.montecarlo.datalog.DataLogHelper;
import com.xiaopeng.montecarlo.navcore.aimessage.type.AiMsg;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class TrafficWaringModel implements AiMsgManager.MsgListener {
    private static final int MESSAGE_TYPE_TRAFFIC = 2;
    private static final L.Tag TAG = new L.Tag("TrafficWaringModel");
    private static TrafficWaringModel sInstance = new TrafficWaringModel();
    private LocalAiMsgService mService;
    private boolean mIsBindService = false;
    private boolean mIsOnlyMapShow = false;
    private CommMsg mHoldMessage = null;
    private AiMsgManager.IpcMessage mTrafficMsg = null;

    @Override // com.xiaopeng.montecarlo.aimessage.AiMsgManager.MsgListener
    public String getName() {
        return "TrafficWaringModel";
    }

    private TrafficWaringModel() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TrafficWaringModel getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bind(LocalAiMsgService localAiMsgService) {
        if (this.mIsBindService) {
            return;
        }
        this.mIsBindService = true;
        localAiMsgService.register(this);
        this.mService = localAiMsgService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnlyMapShow(boolean z) {
        this.mIsOnlyMapShow = z;
    }

    @Override // com.xiaopeng.montecarlo.aimessage.AiMsgManager.MsgListener
    public void onReceive(@NonNull AiMsgManager.IpcMessage ipcMessage) {
        LocalAiMsgService localAiMsgService;
        if (L.ENABLE) {
            L.d(TAG, "onReceive message");
        }
        if (IpcConfig.App.DEVICE_COMMUNICATION.equals(ipcMessage.getSenderPackageName())) {
            CommMsg commMsg = (CommMsg) GsonUtil.fromJson(ipcMessage.getMsg(), (Class<Object>) CommMsg.class);
            if (commMsg != null && commMsg.getMessageType() == 2 && (localAiMsgService = this.mService) != null) {
                localAiMsgService.requestCarState(this);
                this.mTrafficMsg = ipcMessage;
            }
            PageType pageType = DataLogHelper.getPageType();
            switch (pageType) {
                case NAVI_CRUISE:
                case NAVI_ROUTING:
                case NAVI_DETECT_ROUTE:
                case NAVI_GUIDANCE:
                case SEARCH_MAIN_PAGE:
                case Navi_Search_Main_Result:
                case SEARCH_WAYPOINT_PAGE:
                    DataLogUtil.sendStatData(pageType, BtnType.AI_RECEIVE_MESSAGE_CENTER_TRAFFIC_WARNING, new Object[0]);
                    return;
                default:
                    return;
            }
        } else if (AiMsgUtils.isCarStateGetOnMsg(ipcMessage)) {
            AiMsgManager.IpcMessage ipcMessage2 = this.mTrafficMsg;
            CommMsg commMsg2 = ipcMessage2 != null ? (CommMsg) GsonUtil.fromJson(ipcMessage2.getMsg(), (Class<Object>) CommMsg.class) : null;
            if (commMsg2 != null) {
                doTrafficMsg(this.mTrafficMsg, commMsg2);
                this.mTrafficMsg = null;
            }
        }
    }

    private void doTrafficMsg(@NonNull AiMsgManager.IpcMessage ipcMessage, @NonNull CommMsg commMsg) {
        boolean isAppInBackground = AiMsgUtils.getInstance().isAppInBackground();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "doTrafficMsg mIsOnlyMapShow：" + this.mIsOnlyMapShow + " mIsRunInBackground:" + isAppInBackground);
        }
        if (this.mService == null) {
            L.e(TAG, "doTrafficMsg mSetvice is null");
        } else if (this.mIsOnlyMapShow) {
            String content = commMsg.getContent();
            if (TextUtils.isEmpty(content)) {
                L.e(TAG, "doTrafficMsg commMsg content is empty");
                return;
            }
            CommContent commContent = (CommContent) GsonUtil.fromJson(content, (Class<Object>) CommContent.class);
            if (commContent == null) {
                L.e(TAG, "doTrafficMsg commContent is null");
                return;
            }
            String content2 = commContent.getContent();
            if (TextUtils.isEmpty(content2)) {
                L.e(TAG, "doTrafficMsg CommContent content is empty");
                return;
            }
            AiMsg aiMsg = (AiMsg) GsonUtil.fromJson(content2, (Class<Object>) AiMsg.class);
            if (aiMsg == null) {
                L.e(TAG, "doTrafficMsg aiMsg is null");
                return;
            }
            MessageContentBean.MsgButton[] buttons = aiMsg.getButtons();
            if (!isAppInBackground && buttons != null && buttons.length > 0) {
                MapRouteMsg mapRouteMsg = (MapRouteMsg) GsonUtil.fromJson(buttons[0].getContent(), (Class<Object>) MapRouteMsg.class);
                if (mapRouteMsg != null) {
                    AiMsgUtils.getInstance().doRoute(mapRouteMsg, 0);
                    mapRouteMsg.setRoute(true);
                    buttons[0].setContent(GsonUtil.toJson(mapRouteMsg));
                    commContent.setContent(GsonUtil.toJson(aiMsg));
                    commMsg.setContent(GsonUtil.toJson(commContent));
                    this.mHoldMessage = commMsg;
                    return;
                }
                return;
            }
            NavRestoreManager.getInstance().setAiMsgShownFromPowerOn(true);
            this.mService.sendToMessageCenter(ipcMessage.getMsg(), true);
        } else {
            this.mHoldMessage = commMsg;
            sendHoldMsg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendHoldMsg() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendHoldMsg mHoldMessage：" + this.mHoldMessage);
        }
        if (this.mHoldMessage != null) {
            NavRestoreManager.getInstance().setAiMsgShownFromPowerOn(true);
            this.mService.sendToMessageCenter(GsonUtil.toJson(this.mHoldMessage), true);
            this.mHoldMessage = null;
        }
    }
}
