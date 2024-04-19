package com.xiaopeng.montecarlo.aimessage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceManager;
import com.xiaopeng.montecarlo.navcore.sr.data.HappyEnding;
import com.xiaopeng.montecarlo.navcore.xptbt.bean.AiMsgConfirmBean;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class HappyEndingModel implements AiMsgManager.MsgListener {
    private static final L.Tag TAG = new L.Tag("HappyEndingModel");

    @Override // com.xiaopeng.montecarlo.aimessage.AiMsgManager.MsgListener
    public String getName() {
        return "HappyEndingModel";
    }

    @Override // com.xiaopeng.montecarlo.aimessage.AiMsgManager.MsgListener
    public void onReceive(@NonNull AiMsgManager.IpcMessage ipcMessage) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onReceive : " + ipcMessage);
        }
        if (ipcMessage.getMsgID() == 10011) {
            AiMsgConfirmBean aiMsgConfirmBean = (AiMsgConfirmBean) GsonUtil.fromJson(ipcMessage.getMsg(), (Class<Object>) AiMsgConfirmBean.class);
            L.Tag tag2 = TAG;
            L.i(tag2, "onReceive callback : " + aiMsgConfirmBean);
            if (aiMsgConfirmBean == null || TextUtils.isEmpty(aiMsgConfirmBean.getExtra())) {
                return;
            }
            LaneServiceManager.getInstance().showHappyEnding((HappyEnding) GsonUtil.fromJson(aiMsgConfirmBean.getExtra(), (Class<Object>) HappyEnding.class));
        }
    }
}
