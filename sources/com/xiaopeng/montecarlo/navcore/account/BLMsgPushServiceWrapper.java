package com.xiaopeng.montecarlo.navcore.account;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.autonavi.gbl.user.model.UserLoginInfo;
import com.autonavi.gbl.user.msgpush.MsgPushService;
import com.autonavi.gbl.user.msgpush.model.MsgPushInitParam;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileIOUtil;
/* loaded from: classes2.dex */
public class BLMsgPushServiceWrapper {
    private MsgPushService mMsgPushService;
    private static final BLMsgPushServiceWrapper sInstance = new BLMsgPushServiceWrapper();
    private static final L.Tag TAG = new L.Tag("BLMsgPushSer");

    private BLMsgPushServiceWrapper() {
    }

    @NonNull
    public static BLMsgPushServiceWrapper getInstance() {
        return sInstance;
    }

    public MsgPushService getMsgPushService() {
        if (this.mMsgPushService == null) {
            initMsgPushService();
        }
        return this.mMsgPushService;
    }

    public void initMsgPushService() {
        if (this.mMsgPushService == null) {
            this.mMsgPushService = (MsgPushService) ServiceMgr.getServiceMgrInstance().getBLService(2);
            MsgPushInitParam msgPushInitParam = new MsgPushInitParam();
            FileIOUtil.makeDirs(RootUtil.SD_CARD_DIR_MSG_PUSH_SERVICE_FILE_PATH);
            msgPushInitParam.dataPath = RootUtil.SD_CARD_DIR_MSG_PUSH_SERVICE_FILE_PATH;
            msgPushInitParam.mqttKey = new String();
            this.mMsgPushService.init(msgPushInitParam);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, " send2car initMsgPushService path=" + RootUtil.SD_CARD_DIR_MSG_PUSH_SERVICE_FILE_PATH);
            }
            this.mMsgPushService.addObserver(new MsgPushServiceObserver());
        }
    }

    public int setLoginInfo(String str) {
        stop();
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.userId = str;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return start(userLoginInfo);
    }

    private int start(UserLoginInfo userLoginInfo) {
        int startListen = getMsgPushService().startListen(userLoginInfo);
        L.Tag tag = TAG;
        L.i(tag, "send2car MsgPushService startListen result:" + startListen);
        return startListen;
    }

    public void stop() {
        int stopListen = getMsgPushService().stopListen();
        L.Tag tag = TAG;
        L.i(tag, "send2car MsgPushService stopListen result:" + stopListen);
    }
}
