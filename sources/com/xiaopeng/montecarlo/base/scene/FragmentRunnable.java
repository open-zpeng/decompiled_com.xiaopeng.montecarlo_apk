package com.xiaopeng.montecarlo.base.scene;

import androidx.fragment.app.Fragment;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public final class FragmentRunnable implements Runnable, ISceneRunnable {
    private static final L.Tag TAG = new L.Tag("FragmentRunnable");
    public static final int UI_RUNFLAG_RUNHIDE = 1;
    private int mFlag;
    private WeakReference<Fragment> mFragment;
    private Runnable mRunnable;

    @Override // com.xiaopeng.montecarlo.base.scene.ISceneRunnable
    public Runnable getRunnable() {
        return this;
    }

    public FragmentRunnable(Fragment fragment, Runnable runnable, int i) {
        this.mRunnable = runnable;
        this.mFragment = new WeakReference<>(fragment);
        this.mFlag = i;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.ISceneRunnable
    public Object getToken() {
        return this.mFragment.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        Fragment fragment;
        if (this.mRunnable == null || (fragment = this.mFragment.get()) == null) {
            return;
        }
        boolean z = (this.mFlag & 1) != 0;
        boolean z2 = fragment.isDetached() || fragment.isAdded();
        if (!z) {
            z2 = (!z2 || fragment.isDetached() || fragment.isHidden()) ? false : true;
        }
        if (z2) {
            long currentTimeMillis = System.currentTimeMillis();
            this.mRunnable.run();
            if (L.isLoggable()) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 200) {
                    L.Tag tag = TAG;
                    L.w(tag, "SceneRunnable:" + fragment.getClass().getName() + "  runTime:" + currentTimeMillis2);
                }
            }
        }
    }
}
