package com.xiaopeng.montecarlo.anim;

import android.view.View;
import android.view.ViewPropertyAnimator;
/* loaded from: classes2.dex */
public interface AnimBuilder {
    void createAnim(ViewPropertyAnimator viewPropertyAnimator);

    void preAnim(View view);
}
