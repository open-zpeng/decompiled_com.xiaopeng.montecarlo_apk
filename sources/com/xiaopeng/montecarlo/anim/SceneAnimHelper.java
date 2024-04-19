package com.xiaopeng.montecarlo.anim;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.xiaopeng.montecarlo.anim.LifecycleAnimMode;
import com.xiaopeng.montecarlo.lifecycle.LifecycleOwner;
/* loaded from: classes2.dex */
public final class SceneAnimHelper {
    public static LifecycleAnimMode getShowAnim(LifecycleOwner lifecycleOwner, AnimBuilder animBuilder) {
        return new LifecycleAnimMode.Builder().of(lifecycleOwner).addAnimBuilder(animBuilder).create();
    }

    public static LifecycleAnimMode getSlideLeftToRightShowAnim(LifecycleOwner lifecycleOwner) {
        return new LifecycleAnimMode.Builder().of(lifecycleOwner).addAnimBuilder(new AnimBuilder() { // from class: com.xiaopeng.montecarlo.anim.SceneAnimHelper.1
            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void preAnim(View view) {
                view.setTranslationX(view.getMeasuredWidth() + 30);
                view.setVisibility(0);
            }

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void createAnim(ViewPropertyAnimator viewPropertyAnimator) {
                viewPropertyAnimator.translationX(0.0f);
            }
        }).create();
    }

    public static LifecycleAnimMode getSlideRightToLeftHideAnim(LifecycleOwner lifecycleOwner) {
        return new LifecycleAnimMode.Builder().of(lifecycleOwner).addAnimBuilder(new AnimBuilder() { // from class: com.xiaopeng.montecarlo.anim.SceneAnimHelper.2
            int mToX;

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void preAnim(View view) {
                this.mToX = view.getMeasuredWidth() + 30;
                view.setVisibility(0);
            }

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void createAnim(ViewPropertyAnimator viewPropertyAnimator) {
                viewPropertyAnimator.translationX(this.mToX);
            }
        }).create();
    }

    public static LifecycleAnimMode getSlideUpToDownShowAnim(LifecycleOwner lifecycleOwner) {
        return new LifecycleAnimMode.Builder().of(lifecycleOwner).addAnimBuilder(new AnimBuilder() { // from class: com.xiaopeng.montecarlo.anim.SceneAnimHelper.3
            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void preAnim(View view) {
                view.setTranslationY(-view.getMeasuredHeight());
                view.setVisibility(0);
            }

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void createAnim(ViewPropertyAnimator viewPropertyAnimator) {
                viewPropertyAnimator.translationY(0.0f);
            }
        }).create();
    }

    public static LifecycleAnimMode getSlideDownToUpShowAnim(LifecycleOwner lifecycleOwner) {
        return new LifecycleAnimMode.Builder().of(lifecycleOwner).addAnimBuilder(new AnimBuilder() { // from class: com.xiaopeng.montecarlo.anim.SceneAnimHelper.4
            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void preAnim(View view) {
                view.setTranslationY(view.getMeasuredHeight());
                view.setVisibility(0);
            }

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void createAnim(ViewPropertyAnimator viewPropertyAnimator) {
                viewPropertyAnimator.translationY(0.0f);
            }
        }).create();
    }

    public static LifecycleAnimMode getSlideDownToUpHideAnim(LifecycleOwner lifecycleOwner) {
        return new LifecycleAnimMode.Builder().of(lifecycleOwner).addAnimBuilder(new AnimBuilder() { // from class: com.xiaopeng.montecarlo.anim.SceneAnimHelper.5
            int mToY;

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void preAnim(View view) {
                this.mToY = -view.getMeasuredHeight();
                view.setTranslationY(0.0f);
                view.setVisibility(0);
            }

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void createAnim(ViewPropertyAnimator viewPropertyAnimator) {
                viewPropertyAnimator.translationY(this.mToY);
            }
        }).create();
    }

    public static LifecycleAnimMode getSlideUpToDownHideAnim(LifecycleOwner lifecycleOwner) {
        return new LifecycleAnimMode.Builder().of(lifecycleOwner).addAnimBuilder(new AnimBuilder() { // from class: com.xiaopeng.montecarlo.anim.SceneAnimHelper.6
            int mToY;

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void preAnim(View view) {
                this.mToY = view.getMeasuredHeight();
                view.setTranslationY(0.0f);
                view.setVisibility(0);
            }

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void createAnim(ViewPropertyAnimator viewPropertyAnimator) {
                viewPropertyAnimator.translationY(this.mToY);
            }
        }).create();
    }

    public static LifecycleAnimMode getScaleYShowAnim(LifecycleOwner lifecycleOwner, final int i, final int i2, final int i3) {
        return new LifecycleAnimMode.Builder().of(lifecycleOwner).addAnimBuilder(new AnimBuilder() { // from class: com.xiaopeng.montecarlo.anim.SceneAnimHelper.7
            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void preAnim(View view) {
                view.setTranslationY((i + ((i2 - view.getMeasuredHeight()) / 2)) - i3);
                view.setScaleY(0.0f);
                view.setAlpha(0.2f);
                view.setVisibility(0);
            }

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void createAnim(ViewPropertyAnimator viewPropertyAnimator) {
                viewPropertyAnimator.scaleY(1.0f).alpha(1.0f).translationY(0.0f);
            }
        }).create();
    }

    public static LifecycleAnimMode getScaleYHideAnim(LifecycleOwner lifecycleOwner, final int i, final int i2, final int i3) {
        return new LifecycleAnimMode.Builder().of(lifecycleOwner).addAnimBuilder(new AnimBuilder() { // from class: com.xiaopeng.montecarlo.anim.SceneAnimHelper.8
            int mPos;

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void preAnim(View view) {
                this.mPos = (i + ((i2 - view.getMeasuredHeight()) / 2)) - i3;
                view.setScaleY(1.0f);
                view.setAlpha(1.0f);
                view.setVisibility(0);
            }

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void createAnim(ViewPropertyAnimator viewPropertyAnimator) {
                viewPropertyAnimator.scaleY(0.0f).alpha(0.2f).translationY(this.mPos);
            }
        }).create();
    }

    public static LifecycleAnimMode getScaleYHRightToLeftShowAnim(LifecycleOwner lifecycleOwner, final int i, final int i2, final int i3) {
        return new LifecycleAnimMode.Builder().of(lifecycleOwner).addAnimBuilder(new AnimBuilder() { // from class: com.xiaopeng.montecarlo.anim.SceneAnimHelper.9
            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void preAnim(View view) {
                view.setPivotX(0.0f);
                view.setScaleX(0.3f);
                view.setAlpha(0.2f);
                view.setTranslationY((i + ((i2 - view.getMeasuredHeight()) / 2)) - i3);
                view.setVisibility(0);
            }

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void createAnim(ViewPropertyAnimator viewPropertyAnimator) {
                viewPropertyAnimator.scaleX(1.0f).alpha(1.0f);
            }
        }).create();
    }

    public static LifecycleAnimMode getScaleLeftToRightHideAnim(LifecycleOwner lifecycleOwner) {
        return new LifecycleAnimMode.Builder().of(lifecycleOwner).addAnimBuilder(new AnimBuilder() { // from class: com.xiaopeng.montecarlo.anim.SceneAnimHelper.10
            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void preAnim(View view) {
                view.setPivotX(0.0f);
                view.setScaleX(1.0f);
                view.setAlpha(1.0f);
                view.setVisibility(0);
            }

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void createAnim(ViewPropertyAnimator viewPropertyAnimator) {
                viewPropertyAnimator.scaleX(0.0f).alpha(0.0f);
            }
        }).create();
    }

    public static LifecycleAnimMode getSlideYTo0(LifecycleOwner lifecycleOwner, final int i) {
        return new LifecycleAnimMode.Builder().of(lifecycleOwner).addAnimBuilder(new AnimBuilder() { // from class: com.xiaopeng.montecarlo.anim.SceneAnimHelper.11
            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void preAnim(View view) {
            }

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void createAnim(ViewPropertyAnimator viewPropertyAnimator) {
                viewPropertyAnimator.translationY(i);
            }
        }).create();
    }

    public static LifecycleAnimMode getRotationTo(LifecycleOwner lifecycleOwner, final float f) {
        return new LifecycleAnimMode.Builder().of(lifecycleOwner).addAnimBuilder(new AnimBuilder() { // from class: com.xiaopeng.montecarlo.anim.SceneAnimHelper.12
            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void preAnim(View view) {
            }

            @Override // com.xiaopeng.montecarlo.anim.AnimBuilder
            public void createAnim(ViewPropertyAnimator viewPropertyAnimator) {
                viewPropertyAnimator.rotation(f);
            }
        }).create();
    }
}
