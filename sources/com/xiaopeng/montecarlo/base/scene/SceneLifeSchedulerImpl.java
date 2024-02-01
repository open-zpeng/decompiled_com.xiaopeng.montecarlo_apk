package com.xiaopeng.montecarlo.base.scene;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.xiaopeng.montecarlo.base.BaseScene;
/* loaded from: classes.dex */
public class SceneLifeSchedulerImpl implements ISceneLifeScheduler<BaseScene> {
    private final FragmentManager mFragmentManager;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public SceneLifeSchedulerImpl(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.ISceneLifeScheduler
    public void show(final BaseScene baseScene) {
        runOnHandlerThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.scene.-$$Lambda$SceneLifeSchedulerImpl$TM5nyCZRVPiQzY7MWerH2RcVQTI
            @Override // java.lang.Runnable
            public final void run() {
                SceneLifeSchedulerImpl.this.lambda$show$0$SceneLifeSchedulerImpl(baseScene);
            }
        });
    }

    public /* synthetic */ void lambda$show$0$SceneLifeSchedulerImpl(BaseScene baseScene) {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        beginTransaction.show(baseScene);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.ISceneLifeScheduler
    public void remove(final BaseScene baseScene) {
        runOnHandlerThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.scene.-$$Lambda$SceneLifeSchedulerImpl$Mrxj62S-oUhyitjdvS08IF8M6Io
            @Override // java.lang.Runnable
            public final void run() {
                SceneLifeSchedulerImpl.this.lambda$remove$1$SceneLifeSchedulerImpl(baseScene);
            }
        });
    }

    public /* synthetic */ void lambda$remove$1$SceneLifeSchedulerImpl(BaseScene baseScene) {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        beginTransaction.remove(baseScene);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.ISceneLifeScheduler
    public void attach(final BaseScene baseScene) {
        runOnHandlerThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.scene.-$$Lambda$SceneLifeSchedulerImpl$QpZcM4RnW0IATkjKsNixJdQoTmQ
            @Override // java.lang.Runnable
            public final void run() {
                SceneLifeSchedulerImpl.this.lambda$attach$2$SceneLifeSchedulerImpl(baseScene);
            }
        });
    }

    public /* synthetic */ void lambda$attach$2$SceneLifeSchedulerImpl(BaseScene baseScene) {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        beginTransaction.attach(baseScene);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.ISceneLifeScheduler
    public void detach(final BaseScene baseScene) {
        runOnHandlerThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.scene.-$$Lambda$SceneLifeSchedulerImpl$KwghQN1hsgwUcgU2Hbo0we7mLYY
            @Override // java.lang.Runnable
            public final void run() {
                SceneLifeSchedulerImpl.this.lambda$detach$3$SceneLifeSchedulerImpl(baseScene);
            }
        });
    }

    public /* synthetic */ void lambda$detach$3$SceneLifeSchedulerImpl(BaseScene baseScene) {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        beginTransaction.detach(baseScene);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.ISceneLifeScheduler
    public void add(final int i, final BaseScene baseScene) {
        runOnHandlerThread(new Runnable() { // from class: com.xiaopeng.montecarlo.base.scene.-$$Lambda$SceneLifeSchedulerImpl$wwSF8TA3kQUfwFeizh5CrNEgcUE
            @Override // java.lang.Runnable
            public final void run() {
                SceneLifeSchedulerImpl.this.lambda$add$4$SceneLifeSchedulerImpl(i, baseScene);
            }
        });
    }

    public /* synthetic */ void lambda$add$4$SceneLifeSchedulerImpl(int i, BaseScene baseScene) {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        beginTransaction.add(i, baseScene);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.base.scene.ISceneLifeScheduler
    public BaseScene findSceneById(int i) {
        Fragment findFragmentById = this.mFragmentManager.findFragmentById(i);
        if (findFragmentById instanceof BaseScene) {
            return (BaseScene) findFragmentById;
        }
        return null;
    }

    private void runOnHandlerThread(Runnable runnable) {
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }
}
