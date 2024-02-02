package com.xiaopeng.montecarlo.anim;

import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public enum AnimEvent {
    START,
    REPEAT,
    END,
    CANCEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatch(AnimCallback animCallback, @NonNull View view) {
        if (!view.isAttachedToWindow() || animCallback == null) {
            return;
        }
        animCallback.onEvent(this, view);
    }
}
