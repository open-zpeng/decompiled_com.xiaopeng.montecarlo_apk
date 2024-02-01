package com.xiaopeng.speech.protocol.query.speech.ui;

import com.xiaopeng.speech.IQueryCaller;
/* loaded from: classes3.dex */
public interface ISpeechUiCaller extends IQueryCaller {
    default boolean isSuperDialogueOpened() {
        return false;
    }

    default boolean isSuperDialogueWhitelist() {
        return false;
    }
}
