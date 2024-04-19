package com.xiaopeng.speech.protocol.node.custom;

import com.xiaopeng.speech.annotation.ICommandProcessor;
import com.xiaopeng.speech.protocol.event.WakeupTestEvent;
/* loaded from: classes3.dex */
public class WakeupTestNode_Processor implements ICommandProcessor {
    private WakeupTestNode mTarget;

    public WakeupTestNode_Processor(WakeupTestNode wakeupTestNode) {
        this.mTarget = wakeupTestNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void performCommand(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -876394041:
                if (str.equals(WakeupTestEvent.VAD_BEGIN)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -654737660:
                if (str.equals(WakeupTestEvent.WAKEUP_SUCC)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1733167481:
                if (str.equals(WakeupTestEvent.VAD_END)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1766842495:
                if (str.equals(WakeupTestEvent.WAKEUP_FAILED)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            this.mTarget.onVADBeginSpeech(str, str2);
        } else if (c == 1) {
            this.mTarget.onVADEndSpeech(str, str2);
        } else if (c == 2) {
            this.mTarget.onWakeupSucced(str, str2);
        } else if (c != 3) {
        } else {
            this.mTarget.onWakeupFailed(str, str2);
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] getSubscribeEvents() {
        return new String[]{WakeupTestEvent.VAD_BEGIN, WakeupTestEvent.VAD_END, WakeupTestEvent.WAKEUP_SUCC, WakeupTestEvent.WAKEUP_FAILED};
    }
}
