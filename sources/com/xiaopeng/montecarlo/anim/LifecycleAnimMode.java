package com.xiaopeng.montecarlo.anim;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.lifecycle.Lifecycle;
import com.xiaopeng.montecarlo.lifecycle.LifecycleObserver;
import com.xiaopeng.montecarlo.lifecycle.LifecycleOwner;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class LifecycleAnimMode {
    private AnimBuilder mAnimBuilder;
    private AnimCallback mAnimCallback;
    private Lifecycle mLifecycle;
    private ArrayList<LifecycleAnimMode> mNextAnims;
    private View mRunView;
    private View mView;
    private boolean mIsOnceRun = true;
    private LifecycleObserver mLifecycleObserver = new LifecycleObserver() { // from class: com.xiaopeng.montecarlo.anim.LifecycleAnimMode.1
        @Override // com.xiaopeng.montecarlo.lifecycle.LifecycleObserver
        public void onCreate(LifecycleOwner lifecycleOwner) {
        }

        @Override // com.xiaopeng.montecarlo.lifecycle.LifecycleObserver
        public void onPause(LifecycleOwner lifecycleOwner) {
        }

        @Override // com.xiaopeng.montecarlo.lifecycle.LifecycleObserver
        public void onResume(LifecycleOwner lifecycleOwner) {
        }

        @Override // com.xiaopeng.montecarlo.lifecycle.LifecycleObserver
        public void onDestroy(LifecycleOwner lifecycleOwner) {
            if (LifecycleAnimMode.this.mNextAnims != null) {
                LifecycleAnimMode.this.mNextAnims.clear();
            }
            if (LifecycleAnimMode.this.mLifecycle != null) {
                LifecycleAnimMode.this.mLifecycle.removeObserver(this);
                LifecycleAnimMode.this.mLifecycle = null;
            }
            LifecycleAnimMode.this.mView = null;
            LifecycleAnimMode.this.mAnimCallback = null;
            if (LifecycleAnimMode.this.mRunView != null) {
                LifecycleAnimMode.this.mRunView.animate().setListener(null);
                LifecycleAnimMode.this.mRunView.animate().cancel();
                LifecycleAnimMode.this.mRunView = null;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void checkOnceRun() {
        if (this.mIsOnceRun) {
            Lifecycle lifecycle = this.mLifecycle;
            if (lifecycle != null) {
                lifecycle.removeObserver(this.mLifecycleObserver);
                this.mLifecycle = null;
            }
            this.mAnimBuilder = null;
        }
    }

    public void addNextAnimMode(LifecycleAnimMode lifecycleAnimMode) {
        if (this.mIsOnceRun) {
            if (this.mNextAnims == null) {
                this.mNextAnims = new ArrayList<>();
            }
            CollectionUtils.listAdd(this.mNextAnims, lifecycleAnimMode);
        }
    }

    public void start() {
        start(null, null);
    }

    public void start(View view) {
        start(view, null);
    }

    public void start(final View view, final AnimCallback animCallback) {
        Lifecycle.State currentState = this.mLifecycle.getCurrentState();
        if (view == null) {
            view = this.mView;
        }
        if (view == null || !currentState.isAtLeast(Lifecycle.State.CREATED) || !currentState.isLess(Lifecycle.State.DESTROYED) || this.mAnimBuilder == null) {
            return;
        }
        if (animCallback == null) {
            animCallback = this.mAnimCallback;
        }
        view.post(new Runnable() { // from class: com.xiaopeng.montecarlo.anim.LifecycleAnimMode.2
            @Override // java.lang.Runnable
            public void run() {
                ViewPropertyAnimator animate = view.animate();
                animate.cancel();
                LifecycleAnimMode.this.mAnimBuilder.preAnim(view);
                LifecycleAnimMode.this.mAnimBuilder.createAnim(animate);
                animate.setListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.montecarlo.anim.LifecycleAnimMode.2.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        view.animate().setListener(null);
                        AnimEvent.CANCEL.dispatch(animCallback, view);
                        LifecycleAnimMode.this.checkOnceRun();
                        if (LifecycleAnimMode.this.mNextAnims != null) {
                            LifecycleAnimMode.this.mNextAnims.clear();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        view.animate().setListener(null);
                        AnimEvent.END.dispatch(animCallback, view);
                        if (LifecycleAnimMode.this.mNextAnims != null) {
                            Iterator it = LifecycleAnimMode.this.mNextAnims.iterator();
                            while (it.hasNext()) {
                                ((LifecycleAnimMode) it.next()).start();
                            }
                            LifecycleAnimMode.this.mNextAnims.clear();
                        }
                        LifecycleAnimMode.this.mRunView = null;
                        LifecycleAnimMode.this.checkOnceRun();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AnimEvent.REPEAT.dispatch(animCallback, view);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        AnimEvent.START.dispatch(animCallback, view);
                        LifecycleAnimMode.this.mRunView = view;
                    }
                });
                animate.start();
            }
        });
    }

    public void cancel(View view) {
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void addAnimCallback(AnimCallback animCallback) {
        if (this.mIsOnceRun) {
            this.mAnimCallback = animCallback;
        }
    }

    public void addView(View view) {
        if (this.mIsOnceRun) {
            this.mView = view;
        }
    }

    protected void init(@NonNull Builder builder) {
        this.mLifecycle = builder.mLifecycleOwner.getSceneLifecycle();
        this.mLifecycle.addObserver(this.mLifecycleObserver);
        this.mAnimBuilder = builder.mAnimBuilder;
        this.mIsOnceRun = builder.mIsOnceRun;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        AnimBuilder mAnimBuilder;
        boolean mIsOnceRun = true;
        LifecycleOwner mLifecycleOwner;

        public Builder of(LifecycleOwner lifecycleOwner) {
            this.mLifecycleOwner = lifecycleOwner;
            return this;
        }

        public Builder addAnimBuilder(AnimBuilder animBuilder) {
            this.mAnimBuilder = animBuilder;
            return this;
        }

        public Builder disableOnceRun() {
            this.mIsOnceRun = false;
            return this;
        }

        public LifecycleAnimMode create() {
            LifecycleAnimMode lifecycleAnimMode = new LifecycleAnimMode();
            lifecycleAnimMode.init(this);
            return lifecycleAnimMode;
        }
    }
}
