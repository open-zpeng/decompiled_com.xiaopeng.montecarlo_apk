package com.xiaopeng.montecarlo.action.schedule;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.action.IIntentAction;
import com.xiaopeng.montecarlo.action.IIntentActionContext;
import com.xiaopeng.montecarlo.action.IntentActionFactory;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
/* loaded from: classes.dex */
public class IntentTask {
    private static final L.Tag TAG = new L.Tag("IntentTask");
    private final Intent mIntent;

    public IntentTask(Intent intent) {
        this.mIntent = intent;
    }

    public String getName() {
        Intent intent = this.mIntent;
        return intent == null ? "null" : intent.getAction();
    }

    public void run(IIntentActionContext iIntentActionContext) {
        if (iIntentActionContext == null) {
            throw new IllegalArgumentException("IntentTask mActionContext is null ");
        }
        Intent intent = this.mIntent;
        if (intent == null) {
            throw new IllegalArgumentException("IntentTask mIntent is null ");
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            L.w(TAG, "task run: intentaction mIntent data is null");
            return;
        }
        String string = extras.getString(IntentActions.ActionsKey.KEY_ACTION);
        if (TextUtils.isEmpty(string)) {
            string = extras.getString(DebugConfiguration.DebugActionExtra.TEST_ACTION);
            if (TextUtils.isEmpty(string)) {
                L.i(TAG, "task run: intentaction action is null");
                return;
            }
        }
        IIntentAction createAction = IntentActionFactory.createAction(string);
        if (createAction != null) {
            createAction.handlerIntentAction(iIntentActionContext, this.mIntent);
        }
        L.Tag tag = TAG;
        L.i(tag, "task run: intentaction =" + this.mIntent.toString());
    }
}
