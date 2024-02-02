package com.xiaopeng.montecarlo.action;

import android.content.Intent;
import com.xiaopeng.montecarlo.base.MainContext;
/* loaded from: classes2.dex */
public class FinishAction implements IIntentAction {
    @Override // com.xiaopeng.montecarlo.action.IIntentAction
    public boolean handlerIntentAction(IIntentActionContext iIntentActionContext, Intent intent) {
        if (iIntentActionContext == null) {
            throw new IllegalArgumentException("IIntentActionContext is null ");
        }
        MainContext mainContext = iIntentActionContext.getMainContext();
        if (mainContext != null) {
            mainContext.finishActivity();
            return true;
        }
        return true;
    }
}
