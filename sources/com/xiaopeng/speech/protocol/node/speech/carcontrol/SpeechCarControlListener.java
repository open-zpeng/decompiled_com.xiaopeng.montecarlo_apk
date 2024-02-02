package com.xiaopeng.speech.protocol.node.speech.carcontrol;

import com.xiaopeng.speech.INodeListener;
/* loaded from: classes3.dex */
public interface SpeechCarControlListener extends INodeListener {
    void onCloseDriveMileIncrease();

    void onOpenDriveMileIncrease();

    void onOpenLoudspeaker();
}
