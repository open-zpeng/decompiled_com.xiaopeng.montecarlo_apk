package com.xiaopeng.speech.protocol.node.custom;

import com.xiaopeng.speech.INodeListener;
/* loaded from: classes3.dex */
public interface WakeupWordSettingListener extends INodeListener {
    default void onManualInput(String str) {
    }

    default void onSettingDone(String str) {
    }
}
