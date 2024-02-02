package com.xiaopeng.montecarlo.action;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.IntentActions;
/* loaded from: classes2.dex */
public class IntentActionFactory {
    public static IIntentAction createAction(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("create intent action param is null");
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1173171990:
                if (str.equals(IntentActions.ACTION_THIRD_APP_ACCESS)) {
                    c = 3;
                    break;
                }
                break;
            case -767920600:
                if (str.equals(IntentActions.ACTION_CRUISE_CARD_DISPATCH)) {
                    c = 4;
                    break;
                }
                break;
            case -451882782:
                if (str.equals(IntentActions.ACTION_SPEECH_COMMAND_DISPATCH)) {
                    c = 2;
                    break;
                }
                break;
            case 1012778147:
                if (str.equals(IntentActions.ACTION_ACTIVITY_FINISH)) {
                    c = 0;
                    break;
                }
                break;
            case 1029998307:
                if (str.equals(IntentActions.ACTION_AI_MSG_DISPATCH_MAP)) {
                    c = 1;
                    break;
                }
                break;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            return null;
                        }
                        return new CruiseCardAction();
                    }
                    return new ThirdAPPUriAccessAction();
                }
                return new SpeechCommandDispatchAction();
            }
            return new AIMsgNaviAction();
        }
        return new FinishAction();
    }
}
