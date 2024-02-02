package com.xiaopeng.montecarlo.aimessage;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.service.navi.INaviStatusService;
import com.xiaopeng.montecarlo.service.navi.LocalNaviService;
import com.xiaopeng.montecarlo.service.navi.binder.NaviServiceManager;
/* loaded from: classes2.dex */
public final class AiMsgManager {
    private final LocalAiMsgService mService = LocalAiMsgService.getInstance();
    private final TrafficWaringModel mTrafficWaringModel = TrafficWaringModel.getInstance();
    private final MapControlModel mMapControlModel = MapControlModel.getInstance();

    /* loaded from: classes2.dex */
    public interface MsgListener {
        String getName();

        void onReceive(@NonNull IpcMessage ipcMessage);
    }

    public StatusConst.Mode getCurrentSceneMode() {
        INaviStatusService asInterface = INaviStatusService.Stub.asInterface(LocalNaviService.getInstance().getService(ContextUtils.getContext(), NaviServiceManager.NAVI_STATUS));
        if (asInterface != null) {
            try {
                return StatusConst.Mode.valueOf(asInterface.getCurrentSceneName(true));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return StatusConst.Mode.EMPTY;
    }

    public void addMsgListener(MsgListener msgListener) {
        this.mService.register(msgListener);
    }

    public void removeMsgListener(MsgListener msgListener) {
        this.mService.unregister(msgListener);
    }

    public void sendData(int i, Bundle bundle, String... strArr) {
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            IpcRouterUtil.sendData(i, bundle, strArr[0]);
        } else {
            this.mService.sendData(i, bundle, strArr);
        }
    }

    public void setOnlyMapShow(boolean z) {
        this.mTrafficWaringModel.setOnlyMapShow(z);
        this.mMapControlModel.setOnlyMapShow(z);
    }

    public void setIsRunInBackground(boolean z) {
        AiMsgUtils.getInstance().setAppInBackground(z);
    }

    public long getRouteFinishEvent() {
        return this.mMapControlModel.getRouteResult();
    }

    public void sendHoldMsg() {
        this.mTrafficWaringModel.sendHoldMsg();
    }

    public void sendToMessageCenter(String str, boolean z) {
        this.mService.sendToMessageCenter(str, z);
    }

    public boolean requestCarState(MsgListener msgListener) {
        return this.mService.requestCarState(msgListener);
    }

    /* loaded from: classes2.dex */
    public static class IpcMessage {
        final int mIntValue;
        final String mMsg;
        final int mMsgID;
        final String mSenderPackageName;

        /* JADX INFO: Access modifiers changed from: package-private */
        public IpcMessage(String str, int i, String str2) {
            this(str, i, str2, -1);
        }

        IpcMessage(String str, int i, int i2) {
            this(str, i, null, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public IpcMessage(String str, int i, String str2, int i2) {
            this.mSenderPackageName = str;
            this.mMsgID = i;
            this.mMsg = str2;
            this.mIntValue = i2;
        }

        public String getSenderPackageName() {
            return this.mSenderPackageName;
        }

        public int getMsgID() {
            return this.mMsgID;
        }

        public String getMsg() {
            return this.mMsg;
        }

        public int getIntValue() {
            return this.mIntValue;
        }

        public String toString() {
            return "IpcMessage{mSenderPackageName='" + this.mSenderPackageName + "', mMsgID=" + this.mMsgID + ", mMsg='" + this.mMsg + "'}";
        }
    }
}
