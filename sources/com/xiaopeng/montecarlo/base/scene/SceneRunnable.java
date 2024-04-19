package com.xiaopeng.montecarlo.base.scene;

import com.xiaopeng.montecarlo.root.util.L;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public final class SceneRunnable implements Runnable, ISceneRunnable {
    private static final L.Tag TAG = new L.Tag("SceneRunnable");
    public static final int UI_RUNFLAG_RUNHIDE = 1;
    private int mFlag;
    private Runnable mRunnable;
    private WeakReference<IBaseScene> mScene;

    @Override // com.xiaopeng.montecarlo.base.scene.ISceneRunnable
    public Runnable getRunnable() {
        return this;
    }

    public SceneRunnable(IBaseScene iBaseScene, Runnable runnable, int i) {
        this.mRunnable = runnable;
        this.mScene = new WeakReference<>(iBaseScene);
        this.mFlag = i;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.ISceneRunnable
    public Object getToken() {
        return this.mScene.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        IBaseScene iBaseScene;
        if (this.mRunnable == null || (iBaseScene = this.mScene.get()) == null) {
            return;
        }
        boolean z = (this.mFlag & 1) != 0;
        boolean z2 = iBaseScene.isDetached() || iBaseScene.isAdded();
        if (!z) {
            z2 = (!z2 || iBaseScene.isDetached() || iBaseScene.isHidden()) ? false : true;
        }
        if (z2) {
            long currentTimeMillis = System.currentTimeMillis();
            this.mRunnable.run();
            if (L.isLoggable()) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 200) {
                    L.Tag tag = TAG;
                    L.w(tag, "SceneRunnable:" + iBaseScene.getClass().getName() + "  runTime:" + currentTimeMillis2);
                }
            }
        }
    }
}
