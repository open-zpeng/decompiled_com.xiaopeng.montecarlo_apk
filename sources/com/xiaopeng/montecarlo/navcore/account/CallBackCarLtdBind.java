package com.xiaopeng.montecarlo.navcore.account;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.aosclient.model.GCarLtdBindResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdBind;
import com.xiaopeng.montecarlo.navcore.event.AccountBindEvent;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes2.dex */
public class CallBackCarLtdBind implements ICallBackCarLtdBind {
    private static final CallBackCarLtdBind sOurInstance = new CallBackCarLtdBind();

    private CallBackCarLtdBind() {
    }

    @NonNull
    public static CallBackCarLtdBind getInstance() {
        return sOurInstance;
    }

    @Override // com.autonavi.gbl.aosclient.observer.ICallBackCarLtdBind
    public void onRecvAck(@Nullable GCarLtdBindResponseParam gCarLtdBindResponseParam) {
        if (gCarLtdBindResponseParam != null) {
            AccountBindEvent accountBindEvent = new AccountBindEvent();
            accountBindEvent.setParam(gCarLtdBindResponseParam);
            EventBus.getDefault().post(accountBindEvent);
        }
    }
}
